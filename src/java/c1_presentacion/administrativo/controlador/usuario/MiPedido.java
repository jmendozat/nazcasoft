/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c3_dominio.pedidos.entidad.Pedido;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class MiPedido extends GestionarUsuarioComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/c1_presentacion/pedidos/view/pedido/PagePedidoCliente.jsp";
        try {
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            if (pedido == null) {
                pedido = new Pedido();
                HttpSession sesionPedido = request.getSession(true);
                sesionPedido.setAttribute("pedido", pedido);
            }

        } catch (Exception e) {
        }
        return url;
    }

}
