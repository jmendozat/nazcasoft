/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo;

import java.util.List;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.entidad.Persona;
import c4_persistencia.GestorJDBC;
import c4_persistencia.administrativo.fabricaDAO.FabricaAdministrativoDAO;
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
        FabricaAdministrativoDAO fabricaAdministrativo = FabricaAdministrativoDAO.getInstancia();
        gestorJDBC = fabricaAdministrativo.crearGestorJDBC();
        personaDAO = fabricaAdministrativo.crearPersonaDAO(gestorJDBC);
    }

    public int func_NAZCA_ADM_CLIENTE_Crear(Persona persona) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            int resultado = personaDAO.func_NAZCA_ADM_CLIENTE_Crear(persona);
            gestorJDBC.cerrarConexion();
            return resultado;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public List<Persona> func_NAZCA_ADM_CLIENTE_Buscar(String nombre) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Persona> listaPersona = personaDAO.func_NAZCA_ADM_CLIENTE_Buscar(nombre);
            gestorJDBC.cerrarConexion();
            return listaPersona;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void func_NAZCA_CRUD_Crear(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void func_NAZCA_CRUD_Editar(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void func_NAZCA_CRUD_Eliminar(Persona objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Persona func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
