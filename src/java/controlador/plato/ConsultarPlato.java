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
public class ConsultarPlato extends GestionarPlatosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "ConsultarPlatos";
        int platoid = Integer.parseInt(request.getParameter("platoid"));                
        try{
            GestionarServicios gestionarPlatosServicio = new GestionarServicios();
            Plato plato = gestionarPlatosServicio.buscar(platoid);
            if(plato != null){
                request.setAttribute("plato", plato);
                url_forward = "c1_presentacion/vista/PaginaEditarPlato.jsp";
            }
            else{
                request.setAttribute("mensaje", "El regisotr no existe");
            }
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }         
        return url_forward; 
    }
    
}
