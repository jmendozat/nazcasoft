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
package c3_dominio.pedidos.servicio.estrategias;

import java.util.List;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
;
import c3_dominio.pedidos.servicio.factoryestrategia.FabricaEstrategia;


/**
 * 
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public abstract class CalculaDescuentoCompuesto extends FabricaEstrategia implements ICalculoDescuento{    
    protected List<ICalculoDescuento> estrategiasdescuentos;
    
   
    
}
