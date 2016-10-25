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
public class Mesa {
    private int mesaid;
    private int numero;
    private boolean disponible;
    private String color;
    private static final String COLOR_MESADISPONIBLE = "greenyellow";
    private static final String COLOR_MESAOCUPADA = "darksalmon";

    public Mesa(int mesaid) {
        this.mesaid = mesaid;
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
