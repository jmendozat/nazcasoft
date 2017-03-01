/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.pedidos.servicio;

import java.util.List;
import c3_dominio.pedidos.contrato.IMesaDAO;
import c3_dominio.pedidos.entidad.Mesa;
import c4_persistencia.GestorJDBC;
import c4_persistencia.pedidos.fabricaDAO.FabricaPedidosDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarMesaServicio {

    GestorJDBC gestorJDBC;
    IMesaDAO mesaDAO;

    private static GestionarMesaServicio instancia;

    public static GestionarMesaServicio getInstancia() {
        if (instancia == null) {
            instancia = new GestionarMesaServicio();
        }
        return instancia;
    }

    public GestionarMesaServicio() {
        FabricaPedidosDAO fabricaPedidosDAO = FabricaPedidosDAO.getInstancia();
        gestorJDBC = fabricaPedidosDAO.crearGestorJDBC();
        mesaDAO = fabricaPedidosDAO.crearMesaDAO(gestorJDBC);
    }

    
    public List<Mesa> listar() throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Mesa> listaMesa = mesaDAO.listar();
            gestorJDBC.cerrarConexion();
            return listaMesa;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    
    public void modificar(Mesa mesa) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void crear(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void editar(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void eliminar(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Mesa buscar(int id) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Mesa mesa = mesaDAO.buscar(id);
            gestorJDBC.cerrarConexion();
            return mesa;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
    
    
}
