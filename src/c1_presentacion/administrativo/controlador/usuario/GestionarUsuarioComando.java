/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarUsuarioComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarUsuarioComando instanciarComando(String claseComando) {
        GestionarUsuarioComando gestionarUsuarioComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "c1_presentacion.administrativo.controlador.usuario." + claseComando;
            gestionarUsuarioComando = (GestionarUsuarioComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarUsuarioComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
