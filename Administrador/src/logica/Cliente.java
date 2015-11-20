/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author matias.heredia
 */
public class Cliente extends Usuario{
    private Map<Integer,Reserva> reservas;
    
    
    
    
    
    
    
    public Cliente(String nickname, String nombre, String apellido,String email, Date fechaNac, String url, String password){
        super(nickname,nombre,apellido,email,fechaNac,url, password);
        this.reservas = new LinkedHashMap();
    }
    public DataCliente getDataCliente(){
        return new DataCliente( this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),  this.getImagen(), this.getPassword());
    }
    public List<DataReserva> getDataReservas(){
        List<DataReserva> dts = new ArrayList<DataReserva>();
        for (Reserva value : reservas.values()){
            dts.add(value.getDataReserva());
        }
        return dts;
    }
    public void reservarServicio(int identificador,Servicio serv,int cantidad,Date fechaIni,Date fechaFin, ItemReserva item){
        Reserva res = reservas.get(identificador);
        res.agregarItem(item);
    }
    public void modificarEstadoReserva(int identificador, Estado estado){
        Reserva res = reservas.get(identificador);
        if (res.getEstado() == Estado.registrada){
            res.setEstado(estado);
        }
    }
    public void reservarPromocion(int clave,Promocion prom,int cantidad,Date fechaIni,Date fechaFin, ItemReserva item){
        Reserva res = reservas.get(clave);
        res.agregarItem(item);
        
    }
    public void cancelarReserva(int identificador){
        Reserva res = reservas.get(identificador);
        res.darDeBaja();
        reservas.remove(identificador);
    }
    public DataInfoCliente getDataInfoCliente(){
        return new DataInfoCliente(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),  this.getImagen(), getDataReservas(),this.getPassword());
    }
    public Reserva getReserva(int identificador) {
        return reservas.get(identificador);
    }
    public void addReserva(int identificador, Reserva res){
        reservas.put(identificador, res);
    }

    void chequearReserva(Integer id) {
        this.reservas.get(id).chequearEstado();
    }

    List<DataReserva> getDataReservasRegistradas() {
        List<DataReserva> dts = new ArrayList<DataReserva>();
        for (Reserva value : reservas.values()){
            if (value.getEstado() == Estado.registrada)
                dts.add(value.getDataReserva());
        }
        return dts;
    }
}
