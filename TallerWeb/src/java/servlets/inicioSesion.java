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
import logica.IControladorCliente;


/**
 *
 * @author giovani
 */
@WebServlet(name = "inicioSesion", urlPatterns = {"/inicioSesion"})
public class inicioSesion extends HttpServlet {

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
        
        wsc.PublicadorClienteService service = new wsc.PublicadorClienteService();
        wsc.PublicadorCliente port = service.getPublicadorClientePort();
        
     // request.getSession().setAttribute("json", port.listarClientes());
        
      request.getSession().setAttribute("datatype", port.pruebaDatas());
      
      //String mostrar = port.pruebaDatas()[0].getNombre() + port.pruebaDatas()[1].getNombre();
       request.getSession().setAttribute("json", port.pruebaDatas());
//        JSONParser jsonParser = new JSONParser();
//        
//        Object obj;
//        try {
//            obj = jsonParser.parse(port.listarClientes());
//            JSONArray lista = (JSONArray)obj;
//        DataCliente cli = (DataCliente) lista.get(1);
//        request.getSession().setAttribute("Data", cli);
//        } catch (ParseException ex) {
//            Logger.getLogger(inicioSesion.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if ((request.getSession().getAttribute("Login") == "Logeado")){
            
             request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
        }
        else{
            if(request.getParameter("entrar") != null){
               String nick = (String) request.getParameter("nick");
               String pass = (String) request.getParameter("pass");
                wsc.DataInfoCliente cliente = port.iniciarSesion(nick, pass);
               
               if(cliente != null){
                   request.getSession().setAttribute("dataCliente", cliente);
                   request.getSession().setAttribute("dataClienteres", cliente.getReservas());
                   request.getRequestDispatcher("/WEB-INF/Usuarios/perfil.jsp").forward(request, response);
                   request.getSession().setAttribute("Login", "Logeado");
               }else{
                   request.getSession().setAttribute("Login", "Datosincorrectos");
                   request.getRequestDispatcher("/WEB-INF/Usuarios/inicioSesion.jsp").forward(request, response); 
               }
            }else{

              request.getRequestDispatcher("/WEB-INF/Usuarios/inicioSesion.jsp").forward(request, response);  
            }
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
