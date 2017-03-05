/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class DetallePlatos extends GestionarPedidoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/c1_presentacion/pedidos/view/pedido/PageDetallePlatos.jsp";
    }
    
}
