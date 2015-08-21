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
    
    //Constructores
    public DataPromocion(){
        nombre      = "";
        descuento   = 0;
        precioTotal = 0;
    }
    
    public DataPromocion( String nombre, int descuento, int precioTotal){
        this.nombre      = nombre;
        this.descuento   = descuento;
        this.precioTotal = precioTotal;
    }
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    
    public int getDescuento(){
        return descuento;
    }
    
    public float getPrecioTotal(){
        return precioTotal;
    }
    
}
