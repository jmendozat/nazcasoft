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
public class ConexionSQLServer extends GestorJDBC {

    @Override
    public void abrirConexion() throws ExcepcionSQL {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://yfbhz1zuj2.database.windows.net:1433;database=bdnazca;user=Administrador@yfbhz1zuj2;password={Password*123};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            throw ExcepcionSQL.crearErrorAbrirConexion();
        }
    }

}
