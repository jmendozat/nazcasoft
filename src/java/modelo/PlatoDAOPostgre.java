/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PlatoDAOPostgre{
GestorJDBC gestorJDBC;

    public PlatoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public List<Plato> buscar(String nombre) throws Exception{
        ArrayList<Plato> listaPlatos = new ArrayList();
        Plato plato;
        ResultSet resultado;
        if(nombre == null)
            nombre = "";
        String sentenciaSQL = "select platoid, nombre, precio"
                + " from plato where nombre like '%" + nombre + "%' order by nombre";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while(resultado.next()){            
                plato = crearObjetoPlato(resultado);
                listaPlatos.add(plato);
            }
            resultado.close();
            return listaPlatos;    
        } catch (Exception e) {
            throw new Exception("Error al consultar");
        }            
    }       

    private Plato crearObjetoPlato(ResultSet resultado) throws Exception {
        return new Plato(resultado.getInt("platoid"),resultado.getString("nombre"),resultado.getDouble("precio"));
    }

    public Plato buscar(int platoid) throws Exception {
        Plato plato = null;
        ResultSet resultado;
        String sentenciaSQL = "select platoid, nombre, precio"
                + " from plato where platoid = " + platoid;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if(resultado.next()){            
                plato = crearObjetoPlato(resultado);
            }
            resultado.close();
            return plato; 
        } catch (Exception e) {
            throw new Exception("Error al consultar");
        }        
    }

    public void ingresar(Plato plato) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "insert into plato(nombre, precio) values(?,?)";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw new Exception("Error al insertar");
            }
        } catch (Exception e) {
             throw new Exception("Error al insertar");
        }
    }

    private void asignarParametros(PreparedStatement sentencia, Plato plato) throws Exception {
        sentencia.setString(1, plato.getNombre());
        sentencia.setDouble(2, plato.getPrecio());
    }

    public void modificar(Plato plato) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "update plato set nombre = ?, precio = ? where platoid = ?";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, plato);
            sentencia.setInt(3, plato.getPlatoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw new Exception("Error al modificar");
            }
        } catch (Exception e) {
             throw new Exception("Error al modificar");
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
            if(registros_afectados == 0){
                throw new Exception("Error al eliminar el plato");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el plato");
        }
    }


    
}
