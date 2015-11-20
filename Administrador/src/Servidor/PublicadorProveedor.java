/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import logica.DataCategoria;
import logica.DataInfoPromocion;
import logica.DataInfoProveedor;
import logica.DataInfoReserva;
import logica.DataInfoServicio;
import logica.DataItemReserva;
import logica.DataPromocion;
import logica.DataProveedor;
import logica.DataReserva;
import logica.DataServicio;
import logica.Fabrica;
import logica.IControladorProveedor;
/**
 *
 * @author giovani.rondan
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorProveedor {
   private Endpoint endpoint = null;
   public Fabrica fabrica = Fabrica.getInstance();
   public IControladorProveedor ICP = fabrica.getIControladorProveedor();
   @WebMethod(exclude = true)
   public void publicar(){
       
       try {
           Properties propiedades = new Properties();
           propiedades.load(new FileInputStream("src/Propiedades/Propiedades.properties"));
           //properties.load(new FileInputStream("src/properties/publish.properties"));
           String url = propiedades.getProperty("publicadorproveedor");
           endpoint = Endpoint.publish(url, this);
       } catch (IOException ex) {
           Logger.getLogger(PublicadorCliente.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   @WebMethod(exclude = true)
   public Endpoint getEndpoint(){
       return endpoint;
   }
   @WebMethod
   public void seleccionarProveedor(String proveedor){
       ICP.seleccionarProveedor(proveedor);
   }
   @WebMethod 
   public void seleccionarServicio(String nomServicio){
       ICP.seleccionarServicio(nomServicio);
   }
   @WebMethod
   public void ingresarImagenBorrarServicio(String imagen){
       ICP.ingresarImagenBorrarServicio(imagen);
   }
   @WebMethod
   public void ingresarModificarImagenServicio(String imagen){
       ICP.ingresarModificarImagenServicio(imagen);
   }
   @WebMethod
   public void ingresarCategoriaBorrarServicio(String categoria){
       ICP.ingresarCategoriaBorrarServicio(categoria);
   }
   /*@WebMethod
   public List<DataCiudad> listarCiudades(){
       
   }*/
   @WebMethod
   public DataCategoria[] listarCategorias(){
       List<DataCategoria> aux4 = ICP.listarCategorias();
        DataCategoria[] aux5 = new DataCategoria[aux4.size()];
       int i = 0;
       for( DataCategoria it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       return aux5;
   }
   @WebMethod
   public void altaServicio(String nombre, String descripcion, int precio, String origen, String proveedor, String pais)throws Exception{
       ICP.altaServicio(nombre, descripcion, precio, origen, proveedor, pais);
   }
   @WebMethod
   public DataProveedor[] listarProveedores()
   {
       List<DataProveedor> aux4 = ICP.listarProveedores();
        DataProveedor[] aux5 = new DataProveedor[aux4.size()];
       int i = 0;
       for( DataProveedor it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       return aux5;
   }
   @WebMethod
   public DataServicio[] listarServiciosXCategoria(String nomCategoria){
      List<DataServicio> aux4 = ICP.listarServiciosXCategoria(nomCategoria);
        DataServicio[] aux5 = new DataServicio[aux4.size()];
       int i = 0;
       for( DataServicio it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       return aux5;
   };
  
   @WebMethod
   public void ingresarNombreCategoria(String nombre){
       ICP.ingresarNombreCategoria(nombre);
   }
   @WebMethod
   public void seleccionarPadre(String nombre){
       ICP.seleccionarPadre(nombre);
   }
   @WebMethod
   public void altaCategoria(/*sin parametros?*/) throws Exception{
       ICP.altaCategoria();
   }
   @WebMethod
   public DataServicio[] listarServiciosXProveedor(String nomProveedor){
       List<DataServicio> aux4 = ICP.listarServiciosXProveedor(nomProveedor);
        DataServicio[] aux5 = new DataServicio[aux4.size()];
       int i = 0;
       for( DataServicio it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       return aux5;
   };
   /*@WebMethod
   public void altaPromocion( String nomProveedor,List<String> ser, String nombre, int descuento) throws Exception{
       ICP.altaPromocion(nomProveedor, ser, nombre, descuento);
   }*/
   @WebMethod
   public void ingresarDescripcionServicio(String desc){
       ICP.ingresarDescripcionServicio(desc);
   }
   @WebMethod
   public void ingresarImagenServicio(String imagen){
       ICP.ingresarImagenServicio(imagen);
   }
   @WebMethod
   public void ingresarPrecioServicio(float precio){
       ICP.ingresarPrecioServicio(precio);
   }
   @WebMethod
   public void ingresarOrigenServicio(String origen){
       ICP.ingresarOrigenServicio(origen);
   }
   @WebMethod
   public void ingresarDestinoServicio(String destino){
       ICP.ingresarDestinoServicio(destino);
   }
   @WebMethod
   public void vaciarCategoriasServicio(){
       ICP.vaciarCategoriasServicio();
   }
   @WebMethod
   public void ingresarCategoriaServicio(String categoria)throws Exception{
       ICP.ingresarCategoriaServicio(categoria);
   }
   @WebMethod
   public void modificarServicio()throws Exception{
       ICP.modificarServicio();
   }
   /*@WebMethod
   public List<DataEmpresa> listarEmpresas();
   @WebMethod
   public void altaProveedor(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmp, String LinkEmpres, String password) throws Exception{
       ICP.altaProveedor(nick, nombre, apellido, email, fechaNac, imagen, nombreEmp, LinkEmpres, password);
   }*/
   @WebMethod
   public DataPromocion[] listarPromocionesXProveedor(String nomProveedor){
    List<DataPromocion> aux4 = ICP.listarPromocionesXProveedor(nomProveedor);
        DataPromocion[] aux5 = new DataPromocion[aux4.size()];
       int i = 0;
       for( DataPromocion it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       return aux5;
   };
   @WebMethod
   public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion){
       return ICP.verInfoPromocion(nickproveedor, nomPromocion);
   }
   @WebMethod
   public DataInfoServicio verInfoServicio(String nomServicio, String nomProveedor)throws Exception{
       return ICP.verInfoServicio(nomServicio, nomProveedor);
   }
   @WebMethod
   public DataInfoProveedor verInfoProveedor(String nomProveedor){
       return ICP.verInfoProveedor(nomProveedor);
   }
   @WebMethod
   public DataServicio informacionServicio(String prv,String ser) throws Exception{
       return ICP.informacionServicio(prv, ser);
   }/*
   @WebMethod
   public Set<String> infoPaises();
   @WebMethod
   public List<DataCiudad> ciudadesXpais( String pais);
   */@WebMethod
   public void altaPais(String pais)throws Exception{
       ICP.altaPais(pais);
   }
   @WebMethod
   public void altaCiudad(String nomCiudad, String nomPais){
       ICP.altaCiudad(nomCiudad, nomPais);
   }
//################################      operaciones tarea 2 ####################################################################################
   @WebMethod
   public DataServicio[] buscarServicios(String aBuscar){
       List<DataServicio> aux = ICP.buscarServicios(aBuscar);
       DataServicio[] ret = new DataServicio[aux.size()];
       int i = 0;
       for(DataServicio it : aux){
           ret[i] = it;
           i++;
       }
       return ret;
   } 
   @WebMethod
   public DataPromocion[] buscarPromociones(String aBuscar){
       List<DataPromocion> aux = ICP.buscarPromociones(aBuscar);
       DataPromocion[] ret = new DataPromocion[aux.size()];
       int i = 0;
       for(DataPromocion it : aux){
           ret[i] = it;
           i++;
       }
       return ret;
   }
   @WebMethod
   public DataPromocion informacionPromocion(String pvr, String nom)throws Exception{
       return ICP.informacionPromocion(pvr, nom);
   }
   @WebMethod
   public boolean iniciarSesion(String nick, String pass){
       return (ICP.iniciarSesion(nick, pass) != null);
   }
   @WebMethod
   public void facturarReserva(String nick, Integer id){
       ICP.facturarReserva(nick, id);
   }
   @WebMethod
   public DataInfoReserva[] listarReservasXProveedor(String nick){
       List<DataInfoReserva> items = ICP.listarReservasXProveedor(nick);
       DataInfoReserva[] ret = new DataInfoReserva[items.size()];
       int i = 0;
       for (DataInfoReserva it : items){
           ret[i] = it;
           i++;
       }
       return ret;
   }
   
}
