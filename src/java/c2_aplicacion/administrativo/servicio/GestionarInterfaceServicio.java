/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo.servicio;

import java.util.List;
import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.entidad.Interface;
import c4_persistencia.GestorJDBC;
import c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarInterfaceServicio{
    GestorJDBC gestorJDBC;
    IInterfaceDAO interfaceDAO;
    private static GestionarInterfaceServicio instancia;
    
    public static GestionarInterfaceServicio getInstancia(){
     if(instancia==null){
      instancia = new GestionarInterfaceServicio();
     }
     return instancia;
    }

    public GestionarInterfaceServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        interfaceDAO = fabricaAbstractaDAO.crearInterfaceDAO(gestorJDBC);
    }

    
    public List<Interface> obtenerModulosPorUsuario(int codigoUsuario) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Interface> listaInterface = interfaceDAO.obtenerModulosPorUsuario(codigoUsuario);
            gestorJDBC.cerrarConexion();
            return listaInterface;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    
    public void crear(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void editar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void eliminar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Interface buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

