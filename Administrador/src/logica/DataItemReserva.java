/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;


/**
 *
 * @author Juan
 */
public class DataItemReserva {
    private int cantidad; //cantidad de promociones o servicios reservados
    private Date fechaInicio;
    private Date fechaFin;
    private boolean esServico;
    private DataServicio servicio;
    private DataPromocion promocion;
    //Constructores
    public DataItemReserva(){
        this.cantidad      = 0; 
        this.fechaInicio   = new Date();
        this.fechaFin      = new Date();
        this.promocion        = null;
        this.servicio = null;
    }
    
    public DataItemReserva(int cantidad, Date fechaInicio, Date fechaFin, DataServicio servicio, DataPromocion promocion,boolean esservi){
        this.cantidad      = cantidad;
        this.fechaInicio   = fechaInicio;
        this.fechaFin      = fechaFin;
        this.servicio        = servicio;
        esServico = esservi;
        this.promocion = promocion;
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

    public DataServicio getServicio() {
        return servicio;
    }

    public DataPromocion getPromocion() {
        return promocion;
    }

    public boolean getesServico(){
        return esServico;
    }
}
