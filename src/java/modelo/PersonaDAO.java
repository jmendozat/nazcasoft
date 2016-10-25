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

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PersonaDAO {

    GestorJDBC gestorJDBC;

    public PersonaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int crearCliente(Persona persona) throws Exception {
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

        } catch (Exception e) {
            throw new Exception("Error de comunicacion de datos");
        }

    }

    public List<Persona> buscarPersonaCliente(String nombre) throws Exception {

        ArrayList<Persona> listaClientes = new ArrayList();
        Persona persona;
        ResultSet resultado;
        if (nombre == null) {
            nombre = "";
        }
        String sentenciaSQL = "select codigopersona, nombre, apellidosper, razonsocial, direccion,tipopersona, urlfotoperil\n"
                + "from persona \n"
                + "where tipousuario = 'Cliente' and isactivo = true and nombre like '%"+nombre+"%' or apellidosper like '%"+nombre+"%' ";
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
        } catch (Exception e) {
            throw new Exception("No se puede consulta");
        }
    }
}
