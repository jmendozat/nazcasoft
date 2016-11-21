/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public ExcepcionRegla(String message) {
        super(message);
    }

    public static ExcepcionRegla crearErrorPedido() throws ExcepcionRegla {
        return new ExcepcionRegla(ERROR_PEDIDO_INVALIDO);
    }
    public static ExcepcionRegla crearErrorPlatoPrecioIncorrecto()throws ExcepcionRegla{
     return new ExcepcionRegla(ERROR_PLATO_PRECIO_INCORRECTO);
    }
}
