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
 * @author Juan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataItemReserva {
    private int cantidad; //cantidad de promociones o servicios reservados
    private DataFecha fechaInicio;
    private DataFecha fechaFin;
    private boolean esServico;
    private DataServicio servicio;
    private DataPromocion promocion;
    //Constructores
    public DataItemReserva(){
        this.cantidad      = 0; 
        this.fechaInicio   = new DataFecha();
        this.fechaFin      = new DataFecha();
        this.promocion        = null;
        this.servicio = null;
    }
    
    public DataItemReserva(int cantidad, Date fechaInicio, Date fechaFin, DataServicio servicio, DataPromocion promocion,boolean esservi){
        this.cantidad      = cantidad;
        this.fechaInicio   = new DataFecha(fechaInicio.getDay(), fechaInicio.getMonth(), fechaInicio.getYear());
        this.fechaFin      = new DataFecha(fechaFin.getDay(), fechaFin.getMonth(), fechaFin.getYear());
        this.servicio        = servicio;
        esServico = esservi;
        this.promocion = promocion;
    }    
  
    //Getters
    public int getCantidad(){
        return cantidad;
    }
        
    public DataFecha getFechaInicio(){
        return fechaInicio;
    }
    
    public DataFecha getFechaFin(){
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaInicio(DataFecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(DataFecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEsServico(boolean esServico) {
        this.esServico = esServico;
    }

    public void setServicio(DataServicio servicio) {
        this.servicio = servicio;
    }

    public void setPromocion(DataPromocion promocion) {
        this.promocion = promocion;
    }
    
}
