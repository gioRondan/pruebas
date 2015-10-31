
package wsc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PublicadorCliente", targetNamespace = "http://Servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PublicadorCliente {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     * @throws Exception_Exception
     */
    @WebMethod
    @Action(input = "http://Servidor/PublicadorCliente/altaClienteRequest", output = "http://Servidor/PublicadorCliente/altaClienteResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://Servidor/PublicadorCliente/altaCliente/Fault/Exception")
    })
    public void altaCliente(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://Servidor/PublicadorCliente/actualizarEstadoReservaRequest", output = "http://Servidor/PublicadorCliente/actualizarEstadoReservaResponse")
    public void actualizarEstadoReserva(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        Estado arg2);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://Servidor/PublicadorCliente/pruebaRequest", output = "http://Servidor/PublicadorCliente/pruebaResponse")
    public int prueba();

}