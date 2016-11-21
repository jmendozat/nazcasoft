/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import c3_dominio.administrativo.contrato.IConexion;
import c3_dominio.administrativo.entidad.Conexion;
import c5_transversal.propiedades.EditorPropiedades;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PConexion implements IConexion {

    @Override
    public void func_NAZCA_ADM_Editar(Conexion conexion) throws Exception {
        try {
            EditorPropiedades editorProperties = new EditorPropiedades();
            editorProperties.modificarConexion(conexion);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Conexion func_NAZCA_ADM_Mostrar() throws Exception {
        try {
            Conexion conexion = new Conexion(LectorPropiedades.getInstancia().getUserDB(),
                    LectorPropiedades.getInstancia().getPasswordDB(),
                    LectorPropiedades.getInstancia().getServidor(),
                    LectorPropiedades.getInstancia().getPuerto(),
                    LectorPropiedades.getInstancia().getBaseDeDatos(),
                    LectorPropiedades.getInstancia().getValorFabrica("claseFabricaDAO"));
            return conexion;
        } catch (NumberFormatException e) {
            throw new Exception("Error al leer el archivo de propiedades.");
        }
    }

}
