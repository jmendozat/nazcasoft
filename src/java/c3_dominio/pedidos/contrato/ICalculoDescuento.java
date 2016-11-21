/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.contrato;

import c3_dominio.pedidos.entidad.Pedido;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface ICalculoDescuento {

    public double calcularDescuento(Pedido pedido);

  
}
