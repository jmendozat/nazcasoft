/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.usuario;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Persona;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConsultarClientes extends GestionarUsuarioComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
       String url="Modulos/Pedidos/Pedido/PageItemsCliente.jsp";
        try {
            String desc = request.getParameter("descCliente").trim().toUpperCase();
            GestionarServicios gestionarServicios = new GestionarServicios();
            List<Persona> listClient = gestionarServicios.buscarClientes(desc);
            request.setAttribute("listClientes", listClient);
        } catch (Exception e) {
            
        }
        return url;
    }
    
}
