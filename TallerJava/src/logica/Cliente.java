/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.imageio.ImageIO;

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
        return new DataCliente( nickname, nombre, apellido, email, fechaNac, imagen, password);
    }
    public List<DataReserva> getDataReservas(){
        List<DataReserva> dts = new ArrayList<>();
        for (Reserva value : reservas.values()){
            dts.add(value.getDataReserva());
        }
        return dts;
    }
    
    public static BufferedImage leerURLdeImagen(String imgURL){
        File imgF = new File(imgURL);
        try {
            return ImageIO.read(imgF);
        } catch (Exception ex) {
            return null;
        }
    }
    public void reservarServicio(int id,Servicio serv,int cantidad,Date fechaIni,Date fechaFin){
        Reserva res = reservas.get(id);
        
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
        Reserva res = reservas.get(clave);
            ItemReserva item = new ItemReserva(cantidad,prom, fechaIni, fechaFin);
            res.agregarItem(item);
        
    }
    public void cancelarReserva(int id){
        Reserva res = reservas.get(id);
        res.darDeBaja();
        reservas.remove(id);
    }
    public DataInfoCliente getDataInfoCliente(){
        return new DataInfoCliente(nickname, nombre, apellido, email, fechaNac, imagen, getDataReservas(), password);
    }
    public Reserva getReserva(int id) {
        return reservas.get(id);
    }
    public void addReserva(int id, Reserva res){
        reservas.put(id, res);
    }
}
