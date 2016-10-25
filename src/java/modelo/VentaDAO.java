/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class VentaDAO {
    GestorJDBC gestorJDBC;

    public VentaDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    public void generarVenta(Venta venta)throws Exception{
        try {
            String sentenciaSQL="insert into venta values (?,?,?,?,?,?)";
            String sentenciaSQL1="update pedido set estado = ? where pedidoid = ?";
            String sentenciaSQL2 ="update mesa set disponible = true where mesaid = ?";
            PreparedStatement sentencia;
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setInt(1, venta.getPedido().getPedidoid());
            sentencia.setInt(2, venta.getUsuario().getPersona().getCodigo());
            sentencia.setDouble(3,venta.getDescuento());
            sentencia.setDouble(4, venta.getTotal());
            sentencia.setDouble(5, venta.getMontoRecibido());
            sentencia.setDouble(6, venta.getVuelto());
            sentencia.executeUpdate();
            sentencia .close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, Pedido.CERRADO);
            sentencia.setInt(2, venta.getPedido().getPedidoid());
            sentencia.executeUpdate();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            sentencia.setInt(1, venta.getPedido().getMesa().getMesaid());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            throw new Exception("Error de comunicaci\u00F3n de datos");
        }
    }
}
