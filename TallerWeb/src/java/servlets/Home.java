/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.CargaInicial;
import logica.DataCategoria;
import logica.DataItemReserva;
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
                if  (request.getSession().getAttribute("Login") == null){
                    request.getSession().setAttribute("Login", "NoLogeado");
                    List<DataItemReserva> ir = new ArrayList<DataItemReserva>();
                    request.getSession().setAttribute("ItemsReservaActual",ir );
                    CargaInicial x2 = new CargaInicial();
                    x2.cargar();
                }
                   
                    
                    List<DataCategoria> dtps = ICP.listarCategorias();
                    prueba = " { 'core' : {'data' : [";
                     i =0;
                    armarArbol("'#'", dtps);
                   prueba=prueba+"] } });";
                    
                  
                    request.setAttribute("dataCategorias", prueba);
                    
                    List<DataServicio> servicos = new ArrayList<DataServicio>();
                    
                    List<DataPromocion> promos = new ArrayList<DataPromocion>();
                    if ( (request.getParameter("categoria") != null) && (!(request.getParameter("categoria").equals(" "))) ){
                        String categoria = (String) request.getParameter("categoria");
                        request.getSession().setAttribute("categoria", categoria);//seteo para mantener el filtro en el jsp
                        //categoria = categoria.substring( categoria.indexOf(":")+2 , categoria.length() );
                        String c ="";
                        while (  (categoria.indexOf(",")!=-1) ){
                            c = categoria.substring(0, categoria.indexOf(","));
                            categoria = categoria.substring( categoria.indexOf(",")+2 , categoria.length() );
                            servicos.addAll(ICP.listarServiciosXCategoria(c));   
                        }
                        List<DataProveedor> prove = ICP.listarProveedores();
                        for (DataProveedor una : prove){ 
                           promos.addAll(ICP.listarPromocionesXProveedor(una.getNickname()));
                        }
                    }else{
                       List<DataProveedor> cate = ICP.listarProveedores();
                       for (DataProveedor una : cate){
                          servicos.addAll(ICP.listarServiciosXProveedor(una.getNickname()));
                          promos.addAll(ICP.listarPromocionesXProveedor(una.getNickname()));
                       }
                    }
                     
                    
                    if  ( request.getParameter("orden") != null ){
                        int ord = Integer.parseInt(request.getParameter("orden"));
                      switch   ( ord ){
                          case 1://Precio Acendentes
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataServicio s1 = (DataServicio) o1;
                                    DataServicio s2 = (DataServicio) o2;
                                    return new Integer( (int)s1.getPrecio() ).compareTo( (int) s2.getPrecio() );
                                }   
                            });
                            Collections.sort(promos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataPromocion p1 = (DataPromocion) o1;
                                    DataPromocion p2 = (DataPromocion) o2;
                                    return new Integer( (int)p1.getPrecioTotal()).compareTo( (int) p2.getPrecioTotal());
                                }   
                            });
                          break;
                          case 2://Precio Decendente
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataServicio s1 = (DataServicio) o1;
                                    DataServicio s2 = (DataServicio) o2;
                                    return new Integer( (int)s2.getPrecio() ).compareTo( (int) s1.getPrecio() );
                                }   
                            });
                             Collections.sort(promos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataPromocion p1 = (DataPromocion) o1;
                                    DataPromocion p2 = (DataPromocion) o2;
                                    return new Integer( (int)p2.getPrecioTotal()).compareTo( (int) p1.getPrecioTotal());
                                }   
                            });
                          break;
                          case 3://Precio Nombre
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataServicio s1 = (DataServicio) o1;
                                    DataServicio s2 = (DataServicio) o2;
                                    return (s1.getNombre() ).compareTo(s2.getNombre());
                                }   
                            });
                             Collections.sort(promos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataPromocion p1 = (DataPromocion) o1;
                                    DataPromocion p2 = (DataPromocion) o2;
                                    return p1.getNombre().compareTo( p2.getNombre());
                                }   
                            });
                          break;
                          case 4://Nombre Proveedor (Solo Servicio)
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object o1, Object o2) {
                                    DataServicio s1 = (DataServicio) o1;
                                    DataServicio s2 = (DataServicio) o2;
                                    return (s1.getProveedor()).compareTo(s2.getProveedor());
                                }   
                            });
                             
                          break;  
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
