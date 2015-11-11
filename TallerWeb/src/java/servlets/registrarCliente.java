/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataFecha;
import servidor.DataInfoCliente;
import servidor.Exception_Exception;


/**
 *
 * @author giovani
 */
@WebServlet(name = "registrarCliente", urlPatterns = {"/registrarCliente"})
public class registrarCliente extends HttpServlet {

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
        servidor.PublicadorClienteService service = new servidor.PublicadorClienteService();
        servidor.PublicadorCliente port = service.getPublicadorClientePort();
        String nick = request.getParameter("nickRegistrar");
        String pass = request.getParameter("passRegistrar");
        if (request.getParameter("registrar") != null) {
            request.getRequestDispatcher("/WEB-INF/Usuarios/registrarCliente.jsp").forward(request, response);
        } else if (request.getParameter("altaCliente") != null) {
            try {
              
                DataFecha dateNac= new DataFecha();
                String fecha = request.getParameter("fechaCliente");
                String[] partes = fecha.split("-");
                int dia = Integer.parseInt(partes[2]); //dd
                int mes = Integer.parseInt(partes[1]); // mm
                int anio = Integer.parseInt(partes[0]); // aaaa
                dateNac.setDia(dia);
                dateNac.setMes(mes);
                dateNac.setAnio(anio);
                request.getSession().setAttribute("fechaNacimiento", dateNac);
                port.altaCliente(nick, request.getParameter("nombreCliente"), request.getParameter("apellidoCliente"), request.getParameter("emailCliente"), dateNac, "imagen" , pass);
                
            } catch (Exception ex) {
                Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex);

            }
            DataInfoCliente cliente = port.iniciarSesion(nick, pass);
            request.getSession().setAttribute("dataCliente", cliente);
            request.getSession().setAttribute("dataClienteres", cliente.getReservas());
            request.getSession().setAttribute("Login", "Logeado");
            request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
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
