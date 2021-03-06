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
    
    /**
     * 
     * @param persona
     * @return
     * @throws ExcepcionSQL 
     */
    public int crearPersona(Persona persona)throws ExcepcionSQL;
    
    /**
     * 
     * @param nombre
     * @return
     * @throws ExcepcionSQL 
     */
    public List<Persona> buscar(String nombre)throws ExcepcionSQL;
}
