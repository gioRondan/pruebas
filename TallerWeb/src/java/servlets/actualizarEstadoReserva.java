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
import servidor.DataInfoCliente;
import servidor.Estado;

/**
 *
 * @author giovani
 */
@WebServlet(name = "actualizarEstadoReserva", urlPatterns = {"/actualizarEstadoReserva"})
public class actualizarEstadoReserva extends HttpServlet {

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
        //actualizarEstadoReserva(int identificador, String nomCliente, Estado estado)
        servidor.PublicadorClienteService service = new servidor.PublicadorClienteService();
        servidor.PublicadorCliente port = service.getPublicadorClientePort();
        String est = (String) request.getParameter("estado");

        int id = Integer.parseInt((String) request.getParameter("verInfoReserva"));
        String nick = (String) request.getParameter("nickCliente");
        if (est.equals("CANCELADA")) {
            port.actualizarEstadoReserva(id, nick, Estado.CANCELADA);
        } else {
            port.actualizarEstadoReserva(id, nick, Estado.PAGADA);
        }
        //reinicio sesion para actualizar los datos de las reservas 
        DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
        cliente = port.iniciarSesion(cliente.getNickname(), cliente.getPassword());
        request.getSession().setAttribute("dataCliente", cliente);
        request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
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
