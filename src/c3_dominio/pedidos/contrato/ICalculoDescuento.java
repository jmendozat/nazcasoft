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
package c3_dominio.pedidos.contrato;

import c3_dominio.pedidos.entidad.Pedido;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface ICalculoDescuento {

    /**
     * <b>Interface de Regla de Negocio</b>
     * Interface de calcular desciento.
     * @param pedido
     * @return 
     */
    public double calcularDescuento(Pedido pedido);

  
}
