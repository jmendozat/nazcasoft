/*
 * Copyright (c) 2015, 2016, Nazca. Todos los derechos reservados.
 * NAZCA PROPIEDAD/CONFIDENCIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package c4_persistencia;

import c3_dominio.administrativo.contrato.IConexion;
import c5_transversal.seguridad.EConexion;
import c5_transversal.propiedades.EditorPropiedades;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PConexion implements IConexion {

    @Override
    public void func_NAZCA_ADM_Editar(EConexion conexion) throws Exception {
        try {
            EditorPropiedades editorProperties = new EditorPropiedades();
            editorProperties.modificarConexion(conexion);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public EConexion func_NAZCA_ADM_Mostrar() throws Exception {
        try {
            EConexion conexion = new EConexion(LectorPropiedades.getInstancia().getUserDB(),
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
