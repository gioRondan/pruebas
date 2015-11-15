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

    public Estado getEstado() {
        return estado;
    }
    private Date fin;
    private Estado estado;
    private String nickCliente;
    public ItemReserva(int cantidad,Servicio serv, Date inicio, Date fin, String nickCliente){
        this.cantidad = cantidad;
        servicio=serv;
        promocion=null;
        this.inicio = inicio;
        this.fin = fin;
        this.nickCliente = nickCliente;
    }
    public ItemReserva(int cantidad,Promocion pro, Date inicio, Date fin, String nickCliente){
        this.cantidad = cantidad;
        promocion=pro;
        servicio=null;
        this.inicio = inicio;
        this.fin = fin;
        this.nickCliente = nickCliente;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public DataItemReserva getDataItem(){
        if (servicio==null){ 
            return new DataItemReserva(cantidad, inicio, fin, null, promocion.getDataPromocion(),false, nickCliente);
        }else{
            return new DataItemReserva(cantidad, inicio, fin, servicio.getDataServicio(),null,true, nickCliente);
        }
            
    }

    void facturarItem() {
        if(this.estado == Estado.pagada){
            this.estado = Estado.facturada;
        }
    }
    void setEstado(Estado estado){
        this.estado = estado;
    }

    public String getNickCliente() {
        return nickCliente;
    }
}
