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
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public abstract class FabricaPedidosDAO {

    public static FabricaPedidosDAO getInstancia() {
        String claseFabricaDAO;
        FabricaPedidosDAO fabricaPedidosDAO;
        try {
            claseFabricaDAO = LectorPropiedades.getInstancia().getValorFabrica("clasePedidosFabricaDAO");
            fabricaPedidosDAO = (FabricaPedidosDAO) Class.forName(claseFabricaDAO).newInstance();
            return fabricaPedidosDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();

    public abstract IPlatoDAO crearPlatoDAO(GestorJDBC gestorJDBC);

    public abstract IPedidoDAO crearPedidoDAO(GestorJDBC gestorJDBC);

    public abstract IMesaDAO crearMesaDAO(GestorJDBC gestorJDBC);
}
