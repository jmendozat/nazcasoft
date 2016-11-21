/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.pedidos;

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

    
    public List<Mesa> func_NAZCA_ADM_PEDIDOS_MESA_Listar() throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            List<Mesa> listaMesa = mesaDAO.func_NAZCA_ADM_PEDIDOS_MESA_Listar();
            gestorJDBC.cerrarConexion();
            return listaMesa;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }

    
    public void func_NAZCA_ADM_PEDIDOS_MESA_Modificar(Mesa mesa) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Crear(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Editar(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CRUD_Eliminar(Mesa objCrud) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Mesa func_NAZCA_CRUD_Buscar(int id) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            Mesa mesa = mesaDAO.func_NAZCA_CRUD_Buscar(id);
            gestorJDBC.cerrarConexion();
            return mesa;
        } catch (ExcepcionSQL e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
    }
    
    
}
