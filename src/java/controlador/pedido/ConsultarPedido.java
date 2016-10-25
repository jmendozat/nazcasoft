/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Mensaje;
import modelo.Mesa;
import modelo.Pedido;

/**
 *
 * @author Lain
 */
public class ConsultarPedido extends GestionarPedidosComando{
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_pagina="Modulos/Pedidos/Pedido/PageDetallePedido.jsp";
        try {
            
            int mesaid = Integer.parseInt(request.getParameter("mesaid")); 
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            Mesa mesa = gestionarPedidosServicio.buscarMesa(mesaid);
             if(mesa != null){
                Pedido pedido;               
                pedido = gestionarPedidosServicio.buscarPedido(mesa);
                   
                HttpSession sesionPedido = request.getSession(true);
                sesionPedido.setAttribute("pedido", pedido);
            }
            else{
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }
            
        } catch (Exception e) {
           
        }
        return url_pagina;
    }
}
