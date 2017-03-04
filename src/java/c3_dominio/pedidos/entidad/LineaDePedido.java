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
package c3_dominio.pedidos.entidad;

import c5_transversal.excepciones.ExcepcionRegla;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class LineaDePedido {
    private int cantidad;
    private double precio;
    private Plato plato;

    public LineaDePedido(int cantidad, Plato plato) {
        this.cantidad = cantidad;
        this.plato = plato;
        precio = plato.getPrecio();
    }

    public LineaDePedido(int cantidad, double precio, Plato plato) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
    
    /**
     * <b>Regla De Negocio</b>
     * Metodo privado para validar la cantidad ingresada del plato al solicitar un pedido.
     * @param cantidadSolicitada
     * @throws Exception 
     */
    private void validarCantidad(int cantidadSolicitada) throws Exception{
        if(cantidadSolicitada < 1)
            throw ExcepcionRegla.crearErrorCantidadInvalida();
    }
    
    /**
     * <b>Regla De Negocio</b>
     * Metodo publico de validacion de cantidad.
     * @throws Exception 
     */
    public void validarCantidad() throws Exception{
        validarCantidad(cantidad);
    }
    
    /**
     * <b>Regla De Negocio</b>
     * Metodo publico de validacion de cantidad agregada
     * @param cantidadAgregada
     * @throws Exception 
     */
    public void validarCantidadAgregada(int cantidadAgregada) throws Exception{
        validarCantidad(cantidadAgregada);
        int cantidadActualizada = cantidad + cantidadAgregada;
        validarCantidad(cantidadActualizada);
    }
    
    /**
     * <b>Regla De Negocio</b>
     * Validacion de cantidad actualizada
     * @param cantidadActualizada
     * @throws Exception 
     */
    public void validarCantidadActualizada(int cantidadActualizada) throws Exception{
        validarCantidad(cantidadActualizada);
    }
    
   /**
    * <b>Regla De Negocio</b>
    * Este metodo calcula el sub total por cada item agregado al pedido.
    * @return 
    */
    public double calcularSubTotal(){
        return cantidad * precio;
    }
    
    /**
     * <b>Regla De Negocio</b>
     * @param cantidadAgregada 
     */
    public void agregarCantidad(int cantidadAgregada){
        cantidad = cantidad + cantidadAgregada;
    }
}
