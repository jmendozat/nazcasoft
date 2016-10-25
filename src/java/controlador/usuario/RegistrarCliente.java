/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Persona;
import modelo.Usuario;

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
             GestionarServicios gestionarServicios = new GestionarServicios();
             gestionarServicios.crearCliente(usuario);
             HttpSession sesionPedido = request.getSession(true);
             sesionPedido.setAttribute("sesUsuario", persona);
        } catch (Exception e) {
             url="NuevoCliente";
             request.setAttribute("danger", e.getMessage());
        }
        return url;
    }
    
}
