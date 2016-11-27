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
package c4_persistencia.administrativo.fabricaDAO;

import c3_dominio.administrativo.contrato.IInterfaceDAO;
import c3_dominio.administrativo.contrato.IPermisoDAO;
import c3_dominio.administrativo.contrato.IPersonaDAO;
import c3_dominio.administrativo.contrato.IUsuarioDAO;
import c4_persistencia.GestorJDBC;
import c4_persistencia.administrativo.postgresql.AdminConexionPostgreSQL;
import c4_persistencia.administrativo.postgresql.InterfaceDAOPostgre;
import c4_persistencia.administrativo.postgresql.PermisoDAOPostgre;
import c4_persistencia.administrativo.postgresql.PersonaDAOPostgre;
import c4_persistencia.administrativo.postgresql.UsuarioDAOPostgre;

/**
 *
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class AdministrativoDAOPostgre extends FabricaAdministrativoDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new AdminConexionPostgreSQL();
    }

    @Override
    public IInterfaceDAO crearInterfaceDAO(GestorJDBC gestorJDBC) {
        return new InterfaceDAOPostgre(gestorJDBC);
    }

    @Override
    public IPermisoDAO crearPermisoDAO(GestorJDBC gestorJDBC) {
        return new PermisoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPersonaDAO crearPersonaDAO(GestorJDBC gestorJDBC) {
        return new PersonaDAOPostgre(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
        return new UsuarioDAOPostgre(gestorJDBC);
    }
    
}
