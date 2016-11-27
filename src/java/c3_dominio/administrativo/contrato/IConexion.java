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

import c3_dominio.administrativo.entidad.Conexion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IConexion {
    
    public void func_NAZCA_ADM_Editar(Conexion conexion)throws Exception;
    public Conexion func_NAZCA_ADM_Mostrar()throws Exception;
    
}
