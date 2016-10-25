/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lain
 */
public class ConexionPostgreSQL extends GestorJDBC {

    @Override
    public void abrirConexion() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/bdnazca";
            conexion = DriverManager.getConnection(url, "postgres", "123");
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al abrir conexion.");
        }
    }

}
