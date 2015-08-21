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
public class ControladorCliente {
    public void actualizarEstadoReserva(String nomReserva, String nomCliente){}
    
    public void realizarReserva(String proveedor,String cliente,String servicio,int cantidad,Date fechaInicio,Date fechaFin){
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        Cliente aux_cliente = mcli.getCliente(cliente);
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor prov = mpr.getProveedor(proveedor);
        Servicio serv = prov.getServicio(servicio);
        aux_cliente.reservarServicio(serv,cantidad,fechaInicio,fechaFin);
    }
    public void reservarPromocion(String proveedor, String promo, int cantidad, Date fechaIni, Date fechaFin){}
    
    public void altaCliente(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen){}
    
    public Set<DataCliente> listarClientes(){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getDataClientes();
    }
    public void reservarServicio(String proveedor, String promo, int cantidad, Date fechaIni, Date fechaFin){}
    
    public void cancelarReserva(String nomCliente, int id){}
    
    public Set<DataReserva> listarReservasXCliente(String nomCliente){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataReservas();
    }
    public DataInfoReserva verInfoReserva(int id){
        return null;
    }
    public DataInfoCliente verInfoCliente(String nomCliente){
        return null;
    }
}
