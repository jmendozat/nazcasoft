/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acceso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Persona;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class End extends GestionarAccesoComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
         String url_servlet = "Index";
        try {
            String respHr = request.getParameter("hr");
            if (respHr.equals("exit")) {
                Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
                if (persona != null) {
                    HttpSession sesionUsuarios = request.getSession(false);
                    sesionUsuarios.setAttribute("sesUsuario", null);
                }
            }
        } catch (Exception e) {

        }
        return url_servlet;
        
    }
    
}
