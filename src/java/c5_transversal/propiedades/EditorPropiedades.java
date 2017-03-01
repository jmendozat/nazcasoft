/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c5_transversal.propiedades;

import java.io.FileNotFoundException;
import java.util.Properties;
import c5_transversal.seguridad.EConexion;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class EditorPropiedades {

    Properties propiedades;
    InputStream inputStream;
    OutputStream ouputStream;
    
    public EditorPropiedades() throws IOException {
        try {
            propiedades = new Properties();
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("c5_transversal/propiedades/Parametros.properties");
            propiedades.load(inputStream);
        } catch (FileNotFoundException e) {

        }
        
    }

    public void modificarConexion(EConexion conexion) throws Exception {
        try {
            propiedades.setProperty("claseFabricaDAO", conexion.getFabrica());
            propiedades.setProperty("userdb", conexion.getUsuario());
            propiedades.setProperty("passworddb", conexion.getPassword());
            propiedades.setProperty("servidordb", conexion.getServidor());
            propiedades.setProperty("puertodb", conexion.getPuerto());
            propiedades.setProperty("basededatos", conexion.getBaseDatos());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarEstrategia(String estrategia)throws Exception{
        try {
            propiedades.setProperty("fabricaEstrategia", "c3_dominio.pedidos.servicio.estrategias."+estrategia);
            
            System.out.println("Se modifico la estrategia a "+estrategia);
        } catch (Exception e) {
            System.out.println("Ha entrado a la excepcion");
            throw e;
        }
    }

}
