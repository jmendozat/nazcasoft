/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.administrativo.contrato;

import c3_dominio.administrativo.entidad.Interface;
import java.util.List;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IInterfaceDAO extends ICrudDAO<Interface>{
    
     public List<Interface> func_NAZCA_ADM_ObtenerModulosPorUsuario(int codigoUsuario) throws ExcepcionSQL;
     
}
