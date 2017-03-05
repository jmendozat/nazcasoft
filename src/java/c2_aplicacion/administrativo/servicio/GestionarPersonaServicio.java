/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo.servicio;

import java.util.List;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.entidad.Persona;
import c4_persistencia.GestorJDBC;
import c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarPersonaServicio {

    GestorJDBC gestorJDBC;
    IPersonaDAO personaDAO;

    private static GestionarPersonaServicio instancia;

    public static GestionarPersonaServicio getInstancia() {
        if (instancia == null) {
            instancia = new GestionarPersonaServicio();
        }
        return instancia;
    }

    public GestionarPersonaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        personaDAO = fabricaAbstractaDAO.crearPersonaDAO(gestorJDBC);
    }

    public int crearPersona(Persona persona) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            int resultado = personaDAO.crearPersona(persona);
            gestorJDBC.cerrarConexion();
            return resultado;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public List<Persona> buscar(String nombre) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Persona> listaPersona = personaDAO.buscar(nombre);
            gestorJDBC.cerrarConexion();
            return listaPersona;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void crear(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Persona buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
