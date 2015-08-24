/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.Set;
/**
 *
 * @author Juan
 */
public interface IControladorCliente {
    public void actualizarEstadoReserva(int id, String nomCliente, Estado estado);
    public void altaCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen)throws Exception;
    public Set<DataCliente> listarClientes();
    public void cancelarReserva(String nomCliente, int id);
    public Set<DataReserva> listarReservasXCliente(String nomCliente);
    public Set<DataReserva> listarReservasSistema();
    public DataInfoReserva verInfoReserva(String nomCliente, int id);
    public DataInfoCliente verInfoCliente(String nomCliente);
    public void realizarReserva(String proveedor,String cliente,String servicio,int cantidad,Date fechaInicio,Date fechaFin,boolean esServicio );
}
