/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author giovani
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInfoReserva {
    private int id;
    private DataFecha fechaCreacion;
    private DataFecha fechaInicio;
    private DataFecha fechaFin;
    private float precio;
    private Estado estado;
    //private DataItemReserva[] items; 
    private Set<DataItemReserva> items;
    //Constructores
    public DataInfoReserva(){
        this.id = 0;
        this.fechaCreacion = new DataFecha();
        this.fechaInicio   = new DataFecha();
        this.fechaFin      = new DataFecha();
        this.precio        = 0;
        this.estado        = Estado.registrada;     
        this.items         = null;
    }
    
    public DataInfoReserva(int identificador, Date fechaCreacion, Date fechaInicio, Date fechaFin, float precio, Estado estado, Set<DataItemReserva> items){
        this.id = identificador;
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha  = formatoFecha.format(fechaCreacion);
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]); //dd
        int mes = Integer.parseInt(partes[1]); // mm
        int anio = Integer.parseInt(partes[2]); // aaaa
        this.fechaCreacion = new DataFecha(dia, mes, anio);
        
        fecha  = formatoFecha.format(fechaInicio);
        partes = fecha.split("/");
        dia = Integer.parseInt(partes[0]); //dd
        mes = Integer.parseInt(partes[1]); // mm
        anio = Integer.parseInt(partes[2]); // aaaa
        this.fechaInicio   = new DataFecha(dia, mes, anio);
        
        fecha  = formatoFecha.format(fechaFin);
        partes = fecha.split("/");
        dia = Integer.parseInt(partes[0]); //dd
        mes = Integer.parseInt(partes[1]); // mm
        anio = Integer.parseInt(partes[2]); // aaaa
        this.fechaFin      = new DataFecha(dia, mes, anio);
        this.precio        = precio;
        this.estado        = estado;       
        /*DataItemReserva[] ret = new DataItemReserva[items.size()];
        int i = 0;
        for (DataItemReserva value : items){
            ret[i] = value;
            i++;
        }
        this.items = ret;*/
        this.items = items;
    }
    
    //Getters
    public int getId(){
        return id;
    }
    
    public DataFecha getFechaCreacion(){
        return fechaCreacion;
    }

    public DataFecha getFechaInicio(){
        return fechaInicio;
    }
    
    public DataFecha getFechaFin(){
        return fechaFin;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public Estado getEstado(){
        return estado;
    }    

    public Set<DataItemReserva> getItems(){
        return items;
    }

    public void setId(int identificador) {
        this.id = identificador;
    }

    public void setFechaCreacion(DataFecha fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaInicio(DataFecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(DataFecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setItems(Set<DataItemReserva>items) {
        this.items = items;
    }
 
}
