/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GeneralDAO {

    GestorJDBC gestorJDBC;

    public GeneralDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public List<Interface> NAZCASOFT_ADM_ObtenerModuloPorUsuario(int codigousuario) throws Exception {

        try {
            List<Interface> listaInterface = new ArrayList();
            Interface interfaces;
            String consultaSQL = "SELECT INTE.codigointerface, INTE.nombreMayus, INTE.nombreMinus, INTE.ruta, INTE.icondesc\n"
                    + "FROM PERMISO P \n"
                    + "      INNER JOIN INTERFACE INTE\n"
                    + "      ON P.codigointerface = INTE.codigointerface\n"
                    + "WHERE P.codigousuario = ? AND INTE.codigorelacion IS NULL ";
            PreparedStatement sentencia;
            ResultSet resultado;
            sentencia = gestorJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, codigousuario);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                interfaces = crearObjetoInterfaz(resultado);
                interfaces.setListaInterface(buscarInterfacesHija(interfaces.getCodigoInterface(),codigousuario, gestorJDBC));
                listaInterface.add(interfaces);
            }
            resultado.close();
            return listaInterface;
        } catch (Exception e) {
            throw new Exception("Error de comunicaci\u00F3n con la Base de Datos");
        }
    }

    private List<Interface> buscarInterfacesHija(int codigoInterface,
            int codigousuario,
            GestorJDBC gestorJDBC) throws Exception {
        try {
            List<Interface> listaInterface = new ArrayList();
            Interface interfaces;
            String consultaSQL = "SELECT INTE.codigointerface, INTE.nombreMayus, INTE.nombreMinus, INTE.ruta, INTE.icondesc\n"
                    + "FROM PERMISO P \n"
                    + "      INNER JOIN INTERFACE INTE\n"
                    + "      ON P.codigointerface = INTE.codigointerface\n"
                    + "WHERE INTE.codigorelacion = ? AND P.codigousuario = ?";
            PreparedStatement sentencia;
            ResultSet resultado;
            sentencia = gestorJDBC.prepararSentencia(consultaSQL);
            sentencia.setInt(1, codigoInterface);
            sentencia.setInt(2, codigousuario);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {

                interfaces = crearObjetoInterfaz(resultado);
                interfaces.setListaInterface(buscarInterfacesHija(interfaces.getCodigoInterface(),codigousuario, gestorJDBC));
                listaInterface.add(interfaces);
            }
            resultado.close();
            return listaInterface;
        } catch (Exception e) {
            throw new Exception("Error de comunicaci\u00F3n con las Base de Datos");
        }
    }

    private Interface crearObjetoInterfaz(ResultSet resultado) throws SQLException {
        Interface interfaces;
        interfaces = new Interface();
        interfaces.setCodigoInterface(resultado.getInt(1));
        interfaces.setNombreMayus(resultado.getString(2));
        interfaces.setNombreMinus(resultado.getString(3));
        interfaces.setRuta(resultado.getString(4));
        interfaces.setIcondesc(resultado.getString(5));
        return interfaces;
    }

    public Persona NAZCASOFT_ADM_LoginUsuario(String cuenta, String password) throws Exception {
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
            sentencia.setString(1, cuenta);
            sentencia.setString(2, password);
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
        } catch (Exception e) {
            throw new Exception("Error de comunicaci\u00F3n de datos");
        }
    }

 
}
