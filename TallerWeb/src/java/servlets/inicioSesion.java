/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DataInfoCliente;
import logica.Fabrica;
import logica.IControladorCliente;

/**
 *
 * @author giovani
 */
@WebServlet(name = "inicioSesion", urlPatterns = {"/inicioSesion"})
public class inicioSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fabrica fab = Fabrica.getInstance();
        IControladorCliente ICC = fab.getIControladorCliente();
        if(request.getParameter("entrar") != null){
           String nick = (String) request.getParameter("nick");
           String pass = (String) request.getParameter("pass");
           DataInfoCliente cliente = ICC.iniciarSesion(nick, pass);
           if(cliente != null){
               request.getSession().setAttribute("dataCliente", cliente);
               request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
               request.setAttribute("Login", "Logeado");
           }else{
               request.getSession().setAttribute("Login", "Datosincorrectos");
           }
        }else{
        
          request.getRequestDispatcher("/WEB-INF/Usuarios/inicioSesion.jsp").forward(request, response);  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
