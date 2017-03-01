/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.pedidos.servicio;

import c3_dominio.pedidos.contrato.IPlatoDAO;
import c3_dominio.pedidos.entidad.Plato;
import java.util.List;
import c4_persistencia.GestorJDBC;
import c4_persistencia.pedidos.fabricaDAO.FabricaPedidosDAO;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public final class GestionarPlatoServicio {

    GestorJDBC gestorJDBC;
    IPlatoDAO platoDAO;
    private static GestionarPlatoServicio instancia;

    public static GestionarPlatoServicio getInstancia() {
        if (instancia == null) {
            instancia = new GestionarPlatoServicio();
        }
        return instancia;
    }

    public GestionarPlatoServicio() {
        FabricaPedidosDAO fabricaPedidosDAO = FabricaPedidosDAO.getInstancia();
        gestorJDBC = fabricaPedidosDAO.crearGestorJDBC();
        platoDAO = fabricaPedidosDAO.crearPlatoDAO(gestorJDBC);
    }

    public List<Plato> buscarPlatoPorNombre(String nombre) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Plato> listaPlatos = platoDAO.buscarPlatoPorNombre(nombre);
            gestorJDBC.cerrarConexion();
            return listaPlatos;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void crear(Plato plato) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            plato.validarPrecio();
            platoDAO.crear(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void editar(Plato plato) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            plato.validarPrecio();
            platoDAO.editar(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void eliminar(Plato plato) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            platoDAO.eliminar(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public Plato buscar(int id) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Plato plato = platoDAO.buscar(id);
            gestorJDBC.cerrarConexion();
            return plato;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

}
