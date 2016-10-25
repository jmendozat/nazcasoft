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
public class UsuarioDAO {
    GestorJDBC gestorJDBC;

    public UsuarioDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public void crearUsuario(Usuario usuario)throws Exception{
        try {
            String sentenciaSQL="insert into usuario (codigopersona, emailcuenta, upassword, isactivo) values(?,?,md5(?),?)";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, usuario.getPersona().getCodigo());
            sentencia.setString(2, usuario.getEmailCuenta());
            sentencia.setString(3, usuario.getUpassword());
            sentencia.setBoolean(4, usuario.isActivo());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            throw new Exception("Error de comunicacion de datos");
        }
    }
}
