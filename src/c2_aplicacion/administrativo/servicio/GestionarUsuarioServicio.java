/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo.servicio;

import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.contrato.IUsuarioDAO;
import c3_dominio.administrativo.entidad.Interface;
import c3_dominio.administrativo.entidad.Permiso;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c4_persistencia.GestorJDBC;
import c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarUsuarioServicio {

    GestorJDBC gestorJDBC;
    IUsuarioDAO usuarioDAO;
    IPersonaDAO personaDAO;
    IPermisoDAO permisoDAO;

    private static GestionarUsuarioServicio instancia;

    public static GestionarUsuarioServicio getInstancia() {
        if (instancia == null) {
            instancia = new GestionarUsuarioServicio();
        }
        return instancia;
    }

    public GestionarUsuarioServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        usuarioDAO = fabricaAbstractaDAO.crearUsuarioDAO(gestorJDBC);
        personaDAO = fabricaAbstractaDAO.crearPersonaDAO(gestorJDBC);
        permisoDAO = fabricaAbstractaDAO.crearPermisoDAO(gestorJDBC);
    }

    public Persona login(Usuario usuario) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Persona persona = usuarioDAO.login(usuario);
            gestorJDBC.cerrarConexion();

            return persona;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void crear(Usuario usuario) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            Persona persona = usuario.getPersona();
            persona.setCodigo(personaDAO.crearPersona(persona));
            usuario.setPersona(persona);
            usuarioDAO.crear(usuario);
            Permiso permiso = new Permiso();
            permiso.setUsuario(usuario);
            for(int i=0; i<Permiso.DEFAULT_CLIENTE.length; i++){
                Interface intFace = new Interface();
                intFace.setCodigoInterface(Permiso.DEFAULT_CLIENTE[i]);
                permiso.agregarInterface(intFace);
            }
            permisoDAO.crear(permiso);
            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void editar(Usuario usuario) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Usuario usuario) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
