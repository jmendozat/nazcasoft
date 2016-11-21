/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.ventas.controlador;

import c1_presentacion.ventas.controlador.venta.GestionarVentaComando;
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
public class VentasController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlServlet = req.getServletPath();
        GestionarVentaComando gestionarVentaComando = GestionarVentaComando.instanciarComando(urlServlet.substring(1));
        String url = gestionarVentaComando.ejecutar(req, resp);
        RequestDispatcher despachador = req.getRequestDispatcher(url);
        despachador.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlServlet = req.getServletPath();
        GestionarVentaComando gestionarVentaComando = GestionarVentaComando.instanciarComando(urlServlet.substring(1));
        String url = gestionarVentaComando.ejecutar(req, resp);
        RequestDispatcher despachador = req.getRequestDispatcher(url);
        despachador.forward(req, resp);
    }

}
