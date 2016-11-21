/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.plato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarPlatoComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarPlatoComando instanciarComando(String claseComando) {
        GestionarPlatoComando gestionarPlatosComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "c1_presentacion.pedidos.controlador.plato." + claseComando;
            gestionarPlatosComando = (GestionarPlatoComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarPlatosComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
