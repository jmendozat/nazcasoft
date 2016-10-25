/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.mesa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class GestionarMesaComando {
      public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
    
    public static GestionarMesaComando instanciarComando(String claseComando) {
        GestionarMesaComando gestionarMesaComando;
        String nombreClaseComando;
        try{
            nombreClaseComando = "controlador.mesa." + claseComando;
            gestionarMesaComando = (GestionarMesaComando)Class.forName(nombreClaseComando).newInstance();      
            return gestionarMesaComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    } 
}
