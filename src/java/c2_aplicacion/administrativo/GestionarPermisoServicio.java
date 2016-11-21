/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo;

import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.entidad.Permiso;
import c4_persistencia.GestorJDBC;
import c4_persistencia.administrativo.fabricaDAO.FabricaAdministrativoDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarPermisoServicio {
    GestorJDBC gestorJDBC;
    IPermisoDAO permisoDAO;
    private static GestionarPermisoServicio instancia;
    
    public static GestionarPermisoServicio getInstancia(){
     if(instancia==null)
         instancia = new GestionarPermisoServicio();
     return instancia;
    }

    public GestionarPermisoServicio() {
        FabricaAdministrativoDAO fabricaAdministrativoDAO = FabricaAdministrativoDAO.getInstancia();
        gestorJDBC = fabricaAdministrativoDAO.crearGestorJDBC();
        permisoDAO = fabricaAdministrativoDAO.crearPermisoDAO(gestorJDBC);
                
    }

    
    public void func_NAZCA_CRUD_Crear(Permiso permiso) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            permisoDAO.func_NAZCA_CRUD_Crear(permiso);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    
    public void func_NAZCA_CRUD_Editar(Permiso permiso) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Eliminar(Permiso permiso) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Permiso func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
