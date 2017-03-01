/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.pedidos.sqlserver;

import c3_dominio.pedidos.contrato.IPlatoDAO;
import c3_dominio.pedidos.entidad.Plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PlatoDAOPostgre implements IPlatoDAO {

    GestorJDBC gestorJDBC;

    public PlatoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public List<Plato> buscarPlatoPorNombre(String nombre) throws ExcepcionSQL {
        ArrayList<Plato> listaPlatos = new ArrayList();
        Plato plato;
        ResultSet resultado;
        if (nombre == null) {
            nombre = "";
        }
        String sentenciaSQL = "select platoid, nombre, precio, descripcion, urlfoto, estado, isactivo"
                + " from plato where nombre like '%" + nombre + "%' order by platoid desc ";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while (resultado.next()) {
                plato = crearObjetoPlato(resultado);
                listaPlatos.add(plato);
            }
            resultado.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorConsultar();
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPlatos;
    }

    @Override
    public void crear(Plato plato) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "insert into plato(nombre, precio, descripcion, urlfoto, estado, isactivo) values(?,?,?,?,?,?)";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw ExcepcionSQL.crearErrorInsertar();
            }
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorInsertar();
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Plato plato) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "update plato set nombre = ?, precio = ?, descripcion = ?, urlfoto = ?, estado = ?, isactivo = ? where platoid = ?";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            sentencia.setInt(7, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw ExcepcionSQL.crearErrorModificar();
            }
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorModificar();
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Plato plato) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "delete from plato where platoid = ?";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw ExcepcionSQL.crearErrorEliminar();
            }
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorEliminar();
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Plato buscar(int id) throws ExcepcionSQL {
        Plato plato = null;
        ResultSet resultado;
        String sentenciaSQL = "select platoid, nombre, precio, descripcion, urlfoto, estado, isactivo"
                + " from plato where platoid = " + id;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if (resultado.next()) {
                plato = crearObjetoPlato(resultado);
            }
            resultado.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorConsultar();
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plato;
    }

    private Plato crearObjetoPlato(ResultSet resultado) throws SQLException {
        return new Plato(resultado.getInt("platoid"),
                resultado.getString("nombre"),
                resultado.getDouble("precio"),
                resultado.getString("descripcion"),
                resultado.getString("urlfoto"),
                resultado.getString("estado"),
                resultado.getBoolean("isactivo"));
    }

    private void asignarParametros(PreparedStatement sentencia, Plato plato) throws SQLException {
        sentencia.setString(1, plato.getNombre());
        sentencia.setDouble(2, plato.getPrecio());
        sentencia.setString(3, plato.getDescripcion());
        sentencia.setString(4, plato.getUrlfoto());
        sentencia.setString(5, plato.getEstado());
        sentencia.setBoolean(6, plato.isActivo());
    }
}
