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
 * @param <T>
 * @see model.transversal.excepciones 
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 * @version Beta 1.1
 */
public interface ICoreDAO<T> {
    
    /**
     * El metodo NAZCA_CORE_Regsitrar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * @param objCore
     * @throws ExcepcionSQL 
     */
    public void registrar(T objCore)throws ExcepcionSQL;
    
    
    /**
     * El metodo NAZCA_CORE_Modificar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * @param objCore
     * @throws ExcepcionSQL 
     */
    public void modificar(T objCore)throws ExcepcionSQL;
    
    /**
     * El metodo NAZCA_CORE_Activar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * Este metodo sirbe para activar el estado del objeto core por detallado.
     * @param objCore
     * @throws ExcepcionSQL 
     */
    public void activar(T objCore)throws ExcepcionSQL;
    
    /**
     * El metodo NAZCA_CORE_Desactivar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * Este metodo sirbe para activar el estado del objeto core por detallado.
     * @param objCore
     * @throws ExcepcionSQL 
     */
    public void desactivar(T objCore)throws ExcepcionSQL;
    
    /**
     * 
     * @param codigo
     * @return
     * @throws ExcepcionSQL 
     */
    public T buscar(int codigo)throws ExcepcionSQL;
    
    
}
