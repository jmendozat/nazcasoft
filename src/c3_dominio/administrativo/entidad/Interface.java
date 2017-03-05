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
package c3_dominio.administrativo.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Interface {
    private int codigoInterface;
    private String nombreMayus;
    private String nombreMinus;
    private String ruta;
    private String icondesc;
    List<Interface> listaInterface;

    public Interface() {
        this.listaInterface = new ArrayList();
    }

    public int getCodigoInterface() {
        return codigoInterface;
    }

    public void setCodigoInterface(int codigoInterface) {
        this.codigoInterface = codigoInterface;
    }

    public String getNombreMayus() {
        return nombreMayus;
    }

    public void setNombreMayus(String nombreMayus) {
        this.nombreMayus = nombreMayus;
    }

    public String getNombreMinus() {
        return nombreMinus;
    }

    public void setNombreMinus(String nombreMinus) {
        this.nombreMinus = nombreMinus;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getIcondesc() {
        return icondesc;
    }

    public void setIcondesc(String icondesc) {
        this.icondesc = icondesc;
    }

    public List<Interface> getListaInterface() {
        return listaInterface;
    }

    public void setListaInterface(List<Interface> listaInterface) {
        this.listaInterface = listaInterface;
    }
 
    
}
