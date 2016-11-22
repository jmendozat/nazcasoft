/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.GestionarMesaServicio;
import c3_dominio.pedidos.entidad.Mesa;
import c5_transversal.excepciones.ExcepcionSQL;

public class ConsultarMesasDePedido extends GestionarPedidoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "";
        try {
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            List<Mesa> listaMesas = GestionarMesaServicio.getInstancia().func_NAZCA_ADM_PEDIDOS_MESA_Listar();
            request.setAttribute("listaMesas", listaMesas);
            if (tipo > 10) {
                url_forward = "/WEB-INF/c1_presentacion/pedidos/view/pedido/PageBuscarMesas.jsp";
            } else {
                url_forward = "/WEB-INF/c1_presentacion/pedidos/view/pedido/PageMostrarMesas.jsp";
            }

        } catch (NumberFormatException | ExcepcionSQL e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;
    }

}
