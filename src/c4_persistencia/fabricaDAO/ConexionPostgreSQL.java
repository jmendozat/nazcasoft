/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.fabricaDAO;

import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import c5_transversal.propiedades.LectorPropiedades;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class ConexionPostgreSQL extends GestorJDBC {

    @Override
    public void abrirConexion() throws ExcepcionSQL {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + LectorPropiedades.getInstancia().getServidor() + ":" + LectorPropiedades.getInstancia().getPuerto() + "/" + LectorPropiedades.getInstancia().getBaseDeDatos();
            conexion = DriverManager.getConnection(url, LectorPropiedades.getInstancia().getUserDB(), LectorPropiedades.getInstancia().getPasswordDB());
        } catch (ClassNotFoundException | SQLException e) {
            throw ExcepcionSQL.crearErrorAbrirConexion();
        }
    }

}
