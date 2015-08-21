/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Juan
 */
public class DataServicio {
    private final String nombre;
    private final String descripcion;
    private final float precio;
    private String [] imagen;
    
    //Contructores
    public DataServicio(){
        this.nombre         = "";
        this.descripcion    = "";
        this.precio         = 0;
        this.imagen         = null;
    }
        
    public DataServicio(String nombre, String descripcion, float precio, String[] imagen){
        this.nombre         = nombre;
        this.descripcion    = descripcion;
        this.precio         = precio;
        this.imagen         = imagen;
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
    
}
