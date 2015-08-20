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
public class DataCiudad {
    
    private String nombre;
    private String url;
    
    //Constructores
    public DataCiudad(){
        this.nombre = "";
        this.url    = "";
    }
    
    public DataCiudad(String nombre, String url){
        this.nombre = nombre;
        this.url    = url;
    }
    
    //Getters    
    public String getNombre(){
        return nombre;
    }
    
    public String getUrl(){
        return url;
    }

}
