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
import c4_persistencia.administrativo.sqlserver.InterfaceDAOSQLServer;
import c4_persistencia.administrativo.sqlserver.PermisoDAOSQLServer;
import c4_persistencia.administrativo.sqlserver.PersonaDAOSQLServer;
import c4_persistencia.administrativo.sqlserver.UsuarioDAOSQLServer;
import c4_persistencia.pedidos.sqlserver.MesaDAOSQLServer;
import c4_persistencia.pedidos.sqlserver.PedidoDAOSQLServer;
import c4_persistencia.pedidos.sqlserver.PlatoDAOSQLServer;
import c4_persistencia.ventas.sqlserver.VentaDAOSQLServer;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class FabricaDAOSQLServer extends FabricaAbstractaDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new ConexionSQLServer();
    }

    @Override
    public IInterfaceDAO crearInterfaceDAO(GestorJDBC gestorJDBC) {
        return new InterfaceDAOSQLServer(gestorJDBC);
    }

    @Override
    public IPermisoDAO crearPermisoDAO(GestorJDBC gestorJDBC) {
        return new PermisoDAOSQLServer(gestorJDBC);
    }

    @Override
    public IPersonaDAO crearPersonaDAO(GestorJDBC gestorJDBC) {
     return new PersonaDAOSQLServer(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
        return new UsuarioDAOSQLServer(gestorJDBC);
    }

    @Override
    public IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC) {
       return new PlatoDAOSQLServer(gestorJDBC);
    }

    @Override
    public IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC) {
        return new PedidoDAOSQLServer(gestorJDBC);
    }

    @Override
    public IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC) {
        return new MesaDAOSQLServer(gestorJDBC);
    }

    @Override
    public IVentaDAO crearVentaDAO(GestorJDBC gestorJDBC) {
        return new VentaDAOSQLServer(gestorJDBC);
    }
    
}
