/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.contrato;

import java.util.List;
import c3_dominio.administrativo.contrato.ICrudDAO;
import c3_dominio.pedidos.entidad.Mesa;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IMesaDAO extends ICrudDAO<Mesa> {

    public List<Mesa> func_NAZCA_ADM_PEDIDOS_MESA_Listar() throws ExcepcionSQL;
    public void func_NAZCA_ADM_PEDIDOS_MESA_Modificar(Mesa mesa)throws ExcepcionSQL;

}
