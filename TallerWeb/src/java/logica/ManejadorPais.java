/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class ManejadorPais {
    private Map<String, Pais> paises;
    
    private static ManejadorPais instance = null;
    private ManejadorPais(){
        paises = new HashMap();
    }
    
    public static ManejadorPais getInstance(){
        if(instance == null)
            instance = new ManejadorPais();
        return instance;
    }  
    public Pais getPais(String pais){
        return paises.get(pais);
    }
    public void addPais(Pais pais){
        paises.put(pais.getNombre(), pais);
    }
    public Set<String> getNombresPaises(){
        return paises.keySet();
    }
    
}
