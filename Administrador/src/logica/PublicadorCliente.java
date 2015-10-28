/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author rodrigo.linares
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorCliente {
   private Endpoint endpoint = null;
   
   @WebMethod(exclude = true)
   public void publicar(){
       endpoint = Endpoint.publish("http://localhost:3000/publicador",this);
   }
   @WebMethod(exclude = true)
   public Endpoint getEndpoint(){
       return endpoint;
   }
   
   @WebMethod
   public int prueba(){
       return 5;
   }
   
}
