/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.pedidos;

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

    public Pedido func_NAZCA_ADM_PEDIDO_Buscar(Mesa mesa) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Pedido pedido = pedidoDAO.func_NAZCA_ADM_PEDIDO_Buscar(mesa);
            gestorJDBC.cerrarConexion();
            return pedido;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void func_NAZCA_CORE_Registrar(Pedido pedido) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            pedido.validarPedido();
            if (pedido.getPedidoid() == 0) {
                pedidoDAO.func_NAZCA_CORE_Registrar(pedido);
                mesaDAO.func_NAZCA_ADM_PEDIDOS_MESA_Modificar(pedido.getMesa());
            } else {
                pedidoDAO.func_NAZCA_CORE_Modificar(pedido);
            }

            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public void func_NAZCA_CORE_Modificar(Pedido pedido) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            pedido.validarPedido();
            pedidoDAO.func_NAZCA_CORE_Modificar(pedido);
            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionRegla | ExcepcionSQL e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }

    public void func_NAZCA_CORE_Activar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void func_NAZCA_CORE_Desactivar(Pedido pedido) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pedido func_NAZCA_CORE_Buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
