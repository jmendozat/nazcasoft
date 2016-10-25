/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

public class GestionarServicios {

    GestorJDBC gestorJDBC;
    PlatoDAOPostgre platoDAO;
    PedidoDAOPostgre pedidoDAO;
    MesaDAOPostgre mesaDAO;

    public GestionarServicios() {
        gestorJDBC = new ConexionPostgreSQL();
        platoDAO = new PlatoDAOPostgre(gestorJDBC);
        pedidoDAO = new PedidoDAOPostgre(gestorJDBC);
        mesaDAO = new MesaDAOPostgre(gestorJDBC);
    }

    public List<Plato> buscar(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        List<Plato> listaPlatos = platoDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return listaPlatos;
    }

    public Plato buscar(int platoid) throws Exception {
        gestorJDBC.abrirConexion();
        Plato plato = platoDAO.buscar(platoid);
        gestorJDBC.cerrarConexion();
        return plato;
    }

    public void ingresar(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        platoDAO.ingresar(plato);
        gestorJDBC.cerrarConexion();
    }

    public void modificar(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        platoDAO.modificar(plato);
        gestorJDBC.cerrarConexion();
    }

    public void eliminar(Plato plato) throws Exception {
        gestorJDBC.abrirConexion();
        platoDAO.eliminar(plato);
        gestorJDBC.cerrarConexion();
    }

    public Pedido buscar(Mesa mesa) throws Exception {
        gestorJDBC.abrirConexion();
        Pedido pedido = pedidoDAO.buscar(mesa);
        gestorJDBC.cerrarConexion();
        return pedido;
    }

    public void ingresar(Pedido pedido) throws Exception {
        gestorJDBC.abrirConexion();
        pedidoDAO.ingresar(pedido);
        gestorJDBC.cerrarConexion();
    }

    public void modificar(Pedido pedido) throws Exception {
        gestorJDBC.abrirConexion();
        pedidoDAO.modificar(pedido);
        gestorJDBC.cerrarConexion();
    }

    public List<Mesa> buscar() throws Exception {
        gestorJDBC.abrirConexion();
        List<Mesa> listaMesa = mesaDAO.buscar();
        gestorJDBC.cerrarConexion();
        return listaMesa;
    }

    public Mesa buscarMesa(int mesaid) throws Exception {
        gestorJDBC.abrirConexion();
        Mesa mesa = mesaDAO.buscar(mesaid);
        gestorJDBC.cerrarConexion();
        return mesa;
    }

    public void modificar(Mesa mesa) throws Exception {
        gestorJDBC.abrirConexion();
        mesaDAO.modificar(mesa);
        gestorJDBC.cerrarConexion();
    }

}
