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

import c5_transversal.excepciones.ExcepcionSQL;

/**
 *[Prototipo NazcaSoft]
 * La interfaz generica {@code ICoreDAO<T> } contiene los metodos generales de un CORE,
 * el cual tendran que ser implementados los casos de uso tipo core identificados por cada modulo del sistema.
 * 
 * @param <T>
 * @see model.transversal.excepciones 
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 * @version Beta 1.1
 */
public interface ICrudDAO<T> {
    
    /**
     * 
     * @param objCrud
     * @throws ExcepcionSQL 
     */
    public void crear(T objCrud)throws ExcepcionSQL;
    
    /**
     * 
     * @param objCrud
     * @throws ExcepcionSQL 
     */
    public void editar(T objCrud)throws ExcepcionSQL;
    
    /**
     * 
     * @param objCrud
     * @throws ExcepcionSQL 
     */
    public void eliminar(T objCrud)throws ExcepcionSQL;
    
    /**
     * 
     * @param id
     * @return 
     * @throws c5_transversal.excepciones.ExcepcionSQL 
     */
    public T buscar(int id)throws ExcepcionSQL;
    
}
