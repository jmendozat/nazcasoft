/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.venta;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Mesa;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConsultarMesasConPedido extends GestionarVentaComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "Modulos/Ventas/Pagos/PageBuscarMesas.jsp";
        try {
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            List<Mesa> listaMesas = gestionarPedidosServicio.buscarMesas();
            request.setAttribute("listaMesas", listaMesas);
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
        }
        return url_forward;

    }

}
