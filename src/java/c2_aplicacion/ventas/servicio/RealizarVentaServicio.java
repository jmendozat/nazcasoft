/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.ventas.servicio;

import c3_dominio.ventas.contrato.IVentaDAO;
import c3_dominio.ventas.entidad.Venta;
import c4_persistencia.GestorJDBC;
import c4_persistencia.ventas.fabricaDAO.FabricaVentasDAO;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class RealizarVentaServicio{
    GestorJDBC gestorJDBC;
    IVentaDAO ventaDAO;
    
    private static RealizarVentaServicio instancia;
    
    public static RealizarVentaServicio getInstancia(){
     if(instancia==null)
         instancia = new RealizarVentaServicio();
     return instancia;
    }

    public RealizarVentaServicio() {
        FabricaVentasDAO fabricaVentasDAO = FabricaVentasDAO.getInstancia();
        gestorJDBC = fabricaVentasDAO.crearGestorJDBC();
        ventaDAO=fabricaVentasDAO.crearVentaDAO(gestorJDBC);
    }

    
    public void func_NAZCA_CORE_Registrar(Venta venta) throws ExcepcionSQL {
        try {
             gestorJDBC.abrirConexion();
            gestorJDBC.iniciarTransaccion();
            ventaDAO.func_NAZCA_CORE_Registrar(venta);
            gestorJDBC.terminarTransaccion();
        } catch (ExcepcionSQL e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
            
        }
    }

    
    public void func_NAZCA_CORE_Modificar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CORE_Activar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void func_NAZCA_CORE_Desactivar(Venta venta) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Venta func_NAZCA_CORE_Buscar(int codigo) throws ExcepcionSQL {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
