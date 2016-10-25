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
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class BuscarPlatos extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "Modulos/Pedidos/Pedido/PagePlatosSearch.jsp";  
        String nombre = request.getParameter("nombreplato").trim().toUpperCase();                
        try{
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();  
            List<Plato> listaPlatos = gestionarPedidosServicio.buscarPlatos(nombre);       
            request.setAttribute("listaPlatos", listaPlatos);
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }        
        return url_forward; 
    }
    
}
