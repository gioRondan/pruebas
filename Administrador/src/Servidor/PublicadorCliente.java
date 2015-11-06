/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import logica.DataCiudad;
import logica.DataCliente;
import logica.DataInfoCliente;
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
   public IControladorCliente ICC = fabrica.getIControladorCliente();
   
   
   @WebMethod(exclude = true)
   public void publicar(){
       endpoint = Endpoint.publish("http://localhost:3000/publicadorCliente",this);
   }
   @WebMethod(exclude = true)
   public Endpoint getEndpoint(){
       return endpoint;
   }
   
   @WebMethod
   public int prueba(){
       return 5;
   }
   
   @WebMethod
   public void actualizarEstadoReserva(int identificador, String nomCliente, Estado estado){
       ICC.actualizarEstadoReserva(identificador, nomCliente, estado);
   }
   
   @WebMethod
   public void altaCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String password)throws Exception{
       ICC.altaCliente(nickname, nombre, apellido, email, fechaNac, imagen, password);
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
   public DataCiudad pruebaData(){
       DataCiudad aux = new DataCiudad();
       aux.setNombre("cardona");
       aux.setPais("hola2");
       return aux;
   }
   
   @WebMethod
   public DataCiudad[] pruebaDatas(){
       DataCiudad aux = new DataCiudad();
       aux.setNombre("cardona");
       aux.setPais("hola2");
       DataCiudad aux2 = new DataCiudad();
       aux2.setNombre("cardona2");
       aux2.setPais("hola22");
       DataCiudad aux3 = new DataCiudad();
       aux3.setNombre("cardona3");
       aux3.setPais("hola23");
       List<DataCiudad> aux4 = new ArrayList<>();
       aux4.add(aux);
       aux4.add(aux2);
       aux4.add(aux3);
       DataCiudad[] aux5 = new DataCiudad[aux4.size()];
       int i = 0;
       for( DataCiudad it : aux4){
           aux5[i] = it;
           i = i+1;
       }
       /*Iterator it = aux4.iterator();
        while(it.hasNext()) {
            aux5[i] = (DataCiudad) it.next();
            i++;
        }*/
       return aux5;
   }
   /*
   @WebMethod
   public void cancelarReserva(String nomCliente, int identificador){
       ICC.cancelarReserva(nomCliente, identificador);
   }
   
   @WebMethod
   public List<DataReserva> listarReservasXCliente(String nomCliente){
       return ICC.listarReservasXCliente(nomCliente);
   }
   
   
   @WebMethod
   public List<DataReserva> listarReservasSistema(){
       return new ArrayList<>();
   }
   
   
   @WebMethod
   public DataInfoReserva verInfoReserva(String nomCliente, int identificador){
       return null;
   }
   
   @WebMethod
   public DataInfoCliente verInfoCliente(String nomCliente){
       return null;
   }
   
   @WebMethod
   public void realizarReserva(String proveedor,String cliente,Map<String,Integer> servicio, Map<String,Integer> promocion,Map<String,DataExpira> fechas,Map<String,DataExpira> fechaspromos,Date fecha_creacion )throws Exception{
       
   }
   //###################################   Operaciones Tarea2      #########################################################################
   */
   @WebMethod
   public DataInfoCliente iniciarSesion(String nickCliente, String password){
       return ICC.iniciarSesion(nickCliente, password);
   }
   /*
   
   @WebMethod
   public Date toDate(String fecha){
       return null;
   }
   
   @WebMethod
   public void confirmarReserva(List<DataItemReserva> itemsr,DataInfoCliente cli)throws Exception{
       
   }
   */
   @WebMethod
   public boolean existeEmail(String email){
       return ICC.existeEmail(email);
   }
   
   @WebMethod
   public boolean existeNickName(String nickName){
       return ICC.existeNickName(nickName);
   }
   /*
   @WebMethod
   public BufferedImage leerImgURL(String imgURL)throws Exception{
       return null;
   }
   */
   
   
}
