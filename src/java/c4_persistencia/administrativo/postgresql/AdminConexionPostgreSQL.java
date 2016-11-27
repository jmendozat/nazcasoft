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
package c4_persistencia.administrativo.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author Lain
 */
public class AdminConexionPostgreSQL extends GestorJDBC {

    @Override
    public void abrirConexion() throws ExcepcionSQL {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+LectorPropiedades.getInstancia().getServidor()+":"+LectorPropiedades.getInstancia().getPuerto()+"/"+LectorPropiedades.getInstancia().getBaseDeDatos();
            conexion = DriverManager.getConnection(url,LectorPropiedades.getInstancia().getUserDB(), LectorPropiedades.getInstancia().getPasswordDB());
        } catch (ClassNotFoundException | SQLException e) {
            throw ExcepcionSQL.crearErrorAbrirConexion();
        }
    }

}
