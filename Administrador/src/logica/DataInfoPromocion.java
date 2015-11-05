/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInfoPromocion {
    private final String nombre;
    private final int descuento;
    private final int precioTotal;
    private final Set<DataServicio> servicios;
    
    //Constructores
    public DataInfoPromocion(){
        nombre      = "";
        descuento   = 0;
        precioTotal = 0;
        servicios   = new HashSet();
    }
    
    public DataInfoPromocion( String nombre, int descuento, int precioTotal, Set<DataServicio> servicios){
        this.nombre      = nombre;
        this.descuento   = descuento;
        this.precioTotal = precioTotal;
        this.servicios   = servicios;
    }
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    
    public int getDescuento(){
        return descuento;
    }
    
    public int getPrecioTotal(){
        return precioTotal;
    }
    
    public Set<DataServicio> getServicios(){
        return servicios;
    }
    
}
