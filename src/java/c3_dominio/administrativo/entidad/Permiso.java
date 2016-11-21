/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.administrativo.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Permiso {
    private Usuario usuario;
    private List<Interface> listaInterface;
    
    public final static int []DEFAULT_CLIENTE = {2,28,24};

    public Permiso() {
        this.listaInterface = new ArrayList();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Interface> getListaInterface() {
        return listaInterface;
    }

    public void setListaInterface(List<Interface> listaInterface) {
        this.listaInterface = listaInterface;
    }
    
    public void agregarInterface(Interface intFace){
        listaInterface.add(intFace); 
    }
}
