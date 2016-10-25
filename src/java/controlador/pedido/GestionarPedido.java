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
public class GestionarPedido extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "Modulos/Pedidos/Pedido/PageNewPedido.jsp";
        int mesaid = Integer.parseInt(request.getParameter("mesaid")); 
        try{
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            Mesa mesa = gestionarPedidosServicio.buscarMesa(mesaid);
            if(mesa != null){
                Pedido pedido = null;               
                if(mesa.isDisponible()){
                    mesa.setDisponible(false);
                    pedido = new Pedido(mesa);
                }
                HttpSession sesionPedido = request.getSession(true);
                sesionPedido.setAttribute("pedido", pedido);
            }
            else{
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }  
        return url_forward; 
    }
    
}
