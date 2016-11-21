/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class ConfiguracionComando {
      public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static ConfiguracionComando instanciarComando(String claseComando) {
        ConfiguracionComando configComando;
        String nombreClaseComando;
        try {
            nombreClaseComando = "c1_presentacion.administrativo.controlador.config." + claseComando;
            configComando = (ConfiguracionComando) Class.forName(nombreClaseComando).newInstance();
            return configComando;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;
        }
    }
}
