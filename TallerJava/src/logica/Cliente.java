/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author matias.heredia
 */
public class Cliente extends Usuario{
    private Map<Integer,Reserva> reservas;
    
    
    
    
    
    
    
    public Cliente(String nickname, String nombre, String apellido,String email, Date fechaNac, String url){
        super(nickname,nombre,apellido,email,fechaNac,url);
        this.reservas = new LinkedHashMap();
    }
    public DataCliente getDataCliente(){
        return new DataCliente( nickname, nombre, apellido, email, fechaNac, imagen);
    }
    public List<DataReserva> getDataReservas(){
        List<DataReserva> dts = new ArrayList<>();
        for (Reserva value : reservas.values()){
            dts.add(value.getDataReserva());
        }
        return dts;
    }
    public void reservarServicio(int id,Servicio serv,int cantidad,Date fechaIni,Date fechaFin){
        Date fecha_actual = new Date();
        
        Reserva res = new Reserva(id,fecha_actual,fechaIni,fechaFin,0,Estado.registrada);
        
        reservas.put(res.getId(),res);
        ItemReserva item = new ItemReserva(cantidad,serv, fechaIni, fechaFin);
        res.agregarItem(item);
    }
    public void modificarEstadoReserva(int id, Estado estado){
        Reserva res = reservas.get(id);
        if (res.getEstado() == Estado.registrada){
            res.setEstado(estado);
        }
    }
    public void reservarPromocion(int clave,Promocion prom,int cantidad,Date fechaIni,Date fechaFin){
        Date fecha_actual = new Date();
        Reserva res = new Reserva(clave,fecha_actual,fechaIni,fechaFin,0,Estado.registrada);
        reservas.put(res.getId(),res);
        ItemReserva item = new ItemReserva(cantidad,prom, fechaIni, fechaFin);
        res.agregarItem(item);
    }
    public void cancelarReserva(int id){
        Reserva res = reservas.get(id);
        res.darDeBaja();
        reservas.remove(id);
    }
    public DataInfoCliente getDataInfoCliente(){
        return new DataInfoCliente(nickname, nombre, apellido, email, fechaNac, imagen, getDataReservas());
    }
    public Reserva getReserva(int id) {
        return reservas.get(id);
    }
}
