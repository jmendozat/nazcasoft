/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c5_transversal.excepciones;

import java.sql.SQLException;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ExcepcionSQL extends SQLException {

    private static final String MENSAJE_ERROR_CONSULTAR = "No se pudo realizar la consulta."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_INSERTAR = "No se pudo guardar los datos."
            + "Verifique los datos obligatorios y \u00FAnicos.<br>"
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_MODIFICAR = "No se pudo actualizar los datos."
            + "Verifique los datos obligatorios y \u00FAnicos.<br>"
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_ELIMINAR = "No se pudo eliminar el registro."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_ABRIRCONEXION = "No se pudo abrir la conexi\u00F3n con la base de datos."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_CERRARCONEXION = "No se pudo cerrar la conexi\u00F3n con la base de datos."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_INICIARTRANSACCION = "No se pudo iniciar la transacci\u00F3n."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_TERMINARTRANSACCION = "No se pudo terminar la transacci\u00F3n."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_CANCELARTRANSACCION = "No se pudo cancelar la transacci\u00F3n."
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String MENSAJE_ERROR_SENTENCIA = "No se puedo preparar la sentencia.";
    private static final String MENSAJE_ERROR_CONSULTA = "No se puedo ejecutar la consulta.";

    private ExcepcionSQL(String message) {
        super(message);
    }

    public static ExcepcionSQL crearErrorConsultar() {
        return new ExcepcionSQL(MENSAJE_ERROR_CONSULTAR);
    }

    public static ExcepcionSQL crearErrorInsertar() {
        return new ExcepcionSQL(MENSAJE_ERROR_INSERTAR);
    }

    public static ExcepcionSQL crearErrorModificar() {
        return new ExcepcionSQL(MENSAJE_ERROR_MODIFICAR);
    }

    public static ExcepcionSQL crearErrorEliminar() {
        return new ExcepcionSQL(MENSAJE_ERROR_ELIMINAR);
    }

    public static ExcepcionSQL crearErrorAbrirConexion() {
        return new ExcepcionSQL(MENSAJE_ERROR_ABRIRCONEXION);
    }

    public static ExcepcionSQL crearErrorCerrarConexion() {
        return new ExcepcionSQL(MENSAJE_ERROR_CERRARCONEXION);
    }

    public static ExcepcionSQL crearErrorIniciarTransaccion() {
        return new ExcepcionSQL(MENSAJE_ERROR_INICIARTRANSACCION);
    }

    public static ExcepcionSQL crearErrorTerminarTransaccion() {
        return new ExcepcionSQL(MENSAJE_ERROR_TERMINARTRANSACCION);
    }

    public static ExcepcionSQL crearErrorCancelarTransaccion() {
        return new ExcepcionSQL(MENSAJE_ERROR_CANCELARTRANSACCION);
    }

    public static ExcepcionSQL crearErrorPrepararSentencia() {
        return new ExcepcionSQL(MENSAJE_ERROR_SENTENCIA);
    }
    public static ExcepcionSQL crearErrorEjecutarConsulta() {
        return new ExcepcionSQL(MENSAJE_ERROR_CONSULTA);
    }
}
