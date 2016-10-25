/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.venta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Pedido;
import modelo.Persona;
import modelo.Usuario;
import modelo.Venta;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GuardarVenta extends GestionarVentaComando{

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String ruta_servlet="PageReturn.jsp";
        try {
            Usuario usuario = new Usuario();
            Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            if(persona!=null && pedido !=null){
                usuario.setPersona(persona);
                double montorecibido = Double.parseDouble(request.getParameter("monto"));
                Venta venta = new Venta();
                venta.setPedido(pedido);
                venta.setUsuario(usuario);
                venta.setDescuento(pedido.calcularDescuento());
                venta.setTotal(pedido.calcularTotal());
                venta.setMontoRecibido(montorecibido);
                venta.setVuelto(venta.calcularVuelto());
                GestionarServicios gestionarServicios = new GestionarServicios();
                gestionarServicios.guardarVenta(venta);
                HttpSession sesionUsuario = request.getSession(false);
               sesionUsuario.setAttribute("pedido", null);
               
            }else{
                ruta_servlet="index.jsp";
            }
                
        } catch (Exception e) {
        }
        
        return ruta_servlet;
    }
    
}
