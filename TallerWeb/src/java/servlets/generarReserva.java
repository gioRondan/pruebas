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

import servidor.DataInfoCliente;
import servidor.DataItemReserva;




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
            servidor.PublicadorClienteService service = new servidor.PublicadorClienteService();
            servidor.PublicadorCliente port = service.getPublicadorClientePort();
            List<DataItemReserva> items = (List<DataItemReserva>) request.getSession().getAttribute("ItemsReservaActual");
            DataInfoCliente cli = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
            if (items != null){
                try {
                    
                    
                    List<DataItemReserva> ir2 = (List<DataItemReserva>)request.getSession().getAttribute("ItemsReservaActual");
                    DataItemReserva[] arrayItems = new DataItemReserva[ir2.size()];
                    int i =0;
                    for ( DataItemReserva ir : ir2  ){
                        //arrayItems[i]=ir;
                        port.agregarItemReserva(ir);
                        i++;
                    }
                    port.confirmarReserva2(cli);
                    items.removeAll(items);//vacio el carrito
                    request.getSession().setAttribute("ItemsReservaActual", items );
                    DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
                    cliente = port.iniciarSesion(cliente.getNickname(), cliente.getPassword());//reinicio sesion para actualizar los datos de las reservas 
                    request.getSession().setAttribute("dataCliente", cliente);
                } catch (Exception ex) {
                    Logger.getLogger(generarReserva.class.getName()).log(Level.SEVERE, null, ex);
                }  
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
