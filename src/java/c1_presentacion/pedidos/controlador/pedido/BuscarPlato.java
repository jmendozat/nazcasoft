/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.pedidos.servicio.GestionarPlatoServicio;
import c3_dominio.administrativo.entidad.Mensaje;
import c3_dominio.pedidos.entidad.Plato;
import c5_transversal.excepciones.ExcepcionSQL;
/**
 *
 * @author Lain
 */
public class BuscarPlato extends GestionarPedidoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_forward = "BuscarPlatos";
        int platoid = Integer.parseInt(request.getParameter("platoid"));                
        try{
           
            Plato plato = GestionarPlatoServicio.getInstancia().func_NAZCA_CRUD_Buscar(platoid);
            if(plato != null){
                request.setAttribute("plato", plato);
            }
            else{
                request.setAttribute("mensaje", Mensaje.REGISTRO_NO_EXISTE);
            }
        }
        catch(ExcepcionSQL e){
            request.setAttribute("mensaje", e.getMessage());
        }         
        return url_forward; 
    }
    
}
