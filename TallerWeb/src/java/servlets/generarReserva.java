/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DataExpira;
import logica.DataItemReserva;
import logica.DataPromocion;
import logica.DataServicio;
import logica.Fabrica;
import logica.IControladorCliente;
import logica.IControladorWeb;

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
            IControladorWeb web = fab.getIControladorWeb();
            List<DataItemReserva> items = (List<DataItemReserva>) request.getSession().getAttribute("ItemsReservaActual");
            if (items != null){
                for(DataItemReserva item : items){
                    if (item.getesServico()){
                        //(String nickProveedor, String nomServicio, Integer cantidad, Date fechaInicio, Date fechaFin
                    
                    DataServicio serv = item.getServicio();
                    try {
                        web.agregarServicioCarrito(serv.getProveedor(),serv.getNombre(),item.getCantidad(),item.getFechaInicio(),item.getFechaFin());
                    } catch (Exception ex) { }
                    }else{
                        // String nickProveedor, String nomPromocion, Integer cantidad, Date fechaInicio, Date fechaFin
                        DataPromocion prom = item.getPromocion();
                        web.agregarPromocionCarrito(prom.getnickProveedro(),prom.getNombre(),item.getCantidad(),item.getFechaInicio(),item.getFechaFin());
                    }
                        
                    
                }
                web.confirmarReserva();

        
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
