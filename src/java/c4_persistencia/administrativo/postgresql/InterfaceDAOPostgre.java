/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.administrativo.postgresql;

import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.entidad.Interface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class InterfaceDAOPostgre implements IInterfaceDAO{
    GestorJDBC gestorJDBC;

    public InterfaceDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public List<Interface> func_NAZCA_ADM_ObtenerModulosPorUsuario(int codigoUsuario) throws ExcepcionSQL {
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
            sentencia.setInt(1, codigoUsuario);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                interfaces = crearObjetoInterfaz(resultado);
                interfaces.setListaInterface(buscarInterfacesHija(interfaces.getCodigoInterface(),codigoUsuario, gestorJDBC));
                listaInterface.add(interfaces);
            }
            resultado.close();
            return listaInterface;
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    }

    @Override
    public void func_NAZCA_CRUD_Crear(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Editar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CRUD_Eliminar(Interface objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Interface func_NAZCA_CRUD_Buscar(int id)throws ExcepcionSQL{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            throw ExcepcionSQL.crearErrorConsultar();
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

    
}