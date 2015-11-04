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
    private String pais;
    
    //Constructores
    public DataCiudad(){
        this.nombre = "";
        this.pais    = "";
    }
    
    public DataCiudad(String nombre, String pais){
        this.nombre = nombre;
        this.pais   = pais;
    }
    
    //Getters    
    public String getNombre(){
        return nombre;
    }
    
    public String getPais(){
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
