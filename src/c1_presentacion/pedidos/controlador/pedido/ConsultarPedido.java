/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.pedidos.servicio.GestionarMesaServicio;
import c2_aplicacion.pedidos.servicio.RealizarPedidoServicio;
import c3_dominio.administrativo.entidad.Mensaje;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.pedidos.servicio.factoryestrategia.FabricaEstrategia;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author Lain
 */
public class ConsultarPedido extends GestionarPedidoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_pagina = "/WEB-INF/c1_presentacion/pedidos/view/pedido/PageDetallePedido.jsp";
        try {

            int mesaid = Integer.parseInt(request.getParameter("mesaid"));
            Mesa mesa = GestionarMesaServicio.getInstancia().buscar(mesaid);
            if (mesa != null) {
                Pedido pedido;
                pedido = RealizarPedidoServicio.getInstancia().buscar(mesa);
                FabricaEstrategia fabricaEstrategia = FabricaEstrategia.getInstancia();
                ICalculoDescuento estrategiaDescuento = fabricaEstrategia.crearCalculoDescuento(pedido);
                pedido.setEstrategiadescuento(estrategiaDescuento);
                HttpSession sesionPedido = request.getSession(true);
                sesionPedido.setAttribute("pedido", pedido);
            } else {
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }

        } catch (NumberFormatException | ExcepcionSQL | ExcepcionRegla e) {

        }
        return url_pagina;
    }
}
