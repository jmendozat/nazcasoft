/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c2_aplicacion.administrativo;

import c3_dominio.administrativo.contrato.IConexion;
import c3_dominio.administrativo.entidad.Conexion;
import c4_persistencia.PConexion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarConexion {

    IConexion iconexion;
    
    private static GestionarConexion instancia;
    
    public static GestionarConexion getInstancia(){
     if(instancia==null)
         instancia = new GestionarConexion();
     return instancia;
    }

    public GestionarConexion() {
        iconexion = new PConexion();
    }

    public void func_NAZCA_ADM_Editar(Conexion conexion) throws Exception {
        try {
            iconexion.func_NAZCA_ADM_Editar(conexion);
        } catch (Exception e) {
            throw e;
        }
    }

    public Conexion func_NAZCA_ADM_Mostrar() throws Exception {
        try {
            Conexion conex = iconexion.func_NAZCA_ADM_Mostrar();
            return conex;
        } catch (Exception e) {
            throw e;
        }
    }

}
