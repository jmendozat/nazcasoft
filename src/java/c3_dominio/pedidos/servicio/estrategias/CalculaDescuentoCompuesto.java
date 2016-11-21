/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.servicio.estrategias;

import java.util.List;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
;
import c3_dominio.pedidos.servicio.factoryestrategia.FabricaEstrategia;


/**
 *
 * @author CLIENTE
 */
public abstract class CalculaDescuentoCompuesto extends FabricaEstrategia implements ICalculoDescuento{    
    protected List<ICalculoDescuento> estrategiasdescuentos;
    
   
    
}
