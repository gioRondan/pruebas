/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
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
       endpoint = Endpoint.publish("http://localhost:3000/publicadorCliente",this);
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
   public void seleccionarServicio(String nomServicio);
   @WebMethod
   public void ingresarImagenBorrarServicio(String imagen);
   @WebMethod
   public void ingresarModificarImagenServicio(String imagen);
   @WebMethod
   public void ingresarCategoriaBorrarServicio(String categoria);
   @WebMethod
   public List<DataCiudad> listarCiudades();
   @WebMethod
   public List<DataCategoria> listarCategorias();
   @WebMethod
   public void altaServicio(String nombre, String descripcion, int precio, String origen, String proveedor, String pais)throws Exception;
   @WebMethod
   public List<DataProveedor> listarProveedores();
   @WebMethod
   public List<DataServicio> listarServiciosXCategoria(String nomCategoria);
   @WebMethod
   public void ingresarNombreCategoria(String nombre);
   @WebMethod
   public void seleccionarPadre(String nombre);
   @WebMethod
   public void altaCategoria(/*sin parametros?*/) throws Exception;
   @WebMethod
   public List<DataServicio> listarServiciosXProveedor(String nomProveedor);
   @WebMethod
   public void altaPromocion( String nomProveedor,List<String> ser, String nombre, int descuento) throws Exception;
   @WebMethod
   public void ingresarDescripcionServicio(String desc);
   @WebMethod
   public void ingresarImagenServicio(String imagen);
   @WebMethod
   public void ingresarPrecioServicio(float precio);
   @WebMethod
   public void ingresarOrigenServicio(String origen);
   @WebMethod
   public void ingresarDestinoServicio(String destino);
   @WebMethod
   public void vaciarCategoriasServicio();
   @WebMethod
   public void ingresarCategoriaServicio(String categoria)throws Exception;
   @WebMethod
   public void modificarServicio()throws Exception;
   @WebMethod
   public List<DataEmpresa> listarEmpresas();
   @WebMethod
   public void altaProveedor(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmp, String LinkEmpres, String password) throws Exception;
   @WebMethod
   public List<DataPromocion> listarPromocionesXProveedor(String nomProveedor);
   @WebMethod
   public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion);
   @WebMethod
   public DataInfoServicio verInfoServicio(String nomServicio, String nomProveedor)throws Exception;
   @WebMethod
   public DataInfoProveedor verInfoProveedor(String nomProveedor);
   @WebMethod
   public DataServicio informacionServicio(String prv,String ser) throws Exception;
   @WebMethod
   public Set<String> infoPaises();
   @WebMethod
   public List<DataCiudad> ciudadesXpais( String pais);
   @WebMethod
   public void altaPais(String pais)throws Exception;
   @WebMethod
   public void altaCiudad(String nomCiudad, String nomPais);
//################################      operaciones tarea 2 ####################################################################################
   @WebMethod
   public List<DataServicio> buscarServicios(String aBuscar); 
   @WebMethod
   public List<DataPromocion> buscarPromociones(String aBuscar);
   @WebMethod
   public DataPromocion informacionPromocion(String pvr, String nom)throws Exception;
   
   
}
