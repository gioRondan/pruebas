/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    public void realizarReserva(String proveedor,String cliente,Map<String, Integer> servicio, Map<String,Integer> promocion,Map<String,DataExpira> fechas,Map<String,DataExpira> fechaspromos,Date fecha_creacion )throws Exception{
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        Cliente aux_cliente = mcli.getCliente(cliente);
        int clave1 = mcli.getUltimoid();
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Reserva res = new Reserva(clave1,fecha_creacion,fecha_creacion,fecha_creacion,0,Estado.registrada);
        aux_cliente.addReserva(res.getId(),res);
        Proveedor prov = mpr.getProveedor(proveedor);
        float preciototal=0;
        for(Map.Entry<String, Integer> entries : servicio.entrySet()){
           
            aux_cliente.reservarServicio(clave1, prov.getServicio(entries.getKey()),entries.getValue(),fechas.get(entries.getKey()).getFechai(),fechas.get(entries.getKey()).getFechaf());
            preciototal+= preciototal + prov.getServicio(entries.getKey()).getPrecio()*entries.getValue();
        }
        
        
        for(Map.Entry<String, Integer> entries : promocion.entrySet()){
            aux_cliente.reservarPromocion(clave1, prov.getPromocion(entries.getKey()),entries.getValue(),fechaspromos.get(entries.getKey()).getFechai(),fechaspromos.get(entries.getKey()).getFechaf());
            
            preciototal= preciototal + prov.getPromocion(entries.getKey()).getPrecioTotal()*entries.getValue();
        }
        res.setPrecio(preciototal);
    }
    
    @Override
    public void altaCliente(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen) throws Exception{
        
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        ManejadorCliente mCl   = ManejadorCliente.getInstance();
        
        //Control de unicidad de usuarios
        mPr.unicidadNick(nick);
        mPr.unicidadEmail(email);
        mCl.unicidadNick(nick);
        mCl.unicidadEmail(email);
        
        if ((nick.isEmpty()) || (nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty())){
            throw new Exception("Los datos ingresados no son correctos");
        }else{
            Cliente cliente = new Cliente(nick, nombre, apellido, email, fechaNac, imagen);
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
