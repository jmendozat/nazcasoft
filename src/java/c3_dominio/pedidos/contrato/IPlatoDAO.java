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
package c3_dominio.pedidos.contrato;

import c3_dominio.administrativo.contrato.ICrudDAO;
import c3_dominio.pedidos.entidad.Plato;
import java.util.List;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IPlatoDAO extends ICrudDAO<Plato>{
    /**
     * <b>Función de Acceso a Datos</b>
     * Sirbe para devolver una lista de platos dado el nombre.
     * @param nombre
     * @return
     * @throws ExcepcionSQL 
     */
    public List<Plato> buscarPlatoPorNombre(String nombre)throws ExcepcionSQL;
}
