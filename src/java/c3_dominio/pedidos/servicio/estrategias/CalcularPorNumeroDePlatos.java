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

import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.servicio.factoryestrategia.FabricaEstrategia;
import c5_transversal.excepciones.ExcepcionRegla;



/**
 * 
 * @author <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class CalcularPorNumeroDePlatos extends FabricaEstrategia implements ICalculoDescuento{
   
    @Override
    public double calcularDescuento(Pedido pedido) {
        double descuento = 0.0;
        if(pedido.calcularNumeroDePlatos()>10)
            descuento=10.0;
        return descuento;
    }

    @Override
    public ICalculoDescuento crearCalculoDescuento(Pedido pedido) throws ExcepcionRegla {
        return  new CalcularPorNumeroDePlatos();
    }
    
}
