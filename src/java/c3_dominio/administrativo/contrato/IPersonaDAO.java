/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.administrativo.contrato;

import java.util.List;
import c3_dominio.administrativo.entidad.Persona;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IPersonaDAO extends ICrudDAO<Persona>{
    
    public int func_NAZCA_ADM_CLIENTE_Crear(Persona persona)throws ExcepcionSQL;
    public List<Persona> func_NAZCA_ADM_CLIENTE_Buscar(String nombre)throws ExcepcionSQL;
}
