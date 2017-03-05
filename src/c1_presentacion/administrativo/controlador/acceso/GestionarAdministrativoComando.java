/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.acceso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarAdministrativoComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarAdministrativoComando instanciarComando(String claseComando) {
        GestionarAdministrativoComando gestionarAdministrativoComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "c1_presentacion.administrativo.controlador.acceso." + claseComando;
            gestionarAdministrativoComando = (GestionarAdministrativoComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarAdministrativoComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
