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

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Mesa {
    private int mesaid;
    private int numero;
    private boolean disponible;
    private TipoMesa tipoMesa;
    private String color;
    private static final String COLOR_MESADISPONIBLE = "label label-primary";
    private static final String COLOR_MESAOCUPADA = "label label-warning";

    public Mesa() {
    }

    public Mesa(int mesaid) {
        this.mesaid = mesaid;
        this.disponible = false;
    }

    public Mesa(int numero, boolean disponible) {
        this.numero = numero;
        this.disponible = disponible;
        asignarColor();
    }

    public Mesa(int mesaid, int numero, boolean disponible) {
        this.mesaid = mesaid;
        this.numero = numero;
        this.disponible = disponible;
        asignarColor();
    }

    public int getMesaid() {
        return mesaid;
    }

    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public void setMesaid(int mesaid) {
        this.mesaid = mesaid;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
        asignarColor();
    }
    
    public String getColor(){
        return color;
    }
    
    private void asignarColor(){
        if(disponible)
            color = COLOR_MESADISPONIBLE;
        else
            color = COLOR_MESAOCUPADA;
    }
}
