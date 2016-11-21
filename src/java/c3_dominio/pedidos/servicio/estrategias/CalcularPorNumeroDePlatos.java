/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
