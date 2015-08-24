/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class Promocion {
    private String nombre;
    private int descuento;
    private int precioTotal;
    private Map<String,Servicio> servicios;
    
    public Promocion(String nombre, int descuento, int precioTotal){
        this.nombre = nombre;
        this.descuento = descuento;
        this.precioTotal = precioTotal;
        this.servicios = new HashMap();
    }
    public DataPromocion getDataPromocion(){
        return new DataPromocion(nombre, descuento, precioTotal);
    }
    public String getNombre(){
        return nombre;
    }
    public int getDescuento(){
        return descuento;
    }
    public int getPrecioTotal(){
        return precioTotal;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescuento(int descuento){
        this.descuento = descuento;
    }
    public void setPrecioTotal(int precioTotal){
        this.precioTotal = precioTotal;
    }
    public void agregarServicio(Servicio servicio){
        servicios.put(servicio.getNombre(), servicio);
    }

    DataInfoPromocion getDataInfoPromocion() {       
        Set<DataServicio> dts =  new HashSet();
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return new DataInfoPromocion(this.getNombre(),this.getDescuento(),this.getPrecioTotal(),dts);
    }
}
