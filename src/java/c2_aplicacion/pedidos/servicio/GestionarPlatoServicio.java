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

    public List<Plato> func_NAZCA_PEDIDO_BuscarPlatoPorNombre(String nombre) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Plato> listaPlatos = platoDAO.func_NAZCA_PEDIDO_BuscarPlatoPorNombre(nombre);
            gestorJDBC.cerrarConexion();
            return listaPlatos;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void func_NAZCA_CRUD_Crear(Plato plato) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            plato.validarPrecio();
            platoDAO.func_NAZCA_CRUD_Crear(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void func_NAZCA_CRUD_Editar(Plato plato) throws ExcepcionSQL, ExcepcionRegla {
        try {
            gestorJDBC.abrirConexion();
            plato.validarPrecio();
            platoDAO.func_NAZCA_CRUD_Editar(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL | ExcepcionRegla e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public void func_NAZCA_CRUD_Eliminar(Plato plato) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            platoDAO.func_NAZCA_CRUD_Eliminar(plato);
            gestorJDBC.cerrarConexion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    public Plato func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Plato plato = platoDAO.func_NAZCA_CRUD_Buscar(id);
            gestorJDBC.cerrarConexion();
            return plato;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

}
