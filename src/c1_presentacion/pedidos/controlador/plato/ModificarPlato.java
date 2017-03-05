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
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author Lain
 */
public class ModificarPlato extends GestionarPlatoComando {
    
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
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "Datos incorrectos");            
            return url_forward;
        }        
        try {
            
            GestionarPlatoServicio.getInstancia().editar(plato);
            request.setAttribute("mensaje", "Registro Modificado");            
        } catch (ExcepcionSQL e) {
            request.setAttribute("mensaje", e.getMessage());            
        } catch (ExcepcionRegla ex) {
            
        }
        return url_forward;
    }
    
}
