/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Juan
 */


public class Categoria {
    
    private String nombre;
    private Set<Categoria> hijos;
    private Set<Servicio> servicios;   
    
    public Categoria(String nombre){
        this.nombre = nombre;
        this.hijos = null;
        this.servicios = null;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Set<Categoria> getHijos(){
        return this.hijos;
    }
    
    public void setHijo(Categoria hijo){
        this.hijos.add(hijo);
    }
    
    public Set<Servicio> getServicios(){
        return this.servicios;
    }
    public List<DataServicio> getDataServicios(){
        List<DataServicio> dts = new ArrayList<>();
        for(Servicio s : servicios){
            dts.add(s.getDataServicio());
        }
        return dts;
    }
    public Set<DataCategoria> getDataHijos(){
        Set<DataCategoria> dts = new HashSet();
        for(Categoria c : hijos){
            dts.add(c.getDataCategoria());
        }
        return dts;
    }
    public DataCategoria getDataCategoria(){
        return new DataCategoria(nombre, getDataHijos());
    }
    public void setServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
    public void esHoja()throws Exception{
        if (!hijos.isEmpty()){
            throw new Exception("La categoria seleccionada tiene hijos");
        }
    }
}
