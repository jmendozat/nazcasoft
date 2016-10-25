/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acceso;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Pedido;
import modelo.Plato;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ViewPlatos extends GestionarAccesoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String ruta = "viewPlatos.jsp";
        try {
            GestionarServicios gestionarServicio = new GestionarServicios();
            List<Plato> listaPlatos = gestionarServicio.buscarPlatos("");
            request.setAttribute("listViewPlatos", listaPlatos);
            Pedido pedido = new Pedido();
            HttpSession sesionPedido = request.getSession(true);
            sesionPedido.setAttribute("pedido", pedido);
        } catch (Exception e) {
        }
        return ruta;
    }

}
