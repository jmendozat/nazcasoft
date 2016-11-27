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

import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c5_transversal.excepciones.ExcepcionRegla;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Pedido {

    private int pedidoid;
    private Date fecha;
    private String estado;
    private Mesa mesa;
    private Persona cliente;
    private Usuario usuario;
    private List<LineaDePedido> lineasDePedido;
    private ICalculoDescuento estrategiadescuento;
    public static final String ABIERTO = "Abierto";
    public static final String CERRADO = "Cerrado";
    public static final String ANULADO = "Anulado";

    public Pedido(){
        pedidoid = 0;
        fecha = Date.valueOf(LocalDate.now());
        estado = ABIERTO;
        lineasDePedido = new ArrayList();
    }
    
    public Pedido(Mesa mesa) {
        pedidoid = 0;
        this.mesa = mesa;
        fecha = Date.valueOf(LocalDate.now());
        estado = ABIERTO;
        lineasDePedido = new ArrayList();
    }

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

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ICalculoDescuento getEstrategiadescuento() {
        return estrategiadescuento;
    }

    public void setEstrategiadescuento(ICalculoDescuento estrategiadescuento) {
        this.estrategiadescuento = estrategiadescuento;
    }

    /**
     * <b>Regla De Negocio</b>
     * Esta función agrega un plato mas la cantidad al pedido.
     * @param plato
     * @param cantidad
     * @throws Exception 
     */
    public void agregarLineaDePedido(Plato plato, int cantidad)throws Exception{
        boolean esNuevoPlato = true;
        for (LineaDePedido lineaDePedidoExistente : lineasDePedido) {
            Plato platoexistente = lineaDePedidoExistente.getPlato();
            if (plato.getPlatoid() == platoexistente.getPlatoid()) {
                lineaDePedidoExistente.validarCantidadAgregada(cantidad);
                lineaDePedidoExistente.agregarCantidad(cantidad);
                esNuevoPlato = false;
                break;
            }
        }
        if (esNuevoPlato) {
            LineaDePedido lineaDePedido = new LineaDePedido(cantidad, plato);
            lineaDePedido.validarCantidad();
            lineasDePedido.add(lineaDePedido);
        }
    }

    /**
     * <b>Regla De Negocio</b>
     * Funcion de agregacion de toda una Linea de Pedidos
     * @param lineaDePedido 
     */
    public void agregarLineaDePedido(LineaDePedido lineaDePedido) {
        lineasDePedido.add(lineaDePedido);
    }

    /**
     * <b>Regla De Negocio</b>
     * Eliminar la linea de Peido, necesita el identificvado del plato.
     * @param platoid 
     */
    public void eliminarLineaDePedido(int platoid) {
        for (LineaDePedido lineaDePedido : lineasDePedido) {
            Plato plato = lineaDePedido.getPlato();
            if (plato.getPlatoid() == platoid) {
                lineasDePedido.remove(lineaDePedido);
                break;
            }
        }
    }

    /**
     * <b>Regla De Negocio</b>
     * Actualiza la lines de pedidos, necesita los sigueintes parametros:
     * @param platoid
     * @param cantidad
     * @throws Exception 
     */
    public void actualizarLineaDePedido(int platoid, int cantidad) throws Exception {
        for (LineaDePedido lineaDePedido : lineasDePedido) {
            Plato plato = lineaDePedido.getPlato();
            if (plato.getPlatoid() == platoid) {
                lineaDePedido.validarCantidadActualizada(cantidad);
                lineaDePedido.setCantidad(cantidad);
                break;
            }
        }
    }

    /**
     * <b>Regla De Negocio</b>
     * Calcula el sub total de todos los items agregados al pedido.
     * @return 
     */
    public double calcularSubTotal() {
        double total = 0.0;
        total = lineasDePedido.stream().map((lineaDePedido) -> lineaDePedido.calcularSubTotal()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }

    /**
     * <b>Regla De Negocio</b>
     * Clacula el numero de platos de todos los items agregados al pedido.
     * @return 
     */
    public int calcularNumeroDePlatos() {
        int totaldeplatos = 0;
        totaldeplatos = lineasDePedido.stream().map((lineaDePedido) -> lineaDePedido.getCantidad()).reduce(totaldeplatos, Integer::sum);
        return totaldeplatos;
    }

    /**
     * <b>Regla De Negocio</b>
     * Valida el pedido siempre y cuando el sub total sea mayor a 0.
     * @throws ExcepcionRegla 
     */
    public void validarPedido() throws ExcepcionRegla {
        if (calcularSubTotal() == 0) {
            throw ExcepcionRegla.crearErrorPedido();
        }
    }

    /**
     * <b>Regla De Negocio</b>
     * Este metodo calcula el descuento, esta formado por un conjunto de composiciones de estrategias.
     * @return 
     */
    public double calcularDescuento() {
        return estrategiadescuento.calcularDescuento(this);
    }
    /**
     * <b>Regla De Negocio</b>
     * Calcular el total de todos los items del pedido.
     * @return 
     */
    public double calcularTotal() {
        return calcularSubTotal() - calcularDescuento();
    }
}
