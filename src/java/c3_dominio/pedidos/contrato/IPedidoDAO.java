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
    /**
     * <b>Funcion de Acceso a Datos</b>
     * Busca un pedido dado una mesa, retorna todo el pedido.
     * @param mesa
     * @return
     * @throws ExcepcionSQL 
     */
    public Pedido func_NAZCA_ADM_PEDIDO_Buscar(Mesa mesa)throws ExcepcionSQL;
    
}
