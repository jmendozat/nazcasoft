/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.plato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.GestionarPlatoServicio;
import c3_dominio.pedidos.entidad.Plato;
import c5_transversal.excepciones.ExcepcionSQL;

public class ConsultarPlato extends GestionarPlatoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "/WEB-INF/c1_presentacion/pedidos/view/plato/PageEditarPlato.jsp";
        int platoid = Integer.parseInt(request.getParameter("platoid"));                
        try{
            
            Plato plato = GestionarPlatoServicio.getInstancia().buscar(platoid);
            if(plato != null){
                request.setAttribute("plato", plato);
                url_forward = "/WEB-INF/c1_presentacion/pedidos/view/plato/PageEditarPlato.jsp";
            }
            else{
                request.setAttribute("mensaje", "registro no existe");
            }
        }
        catch(ExcepcionSQL e){
            request.setAttribute("mensaje", e.getMessage());
        }         
        return url_forward; 
    }
    
}
