/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giovani
 */
public class User {
    private String name;
    private String lastName;
    private List<Integer> datos;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.datos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getDatos() {
        return datos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDatos(List<Integer> datos) {
        this.datos = datos;
    }

    public void agregarDato(Integer dato){
        this.datos.add(dato);
    }
    
    
    
    
}
