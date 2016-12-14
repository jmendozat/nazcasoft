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

import java.sql.DriverManager;
import java.sql.SQLException;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import c5_transversal.propiedades.LectorPropiedades;

/**
 * 
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class AdminConexionSQLServer extends GestorJDBC {

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
