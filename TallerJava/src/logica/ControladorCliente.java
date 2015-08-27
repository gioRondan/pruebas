/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 *
 * @author Juan
 */
public class ControladorCliente implements IControladorCliente{
    
    @Override
    public void actualizarEstadoReserva(int id, String nomCliente, Estado estado){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        Cliente cli = mCl.getCliente(nomCliente);
        cli.modificarEstadoReserva(id, estado);
    }
    
    @Override
    public void realizarReserva(String proveedor,String cliente,String servicio,int cantidad,Date fechaInicio,Date fechaFin,boolean esServicio ){ //el bool servicio indica si voy a reservar un servicio, si es false es para reservar una promocion
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        Cliente aux_cliente = mcli.getCliente(cliente);
        int clave1 = mcli.getUltimoid();
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor prov = mpr.getProveedor(proveedor);
        
        if (esServicio){
            Servicio serv = prov.getServicio(servicio);
            aux_cliente.reservarServicio(clave1,serv,cantidad,fechaInicio,fechaFin);
        }
        else
        {
            Promocion pr = prov.getPromocion(servicio);
            aux_cliente.reservarPromocion(clave1,pr, cantidad, fechaInicio, fechaFin);
        }
    }
    
    @Override
    public void altaCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) throws Exception{
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        boolean existeNickname = mCl.existeCliente(nickname);
        boolean existeMail     = mCl.existeCliente(email);      
        if(existeNickname){
            throw new Exception("Ya existe un usuario con el nickname: " + nickname);
        }
        else if(existeMail){
            throw new Exception("Ya existe un usuario con el email: " + email);
        }
        else{
            Cliente cliente;
            cliente = new Cliente(nickname, nombre, apellido, email, fechaNac, imagen);
            mCl.addCliente(cliente);
        }        
    }
    
    @Override
    public List<DataCliente> listarClientes(){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getDataClientes();
    }
    
    @Override
    public void cancelarReserva(String nomCliente, int id){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        Cliente cli = mCl.getCliente(nomCliente);
        cli.cancelarReserva(id);
    }
    
    @Override
    public List<DataReserva> listarReservasSistema(){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.listarReservas();
        
    }
    
    @Override
    public List<DataReserva> listarReservasXCliente(String nomCliente){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataReservas();
    }
    
    @Override
    public DataInfoReserva verInfoReserva(String nomCliente, int id){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        Cliente cliente = mCl.getCliente(nomCliente);
        Reserva reserva = cliente.getReserva(id);
        return reserva.getDataInfoReserva();
    }
    
    @Override
    public DataInfoCliente verInfoCliente( String nomCliente){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataInfoCliente();
    }

}
