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
 * @author Juan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataServicio {
    private String nombre;
    private String descripcion;
    private float precio;
    private String[] imagen;
    private String proveedor;
    
    //Contructores
    public DataServicio(){
        this.nombre         = "";
        this.descripcion    = "";
        this.precio         = 0;
        this.imagen         = null;
        this.proveedor = "";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
        
    public DataServicio(String nombre, String descripcion, float precio, String[] imagen, String proveedor){
        this.nombre         = nombre;
        this.descripcion    = descripcion;
        this.precio         = precio;
        this.imagen         = imagen;
        this.proveedor = proveedor;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String[] getImagen(){
        return imagen;
    }
        
    public float getPrecio() {
        return precio;
    }
    public String getProveedor(){
        return proveedor;
    }

    public void setImagen(String[] imagen) {
        this.imagen = imagen;
    }

    
}
