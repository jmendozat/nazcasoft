/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.administrativo.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.entidad.Persona;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PersonaDAOPostgre implements IPersonaDAO {

    GestorJDBC gestorJDBC;

    public PersonaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void func_NAZCA_CRUD_Crear(Persona persona) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Editar(Persona persona) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Eliminar(Persona persona) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int func_NAZCA_ADM_CLIENTE_Crear(Persona persona) throws ExcepcionSQL {
        try {
            int codigopersona = 0;
            String sentenciaSQL = "insert into persona (fecharegistro, nombre,correo, isactivo, tipousuario,tipopersona,urlfotoperil) values (?,?,?,?,?,?,?)";
            String consultaSQL = "select max(codigopersona) codigopersona from persona";
            PreparedStatement sentencia;
            ResultSet resultado;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setDate(1, persona.getFechaRegistro());
            sentencia.setString(2, persona.getNombre());
            sentencia.setString(3, persona.getCorreo());
            sentencia.setBoolean(4, persona.isActivo());
            sentencia.setString(5, persona.getTipousuario());
            sentencia.setString(6, persona.getTipopersona());
            sentencia.setString(7, persona.getUrlfotoperfil());
            sentencia.executeUpdate();
            sentencia.close();
            resultado = gestorJDBC.ejecutarConsulta(consultaSQL);
            if (resultado.next()) {
                codigopersona = resultado.getInt("codigopersona");
            }
            resultado.close();
            return codigopersona;

        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public List<Persona> func_NAZCA_ADM_CLIENTE_Buscar(String nombre) throws ExcepcionSQL {
        ArrayList<Persona> listaClientes = new ArrayList();
        Persona persona;
        ResultSet resultado;
        if (nombre == null) {
            nombre = "";
        }
        String sentenciaSQL = "select codigopersona, nombre, apellidosper, razonsocial, direccion,tipopersona, urlfotoperil\n"
                + "from persona \n"
                + "where tipousuario = 'Cliente' and isactivo = true and nombre like '%" + nombre + "%' or apellidosper like '%" + nombre + "%' ";
        try {
            resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while (resultado.next()) {
                persona = new Persona();
                persona.setCodigo(resultado.getInt("codigopersona"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellidos(resultado.getString("apellidosper"));
                persona.setRazonsocial(resultado.getString("razonsocial"));
                persona.setDireccion(resultado.getString("direccion"));
                persona.setTipopersona(resultado.getString("tipopersona"));
                persona.setUrlfotoperfil(resultado.getString("urlfotoperil"));
                listaClientes.add(persona);
            }
            resultado.close();
            return listaClientes;
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }

    }

}
