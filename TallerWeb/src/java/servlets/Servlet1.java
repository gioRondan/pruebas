/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author rodrigo.linares
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

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
            //String password = (String)request.getSession().getAttribute("txtpass");
            String clave = (String) request.getSession().getAttribute("clave");
            //String clave = (String) request.getParameter("clave");
//#############################     iniciarSesion   #################################################
            if(clave.equals("inicioSesion")){
                String nick = (String) request.getParameter("nick");
                String pass = (String) request.getParameter("pass");
////#############################     prueba      #####################################################
//            try {
//                ICC.altaCliente(nick, nick, nick, nick, null, nick, pass);
//            } catch (Exception ex) {
//                Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
////##################################################################################################
                DataInfoCliente cliente = ICC.iniciarSesion(nick, pass);
                if(cliente != null){
                    request.getSession().setAttribute("dataCliente", cliente);
                    request.getRequestDispatcher("/WEB-INF/perfil.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
//#############################     cerrarSesion   #################################################                
            }else if(clave.equals("cerrarSesion")){
                request.getSession().setAttribute("nick", "");
                request.getSession().setAttribute("pass", "");
                // vaciar carrito
                request.getRequestDispatcher("/index.jsp").forward(request, response);
//#############################     registrarCliente   #################################################
            }else if(clave.equals("registrarCliente")){
                request.getRequestDispatcher("/WEB-INF/registrarCliente.jsp").forward(request, response);
            }else if(clave.equals("altaCliente")){
            try {
                ICC.altaCliente(request.getParameter("nickRegistrar"), request.getParameter("nombreCliente"), request.getParameter("apellidoCliente"), request.getParameter("emailCliente"), null, "imagen", request.getParameter("passRegistrar"));
            } catch (Exception ex) {
                Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
                
            }
                DataInfoCliente cliente = ICC.iniciarSesion(request.getParameter("nickRegistrar"), request.getParameter("passRegistrar"));
                request.getSession().setAttribute("dataCliente", cliente);
                request.getRequestDispatcher("/WEB-INF/perfil.jsp").forward(request, response);
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
