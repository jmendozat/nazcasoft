/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.administrativo.postgresql;

import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.entidad.Interface;
import c3_dominio.administrativo.entidad.Permiso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PermisoDAOPostgre implements IPermisoDAO {

    GestorJDBC gestorJDBC;

    public PermisoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void func_NAZCA_CRUD_Crear(Permiso permiso) throws ExcepcionSQL {
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
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void func_NAZCA_CRUD_Editar(Permiso objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Eliminar(Permiso objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso func_NAZCA_CRUD_Buscar(int id)throws ExcepcionSQL{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
