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
public class GuardarConexion extends ConfiguracionComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String ruta="Logout?hr=exit";
        try {
            EConexion conexion = new EConexion(request.getParameter("tusuario").trim(),
                    request.getParameter("tpassword").trim(),
                    request.getParameter("tservidor").trim(),
                    request.getParameter("tpuerto").trim(),
                    request.getParameter("tbased").trim(),
                    request.getParameter("tfabrica").trim());
            GestionarConexion.getInstancia().editar(conexion);
        } catch (Exception e) {
        }
        return ruta;
    }
    
}
