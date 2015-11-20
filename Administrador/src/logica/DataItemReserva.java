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
    private Date fechaInicio;
    private Date fechaFin;
    private boolean esServico;
    private DataServicio servicio;
    private DataPromocion promocion;
    private String nickCliente;
    private Estado estado;

    //Constructores
    public DataItemReserva(){
        this.cantidad      = 0; 
        this.fechaInicio   = new Date();
        this.fechaFin      = new Date();
        this.promocion        = null;
        this.servicio = null;
        this.nickCliente = "";
    }

    public Estado getEstado() {
        return estado;
    }
    
    public DataItemReserva(int cantidad, Date fechaInicio, Date fechaFin, DataServicio servicio, DataPromocion promocion,boolean esservi, String nickCliente, Estado estado){
        this.cantidad      = cantidad;
        this.fechaInicio   = fechaInicio;
        this.fechaFin      = fechaFin;
        this.servicio        = servicio;
        esServico = esservi;
        this.promocion = promocion;
        this.nickCliente = nickCliente;
        this.estado = estado;
    }    

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public void setNickCliente(String nickCliente) {
        this.nickCliente = nickCliente;
    }

    public boolean isEsServico() {
        return esServico;
    }

    public String getNickCliente() {
        return nickCliente;
    }

    public boolean getesServico(){
        return esServico;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
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
