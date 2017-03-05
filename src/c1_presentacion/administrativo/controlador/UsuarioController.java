/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador;

import c1_presentacion.administrativo.controlador.usuario.GestionarUsuarioComando;
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
public class UsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gestionarUsuarioController(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        gestionarUsuarioController(req, resp);
    }

    private void gestionarUsuarioController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlServlet = req.getServletPath();
        GestionarUsuarioComando gestionarUsuarioComando = GestionarUsuarioComando.instanciarComando(urlServlet.substring(1));
        String url = gestionarUsuarioComando.ejecutar(req, resp);
        RequestDispatcher despachador = req.getRequestDispatcher(url);
        despachador.forward(req, resp);
    }

}
