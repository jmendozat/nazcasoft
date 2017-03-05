/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.fabricaDAO;

import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.contrato.IUsuarioDAO;
import c3_dominio.pedidos.contrato.IMesaDAO;
import c3_dominio.pedidos.contrato.IPedidoDAO;
import c3_dominio.pedidos.contrato.IPlatoDAO;
import c3_dominio.ventas.contrato.IVentaDAO;
import c4_persistencia.GestorJDBC;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public abstract class FabricaAbstractaDAO {

    public static FabricaAbstractaDAO getInstancia() {
        String claseFabricaDAO;
        FabricaAbstractaDAO fabricaPedidosDAO;
        try {
            claseFabricaDAO = LectorPropiedades.getInstancia().getValorFabrica("claseFabricaDAO");
            fabricaPedidosDAO = (FabricaAbstractaDAO) Class.forName(claseFabricaDAO).newInstance();
            return fabricaPedidosDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();
   public abstract IInterfaceDAO crearInterfaceDAO(GestorJDBC gestorJDBC);

    public abstract IPermisoDAO crearPermisoDAO(GestorJDBC gestorJDBC);

    public abstract IPersonaDAO crearPersonaDAO(GestorJDBC gestorJDBC);

    public abstract IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC);
    
     public abstract IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC);

    public abstract IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC);

    public abstract IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC);
     public abstract IVentaDAO crearVentaDAO(GestorJDBC gestorJDBC);
    
}
