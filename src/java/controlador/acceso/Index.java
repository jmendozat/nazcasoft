/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acceso;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarServicios;
import modelo.Interface;
import modelo.Persona;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Index extends GestionarAccesoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_Page = "Modulos/Index.jsp";
        Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
        if (persona != null) {
            GestionarServicios gestionarServicios = new GestionarServicios();
            try {
                List<Interface> listaInterface = gestionarServicios.NAZCASOFT_ADM_ObtenerModuloPorUsuario(persona.getCodigo());
                request.setAttribute("listInterface", listaInterface);
            } catch (Exception e) {
            }
        } else {
            url_Page = "Login.jsp";
        }
        return url_Page;
    }

}
