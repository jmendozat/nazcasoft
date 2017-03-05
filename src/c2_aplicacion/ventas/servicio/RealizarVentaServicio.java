/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.ventas.servicio;

import c3_dominio.ventas.contrato.IVentaDAO;
import c3_dominio.ventas.entidad.Venta;
import c4_persistencia.GestorJDBC;
import c4_persistencia.fabricaDAO.FabricaAbstractaDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class RealizarVentaServicio {

    GestorJDBC gestorJDBC;
    IVentaDAO ventaDAO;

    private static RealizarVentaServicio instancia;

    public static RealizarVentaServicio getInstancia() {
        if (instancia == null) {
            instancia = new RealizarVentaServicio();
        }
        return instancia;
    }

    public RealizarVentaServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        ventaDAO = fabricaAbstractaDAO.crearVentaDAO(gestorJDBC);
    }

    public void registrar(Venta venta) throws ExcepcionSQL {
        try {
            gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            ventaDAO.registrar(venta);
            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cancelarTransaccion();
            throw e;

        }
    }

    public void modificar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void activar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void desactivar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Venta buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
