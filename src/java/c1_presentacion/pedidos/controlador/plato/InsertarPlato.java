/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.plato;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.GestionarPlatoServicio;
import c3_dominio.pedidos.entidad.Plato;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author Lain
 */
public class InsertarPlato extends GestionarPlatoComando {
    
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response){
        String url_forward = "PageReturn.jsp";        
        Plato plato;
        try {
            plato = new Plato();
            plato.setNombre(request.getParameter("nombre").trim().toUpperCase());            
            plato.setPrecio(Double.parseDouble(request.getParameter("precio")));
            plato.setDescripcion(request.getParameter("descripcion").trim());
            plato.setUrlfoto(request.getParameter("urlfoto").trim());
            
        } catch (NumberFormatException e) {
            return url_forward;
        }        
        try {            
            GestionarPlatoServicio.getInstancia().func_NAZCA_CRUD_Crear(plato);
        } catch (ExcepcionSQL e) {
            request.setAttribute("mensaje", e.getMessage());            
        } catch (ExcepcionRegla ex) {
            Logger.getLogger(InsertarPlato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url_forward;
    }
    
}
