/*
 * Copyright (c) 2015, 2016, Nazca. Todos los derechos reservados.
 * NAZCA PROPIEDAD/CONFIDENCIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package c4_persistencia.pedidos.fabricaDAO;

import c3_dominio.pedidos.contrato.IMesaDAO;
import c3_dominio.pedidos.contrato.IPedidoDAO;
import c3_dominio.pedidos.contrato.IPlatoDAO;
import c4_persistencia.GestorJDBC;
import c4_persistencia.pedidos.postgresql.MesaDAOPostgre;
import c4_persistencia.pedidos.postgresql.PedidoDAOPostgre;
import c4_persistencia.pedidos.postgresql.PedidosConexionPostgreSQL;
import c4_persistencia.pedidos.postgresql.PlatoDAOPostgre;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class PedidosDAOPostgre extends FabricaPedidosDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new PedidosConexionPostgreSQL();
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
    
}
