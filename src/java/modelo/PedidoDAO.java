/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDAO {

    GestorJDBC gestorJDBC;

    public PedidoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public Pedido buscar(Mesa mesa) throws Exception {
        Pedido pedido = null;
        ResultSet resultado;
        PreparedStatement sentencia;
        int pedidoid = 0;

        String sentenciaSQL1 = "select p.pedidoid, p.fecha, p.estado,\n"
                + "per.codigopersona, per.nombre, per.apellidosper, per.razonsocial, per.direccion, per.tipopersona, per.urlfotoperil\n"
                + "from pedido p inner join persona per\n"
                + "on (p.idcliente = per.codigopersona)\n"
                + "where mesaid = ? and estado = 'Abierto'";

        String sentenciaSQL2 = "select l.cantidad, l.precio, p.platoid, p.nombre, p.descripcion, p.urlfoto, p.estado, p.isactivo"
                + " from lineadepedido l inner join plato p on l.platoid = p.platoid"
                + " where l.pedidoid = ?";

        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, mesa.getMesaid());
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                pedidoid = resultado.getInt("pedidoid");
                Date fecha = resultado.getDate("fecha");
                String estado = resultado.getString("estado");
                pedido = new Pedido(pedidoid, fecha, estado);
                pedido.setMesa(mesa);
                Persona persona = new Persona();
                persona.setCodigo(resultado.getInt("codigopersona"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellidos(resultado.getString("apellidosper"));
                persona.setRazonsocial(resultado.getString("razonsocial"));
                persona.setDireccion(resultado.getString("direccion"));
                persona.setTipopersona(resultado.getString("tipopersona"));
                persona.setUrlfotoperfil(resultado.getString("urlfotoperil"));
                pedido.setCliente(persona);

            } else {
                throw new Exception("Crear error al consultar");
            }
            resultado.close();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            sentencia.setInt(1, pedidoid);
            resultado = sentencia.executeQuery();
            LineaDePedido lineaDePedido;
            Plato plato;
            while (resultado.next()) {
                int cantidad = resultado.getInt("cantidad");
                double precio = resultado.getDouble("precio");
                int platoid = resultado.getInt("platoid");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                String urlFoto = resultado.getString("urlfoto");
                String estado = resultado.getString("urlfoto");
                boolean isactivo = resultado.getBoolean("isactivo");
                plato = new Plato(platoid, nombre, precio, descripcion, urlFoto, estado, isactivo);
                lineaDePedido = new LineaDePedido(cantidad, precio, plato);
                pedido.agregarLineaDePedido(lineaDePedido);
            }
            resultado.close();
            sentencia.close();
            return pedido;
        } catch (Exception e) {
            throw new Exception("Crear error al consultar");
        }
    }

    public void ingresar(Pedido pedido) throws Exception {
        int registros_afectados, pedidoid_maximo;
        PreparedStatement sentencia;
        ResultSet resultado;
        String sentenciaSQL1 = "insert into pedido(fecha, estado, mesaid, idusuario, idcliente) values(?,?,?,?,?)";
        String sentenciaSQL2 = "select max(pedidoid) as pedidoid_maximo from pedido";
        String sentenciaSQL3 = "insert into lineadepedido(pedidoid, platoid, cantidad, precio) values(?,?,?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setDate(1, pedido.getFecha());
            sentencia.setString(2, pedido.getEstado());
            sentencia.setInt(3, pedido.getMesa().getMesaid());
            sentencia.setInt(4, pedido.getUsuario().getPersona().getCodigo());
            sentencia.setInt(5, pedido.getCliente().getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("Crear error al insertar");
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                pedidoid_maximo = resultado.getInt("pedidoid_maximo");
            } else {
                throw new Exception("Crear error al insertar");
            }
            resultado.close();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL3);
            for (LineaDePedido lineaDePedido : pedido.getLineasDePedido()) {
                sentencia.setInt(1, pedidoid_maximo);
                sentencia.setInt(2, lineaDePedido.getPlato().getPlatoid());
                sentencia.setInt(3, lineaDePedido.getCantidad());
                sentencia.setDouble(4, lineaDePedido.getPrecio());
                registros_afectados = sentencia.executeUpdate();
                if (registros_afectados == 0) {
                    throw new Exception("Crear error al insertar");
                }
            }
            sentencia.close();
        } catch (Exception e) {
            throw new Exception("Crear error al insertar");
        }
    }

    public void modificar(Pedido pedido) throws Exception {
        int registros_afectados;
        PreparedStatement sentencia;
        String sentenciaSQL1 = "delete from lineadepedido where pedidoid = ?";
        String sentenciaSQL2 = "insert into lineadepedido(pedidoid, platoid, cantidad, precio) values(?,?,?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, pedido.getPedidoid());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if (registros_afectados == 0) {
                throw new Exception("Crear error al modificar");
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            for (LineaDePedido lineaDePedido : pedido.getLineasDePedido()) {
                sentencia.setInt(1, pedido.getPedidoid());
                sentencia.setInt(2, lineaDePedido.getPlato().getPlatoid());
                sentencia.setInt(3, lineaDePedido.getCantidad());
                sentencia.setDouble(4, lineaDePedido.getPrecio());
                registros_afectados = sentencia.executeUpdate();
                if (registros_afectados == 0) {
                    throw new Exception("Crear error al modificar");
                }
            }
            sentencia.close();
        } catch (Exception e) {
            throw new Exception("Crear error al modificar");
        }

    }

}
