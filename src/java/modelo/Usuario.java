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
public class Usuario {

    private Persona persona;
    private String emailCuenta;
    private String upassword;
    private boolean activo;

    public Usuario(Persona persona){
        this.persona=persona;
        
    }
    
    public Usuario(Persona persona, String email, String upassword) {
        this.persona = persona;
        this.emailCuenta = email;
        this.upassword = upassword;
        this.activo = true;
    }

    public Usuario() {
        this.activo = true;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEmailCuenta() {
        return emailCuenta;
    }

    public void setEmailCuenta(String emailCuenta) {
        this.emailCuenta = emailCuenta;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
