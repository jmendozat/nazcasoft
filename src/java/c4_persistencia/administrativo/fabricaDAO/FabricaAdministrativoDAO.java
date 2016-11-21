/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4_persistencia.administrativo.fabricaDAO;

import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.contrato.IUsuarioDAO;
import c4_persistencia.GestorJDBC;
import c5_transversal.propiedades.LectorPropiedades;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public abstract class FabricaAdministrativoDAO {

    public static FabricaAdministrativoDAO getInstancia() {
        String claseFabricaDAO;
        FabricaAdministrativoDAO fabricaAdminDAO;
        try {
            claseFabricaDAO = LectorPropiedades.getInstancia().getValorFabrica("claseAdminFabricaDAO");
            fabricaAdminDAO = (FabricaAdministrativoDAO) Class.forName(claseFabricaDAO).newInstance();
            return fabricaAdminDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();
    
    public abstract IInterfaceDAO crearInterfaceDAO(GestorJDBC gestorJDBC);
    public abstract IPermisoDAO crearPermisoDAO(GestorJDBC gestorJDBC);
    public abstract IPersonaDAO crearPersonaDAO(GestorJDBC gestorJDBC);
    public abstract IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC); 
    
}