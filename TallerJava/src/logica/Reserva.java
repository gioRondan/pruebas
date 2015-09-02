/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class Reserva {
    private int id; 
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private float precio;
    private Estado estado;
    private List<ItemReserva> item;
    
    public Reserva(int id,Date fechaCreacion, Date fechaInicio, Date fechaFin, float precio, Estado estado){
        this.id=id;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.estado = estado;
        this.item = new ArrayList<>();
    }
    
    public int getId(){
        return id;
    }
    public Date getFechaCreacion(){
        return fechaCreacion;
    }
    public Date getFechaInicio(){
        return fechaInicio;
    }
    public Date getFechaFin(){
        return fechaFin;
    }
    public float getPrecio(){
        return precio;
    }
    public Estado getEstado(){
        return estado;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    public void setFechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public void setFechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    public void agregarItem(ItemReserva ite){
        this.item.add(ite);
    }
    public DataReserva getDataReserva(){
        return new DataReserva(id, fechaCreacion, fechaInicio, fechaFin, precio, estado);
    }
    public void darDeBaja(){
        for(ItemReserva it : item){
            item.remove(it);
        }
    }
    public Set<DataItemReserva> getDataItemsReserva(){
        Set<DataItemReserva> dts = new HashSet();
        for(ItemReserva it : item){
            dts.add(it.getDataItem());
        }
        return dts;
    }
    public DataInfoReserva getDataInfoReserva() {
     
        return new DataInfoReserva( id,  fechaCreacion,  fechaInicio,  fechaFin,  precio,  estado, getDataItemsReserva());
    }
}
