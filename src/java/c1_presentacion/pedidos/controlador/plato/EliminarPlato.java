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

/**
 *
 * @author Lain
 */
public class EliminarPlato extends GestionarPlatoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "PageReturn.jsp";                
        Plato plato = new Plato(Integer.parseInt(request.getParameter("platoid")));        
        try{
            GestionarPlatoServicio.getInstancia().func_NAZCA_CRUD_Eliminar(plato);           
        }
        catch(ExcepcionSQL e){
            request.setAttribute("mensaje", e.getMessage()); 
        }
        return url_forward;
    }
    
}
