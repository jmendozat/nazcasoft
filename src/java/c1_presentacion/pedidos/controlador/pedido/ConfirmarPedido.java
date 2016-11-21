/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.pedidos.RealizarPedidoServicio;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConfirmarPedido extends GestionarPedidoComando {

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
            RealizarPedidoServicio.getInstancia().func_NAZCA_CORE_Registrar(pedido);
            pedido = new Pedido();
            HttpSession sesionPedido = request.getSession(true);
            sesionPedido.setAttribute("pedido", pedido);
        } catch (NumberFormatException | ExcepcionRegla | ExcepcionSQL e) {
            url_forward = "PageReturn.jsp";
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;
    }

}
