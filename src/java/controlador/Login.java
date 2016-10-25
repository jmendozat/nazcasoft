/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.GestionarServicios;
import modelo.Persona;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario, password;
        usuario = req.getParameter("txtUsuario");
        password = req.getParameter("txtPassword");
        try {
            GestionarServicios gestionarServicios = new GestionarServicios();
            Persona persona;
            persona = gestionarServicios.NAZCASOFT_ADM_LoginUsuario(usuario, password);
            if (persona != null) {
                HttpSession sesionUsuario = req.getSession(true);
                sesionUsuario.setAttribute("sesUsuario", persona);
                resp.sendRedirect("Index");
            } else {
                RequestDispatcher despachador = req.getRequestDispatcher("Login.jsp");
                despachador.forward(req, resp);
            }

        } catch (Exception e) {
            RequestDispatcher despachador = req.getRequestDispatcher("Login.jsp");
            despachador.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario, password;
        usuario = req.getParameter("txtUsuario");
        password = req.getParameter("txtPassword");
        try {
            GestionarServicios gestionarServicios = new GestionarServicios();
            Persona persona;
            persona = gestionarServicios.NAZCASOFT_ADM_LoginUsuario(usuario, password);
            if (persona != null) {
                HttpSession sesionUsuario = req.getSession(true);
                sesionUsuario.setAttribute("sesUsuario", persona);
                resp.sendRedirect("Index");
            } else {
                RequestDispatcher despachador = req.getRequestDispatcher("index.jsp");
                despachador.forward(req, resp);
            }

        } catch (Exception e) {
            RequestDispatcher despachador = req.getRequestDispatcher("index.jsp");
            despachador.forward(req, resp);
        }
    }

}
