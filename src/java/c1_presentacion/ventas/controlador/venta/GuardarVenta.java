/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.ventas.controlador.venta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.ventas.servicio.RealizarVentaServicio;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.ventas.entidad.Venta;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GuardarVenta extends GestionarVentaComando {
    
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String ruta_servlet = "PageReturn.jsp";
        try {
            Usuario usuario = new Usuario();
            Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
            Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
            if (persona != null && pedido != null) {
                usuario.setPersona(persona);
                double montorecibido = Double.parseDouble(request.getParameter("monto"));
                Venta venta = new Venta();
                venta.setPedido(pedido);
                venta.setUsuario(usuario);
                venta.setDescuento(pedido.calcularDescuento());
                venta.setTotal(pedido.calcularTotal());
                venta.setMontoRecibido(montorecibido);
                venta.setVuelto(venta.calcularVuelto());
                RealizarVentaServicio.getInstancia().registrar(venta);
                HttpSession sesionUsuario = request.getSession(false);
                sesionUsuario.setAttribute("pedido", null);
                
            } else {
                ruta_servlet = "Index";
            }
            
        } catch (Exception e) {
        }
        
        return ruta_servlet;
    }
    
}
