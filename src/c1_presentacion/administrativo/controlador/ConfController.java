/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador;

import c1_presentacion.administrativo.controlador.config.ConfiguracionComando;
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
public class ConfController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gestionarConfController(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gestionarConfController(req, resp);

    }

    private void gestionarConfController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlServlet = req.getServletPath();
        ConfiguracionComando confComando = ConfiguracionComando.instanciarComando(urlServlet.substring(1));
        String url = confComando.ejecutar(req, resp);
        RequestDispatcher despachador = req.getRequestDispatcher(url);
        despachador.forward(req, resp);
    }

}
