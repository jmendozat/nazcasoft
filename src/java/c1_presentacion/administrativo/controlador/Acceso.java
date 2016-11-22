/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.administrativo.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c2_aplicacion.administrativo.servicio.GestionarUsuarioServicio;
import c3_dominio.administrativo.entidad.Persona;
import c3_dominio.administrativo.entidad.Usuario;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
@WebServlet(name = "Acceso", urlPatterns = {"/Acceso"})
public class Acceso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario, password;
        usuario = req.getParameter("txtUsuario");
        password = req.getParameter("txtPassword");
        try {
            Persona persona = GestionarUsuarioServicio.getInstancia().func_NAZCA_ADM_Login(new Usuario(usuario, password));
            if (persona != null) {
                HttpSession sesionUsuario = req.getSession(true);
                sesionUsuario.setAttribute("sesUsuario", persona);
                resp.sendRedirect("Index");
            } else {
                RequestDispatcher despachador = req.getRequestDispatcher("Login");
                despachador.forward(req, resp);
            }

        } catch (IOException | ServletException | ExcepcionSQL e) {
            RequestDispatcher despachador = req.getRequestDispatcher("Login");
            despachador.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String usuario, password;
        usuario = req.getParameter("txtUsuario");
        password = req.getParameter("txtPassword");
        try {
            Persona persona = GestionarUsuarioServicio.getInstancia().func_NAZCA_ADM_Login(new Usuario(usuario, password));
            if (persona != null) {
                HttpSession sesionUsuario = req.getSession(true);
                sesionUsuario.setAttribute("sesUsuario", persona);
                resp.sendRedirect("Index");
            } else {
                RequestDispatcher despachador = req.getRequestDispatcher("Login");
                despachador.forward(req, resp);
            }

        } catch (IOException | ServletException | ExcepcionSQL e) {
            RequestDispatcher despachador = req.getRequestDispatcher("Login");
            despachador.forward(req, resp);
        }

    }
    
 
}
