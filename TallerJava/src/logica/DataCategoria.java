/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Set;

/**
 *
 * @author Juan
 */
public class DataCategoria {
    private String nombre;
    private Set<DataCategoria> hijos;

    public DataCategoria(String nombre, Set<DataCategoria> hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<DataCategoria> getHijos() {
        return hijos;
    }
    
}
