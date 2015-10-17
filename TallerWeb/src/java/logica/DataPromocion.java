/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author diego
 */
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
    public String getnickProveedro(){
        return  nickProveedor;
    }

    public int getDescuento(){
        return descuento;
    }
    
    public float getPrecioTotal(){
        return precioTotal;
    }
    
}
