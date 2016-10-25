/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lain
 */
public abstract class GestionarPedidosComando {
    
    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
    
    public static GestionarPedidosComando instanciarComando(String claseComando) {
       GestionarPedidosComando gestionarPedidosComando;
        String nombreClaseComando;
        try{
            nombreClaseComando = "controlador.pedido." + claseComando;
            gestionarPedidosComando = (GestionarPedidosComando)Class.forName(nombreClaseComando).newInstance();      
            return gestionarPedidosComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    } 
    
}
