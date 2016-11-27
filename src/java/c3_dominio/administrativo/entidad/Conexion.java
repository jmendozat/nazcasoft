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

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class Conexion {
    private String usuario;
    private String password;
    private String servidor;
    private String puerto;
    private String baseDatos;
    private String fabrica;

    public Conexion(String usuario, String password, String servidor, String puerto, String baseDatos, String fabrica) {
        this.usuario = usuario;
        this.password = password;
        this.servidor = servidor;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
        this.fabrica = fabrica;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }
    
}
