/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.plato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Mensaje;
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class ModificarPlato extends GestionarPlatosComando {
    
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";        
        Plato plato;
        try {
            plato = new Plato(Integer.parseInt(request.getParameter("platoid")),
                    request.getParameter("nombre").trim().toUpperCase(),
                    Double.parseDouble(request.getParameter("precio")),
                    request.getParameter("descripcion").trim(),
                    request.getParameter("urlfoto").trim(),
                    request.getParameter("estado"));
        } catch (Exception e) {
            request.setAttribute("mensaje", Mensaje.REGISTRO_DATOSINCORRECTOS);            
            return url_forward;
        }        
        try {
            GestionarServicios gestionarPlatosServicio = new GestionarServicios();
            gestionarPlatosServicio.modificarPlato(plato);
            request.setAttribute("mensaje", Mensaje.REGISTRO_MODIFICADO);            
        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());            
        }
        return url_forward;
    }
    
}
