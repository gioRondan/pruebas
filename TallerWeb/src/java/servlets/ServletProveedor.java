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
import logica.DataInfoProveedor;
import logica.Fabrica;
import logica.IControladorProveedor;

/**
 *
 * @author giovani
 */
@WebServlet(name = "ServletProveedor", urlPatterns = {"/ServletProveedor"})
public class ServletProveedor extends HttpServlet {

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
        //String password = (String)request.getSession().getAttribute("txtpass");
        //String clave = (String) request.getParameter("clave");
        if(request.getParameter("infoProveedor")!= null){
            //DataInfoProveedor proveedor = (DataInfoProveedor) ICP.verInfoProveedor(request.getParameter("nickProveedor"));
            //request.getSession().setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("/WEB-INF/verInfoProveedor.jsp").forward(request, response);
        }
//######################################    verinfoServicio     #########################################################
        else if(request.getParameter("listarCategorias") != null){
            request.getSession().setAttribute("categorias", ICP.listarCategorias());
                
        }
        else if(request.getParameter("verInfoServicio") != null){
            try {
                request.getSession().setAttribute("infoServicio", ICP.verInfoServicio(request.getParameter("nickProveedor"), request.getParameter("nomServicio")));
            } catch (Exception ex) {
                Logger.getLogger(ServletProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/WEB-INF/verInfoServicio.jsp").forward(request, response);
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
