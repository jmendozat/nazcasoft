/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author Lain
 */
public class Plato {
    private int platoid;
    private String nombre;
    private double precio;

    public Plato(int platoid) {
        this.platoid = platoid;
    }

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Plato(int platoid, String nombre, double precio) {
        this.platoid = platoid;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getPlatoid() {
        return platoid;
    }

    public void setPlatoid(int platoid) {
        this.platoid = platoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    
    // se valida una regla de negocio
    public void validarPrecio() throws Exception {
        if(precio < 10.0 || precio > 200.0)
            throw new Exception("Error de precio");
    }

}
