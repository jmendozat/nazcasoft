/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.venta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarVentaComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarVentaComando instanciarComando(String claseComando) {
        GestionarVentaComando gestionarVentaComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "controlador.venta." + claseComando;
            gestionarVentaComando = (GestionarVentaComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarVentaComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
