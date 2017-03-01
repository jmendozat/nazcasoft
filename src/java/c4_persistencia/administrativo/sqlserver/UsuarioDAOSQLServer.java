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
package c4_persistencia.administrativo.sqlserver;

import c3_dominio.administrativo.contrato.IUsuarioDAO;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class UsuarioDAOSQLServer implements IUsuarioDAO {

    GestorJDBC gestorJDBC;

    public UsuarioDAOSQLServer(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Usuario usuario) throws ExcepcionSQL {
        try {
            String sentenciaSQL = "insert into usuario (codigopersona, emailcuenta, upassword, isactivo) values(?,?,?,?)";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, usuario.getPersona().getCodigo());
            sentencia.setString(2, usuario.getEmailCuenta());
            sentencia.setString(3, usuario.getUpassword());
            sentencia.setBoolean(4, usuario.isActivo());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void editar(Usuario objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(int id)throws ExcepcionSQL{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona login(Usuario usuario) throws ExcepcionSQL {
        try {
            Persona persona = null;
            String consultaSQL = "SELECT \n"
                    + "      P.codigopersona,\n"
                    + "      P.apellidosper, \n"
                    + "      P.nombre,\n"
                    + "      P.razonsocial,\n"
                    + "      P.tipousuario,\n"
                    + "      P.urlfotoperil\n"
                    + "FROM usuario U \n"
                    + "     INNER JOIN persona P\n"
                    + "     ON U.codigopersona = P.codigopersona\n"
                    + "WHERE U.emailcuenta = ? \n"
                    + "      AND U.upassword = ?\n"
                    + "      AND U.isactivo = 1 ";
            PreparedStatement sentencia;
            ResultSet resultado;
            sentencia = gestorJDBC.prepararSentencia(consultaSQL);
            sentencia.setString(1, usuario.getEmailCuenta());
            sentencia.setString(2, usuario.getUpassword());
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                persona = new Persona();
                persona.setCodigo(resultado.getInt(1));
                persona.setApellidos(resultado.getString(2));
                persona.setNombre(resultado.getString(3));
                persona.setRazonsocial(resultado.getString(4));
                persona.setTipousuario(resultado.getString(5));
                persona.setUrlfotoperfil(resultado.getString(6));
            }
            resultado.close();
            return persona;
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    }

}
