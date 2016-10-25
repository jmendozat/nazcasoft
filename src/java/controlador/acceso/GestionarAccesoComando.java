/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acceso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarAccesoComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarAccesoComando instanciarComando(String claseComando) {
        GestionarAccesoComando gestionarAccesoComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "controlador.acceso." + claseComando;
            gestionarAccesoComando = (GestionarAccesoComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarAccesoComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
