/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo.servicio;

import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.entidad.Permiso;
import c4_persistencia.GestorJDBC;
import c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
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

    public static GestionarPermisoServicio getInstancia() {
        if (instancia == null) {
            instancia = new GestionarPermisoServicio();
        }
        return instancia;
    }

    public GestionarPermisoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        permisoDAO = fabricaAbstractaDAO.crearPermisoDAO(gestorJDBC);

    }

    public void crear(Permiso permiso) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            permisoDAO.crear(permiso);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void editar(Permiso permiso) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Permiso permiso) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Permiso buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
