/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.acceso;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.administrativo.servicio.GestionarInterfaceServicio;
import c3_dominio.administrativo.entidad.Interface;
import c3_dominio.administrativo.entidad.Persona;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Index extends GestionarAdministrativoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_Page = "/WEB-INF/c1_presentacion/administrativo/Index.jsp";
        Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
        if (persona != null) {
            try {
                List<Interface> listaInterface = GestionarInterfaceServicio.getInstancia().func_NAZCA_ADM_ObtenerModulosPorUsuario(persona.getCodigo());
                request.setAttribute("listInterface", listaInterface);
                
                
            } catch (ExcepcionSQL e) {

            }
        } else {
            url_Page = "Login";
        }
        return url_Page;

    }

}
