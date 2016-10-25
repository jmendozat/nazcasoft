/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {

    GestorJDBC gestorJDBC;

    public MesaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<Mesa> buscar() throws Exception {
        ArrayList<Mesa> listaMesas = new ArrayList();
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
            return listaMesas;
        } catch (Exception e) {
            throw new Exception("Error al buscar");
        }
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

    public Mesa buscar(int mesaid) throws Exception {
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
                + "     WHERE m.mesaid = "+mesaid;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if (resultado.next()) {
                mesa = crearObjetoMesa(resultado);
            }
            resultado.close();
            return mesa;
        } catch (Exception e) {
            throw new Exception("Error al buscar");
        }
    }

    public void ingresar(Mesa mesa) throws Exception {
        try {
            String sentenciaSQL = "";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, mesa.getNumero());
            sentencia.setBoolean(2, mesa.isDisponible());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Se ha registrado la mesa N\u00BA " + mesa.getNumero());
        }
    }

  

    public void modificarMesaPedido(Mesa mesa) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "update mesa set disponible = ? where mesaid = ?";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
           
            sentencia.setBoolean(1, mesa.isDisponible());
            sentencia.setInt(2, mesa.getMesaid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("Error al modificar");
            }
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    public void eliminar(Mesa mesa) throws Exception {
        try {
            String sentenciaSQL = "delete from mesa where idmesa= ?";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, mesa.getMesaid());
            sentencia.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar la mesa N\u00BA " + mesa.getNumero());
        }

    }

}
