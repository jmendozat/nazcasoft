/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
