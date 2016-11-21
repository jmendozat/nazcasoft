/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c5_transversal.propiedades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import c3_dominio.administrativo.entidad.Conexion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class EditorPropiedades {

    Properties propiedades;
    OutputStream ouputStream;

    public EditorPropiedades() {
        try {
            propiedades = new Properties();
            ouputStream = new FileOutputStream("c5_transversal/propiedades/Parametros.properties");

        } catch (FileNotFoundException e) {

        }

    }

    public void modificarConexion(Conexion conexion) throws Exception {
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

}
