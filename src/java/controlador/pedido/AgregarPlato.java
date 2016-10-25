/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;
import modelo.GestionarServicios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pedido;
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class AgregarPlato extends GestionarPedidosComando{
    
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "BuscarPlato"; 
        int platoid, cantidad;
        try {
            platoid = Integer.parseInt(request.getParameter("platoid"));
            cantidad = Integer.parseInt(request.getParameter("cantidad"));            
        } catch (Exception e) {
            request.setAttribute("mensaje", "Datos incorrectos"); 
            return url_forward;
        }        
        try{    
            GestionarServicios gestionarPedidoServicio = new GestionarServicios();
            Plato plato = gestionarPedidoServicio.buscar(platoid);
            Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
            pedido.agregarLineaDePedido(plato, cantidad);
            url_forward = "BuscarPlatos";            
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
