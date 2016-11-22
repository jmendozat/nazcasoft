/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.plato;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.GestionarPlatoServicio;
import c3_dominio.pedidos.entidad.Plato;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author Lain
 */
public class ConsultarPlatos extends GestionarPlatoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "/WEB-INF/c1_presentacion/pedidos/view/plato/PageBuscarPlatos.jsp";  
        String nombre = request.getParameter("nombreplato").trim().toUpperCase();                
        try{  
            List<Plato> listaPlatos = GestionarPlatoServicio.getInstancia().func_NAZCA_PEDIDO_BuscarPlatoPorNombre(nombre);
            request.setAttribute("listaPlatos", listaPlatos);
        }
        catch(ExcepcionSQL e){
            request.setAttribute("mensaje", e.getMessage());
        }        
        return url_forward; 
    }
    
}
