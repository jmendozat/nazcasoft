/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Mesa;


public class ConsultarMesasDePedido extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward="";  
        try{
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();  
            List<Mesa> listaMesas = gestionarPedidosServicio.buscarMesas();
            request.setAttribute("listaMesas", listaMesas);
            if(tipo > 10){
                url_forward = "Modulos/Pedidos/Pedido/PageBuscarMesas.jsp";
            }else{
             url_forward  = "Modulos/Pedidos/Pedido/PageMostrarMesas.jsp";
            }
               
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }        
        return url_forward; 
    }
    
}
