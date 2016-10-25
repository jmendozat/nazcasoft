/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class NuevoCliente extends GestionarUsuarioComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        return "Modulos/Administracion/Usuarios/PageNuevoCliente.jsp";
    }
    
}
