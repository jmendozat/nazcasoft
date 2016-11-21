/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.pedidos.GestionarMesaServicio;
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
public class GestionarPedido extends GestionarPedidoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "/WEB-INF/c1_presentacion/pedidos/view/pedido/PageNewPedido.jsp";
        int mesaid = Integer.parseInt(request.getParameter("mesaid"));
        try {
            Mesa mesa = GestionarMesaServicio.getInstancia().func_NAZCA_CRUD_Buscar(mesaid);
            if (mesa != null) {
                if (mesa.isDisponible()) {
                    Pedido pedido;
                    mesa.setDisponible(false);
                    pedido = new Pedido(mesa);
                    FabricaEstrategia fabricaEstrategia = FabricaEstrategia.getInstancia();
                    ICalculoDescuento estrategiaDescuento = fabricaEstrategia.crearCalculoDescuento(pedido);
                    pedido.setEstrategiadescuento(estrategiaDescuento);
                    HttpSession sesionPedido = request.getSession(true);
                    sesionPedido.setAttribute("pedido", pedido);
                }

            } else {
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;
    }

}
