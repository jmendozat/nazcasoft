/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.administrativo.GestionarUsuarioServicio;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class RegistrarCliente extends GestionarUsuarioComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
      String url="Index";
        try {
             Persona persona = new Persona();
             persona.setNombre(request.getParameter("nombres").trim());
             persona.setCorreo(request.getParameter("correo"));
             persona.setTipousuario(Persona.TIPOCLIENTE);
             persona.setTipopersona(Persona.NATURAL);
             Usuario usuario = new Usuario(persona,persona.getCorreo(),request.getParameter("password"));         
             GestionarUsuarioServicio.getInstancia().func_NAZCA_CRUD_Crear(usuario);
             HttpSession sesionPedido = request.getSession(true);
             sesionPedido.setAttribute("sesUsuario", persona);
        } catch (ExcepcionSQL e) {
             url="NuevoCliente";
             request.setAttribute("danger", e.getMessage());
        }
        return url;
    }
    
}
