/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador.config;

import c5_transversal.propiedades.EditorPropiedades;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pancho
 */
public class ModificarEstrategia extends ConfiguracionComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String respuesta = "Logout?hr=exit";
        try {
            EditorPropiedades editorPropiedades = new EditorPropiedades();
            editorPropiedades.modificarEstrategia(request.getParameter("idestrategia"));
            
        } catch (IOException e) {
            Logger.getLogger(ModificarEstrategia.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(ModificarEstrategia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
