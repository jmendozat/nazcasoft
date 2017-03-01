/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.pedidos.servicio;

import c3_dominio.pedidos.contrato.IMesaDAO;
import c3_dominio.pedidos.contrato.IPedidoDAO;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.Pedido;
import c4_persistencia.GestorJDBC;
import c4_persistencia.pedidos.fabricaDAO.FabricaPedidosDAO;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class RealizarPedidoServicio {

    GestorJDBC gestorJDBC;
    IPedidoDAO pedidoDAO;
    IMesaDAO mesaDAO;
    private static RealizarPedidoServicio instancia;

    public RealizarPedidoServicio() {
        FabricaPedidosDAO fabricaPedidosDAO = FabricaPedidosDAO.getInstancia();
        gestorJDBC = fabricaPedidosDAO.crearGestorJDBC();
        pedidoDAO = fabricaPedidosDAO.crearPedidoDAO(gestorJDBC);
        mesaDAO = fabricaPedidosDAO.crearMesaDAO(gestorJDBC);

    }

    public static RealizarPedidoServicio getInstancia() {
        if (instancia == null) {
            instancia = new RealizarPedidoServicio();
        }
        return instancia;
    }

    public Pedido buscar(Mesa mesa) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Pedido pedido = pedidoDAO.buscar(mesa);
            gestorJDBC.cerrarConexion();
            return pedido;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void registrar(Pedido pedido) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            pedido.validarPedido();
            if (pedido.getPedidoid() == 0) {
                pedidoDAO.registrar(pedido);
                mesaDAO.modificar(pedido.getMesa());
            } else {
                pedidoDAO.modificar(pedido);
            }

            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public void modificar(Pedido pedido) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            pedido.validarPedido();
            pedidoDAO.modificar(pedido);
            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionRegla | ExcepcionSQL e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public void activar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void desactivar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pedido buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
