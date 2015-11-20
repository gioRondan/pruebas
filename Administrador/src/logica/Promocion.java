/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.util.HashMap;
import java.util.HashSet;

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
    private Proveedor proveedor;
    
    public Promocion(String nombre, int descuento, int precioTotal,Proveedor prov){
        this.nombre = nombre;
        this.descuento = descuento;
        this.precioTotal = precioTotal;
        this.servicios = new HashMap();
        this.proveedor = prov;
    }
    public DataPromocion getDataPromocion(){
        return new DataPromocion(nombre, descuento, precioTotal,proveedor.getNickname());
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
    public void esdeProveedor(String nomProv) throws Exception{
        if (!(nomProv.equals(proveedor.getNickname()))){
            throw new Exception("Las promociones deben ser de un mismo proveedor");
        }
    }
    public Proveedor getProveedor(){
        return proveedor;
    }
    DataInfoPromocion getDataInfoPromocion() {       
        Set<DataServicio> dts =  new HashSet();
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return new DataInfoPromocion(this.getNombre(),this.getDescuento(),this.getPrecioTotal(),dts);
    }

    boolean buscado(String aBuscar) {
        return this.nombre.contains(aBuscar);
    }
}
