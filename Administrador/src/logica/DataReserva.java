/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataReserva {
    private int identificador;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private float precio;
    private Estado estado;
    
    //Constructores
    public DataReserva(){
        this.identificador = 0;
        this.fechaCreacion = new Date();
        this.fechaInicio   = new Date();
        this.fechaFin      = new Date();
        this.precio        = 0;
        this.estado        = Estado.registrada;        
    }
    
    public DataReserva(int identificador, Date fechaCreacion, Date fechaInicio, Date fechaFin, float precio, Estado estado){
        this.identificador = identificador;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio   = fechaInicio;
        this.fechaFin      = fechaFin;
        this.precio        = precio;
        this.estado        = estado;        
    }
    
    //Getters
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

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
