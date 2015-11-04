/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;


import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import logica.DataInfoPromocion;
import logica.DataInfoProveedor;
import logica.DataInfoServicio;
import logica.DataPromocion;
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
       endpoint = Endpoint.publish("http://localhost:3001/publicadorProveedor",this);
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
       
   }
   @WebMethod
   public List<DataCategoria> listarCategorias();
   */@WebMethod
   public void altaServicio(String nombre, String descripcion, int precio, String origen, String proveedor, String pais)throws Exception{
       ICP.altaServicio(nombre, descripcion, precio, origen, proveedor, pais);
   }/*
   @WebMethod
   public List<DataProveedor> listarProveedores();
   @WebMethod
   public List<DataServicio> listarServiciosXCategoria(String nomCategoria);
   */@WebMethod
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
   /*@WebMethod
   public List<DataServicio> listarServiciosXProveedor(String nomProveedor);
   @WebMethod
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
   }
   @WebMethod
   public List<DataPromocion> listarPromocionesXProveedor(String nomProveedor);
   */@WebMethod
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
   /*@WebMethod
   public List<DataServicio> buscarServicios(String aBuscar); 
   @WebMethod
   public List<DataPromocion> buscarPromociones(String aBuscar);
   */@WebMethod
   public DataPromocion informacionPromocion(String pvr, String nom)throws Exception{
       return ICP.informacionPromocion(pvr, nom);
   }
   
   
}
