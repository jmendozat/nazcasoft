/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.ventas.sqlserver;

import java.sql.DriverManager;
import java.sql.SQLException;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author Lain
 */
public class VentasConexionPostgreSQL extends GestorJDBC {

    @Override
    public void abrirConexion() throws ExcepcionSQL {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + LectorPropiedades.getInstancia().getServidor() + "database=" + LectorPropiedades.getInstancia().getBaseDeDatos() + "user=" + LectorPropiedades.getInstancia().getUserDB() + "password=" + LectorPropiedades.getInstancia().getPasswordDB() + "encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            throw ExcepcionSQL.crearErrorAbrirConexion();
        }
    }

}
