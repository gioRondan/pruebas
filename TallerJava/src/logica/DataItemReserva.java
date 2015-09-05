/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Juan
 */
public class DataItemReserva {
    private int cantidad; //cantidad de promociones o servicios reservados
    private Date fechaInicio;
    private Date fechaFin;
    private boolean esServico;
    private String nombre; //nombre del servicio o promocion reservada
    
    //Constructores
    public DataItemReserva(){
        this.cantidad      = 0; 
        this.fechaInicio   = new Date();
        this.fechaFin      = new Date();
        this.nombre        = nombre;     
    }
    
    public DataItemReserva(int cantidad, Date fechaInicio, Date fechaFin, String nombre,boolean es){
        this.cantidad      = cantidad;
        this.fechaInicio   = fechaInicio;
        this.fechaFin      = fechaFin;
        this.nombre        = nombre;
        esServico = es;
    }    
    
    //Getters
    public int getCantidad(){
        return cantidad;
    }
        
    public Date getFechaInicio(){
        return fechaInicio;
    }
    
    public Date getFechaFin(){
        return fechaFin;
    }
            
    public String getNombre(){
        return nombre;
    }
    
    public boolean getesServico(){
        return esServico;
    }
}
