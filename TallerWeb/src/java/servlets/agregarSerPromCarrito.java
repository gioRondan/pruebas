/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import servidor.DataFecha;
import servidor.DataItemReserva;
import servidor.DataServicio;
import servidor.Exception_Exception;


/**
 *
 * @author giovani
 */
@WebServlet(name = "agregarSerPromCarrito", urlPatterns = {"/agregarSerPromCarrito"})
public class agregarSerPromCarrito extends HttpServlet {

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
             servidor.PublicadorProveedorService service = new servidor.PublicadorProveedorService();
        servidor.PublicadorProveedor port = service.getPublicadorProveedorPort();
            if (request.getParameter("borrar")!=null){
                List<DataItemReserva> itemsreservascarro = new ArrayList<DataItemReserva>();
                List<DataItemReserva> ir2 = (List<DataItemReserva>)request.getSession().getAttribute("ItemsReservaActual");
                for(DataItemReserva item : ir2 ){
                    String nom;
                    String pvr;
                    if (item.isEsServico()){
                        nom = request.getParameter("nomServicio");
                        pvr = request.getParameter("nomProveedorServicio");
                        if (item.getServicio().getNombre().equals(nom) && item.getServicio().getProveedor().equals(pvr) ){
                           // ir2.remove(item);
                        }else{
                            itemsreservascarro.add(item);
                        }
                    }else{
                        nom = request.getParameter("nomPromocion");
                        pvr = request.getParameter("nomProveedorPromocion");
                         if (item.getPromocion().getNombre().equals(nom) && item.getPromocion().getNickProveedor().equals(pvr) ){
                            //ir2.remove(item);
                        }else{
                          itemsreservascarro.add(item);
                        }
                    }
                }
                
                request.getSession().setAttribute("ItemsReservaActual", itemsreservascarro);
            }else{
                int cant;
                String nom;
                String pvr;
                boolean esser = Boolean.parseBoolean(request.getParameter("esservicio"));
                List<DataItemReserva> ir2 = (List<DataItemReserva>)request.getSession().getAttribute("ItemsReservaActual");
                if (esser){
                    nom = request.getParameter("nomServicio");
                    pvr = request.getParameter("nomProveedorServicio");
                    cant = Integer.parseInt(request.getParameter("cantItemReserva"));
                   

                
                String fecha = request.getParameter("fechainiItemReserva");
                String[] partes = fecha.split("-");
                int dia = Integer.parseInt(partes[2]); //dd
                int mes = Integer.parseInt(partes[1]); // mm
                int anio = Integer.parseInt(partes[0]); // aaaa
                                  
                 GregorianCalendar fechainicio = new GregorianCalendar(anio,mes,dia);
                
                 
                String fecha2 = request.getParameter("fechafinItemReserva");
                String[] partes2 = fecha2.split("-");
                int dia2 = Integer.parseInt(partes2[2]); //dd
                int mes2 = Integer.parseInt(partes2[1]); // mm
                int anio2 = Integer.parseInt(partes2[0]); // aaaa
                GregorianCalendar fechafin = new GregorianCalendar(anio2,mes2,dia2);  
        
                try{
                        XMLGregorianCalendar fini = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechainicio);
                        XMLGregorianCalendar  ffin = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechafin);
                        DataItemReserva dtr = new DataItemReserva();
                        dtr.setCantidad(cant);
                        dtr.setFechaInicio(fini);
                        dtr.setFechaFin(ffin);
                        dtr.setServicio(port.informacionServicio(pvr,nom));
                        dtr.setEsServico(esser);
                        ir2.add(dtr);
                    }catch(Exception e ){
                        
                    }
                    
                    
                }else{
                    nom = request.getParameter("nomPromocion");
                    pvr = request.getParameter("nomProveedorPromocion");
                    cant = Integer.parseInt(request.getParameter("cantItemReservaPromo"));
                    
                    String fecha = request.getParameter("fechainiItemReserva");
                    String[] partes = fecha.split("-");
                    int dia = Integer.parseInt(partes[2]); //dd
                    int mes = Integer.parseInt(partes[1]); // mm
                    int anio = Integer.parseInt(partes[0]); // aaaa

                     GregorianCalendar fechainicio = new GregorianCalendar(anio,mes,dia);


                    String fecha2 = request.getParameter("fechainiItemReserva");
                    String[] partes2 = fecha2.split("-");
                    int dia2 = Integer.parseInt(partes2[2]); //dd
                    int mes2 = Integer.parseInt(partes2[1]); // mm
                    int anio2 = Integer.parseInt(partes2[0]); // aaaa
                    GregorianCalendar fechafin = new GregorianCalendar(anio2,mes2,dia2);   
                   
                    try{
                        XMLGregorianCalendar fini = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechainicio);
                        XMLGregorianCalendar  ffin = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechafin);
                        DataItemReserva dtr = new DataItemReserva();
                        dtr.setCantidad(cant);
                        dtr.setFechaInicio(fini);
                        dtr.setFechaFin(ffin);
                        dtr.setPromocion(port.informacionPromocion(pvr,nom));
                        dtr.setEsServico(esser);
                        ir2.add(dtr);
                    }catch(Exception e ){
                        
                    }
                }
                request.getSession().setAttribute("ItemsReservaActual",ir2);
            }
            request.getRequestDispatcher("/WEB-INF/Usuarios/carro.jsp").forward(request, response);
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
