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
import modelo.Plato;

/**
 *
 * @author Lain
 */
public class BuscarPlato extends GestionarPedidosComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "BuscarPlatos";
        int platoid = Integer.parseInt(request.getParameter("platoid"));                
        try{
            GestionarServicios gestionarPedidosServicio = new GestionarServicios();
            Plato plato = gestionarPedidosServicio.buscarPlato(platoid);
            if(plato != null){
                request.setAttribute("plato", plato);
                url_forward = "vista/PaginaAgregarPlato.jsp";
            }
            else{
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }
        }
        catch(Exception e){
            request.setAttribute("mensaje", e.getMessage());
        }         
        return url_forward; 
    }
    
}
