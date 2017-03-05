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
    /**
     * <b>Metodo Abstracto para crear el calculo descuento</b>
     * @param pedido
     * @return
     * @throws ExcepcionRegla 
     */
    public abstract ICalculoDescuento crearCalculoDescuento(Pedido pedido)throws ExcepcionRegla;
    
    
}
