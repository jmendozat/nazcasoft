/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo;

import java.util.List;
import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.entidad.Interface;
import c4_persistencia.GestorJDBC;
import c4_persistencia.administrativo.fabricaDAO.FabricaAdministrativoDAO;
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
        FabricaAdministrativoDAO fabricaAdministrativoDAO = FabricaAdministrativoDAO.getInstancia();
        gestorJDBC = fabricaAdministrativoDAO.crearGestorJDBC();
        interfaceDAO = fabricaAdministrativoDAO.crearInterfaceDAO(gestorJDBC);
    }

    
    public List<Interface> func_NAZCA_ADM_ObtenerModulosPorUsuario(int codigoUsuario) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Interface> listaInterface = interfaceDAO.func_NAZCA_ADM_ObtenerModulosPorUsuario(codigoUsuario);
            gestorJDBC.cerrarConexion();
            return listaInterface;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    
    public void func_NAZCA_CRUD_Crear(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Editar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Eliminar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Interface func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

