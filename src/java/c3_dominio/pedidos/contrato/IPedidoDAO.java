/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.contrato;

import c3_dominio.administrativo.contrato.ICoreDAO;
import c3_dominio.pedidos.entidad.Mesa;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IPedidoDAO extends ICoreDAO<Pedido>{
    
    public Pedido func_NAZCA_ADM_PEDIDO_Buscar(Mesa mesa)throws ExcepcionSQL;
    
}
