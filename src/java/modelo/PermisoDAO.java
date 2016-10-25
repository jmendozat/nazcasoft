/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PermisoDAO {

    GestorJDBC gestorJDBC;

    public PermisoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public void agregarPermisos(Permiso permiso) throws Exception {
        try {
            String sentenciaSQL = "insert into permiso(codigousuario, codigointerface) values(?,?)";
            PreparedStatement sentencia;
            for (Interface intFace : permiso.getListaInterface()) {
                sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
                sentencia.setInt(1, permiso.getUsuario().getPersona().getCodigo());
                sentencia.setInt(2, intFace.getCodigoInterface());
                sentencia.executeUpdate();
                sentencia.close();
            }
        } catch (Exception e) {
            throw new Exception("Error de comunicacion de datos");
        }
    }
}
