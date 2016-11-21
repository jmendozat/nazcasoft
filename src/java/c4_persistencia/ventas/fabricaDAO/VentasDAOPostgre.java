/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.ventas.fabricaDAO;

import c3_dominio.ventas.contrato.IVentaDAO;
import c4_persistencia.GestorJDBC;
import c4_persistencia.ventas.postgresql.VentaDAOPostgre;
import c4_persistencia.ventas.postgresql.VentasConexionPostgreSQL;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class VentasDAOPostgre extends FabricaVentasDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new VentasConexionPostgreSQL();

    }
    
    @Override
    public IVentaDAO crearVentaDAO(GestorJDBC gestorJDBC) {
        return new VentaDAOPostgre(gestorJDBC);
    }
    
}
