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
public class Venta {

    private Pedido pedido;
    private Usuario usuario;
    private double descuento;
    private double total;
    private double montoRecibido;
    private double vuelto;

    public Venta() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    private void validarMonto() throws Exception {
        if (montoRecibido < total) {
            throw new Exception("El monto es incorrecto");
        }
    }

    public double calcularVuelto() throws Exception {
        validarMonto();
        double vuelto = 0.0;
        vuelto = montoRecibido - total;
        return vuelto;
    }

}
