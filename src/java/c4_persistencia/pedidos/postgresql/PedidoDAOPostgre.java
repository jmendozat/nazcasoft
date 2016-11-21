/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.pedidos.postgresql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import c3_dominio.pedidos.contrato.IPedidoDAO;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.pedidos.entidad.LineaDePedido;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.pedidos.entidad.Plato;
import c4_persistencia.GestorJDBC;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class PedidoDAOPostgre implements IPedidoDAO {

    GestorJDBC gestorJDBC;

    public PedidoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Pedido func_NAZCA_ADM_PEDIDO_Buscar(Mesa mesa) throws ExcepcionSQL {
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
                throw ExcepcionSQL.crearErrorConsultar();
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
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }

    }

    @Override
    public void func_NAZCA_CORE_Registrar(Pedido pedido) throws ExcepcionSQL {
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
                throw ExcepcionSQL.crearErrorInsertar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                pedidoid_maximo = resultado.getInt("pedidoid_maximo");
            } else {
                throw ExcepcionSQL.crearErrorInsertar();
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
                    throw ExcepcionSQL.crearErrorInsertar();
                }
            }
            sentencia.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void func_NAZCA_CORE_Modificar(Pedido pedido) throws ExcepcionSQL {
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
                  throw ExcepcionSQL.crearErrorModificar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            for (LineaDePedido lineaDePedido : pedido.getLineasDePedido()) {
                sentencia.setInt(1, pedido.getPedidoid());
                sentencia.setInt(2, lineaDePedido.getPlato().getPlatoid());
                sentencia.setInt(3, lineaDePedido.getCantidad());
                sentencia.setDouble(4, lineaDePedido.getPrecio());
                registros_afectados = sentencia.executeUpdate();
                if (registros_afectados == 0) {
                     throw ExcepcionSQL.crearErrorModificar();
                }
            }
            sentencia.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void func_NAZCA_CORE_Activar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void func_NAZCA_CORE_Desactivar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido func_NAZCA_CORE_Buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
