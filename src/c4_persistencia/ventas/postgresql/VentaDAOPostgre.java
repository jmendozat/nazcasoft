/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.ventas.postgresql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import c3_dominio.ventas.contrato.IVentaDAO;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.ventas.entidad.Venta;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class VentaDAOPostgre implements IVentaDAO {

    GestorJDBC gestorJDBC;

    public VentaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void registrar(Venta venta) throws ExcepcionSQL {
        try {
            String sentenciaSQL = "insert into venta values (?,?,?,?,?,?)";
            String sentenciaSQL1 = "update pedido set estado = ? where pedidoid = ?";
            String sentenciaSQL2 = "update mesa set disponible = true where mesaid = ?";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, venta.getPedido().getPedidoid());
            sentencia.setInt(2, venta.getUsuario().getPersona().getCodigo());
            sentencia.setDouble(3, venta.getDescuento());
            sentencia.setDouble(4, venta.getTotal());
            sentencia.setDouble(5, venta.getMontoRecibido());
            sentencia.setDouble(6, venta.getVuelto());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, Pedido.CERRADO);
            sentencia.setInt(2, venta.getPedido().getPedidoid());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            sentencia.setInt(1, venta.getPedido().getMesa().getMesaid());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorInsertar();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desactivar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
