/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Juan
 */
public class DataCategoria {
    private String nombre;
    private List<DataCategoria> hijos;

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
    
}
