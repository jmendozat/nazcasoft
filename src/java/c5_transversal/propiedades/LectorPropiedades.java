/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c5_transversal.propiedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class LectorPropiedades {

    Properties propiedades;
    InputStream inputStream;

    private static LectorPropiedades instancia;

    public LectorPropiedades() {
        try {
            propiedades = new Properties();
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("c5_transversal/propiedades/Parametros.properties");
            propiedades.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo de propiedades");
        }

    }

    public static LectorPropiedades getInstancia() {
        if (instancia == null) {
            instancia = new LectorPropiedades();
        }
        return instancia;
    }

    public String getValorFabrica(String clave) {
        return propiedades.getProperty(clave);
    }

    public String getUserDB() {
        return propiedades.getProperty("userdb");
    }

    public String getPasswordDB() {
        return propiedades.getProperty("passworddb");
    }

    public String getServidor() {
        return propiedades.getProperty("servidordb");
    }

    public String getPuerto() {
        return propiedades.getProperty("puertodb");
    }

    public String getBaseDeDatos() {
        return propiedades.getProperty("basededatos");
    }
    
    public String[] getListStrategy(){
        String estrategias = propiedades.getProperty("");
        String[] listaEstrategias = estrategias.split("_");
        return listaEstrategias;
    }

}
