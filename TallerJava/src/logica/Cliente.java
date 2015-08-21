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
 * @author matias.heredia
 */
public class Cliente extends Usuario{
    private Map<String,Servicio> servicios;
    private Map<String,Reserva> reservas;
    
    
    
    public Cliente(String nickname, String nombre, String apellido,String email, Date fechaNac, String url){
        super(nickname,nombre,apellido,email,fechaNac,url);
        
    }
    public DataCliente getDataCliente(){
        return null;
    }
    public void reservarServicio(Servicio serv,int cantidad,Date fechaIni,Date fechaFin){
        Date fecha_actual = new Date();
        Reserva res = new Reserva(fecha_actual,fechaIni,fechaFin,0,Estado.registrada);
        reservas.put(res.getId(),res);
        ItemReserva item = new ItemReserva(cantidad,serv);
        res.agregarItem(item);
    }
    public void reservarPromocion(Promocion prom,int cantidad,Date fechaIni,Date fechaFin){
        Date fecha_actual = new Date();
        Reserva res = new Reserva(fecha_actual,fechaIni,fechaFin,0,Estado.registrada);
        reservas.put(res.getId(),res);
        ItemReserva item = new ItemReserva(cantidad,prom);
        res.agregarItem(item);
    }
}
