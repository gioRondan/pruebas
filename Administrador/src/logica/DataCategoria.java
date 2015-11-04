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
public class DataCategoria {
    private String nombre;
    private List<DataCategoria> hijos;

    
    public DataCategoria() {
         this.nombre = "";
        this.hijos = new ArrayList<>();
    }

    public DataCategoria(String nombre, List<DataCategoria> hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<DataCategoria> getHijos() {
        return hijos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHijos(List<DataCategoria> hijos) {
        this.hijos = hijos;
    }
    
}
