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

public class MesaDAOPostgre {
   GestorJDBC gestorJDBC;

    public MesaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    
    public List<Mesa> buscar() throws Exception {
        ArrayList<Mesa> listaMesas = new ArrayList();
        Mesa mesa;
        ResultSet resultado;
        String sentenciaSQL = "select mesaid, numero, disponible "
                + "from mesa order by numero";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while(resultado.next()){            
                mesa = crearObjetoMesa(resultado);
                listaMesas.add(mesa);
            }
            resultado.close();
            return listaMesas;    
        } catch (Exception e) {
            throw new Exception("Error al consultar la mesa");
        }  
    }
    
    private Mesa crearObjetoMesa(ResultSet resultado) throws Exception {
        return new Mesa(resultado.getInt("mesaid"),resultado.getInt("numero"),resultado.getBoolean("disponible"));
    }

    
    public Mesa buscar(int mesaid) throws Exception {
        Mesa mesa = null;
        ResultSet resultado;
        String sentenciaSQL = "select mesaid, numero, disponible"
                + " from mesa where mesaid = " + mesaid;
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            if(resultado.next()){            
                mesa = crearObjetoMesa(resultado);
            }
            resultado.close();
            return mesa; 
        } catch (Exception e) {
            throw new Exception("Error al consultar la mesa");
        }  
    }

    
    public void ingresar(Mesa mesa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void asignarParametros(PreparedStatement sentencia, Mesa mesa) throws Exception {
        sentencia.setInt(1, mesa.getNumero());
        sentencia.setBoolean(2, mesa.isDisponible());
    }

    
    public void modificar(Mesa mesa) throws Exception {
        int registros_afectados;
        String sentenciaSQL = "update mesa set numero = ?, disponible = ? where mesaid = ?";
        try {
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, mesa);
            sentencia.setInt(3, mesa.getMesaid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                 throw new Exception("Error al modficar la mesa");
            }
        } catch (Exception e) {
            throw new Exception("Error al modficar la mesa");
        } 
    }

    
    public void eliminar(Mesa mesa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
