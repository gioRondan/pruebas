/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.DataInfoCliente;
import logica.DataItemReserva;


import logica.Fabrica;
import logica.IControladorCliente;


/**
 *
 * @author giovani
 */
@WebServlet(name = "generarReserva", urlPatterns = {"/generarReserva"})
public class generarReserva extends HttpServlet {

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
        if(request.getParameter("comprar") != null){
            Fabrica fab = Fabrica.getInstance();
            IControladorCliente ICC = fab.getIControladorCliente();
            
            List<DataItemReserva> items = (List<DataItemReserva>) request.getSession().getAttribute("ItemsReservaActual");
            DataInfoCliente cli = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
            if (items != null){
                try {
                    ICC.confirmarReserva(items,cli);
                } catch (Exception ex) {
                    Logger.getLogger(generarReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
                items.removeAll(items);//vacio el carrito
                request.getSession().setAttribute("ItemsReservaActual", items );
                DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
                cliente = ICC.iniciarSesion(cliente.getNickname(), cliente.getPassword());//reinicio sesion para actualizar los datos de las reservas 
                request.getSession().setAttribute("dataCliente", cliente);
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
