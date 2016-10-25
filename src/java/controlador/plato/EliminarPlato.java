/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.plato;

import modelo.GestionarServicios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class EliminarPlato extends GestionarPlatosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "ConsultarPlatos";                
        Plato plato = new Plato(Integer.parseInt(request.getParameter("platoid")));        
        try{
            GestionarServicios gestionarPlatosServicio = new GestionarServicios();
            gestionarPlatosServicio.eliminar(plato);
            request.setAttribute("mensaje", "Registro Eliminado"); 
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
