/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConfirmarPedido extends GestionarPedidosComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";
        try {
            Persona portal = new Persona(Persona.USER_PORTAL);
            Usuario usuario = new Usuario(portal);
            Mesa mesa = new Mesa(Integer.parseInt(request.getParameter("idmesa")));
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            pedido.setMesa(mesa);
            pedido.setUsuario(usuario);
            Persona cliente = (Persona) request.getSession().getAttribute("sesUsuario");
            pedido.setCliente(cliente);
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            gestionarPedidosServicio.guardarPedido(pedido);
            pedido = new Pedido();
            HttpSession sesionPedido = request.getSession(true);
            sesionPedido.setAttribute("pedido", pedido);
        } catch (Exception e) {
            url_forward = "PageReturn.jsp";
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;
    }

}
