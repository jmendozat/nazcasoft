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
public class ModificarPlato extends GestionarPlatosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "ConsultarPlato";                
        Plato plato;
        try {
            plato = new Plato(Integer.parseInt(request.getParameter("platoid")),request.getParameter("nombre"),Double.parseDouble(request.getParameter("precio")));
        } catch (Exception e) {
            request.setAttribute("mensaje", "Datos incorrectos"); 
            return url_forward;
        }          
        try{
            GestionarServicios gestionarPlatosServicio = new GestionarServicios();
            gestionarPlatosServicio.modificar(plato);
            request.setAttribute("mensaje", "Modificado"); 
            url_forward = "ConsultarPlatos";
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
