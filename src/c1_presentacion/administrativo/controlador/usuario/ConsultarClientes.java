/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.usuario;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.administrativo.servicio.GestionarPersonaServicio;
import c3_dominio.administrativo.entidad.Persona;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConsultarClientes extends GestionarUsuarioComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
       String url="/WEB-INF/c1_presentacion/pedidos/view/pedido/PageItemsCliente.jsp";
        try {
            String desc = request.getParameter("descCliente").trim().toUpperCase();
            List<Persona> listClient = GestionarPersonaServicio.getInstancia().buscar(desc);
            request.setAttribute("listClientes", listClient);
        } catch (ExcepcionSQL e) {
            Logger.getLogger(ConsultarClientes.class.getName()).log(Level.SEVERE, null, e);
        }
        return url;
    }
    
}
