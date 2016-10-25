/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Pedido;

/**
 *
 * @author Lain
 */
public class GuardarPedido extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "ConsultarMesasDePedido";        
        try{    
            Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();            
            gestionarPedidosServicio.ingresar(pedido);
        }
        catch(Exception e){
            url_forward = "c1_presentacion/vista/PaginaRegistrarPedido.jsp";
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
