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
