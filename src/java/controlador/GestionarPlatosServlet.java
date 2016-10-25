/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.plato.GestionarPlatosComando;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lain
 */
public class GestionarPlatosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlServlet = request.getServletPath();
        GestionarPlatosComando gestionarPlatosComando = GestionarPlatosComando.instanciarComando(urlServlet.substring(1));
        String url = gestionarPlatosComando.ejecutar(request,response);
        RequestDispatcher despachador = request.getRequestDispatcher(url);
        despachador.forward(request, response);
    }
    
}
