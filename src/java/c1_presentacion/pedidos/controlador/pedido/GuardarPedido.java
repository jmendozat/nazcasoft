/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.RealizarPedidoServicio;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author Lain
 */
public class GuardarPedido extends GestionarPedidoComando {

    private static final int MISMO_CLIENTE = 0;

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";

        try {
            int idCliente;
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
            Usuario usuario = new Usuario(persona);
            idCliente = Integer.parseInt(request.getParameter("idCliente"));
            if (idCliente == MISMO_CLIENTE) {
                pedido.setUsuario(usuario);
                RealizarPedidoServicio.getInstancia().func_NAZCA_CORE_Registrar(pedido);
            } else {
                Persona cliente = new Persona(idCliente);
                pedido.setUsuario(usuario);
                pedido.setCliente(cliente);
                RealizarPedidoServicio.getInstancia().func_NAZCA_CORE_Registrar(pedido);

            }

        } catch (NumberFormatException | ExcepcionRegla | ExcepcionSQL e) {
            url_forward = "PageReturn.jsp";
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;
    }

}
