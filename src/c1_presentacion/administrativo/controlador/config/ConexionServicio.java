/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import c2_aplicacion.administrativo.servicio.GestionarConexion;
import c5_transversal.seguridad.EConexion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConexionServicio extends ConfiguracionComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String url_servlet = "/WEB-INF/c1_presentacion/administrativo/view/config/PageConfEstrategy.html";
        try {
            EConexion conexion = GestionarConexion.getInstancia().mostrar();
            request.setAttribute("conexion", conexion);
        } catch (Exception e) {
        }
        
        return url_servlet;
    }
    
}
