/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Juan
 */
public class Imagenes extends HttpServlet {

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
         PrintWriter out = response.getWriter();
        /*if (request.getParameter("Subir")!=null){
            String ubicacion = CargaInicial.getRuta()+"/Imagenes/Usuarios/";
            
               DiskFileItemFactory fabrica = new DiskFileItemFactory();
               fabrica.setSizeThreshold(1024);

               fabrica.setRepository(new File(ubicacion));
               
               ServletFileUpload upload = new ServletFileUpload(fabrica);
               try{
                   
                   List<FileItem> partes=upload.parseRequest(request);
                    
                   for(FileItem par : partes ){
                      File file = new File(ubicacion, par.getName());
                       par.write(file);
                       out.println("Ok");
                   }
                   out.println("Ok");
                   
               }catch (Exception ex){
                   out.println("Error "+ex.getMessage());
               }
        }
        if (request.getParameter("Bajar")!=null){
            Fabrica fab = Fabrica.getInstance();
            BufferedImage img;
             try {
                 img = fab.getIControladorCliente().leerImgURL(request.getParameter(CargaInicial.getRuta()+request.getParameter("rutaIamgen")));
                  request.setAttribute("imagen", img.createGraphics());
             } catch (Exception ex) {
                 Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }*/
        
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
