/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Mensaje;
import modelo.Pedido;
import modelo.Plato;


public class AgregarPlato extends GestionarPedidosComando{
    
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp"; 
        int platoid, cantidad;
        try {
            platoid = Integer.parseInt(request.getParameter("platoid"));
            cantidad = Integer.parseInt(request.getParameter("cantidad"));            
        } catch (Exception e) {
            request.setAttribute("mensaje", Mensaje.REGISTRO_DATOSINCORRECTOS); 
            return url_forward;
        }        
        try{    
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            Plato plato = gestionarPedidosServicio.buscarPlato(platoid);
            Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
            pedido.agregarLineaDePedido(plato, cantidad);           
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
