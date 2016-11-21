/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import c5_transversal.excepciones.ExcepcionSQL;

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
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorIniciarTransaccion();
        }
    }

    public void terminarTransaccion() throws ExcepcionSQL {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorTerminarTransaccion();
        }

    }

    public void cancelarTransaccion() throws ExcepcionSQL {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            conexion.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorCancelarTransaccion();
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
