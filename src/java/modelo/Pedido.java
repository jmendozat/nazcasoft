/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lain
 */
public class Pedido {
    private int pedidoid;
    private Date fecha;
    private String estado;
    private Mesa mesa;
    private List<LineaDePedido> lineasDePedido;
    public static final String ABIERTO = "Abierto";
    public static final String CERRADO = "Cerrado";
    public static final String ANULADO = "Anulado";

    // constructor usado desde la capa de presentación
    public Pedido(Mesa mesa) {
        pedidoid = 0;
        this.mesa = mesa;        
        fecha = Date.valueOf(LocalDate.now());
    //fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
        estado = ABIERTO;
        lineasDePedido = new ArrayList();        
    }

    // constructor usado desde la capa de persistencia
    public Pedido(int pedidoid, Date fecha, String estado) {
        this.pedidoid = pedidoid;
        this.fecha = fecha;
        this.estado = estado;
        lineasDePedido = new ArrayList();
    }

    public int getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(int pedidoid) {
        this.pedidoid = pedidoid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<LineaDePedido> getLineasDePedido() {
        return lineasDePedido;
    }
    // regla de negocio
    public void agregarLineaDePedido(Plato plato, int cantidad) throws Exception{
        boolean esNuevoPlato = true;
        for(LineaDePedido lineaDePedidoExistente : lineasDePedido){
            Plato platoexistente = lineaDePedidoExistente.getPlato();
            if(plato.getPlatoid() == platoexistente.getPlatoid()){                
                lineaDePedidoExistente.validarCantidadAgregada(cantidad);
                lineaDePedidoExistente.agregarCantidad(cantidad);                 
                esNuevoPlato = false;
                break;
            }
        }
        if(esNuevoPlato){
            LineaDePedido lineaDePedido = new LineaDePedido(cantidad, plato);
            lineaDePedido.validarCantidad();
            lineasDePedido.add(lineaDePedido);
        }
    }
    
    // regla de negocio
    public void agregarLineaDePedido(LineaDePedido lineaDePedido) {
        lineasDePedido.add(lineaDePedido);
    }
    
    // regla de negocio
    public void eliminarLineaDePedido(int platoid){
        for(LineaDePedido lineaDePedido : lineasDePedido){
            Plato plato = lineaDePedido.getPlato();
            if(plato.getPlatoid() == platoid){    
                lineasDePedido.remove(lineaDePedido);
                break;
            }
        }
    }
    
    // regla de negocio
    public void actualizarLineaDePedido(int platoid, int cantidad) throws Exception{        
        for(LineaDePedido lineaDePedido : lineasDePedido){
            Plato plato = lineaDePedido.getPlato();
            if(plato.getPlatoid() == platoid){    
                lineaDePedido.validarCantidadActualizada(cantidad);
                lineaDePedido.setCantidad(cantidad);
                break;
            }
        }
    } 
    // regla de negocio
    public double calcularTotal(){
        double total = 0.0;
        for(LineaDePedido lineaDePedido : lineasDePedido){
            total += lineaDePedido.calcularSubTotal();
        }
        return total;
    }  
    // regla de negocio
    public double calcularNumeroDePlatos(){
        int totaldeplatos = 0;
        for(LineaDePedido lineaDePedido : lineasDePedido){
            totaldeplatos += lineaDePedido.getCantidad();
        }
        return totaldeplatos;
    }  
    // regla de negocio
    public void validarPedido()  throws Exception{
        if(calcularTotal() == 0)
            throw new Exception("Error de pedido");
    }
    public double calcularDescuento(){
       return 0;
    }  
    public double calcularTotalito(){
        return calcularTotal()-calcularDescuento();
    }
    
 
}
