/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.administrativo.postgresql;

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
public class UsuarioDAOPostgre implements IUsuarioDAO {

    GestorJDBC gestorJDBC;

    public UsuarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void func_NAZCA_CRUD_Crear(Usuario usuario) throws ExcepcionSQL {
        try {
            String sentenciaSQL = "insert into usuario (codigopersona, emailcuenta, upassword, isactivo) values(?,?,md5(?),?)";
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
    public void func_NAZCA_CRUD_Editar(Usuario objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Eliminar(Usuario objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario func_NAZCA_CRUD_Buscar(int id)throws ExcepcionSQL{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona func_NAZCA_ADM_Login(Usuario usuario) throws ExcepcionSQL {
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
                    + "      AND U.upassword = md5(?)\n"
                    + "      AND U.isactivo = true ";
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