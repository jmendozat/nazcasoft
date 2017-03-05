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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GestorJDBC {

    protected Connection conexion;

    public abstract void abrirConexion() throws ExcepcionSQL;

    public void cerrarConexion() throws ExcepcionSQL {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorCerrarConexion();
        }
    }

    public void iniciarTransaccion() throws ExcepcionSQL {
        try {
            conexion.setAutoCommit(false);
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorIniciarTransaccion();
        } catch (SQLException ex) {
            Logger.getLogger(GestorJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarTransaccion() throws ExcepcionSQL {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorTerminarTransaccion();
        } catch (SQLException ex) {
            Logger.getLogger(GestorJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancelarTransaccion() throws ExcepcionSQL {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorCancelarTransaccion();
        } catch (SQLException ex) {
            Logger.getLogger(GestorJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PreparedStatement prepararSentencia(String sql) throws ExcepcionSQL {
        try {
            return conexion.prepareStatement(sql);
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorPrepararSentencia();
        }
    }

    public ResultSet ejecutarConsulta(String sql) throws ExcepcionSQL {
        try {
            Statement sentencia;
            ResultSet resultado;
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorEjecutarConsulta();
        }

    }
}
