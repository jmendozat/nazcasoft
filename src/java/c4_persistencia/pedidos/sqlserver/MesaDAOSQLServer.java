/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.pedidos.sqlserver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c3_dominio.pedidos.contrato.IMesaDAO;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.TipoMesa;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class MesaDAOSQLServer implements IMesaDAO {

    GestorJDBC gestorJDBC;

    public MesaDAOSQLServer(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public List<Mesa> listar() throws ExcepcionSQL {
        ArrayList<Mesa> listaMesas = new ArrayList<>();
        Mesa mesa;
        ResultSet resultado;
        String sentenciaSQL = "SELECT  m.mesaid,\n"
                + "	m.numero,\n"
                + "	m.disponible,\n"
                + "	tm.codigotipomesa,\n"
                + "	tm.nombretipo,\n"
                + "	tm.descripciontipo\n"
                + "FROM mesa m\n"
                + "     INNER JOIN tipomesa tm \n"
                + "     ON m.codigotipomesa = tm.codigotipomesa";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while (resultado.next()) {
                mesa = crearObjetoMesa(resultado);
                listaMesas.add(mesa);
            }
            resultado.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorConsultar();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAOSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMesas;
    }

    @Override
    public void crear(Mesa mesa) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Mesa mesa) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Mesa mesa) throws ExcepcionSQL {
        try {
            String sentenciaSQL = "delete from mesa where idmesa= ?";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, mesa.getMesaid());
            sentencia.executeUpdate();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorEliminar();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAOSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Mesa buscar(int id) throws ExcepcionSQL {
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL = "SELECT  m.mesaid,\n"
                + "	m.numero,\n"
                + "	m.disponible,\n"
                + "	tm.codigotipomesa,\n"
                + "	tm.nombretipo,\n"
                + "	tm.descripciontipo\n"
                + "FROM mesa m\n"
                + "     INNER JOIN tipomesa tm \n"
                + "     ON m.codigotipomesa = tm.codigotipomesa\n"
                + "     WHERE m.mesaid = " + id;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if (resultado.next()) {
                mesa = crearObjetoMesa(resultado);
            }
            resultado.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorConsultar();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAOSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;
    }

    private Mesa crearObjetoMesa(ResultSet resultado) throws SQLException {
        Mesa mesa = new Mesa();
        mesa.setMesaid(resultado.getInt("mesaid"));
        mesa.setNumero(resultado.getInt("numero"));
        mesa.setDisponible(resultado.getBoolean("disponible"));
        TipoMesa tipoMesa = new TipoMesa();
        tipoMesa.setCodigo(resultado.getInt("codigotipomesa"));
        tipoMesa.setNombre(resultado.getString("nombretipo"));
        tipoMesa.setDescripcion(resultado.getString("descripciontipo"));
        mesa.setTipoMesa(tipoMesa);
        return mesa;
    }

    @Override
    public void modificar(Mesa mesa) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "update mesa set disponible = ? where mesaid = ?";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setBoolean(1, mesa.isDisponible());
            sentencia.setInt(2, mesa.getMesaid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw ExcepcionSQL.crearErrorModificar();
            }
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorModificar();
        } catch (SQLException ex) {
            Logger.getLogger(MesaDAOSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
