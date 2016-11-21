/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.ventas.fabricaDAO;

import c3_dominio.ventas.contrato.IVentaDAO;
import c4_persistencia.GestorJDBC;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public abstract class FabricaVentasDAO {
       public static FabricaVentasDAO getInstancia() {
        String claseFabricaDAO;
        FabricaVentasDAO fabricaPedidosDAO;
        try {
            claseFabricaDAO = LectorPropiedades.getInstancia().getValorFabrica("claseVentasFabricaDAO");
            fabricaPedidosDAO = (FabricaVentasDAO) Class.forName(claseFabricaDAO).newInstance();
            return fabricaPedidosDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
   public abstract GestorJDBC crearGestorJDBC();
   public abstract IVentaDAO crearVentaDAO(GestorJDBC gestorJDBC);
    
}
