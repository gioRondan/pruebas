/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author giovani
 */
public class ItemReserva {
    private int cantidad;
    private Servicio servicio;
    private Promocion promocion;
    private Date inicio;
    private Date fin;
    
    public ItemReserva(int cantidad,Servicio serv, Date inicio, Date fin){
        this.cantidad = cantidad;
        servicio=serv;
        promocion=null;
        this.inicio = inicio;
        this.fin = fin;
    }
    public ItemReserva(int cantidad,Promocion pro, Date inicio, Date fin){
        this.cantidad = cantidad;
        promocion=pro;
        servicio=null;
        this.inicio = inicio;
        this.fin = fin;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public DataItemReserva getDataItem(){
        return null;
    }
}
