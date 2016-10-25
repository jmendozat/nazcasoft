/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Pedido;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author Lain
 */
public class GuardarPedido extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";        
        try{    
            Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
            Persona persona = (Persona)request.getSession().getAttribute("sesUsuario");
            Usuario usuario = new Usuario(persona);
            Persona cliente = new Persona(Integer.parseInt(request.getParameter("idCliente")));
            pedido.setUsuario(usuario);
            pedido.setCliente(cliente);
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();            
            gestionarPedidosServicio.guardarPedido(pedido);
        }
        catch(Exception e){
            url_forward = "PageReturn.jsp";
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
