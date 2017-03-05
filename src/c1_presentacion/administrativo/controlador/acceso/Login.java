/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.acceso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c3_dominio.administrativo.entidad.Persona;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Login extends GestionarAdministrativoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_Servlet = "/WEB-INF/c1_presentacion/administrativo/view/Login.jsp";
        try {
            Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
            if (persona != null) {
                url_Servlet = "Index";
            }
        } catch (Exception e) {

        }
        return url_Servlet;
    }

}
