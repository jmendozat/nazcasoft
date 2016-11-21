/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.ventas.controlador.venta;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.GestionarMesaServicio;
import c3_dominio.pedidos.entidad.Mesa;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConsultarMesasConPedido extends GestionarVentaComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "/WEB-INF/c1_presentacion/ventas/view/pago/PageBuscarMesas.jsp";
        try {
            List<Mesa> listaMesas = GestionarMesaServicio.getInstancia().func_NAZCA_ADM_PEDIDOS_MESA_Listar();
            request.setAttribute("listaMesas", listaMesas);
        } catch (ExcepcionSQL e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;

    }

}
