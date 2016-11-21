/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.contrato;

import c3_dominio.administrativo.contrato.ICrudDAO;
import c3_dominio.pedidos.entidad.Plato;
import java.util.List;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IPlatoDAO extends ICrudDAO<Plato>{
    
    public List<Plato> func_NAZCA_PEDIDO_BuscarPlatoPorNombre(String nombre)throws ExcepcionSQL;
}
