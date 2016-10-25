/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pedido;

/**
 *
 * @author Lain
 */
public class EliminarPlatoDePedido extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "c1_presentacion/vista/PaginaRegistrarPedido.jsp"; 
        int platoid = Integer.parseInt(request.getParameter("platoid"));
        Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
        pedido.eliminarLineaDePedido(platoid);
        return url_forward;
    }
    
}
