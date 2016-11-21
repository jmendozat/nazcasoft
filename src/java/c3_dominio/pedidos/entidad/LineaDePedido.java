/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.entidad;

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
    
    // regla de negocio
    private void validarCantidad(int cantidadSolicitada) throws Exception{
        if(cantidadSolicitada < 1 || cantidadSolicitada > 15)
            throw new Exception("Error cantidad invalida");
    }
    
    // regla de negocio
    public void validarCantidad() throws Exception{
        validarCantidad(cantidad);
    }
    
    // regla de negocio
    public void validarCantidadAgregada(int cantidadAgregada) throws Exception{
        validarCantidad(cantidadAgregada);
        int cantidadActualizada = cantidad + cantidadAgregada;
        validarCantidad(cantidadActualizada);
    }
    
    // regla de negocio
    public void validarCantidadActualizada(int cantidadActualizada) throws Exception{
        validarCantidad(cantidadActualizada);
    }
    
    // regla de negocio
    public double calcularSubTotal(){
        return cantidad * precio;
    }
    
    // regla de negocio
    public void agregarCantidad(int cantidadAgregada){
        cantidad = cantidad + cantidadAgregada;
    }
}
