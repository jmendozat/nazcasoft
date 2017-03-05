/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarPedidoComando {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static GestionarPedidoComando instanciarComando(String claseComando) {
        GestionarPedidoComando gestionarPedidoComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "c1_presentacion.pedidos.controlador.pedido." + claseComando;
            gestionarPedidoComando = (GestionarPedidoComando) Class.forName(nombreClaseComando).newInstance();
            return gestionarPedidoComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
