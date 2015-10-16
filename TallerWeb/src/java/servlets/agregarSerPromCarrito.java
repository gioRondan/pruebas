/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DataItemReserva;
import logica.Fabrica;
import logica.IControladorCliente;
import logica.ItemReserva;

/**
 *
 * @author giovani
 */
@WebServlet(name = "agregarSerPromCarrito", urlPatterns = {"/agregarSerPromCarrito"})
public class agregarSerPromCarrito extends HttpServlet {

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
            if (request.getParameter("agergaracarrito") != null){
                Fabrica f = Fabrica.getInstance();
                IControladorCliente ICC = f.getIControladorCliente();
                int cant =  Integer.parseInt(request.getParameter("cantItemReserva"));
                Date fini = ICC.toDate(request.getParameter("fechainiItemReserva"));
                Date ffin = ICC.toDate(request.getParameter("fechafinItemReserva"));
                String nom = request.getParameter("nomServicio");
                boolean esser = Boolean.parseBoolean(request.getParameter("esservicio"));
                DataItemReserva x = new DataItemReserva(cant,fini ,ffin ,nom,esser);               
                List<DataItemReserva> ir2 = (List<DataItemReserva>)request.getSession().getAttribute("ItemsReservaActual");
                ir2.add(x);
                request.getSession().setAttribute("ItemsReservaActual",ir2 );
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
