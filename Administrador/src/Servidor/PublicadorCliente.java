/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import logica.DataCiudad;
import logica.DataCliente;
import logica.DataFecha;
import logica.DataInfoCliente;
import logica.DataInfoReserva;
import logica.DataItemReserva;
import logica.DataReserva;
import logica.Estado;
import logica.Fabrica;
import logica.IControladorCliente;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author rodrigo.linares
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorCliente {
   private Endpoint endpoint = null;
   public Fabrica fabrica = Fabrica.getInstance();
   private List<DataItemReserva> items = new ArrayList<>();
   public IControladorCliente ICC = fabrica.getIControladorCliente();
   
   
   @WebMethod(exclude = true)
   public void publicar(){
       try {
           Properties propiedades = new Properties();
           propiedades.load(new FileInputStream("src/Propiedades/Propiedades.properties"));
           //properties.load(new FileInputStream("src/properties/publish.properties"));
           String url = propiedades.getProperty("publicadorcliente");
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
   public void actualizarEstadoReserva(int identificador, String nomCliente, Estado estado){
       ICC.actualizarEstadoReserva(identificador, nomCliente, estado);
   }
   
   @WebMethod
   public void altaCliente(String nickname, String nombre, String apellido, String email, DataFecha fechaNac, String imagen, String password)throws Exception{
       Date dateNac = null;
       String fechas =  fechaNac.getDia()+"/"+fechaNac.getMes()+"/"+fechaNac.getAnio();
       SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
       dateNac = formatoFecha.parse(fechas);
       ICC.altaCliente(nickname, nombre, apellido, email, dateNac, imagen, password);
   }
   
   
   @WebMethod
   public DataCliente[] listarClientes(){
    List<DataCliente> clientes = ICC.listarClientes();
    DataCliente[] aux5 = new DataCliente[clientes.size()];
       int i = 0;
       for( DataCliente it : clientes){
           aux5[i] = it;
           i = i+1;
       }
         return aux5;

   }
  
   
   @WebMethod
   public void cancelarReserva(String nomCliente, int identificador){
       ICC.cancelarReserva(nomCliente, identificador);
   }
   
   @WebMethod
   public DataReserva[] listarReservasXCliente(String nomCliente){
        List<DataReserva> aux = ICC.listarReservasXCliente(nomCliente);
       DataReserva[] ret = new DataReserva[aux.size()];
       int i = 0;
       for(DataReserva it : aux){
           ret[i] = it;
           i++;
       }
       return ret;
   }
 
   
   @WebMethod
   public DataReserva[] listarReservasSistema(){
       List<DataReserva> aux = ICC.listarReservasSistema();
       DataReserva[] ret = new DataReserva[aux.size()];
       int i = 0;
       for(DataReserva it : aux){
           ret[i] = it;
           i++;
       }
       return ret;
   }
   
   
   @WebMethod
   public DataInfoReserva verInfoReserva(String nomCliente, int identificador){
       return ICC.verInfoReserva(nomCliente, identificador);
   }
   
   @WebMethod
   public DataInfoCliente verInfoCliente(String nomCliente){
       return ICC.verInfoCliente(nomCliente);
   }
  
   
   @WebMethod
   public DataInfoCliente iniciarSesion(String nickCliente, String password){
       return ICC.iniciarSesion(nickCliente, password);
   }
   
   @WebMethod
   public void confirmarReserva(DataItemReserva[] itemsr,DataInfoCliente cli)throws Exception{
       List<DataItemReserva> aux = new ArrayList<>();
       for(int i = 0; i < itemsr.length; ++i){
           aux.add(itemsr[i]);
       }
       ICC.confirmarReserva(aux, cli);
   }
   
   @WebMethod
   public void agregarItemReserva(DataItemReserva item){
       
       this.items.add(item);
   }
   
   @WebMethod
   public void confirmarReserva2( DataInfoCliente cli)throws Exception{
       
       ICC.confirmarReserva(this.items, cli);
       this.items = new ArrayList<>();
   }
   
   @WebMethod
   public boolean existeEmail(String email){
       return ICC.existeEmail(email);
   }
   
   @WebMethod
   public boolean existeNickName(String nickName){
       return ICC.existeNickName(nickName);
   }
   @WebMethod
   public void vaciarCarrito(){
       this.items = new ArrayList<>();
   }
   @WebMethod
   public DataReserva[] listarReservasXClienteRegistradas(String nomCliente){
       List<DataReserva> aux = ICC.listarReservasXClienteRegistradas(nomCliente);
       DataReserva[] ret = new DataReserva[aux.size()];
       int i = 0;
       for(DataReserva it : aux){
           ret[i] = it;
           i++;
       }
       return ret;
   }
   @WebMethod
   public void actualizarRegistro(String ip, String url, String browser, String so){
       ICC.actualizarRegistro(ip, url, browser, so);
   }
}
