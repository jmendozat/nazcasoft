/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.GestionarPlatoServicio;
import c3_dominio.administrativo.entidad.Mensaje;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.pedidos.entidad.Plato;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarPlato extends GestionarPedidoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";
        int platoid, cantidad;
        try {
            platoid = Integer.parseInt(request.getParameter("platoid"));
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", Mensaje.REGISTRO_DATOSINCORRECTOS);
            return url_forward;
        }
        try {
            Plato plato = GestionarPlatoServicio.getInstancia().func_NAZCA_CRUD_Buscar(platoid);
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            pedido.agregarLineaDePedido(plato, cantidad);
        } catch (ExcepcionSQL e) {
            request.setAttribute("mensaje", e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(AgregarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url_forward;
    }

}
