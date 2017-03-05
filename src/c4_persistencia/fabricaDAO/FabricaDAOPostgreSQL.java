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
import c4_persistencia.administrativo.postgresql.InterfaceDAOPostgre;
import c4_persistencia.administrativo.postgresql.PermisoDAOPostgre;
import c4_persistencia.administrativo.postgresql.PersonaDAOPostgre;
import c4_persistencia.administrativo.postgresql.UsuarioDAOPostgre;
import c4_persistencia.pedidos.postgresql.MesaDAOPostgre;
import c4_persistencia.pedidos.postgresql.PedidoDAOPostgre;
import c4_persistencia.pedidos.postgresql.PlatoDAOPostgre;
import c4_persistencia.ventas.postgresql.VentaDAOPostgre;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class FabricaDAOPostgreSQL extends FabricaAbstractaDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new ConexionPostgreSQL();
    }

    @Override
    public IInterfaceDAO crearInterfaceDAO(GestorJDBC gestorJDBC) {
        return new InterfaceDAOPostgre(gestorJDBC);
    }

    @Override
    public IPermisoDAO crearPermisoDAO(GestorJDBC gestorJDBC) {
        return new PermisoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPersonaDAO crearPersonaDAO(GestorJDBC gestorJDBC) {
        return new PersonaDAOPostgre(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
        return new UsuarioDAOPostgre(gestorJDBC);
    }

    @Override
    public IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC) {
       return new PlatoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC) {
       return new PedidoDAOPostgre(gestorJDBC);
    }

    @Override
    public IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC) {
        return new MesaDAOPostgre(gestorJDBC);
    }

    @Override
    public IVentaDAO crearVentaDAO(GestorJDBC gestorJDBC) {
        return new VentaDAOPostgre(gestorJDBC);
    }
    
}
