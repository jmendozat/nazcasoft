/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.plato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lain
 */
public abstract class GestionarPlatosComando {
    
    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
    
    public static GestionarPlatosComando instanciarComando(String claseComando) {
        GestionarPlatosComando gestionarPlatosComando;
        String nombreClaseComando;
        try{
            nombreClaseComando = "controlador.plato." + claseComando;
            gestionarPlatosComando = (GestionarPlatosComando)Class.forName(nombreClaseComando).newInstance();      
            return gestionarPlatosComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    } 
    
}
