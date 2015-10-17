/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class Reserva {
    private int identificador; 
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private float precio;
    private Estado estado;
    private List<ItemReserva> item;
    
    public Reserva(int identificador,Date fechaCreacion, Date fechaInicio, Date fechaFin, float precio, Estado estado){
        this.identificador=identificador;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.estado = estado;
        this.item = new ArrayList<ItemReserva>();
    }
    
    public int getId(){
        return identificador;
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
    public void setId(int identificador){
        this.identificador = identificador;
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
        return new DataReserva(identificador, fechaCreacion, fechaInicio, fechaFin, precio, estado);
    }
    public void darDeBaja(){ 
        item.removeAll(item);
    }
    public Set<DataItemReserva> getDataItemsReserva(){
        Set<DataItemReserva> dts = new HashSet();
        for(ItemReserva it : item){
            dts.add(it.getDataItem());
        }
        return dts;
    }
    public DataInfoReserva getDataInfoReserva() {
     
        return new DataInfoReserva( identificador,  fechaCreacion,  fechaInicio,  fechaFin,  precio,  estado, getDataItemsReserva());
    }
}
