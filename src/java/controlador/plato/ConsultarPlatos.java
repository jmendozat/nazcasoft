/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.plato;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class ConsultarPlatos extends GestionarPlatosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "Modulos/Pedidos/Platos/PageBuscarPlatos.jsp";  
        String nombre = request.getParameter("nombreplato").trim().toUpperCase();                
        try{
            GestionarServicios gestionarPlatosServicio = new GestionarServicios();  
            List<Plato> listaPlatos = gestionarPlatosServicio.buscarPlatos(nombre);       
            request.setAttribute("listaPlatos", listaPlatos);
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }        
        return url_forward; 
    }
    
}
