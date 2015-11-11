/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataCategoria;
import servidor.DataItemReserva;
import servidor.DataPromocion;
import servidor.DataProveedor;
import servidor.DataServicio;
import servidor.Exception_Exception;


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
    private static String prueba = " { 'core' : {'data' : [";
    int indice =0;
    public void armarArbol(String padre, List<DataCategoria> dtps) {
        
        for (DataCategoria dtcategoria : dtps) {
           indice++;
           prueba = prueba+"{"+"'id'"+" : "+ "'ajson"+indice+"', "+ "'parent' : "+padre+", 'text' : '"+dtcategoria.getNombre()+"'},";
           armarArbol("'ajson"+indice+"'", dtcategoria.getHijos() );
       }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
                    servidor.PublicadorProveedorService service = new servidor.PublicadorProveedorService();
        servidor.PublicadorProveedor portP = service.getPublicadorProveedorPort();
                if  (request.getSession().getAttribute("Login") == null){
                    request.getSession().setAttribute("Login", "NoLogeado");
                    List<DataItemReserva> itemsreservascarro = new ArrayList<DataItemReserva>();
                    request.getSession().setAttribute("textodebusqueda"," ");
                    request.getSession().setAttribute("ItemsReservaActual",itemsreservascarro );
//                        try {
//                           new CargaInicial().cargar();
//                        } catch (Exception ex) {
//                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                }
                   
                    
                    List<DataCategoria> dtps = portP.listarCategorias().getItem();
                    prueba = " { 'core' : {'data' : [";
                    indice =0;
                    armarArbol("'#'", dtps);
                    prueba=prueba+"] } }";
                    
                  
                    request.setAttribute("dataCategorias", prueba);
                    
                    List<DataServicio> servicos = new ArrayList<DataServicio>();
                    List<DataProveedor> prove = portP.listarProveedores().getItem();
                    List<DataPromocion> promos = new ArrayList<DataPromocion>();
                    if ( (request.getParameter("textodebusqueda")!=null) && (!(request.getParameter("textodebusqueda")).equals(" ") ) ){
                        request.getSession().setAttribute("textodebusqueda", request.getParameter("textodebusqueda"));//seteo para mantener el filtro en el jsp
                        servicos.addAll(portP.buscarServicios(request.getParameter("textodebusqueda")).getItem());
                        promos.addAll(portP.buscarPromociones(request.getParameter("textodebusqueda")).getItem());
//                         if ( (request.getParameter("categoria") != null) && (!(request.getParameter("categoria").equals(" "))) ){
//                            String categoria = (String) request.getParameter("categoria");
//                            request.getSession().setAttribute("categoria", categoria);//seteo para mantener el filtro en el jsp
//                            //categoria = categoria.substring( categoria.indexOf(":")+2 , categoria.length() );
//                            String comas ="";
//                            while (  categoria.indexOf(",")!=-1 ){
//                                comas = categoria.substring(0, categoria.indexOf(","));
//                                categoria = categoria.substring( categoria.indexOf(",")+2 , categoria.length() );
//                                for (DataServicio servicio : servicos){
//                                    List<String> nombrescategorias = new ArrayList<String>();
//                                    try {
//                                        for ( DataCategoria catego : ICP.verInfoServicio(servicio.getNombre(),servicio.getProveedor()).getCategorias() ){
//                                            nombrescategorias.add(catego.getNombre());
//                                        }
//                                        if ( !nombrescategorias.contains(categoria) ){
//                                            servicos.remove(servicio);
//                                        }
//                                    } catch (Exception ex) {
//                                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                }  
//                            }
//                        }
                    }else{
                        if ( (request.getParameter("categoria") != null) && (!(request.getParameter("categoria").equals(" "))) ){
                            String categoria = (String) request.getParameter("categoria");
                            request.getSession().setAttribute("categoria", categoria);//seteo para mantener el filtro en el jsp
                            
                            String comas ="";
                            while (  categoria.indexOf(",")!=-1 ){
                                comas = categoria.substring(0, categoria.indexOf(","));
                                categoria = categoria.substring( categoria.indexOf(",")+2 , categoria.length() );
                                servicos.addAll(portP.listarServiciosXCategoria(comas).getItem());   
                            }

                            for (DataProveedor una : prove){ 
                               promos.addAll(portP.listarPromocionesXProveedor(una.getNickname()).getItem());
                            }
                        }else{
                           request.getSession().setAttribute("categoria", " ");//seteo para mantener el filtro en el jsp
                           List<DataProveedor> cate = portP.listarProveedores().getItem();
                           for (DataProveedor una : cate){
                              servicos.addAll(portP.listarServiciosXProveedor(una.getNickname()).getItem());
                              promos.addAll(portP.listarPromocionesXProveedor(una.getNickname()).getItem());
                           }
                        }
                    }
                    
                    if  ( request.getParameter("orden") != null ){
                        int ord = Integer.parseInt(request.getParameter("orden"));
                      switch   ( ord ){
                          case 1://Precio Acendentes
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataServicio sercivio1 = (DataServicio) objeto1;
                                    DataServicio sercivio2 = (DataServicio) objeto2;
                                    return new Integer( (int)sercivio1.getPrecio() ).compareTo( (int) sercivio2.getPrecio() );
                                }   
                            });
                            Collections.sort(promos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataPromocion promo1 = (DataPromocion) objeto1;
                                    DataPromocion promo2 = (DataPromocion) objeto2;
                                    return new Integer( (int)promo1.getPrecioTotal()).compareTo( (int) promo2.getPrecioTotal());
                                }   
                            });
                          break;
                          case 2://Precio Decendente
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataServicio sercivio1 = (DataServicio) objeto1;
                                    DataServicio sercivio2 = (DataServicio) objeto2;
                                    return new Integer( (int)sercivio2.getPrecio() ).compareTo( (int) sercivio1.getPrecio() );
                                }   
                            });
                             Collections.sort(promos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataPromocion promo1 = (DataPromocion) objeto1;
                                    DataPromocion promo2 = (DataPromocion) objeto2;
                                    return new Integer( (int)promo2.getPrecioTotal()).compareTo( (int) promo1.getPrecioTotal());
                                }   
                            });
                          break;
                          case 3://Precio Nombre
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataServicio sercivio1 = (DataServicio) objeto1;
                                    DataServicio sercivio2 = (DataServicio) objeto2;
                                    return (sercivio1.getNombre() ).compareTo(sercivio2.getNombre());
                                }   
                            });
                             Collections.sort(promos, new Comparator() {
                                @Override
                                 public int compare(Object objeto1, Object objeto2) {
                                    DataPromocion promo1 = (DataPromocion) objeto1;
                                    DataPromocion promo2 = (DataPromocion) objeto2;
                                    return promo1.getNombre().compareTo( promo2.getNombre());
                                }   
                            });
                          break;
                          case 4://Nombre Proveedor (Solo Servicio)
                            Collections.sort(servicos, new Comparator() {
                                @Override
                                public int compare(Object objeto1, Object objeto2) {
                                    DataServicio sercivio1 = (DataServicio) objeto1;
                                    DataServicio sercivio2 = (DataServicio) objeto2;
                                    return (sercivio1.getProveedor()).compareTo(sercivio2.getProveedor());
                                }   
                            });
                             
                          break;  
                      }
                      
                    }
                request.setAttribute("dataProveedor", prove);
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
