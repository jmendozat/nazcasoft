/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;
import modelo.GestionarServicios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class BuscarPlatos extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "c1_presentacion/vista/PaginaBuscarPlatos.jsp";  
        String nombre = request.getParameter("nombreplato");                
        try{
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();  
            List<Plato> listaPlatos = gestionarPedidosServicio.buscar(nombre);       
            request.setAttribute("listaPlatos", listaPlatos);
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }        
        return url_forward; 
    }
    
}
