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
import logica.Fabrica;
import logica.IControladorProveedor;

/**
 *
 * @author giovani
 */
@WebServlet(name = "verInfoServicio", urlPatterns = {"/verInfoServicio"})
public class verInfoServicio extends HttpServlet {

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
        IControladorProveedor ICP = fab.getIControladorProveedor();
        if(request.getParameter("listarCategorias") != null){
            request.getSession().setAttribute("categorias", ICP.listarCategorias());
                
        }
        else if(request.getParameter("verInfoServicio") != null){
            try {
               request.getSession().setAttribute("infoServicio", ICP.verInfoServicio(request.getParameter("proveedorServico"), request.getParameter("nombreServico")));
            } catch (Exception ex) {
                Logger.getLogger(ServletProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        try {
            String s = request.getParameter("proveedorServico");
            String s2 = request.getParameter("nombreServico");
            request.setAttribute("infoServicio", ICP.verInfoServicio(s,s2) );
        } catch (Exception ex) {
            Logger.getLogger(verInfoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/Servicios/verInfoServicio.jsp").forward(request, response);
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
