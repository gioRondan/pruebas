/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;


/**
 *
 * @author diego
 */
public class DataReserva {
    private int id;
    private Date fechaCreacion;
    private Date fechaInicio;
    private Date fechaFin;
    private float precio;
    private Estado estado;
    
    //Constructores
    public DataReserva(){
        this.id            = 0;
        this.fechaCreacion = new Date();
        this.fechaInicio   = new Date();
        this.fechaFin      = new Date();
        this.precio        = 0;
        this.estado        = Estado.registrada;        
    }
    
    public DataReserva(int id, Date fechaCreacion, Date fechaInicio, Date fechaFin, float precio, Estado estado){
        this.id            = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio   = fechaInicio;
        this.fechaFin      = fechaFin;
        this.precio        = precio;
        this.estado        = estado;        
    }
    
    //Getters
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
    
    
}
