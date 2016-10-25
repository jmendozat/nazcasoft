/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lain
 */
public class ConsultarPedido extends GestionarPedidosComando{
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        return "c1_presentacion/vista/PaginaRegistrarPedido.jsp";
    }
}
