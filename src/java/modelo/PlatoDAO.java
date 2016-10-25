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

public class PlatoDAO {

    GestorJDBC gestorJDBC;
    
    public PlatoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Plato> buscar(String nombre) throws Exception {
        ArrayList<Plato> listaPlatos = new ArrayList();
        Plato plato;
        ResultSet resultado;
        if (nombre == null) {
            nombre = "";
        }
        String sentenciaSQL = "select platoid, nombre, precio, descripcion, urlfoto, estado, isactivo"
                + " from plato where nombre like '%" + nombre + "%' order by nombre";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while (resultado.next()) {                
                plato = crearObjetoPlato(resultado);
                listaPlatos.add(plato);
            }
            resultado.close();
            return listaPlatos;            
        } catch (Exception e) {
            throw new Exception("No se puede consulta");
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
    
    public Plato buscar(int platoid) throws Exception {
        Plato plato = null;
        ResultSet resultado;
        String sentenciaSQL = "select platoid, nombre, precio, descripcion, urlfoto, estado, isactivo"
                + " from plato where platoid = " + platoid;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if (resultado.next()) {                
                plato = crearObjetoPlato(resultado);
            }
            resultado.close();
            return plato;            
        } catch (Exception e) {
            throw new Exception("No se puede consulta");
        }        
    }
    
    public void ingresar(Plato plato) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "insert into plato(nombre, precio, descripcion, urlfoto, estado, isactivo) values(?,?,?,?,?,?)";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("No se puede insertar");
            }
        } catch (Exception e) {
            throw new Exception("No se puede insertar");
        }
    }
    
    private void asignarParametros(PreparedStatement sentencia, Plato plato) throws SQLException {
        sentencia.setString(1, plato.getNombre());
        sentencia.setDouble(2, plato.getPrecio());
        sentencia.setString(3, plato.getDescripcion());
        sentencia.setString(4, plato.getUrlfoto());
        sentencia.setString(5, plato.getEstado());
        sentencia.setBoolean(6, plato.isActivo());
    }
    
    public void modificar(Plato plato) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "update plato set nombre = ?, precio = ?, descripcion = ?, urlfoto = ?, estado = ?, isactivo = ? where platoid = ?";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            sentencia.setInt(7, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("No se puede modificar");
            }
        } catch (Exception e) {
            throw new Exception("No se puede modificar");
        }        
    }
    
    public void eliminar(Plato plato) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "delete from plato where platoid = ?";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("No se puede eliminar");
            }
        } catch (Exception e) {
            throw new Exception("No se puede eliminar");
        }
    }
    
}
