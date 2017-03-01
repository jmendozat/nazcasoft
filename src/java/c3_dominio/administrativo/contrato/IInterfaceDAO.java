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

import c3_dominio.administrativo.entidad.Interface;
import java.util.List;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IInterfaceDAO extends ICrudDAO<Interface>{
    
    /**
     * 
     * @param codigoUsuario
     * @return
     * @throws ExcepcionSQL 
     */
     public List<Interface> obtenerModulosPorUsuario(int codigoUsuario) throws ExcepcionSQL;
     
}
