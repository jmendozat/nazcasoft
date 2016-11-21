/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.servicio.factoryestrategia;

import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class FabricaEstrategia {
         
    public static FabricaEstrategia getInstancia(){
        String classFactoryEstrategy;
        FabricaEstrategia factoryEstrategy;
        try {
            classFactoryEstrategy = LectorPropiedades.getInstancia().getValorFabrica("fabricaEstrategia");
            factoryEstrategy = (FabricaEstrategia)Class.forName(classFactoryEstrategy).newInstance();
            return factoryEstrategy;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
    
    public abstract ICalculoDescuento crearCalculoDescuento(Pedido pedido)throws ExcepcionRegla;
    
    
}
