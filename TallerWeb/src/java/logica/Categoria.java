/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Juan
 */


public class Categoria {
    
    private String nombre;
    private List<Categoria> hijos;
    private List<Servicio> servicios;
    private boolean tienePadre;
    
    public Categoria(String nombre, boolean tienePadre){
        this.nombre = nombre;
        this.tienePadre = tienePadre;
        this.hijos = new ArrayList<Categoria>();
        this.servicios = new ArrayList<Servicio>();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public List<Categoria> getHijos(){
        return this.hijos;
    }
    
    public void setHijo(Categoria hijo){
        this.hijos.add(hijo);
    }
    
    public List<Servicio> getServicios(){
        return this.servicios;
    }
    public List<DataServicio> getDataServicios(){
        List<DataServicio> dts = new ArrayList<DataServicio>();
        for(Servicio s : servicios){
            dts.add(s.getDataServicio());
        }
        return dts;
    }
    public List<DataCategoria> getDataHijos(){
        List<DataCategoria> dts = new ArrayList<DataCategoria>();
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
    public boolean esHoja(){
        return hijos.isEmpty();
    }

    @Override
    public String toString() {
        return nombre;
    }
    public boolean esRaiz() {
        return !tienePadre;
    }

    Servicio getServicio(String nomServicio) {
        for(Servicio it : servicios){
            if(it.getNombre().equals(nomServicio))
                return it;
        }
        return null;
    }
    public void eliminarServicio(Servicio servicio){
        if(servicios.contains(servicio))
            this.servicios.remove(servicio);
    }
}
