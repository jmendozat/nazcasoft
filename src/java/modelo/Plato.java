/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Plato {

    private int platoid;
    private String nombre;
    private String descripcion;
    private String urlfoto;
    private String estado;
    private boolean activo;
    private double precio;

    public static final String EN_CARTA = "EN CARTA";
    public static final String AGOTADO = "AGOTADO";
    public static final String POR_AGOTAR = "POR AGOTAR";

    public Plato() {
        this.activo = true;
        this.estado = EN_CARTA;
    }

    public Plato(int platoid) {
        this.platoid = platoid;
        this.activo = true;
        this.estado = EN_CARTA;
    }

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.activo = true;
        this.estado = EN_CARTA;
    }

    public Plato(int platoid, String nombre, double precio, String descripcion, String urlfoto, String estado, boolean activo) {
        this.platoid = platoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlfoto = urlfoto;
        this.estado = estado;
        this.activo = activo;
        this.precio = precio;
    }

    public Plato(int platoid, String nombre, double precio, String descripcion, String urlfoto, String estado) {
        this.platoid = platoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlfoto = urlfoto;
        this.estado = estado;
        this.precio = precio;
        this.activo = true;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // se valida una regla de negocio
    public void validarPrecio() throws Exception {
        if (precio < 10.0 || precio > 200.0) {
            throw new Exception("El precio es invalido");
        }
    }
}
