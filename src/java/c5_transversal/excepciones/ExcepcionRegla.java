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
package c5_transversal.excepciones;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ExcepcionRegla extends Exception {

    private static final String ERROR_PEDIDO_INVALIDO = "Pedido Incorrecto";
    private static final String ERROR_PLATO_PRECIO_INCORRECTO ="El precio ingresado es incorrecto.";
    private static final String ERROR_CANTIDAD_INVALIDAD="Error cantidad invalida.";

    public ExcepcionRegla(String message) {
        super(message);
    }

    public static ExcepcionRegla crearErrorPedido() throws ExcepcionRegla {
        return new ExcepcionRegla(ERROR_PEDIDO_INVALIDO);
    }
    public static ExcepcionRegla crearErrorPlatoPrecioIncorrecto()throws ExcepcionRegla{
     return new ExcepcionRegla(ERROR_PLATO_PRECIO_INCORRECTO);
    }
    public static ExcepcionRegla crearErrorCantidadInvalida()throws ExcepcionRegla{
        return new ExcepcionRegla(ERROR_CANTIDAD_INVALIDAD);
    }
}
