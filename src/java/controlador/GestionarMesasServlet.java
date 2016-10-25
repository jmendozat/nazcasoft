/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.mesa.GestionarMesaComando;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarMesasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlServlet = request.getServletPath();
        GestionarMesaComando gestionarMesasComando = GestionarMesaComando.instanciarComando(urlServlet.substring(1));
        String url = gestionarMesasComando.ejecutar(request,response);
        RequestDispatcher despachador = request.getRequestDispatcher(url);
        despachador.forward(request, response);
    }
}
