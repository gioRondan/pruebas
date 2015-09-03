/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Juan
 */
public interface IControladorCliente {
    public void actualizarEstadoReserva(int id, String nomCliente, Estado estado);
    public void altaCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen)throws Exception;
    public List<DataCliente> listarClientes();
    public void cancelarReserva(String nomCliente, int id);
    public List<DataReserva> listarReservasXCliente(String nomCliente);
    public List<DataReserva> listarReservasSistema();
    public DataInfoReserva verInfoReserva(String nomCliente, int id);
    public DataInfoCliente verInfoCliente(String nomCliente);
    public void realizarReserva(String proveedor,String cliente,Map<Integer, String> servicio, Map<Integer, String> promocion, int cantidad,Date fechaInicio,Date fechaFin );
}
