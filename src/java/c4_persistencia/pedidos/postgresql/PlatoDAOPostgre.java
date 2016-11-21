/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.pedidos.postgresql;

import c3_dominio.pedidos.contrato.IPlatoDAO;
import c3_dominio.pedidos.entidad.Plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

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
    public List<Plato> func_NAZCA_PEDIDO_BuscarPlatoPorNombre(String nombre) throws ExcepcionSQL {
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
            return listaPlatos;
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    }

    @Override
    public void func_NAZCA_CRUD_Crear(Plato plato) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "insert into plato(nombre, precio, descripcion, urlfoto, estado, isactivo) values(?,?,?,?,?,?)";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("No se puede insertar");
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void func_NAZCA_CRUD_Editar(Plato plato) throws ExcepcionSQL {
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
                throw new Exception("No se puede modificar");
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void func_NAZCA_CRUD_Eliminar(Plato plato) throws ExcepcionSQL {
        int registros_afectados;
        String sentenciaSQL = "delete from plato where platoid = ?";
        try {
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("No se puede eliminar");
            }
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public Plato func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
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
            return plato;
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
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
