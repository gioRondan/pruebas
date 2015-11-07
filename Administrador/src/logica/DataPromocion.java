/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPromocion {

    private String nombre;
    private int descuento;
    private int precioTotal;
    private String nickProveedor;
    //Constructores
    public DataPromocion(){
        nombre      = "";
        descuento   = 0;
        precioTotal = 0;
        nickProveedor ="";
    }
    
    public DataPromocion(String nombre, int descuento, int precioTotal, String nickProveedor){
    
        this.nombre      = nombre;
        this.descuento   = descuento;
        this.precioTotal = precioTotal;
        this.nickProveedor = nickProveedor;
    }

    
    
    //Getters
    
    
    public String getNombre(){
        return nombre;
    }
    public String getNickProveedor(){
        return  nickProveedor;
    }

    public int getDescuento(){
        return descuento;
    }
    
    public float getPrecioTotal(){
        return precioTotal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setNickProveedor(String nickProveedor) {
        this.nickProveedor = nickProveedor;
    }
    
}
