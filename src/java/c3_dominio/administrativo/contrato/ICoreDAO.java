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
     * @return
     * @throws ExcepcionSQL 
     */
    public void func_NAZCA_CORE_Registrar(T objCore)throws ExcepcionSQL;
    
    
    /**
     * El metodo NAZCA_CORE_Modificar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * @param objCore
     * @return
     * @throws ExcepcionSQL 
     */
    public void func_NAZCA_CORE_Modificar(T objCore)throws ExcepcionSQL;
    
    /**
     * El metodo NAZCA_CORE_Activar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * Este metodo sirbe para activar el estado del objeto core por detallado.
     * @param objCore
     * @return
     * @throws ExcepcionSQL 
     */
    public void func_NAZCA_CORE_Activar(T objCore)throws ExcepcionSQL;
    
    /**
     * El metodo NAZCA_CORE_Desactivar necesita como parametro cualquier tipo de objeto, se recomienda usar objetos identificados
     * por cada caso de uso del modulo analizado.
     * Este metodo sirbe para activar el estado del objeto core por detallado.
     * @param objCore
     * @return
     * @throws ExcepcionSQL 
     */
    public void func_NAZCA_CORE_Desactivar(T objCore)throws ExcepcionSQL;
    
    /**
     * 
     * @param codigo
     * @return
     * @throws ExcepcionSQL 
     */
    public T func_NAZCA_CORE_Buscar(int codigo)throws ExcepcionSQL;
    
    
}
