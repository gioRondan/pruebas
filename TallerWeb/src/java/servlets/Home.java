/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.CargaInicial;
import logica.DataCategoria;
import logica.DataPromocion;
import logica.DataProveedor;
import logica.DataServicio;
import logica.Fabrica;
import logica.IControladorProveedor;


/**
 *
 * @author Juan
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    static String prueba = " { 'core' : {'data' : [";
    int i =0;
    
    public void armarArbol(String padre, List<DataCategoria> dtps) {
        
        for (DataCategoria dtcategoria : dtps) {
           i++;
           prueba = prueba+"{"+"'id'"+" : "+ "'ajson"+i+"', "+ "'parent' : "+padre+", 'text' : '"+dtcategoria.getNombre()+"'},";
           armarArbol("'ajson"+i+"'", dtcategoria.getHijos() );
       }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
                    Fabrica fab = Fabrica.getInstance();
                    IControladorProveedor ICP = fab.getIControladorProveedor();
           
                    CargaInicial x2 = new CargaInicial();
                    x2.cargar();
                    
                    List<DataCategoria> dtps = ICP.listarCategorias();
                    prueba = " { 'core' : {'data' : [";
                     i =0;
                    armarArbol("'#'", dtps);
                   prueba=prueba+"] } });";
                    
                  
                    request.setAttribute("dataCategorias", prueba);
                    
                    List<DataServicio> servicos = new ArrayList<DataServicio>();
                    List<DataPromocion> promos = new ArrayList<DataPromocion>();
                    if (request.getParameter("categoria") != null){
                        String categoria = (String) request.getParameter("categoria");
                        servicos = ICP.listarServiciosXCategoria(categoria);
                    }else{
                       List<DataProveedor> cate = ICP.listarProveedores();
                       for (DataProveedor una : cate){
                          servicos.addAll(ICP.listarServiciosXProveedor(una.getNickname()));
                          promos.addAll(ICP.listarPromocionesXProveedor(una.getNickname()));
                       }
                    }
                
                request.setAttribute("dataServicos", servicos);
                request.setAttribute("dataPromociones", promos);
                //request.getRequestDispatcher("/WEB-INF/perfil.jsp").forward(request, response);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
      
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
                
                request.getRequestDispatcher("/WEB-INF/Servicios/listar.jsp").forward(request, response);
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
