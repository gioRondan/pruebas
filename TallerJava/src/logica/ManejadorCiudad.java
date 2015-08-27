/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class ManejadorCiudad {
    private Map<String,Ciudad> ciudades;
    private static ManejadorCiudad instance = null;
    private ManejadorCiudad(){}
    
    public static ManejadorCiudad getInstance(){
        if(instance == null)
            instance = new ManejadorCiudad();
        return instance;
    } 
    
   public List<DataCiudad> getDataCiudades(){
       return null;
   }
    public Ciudad getCiudad(String a){
        return null;
    }
    /* operaciones para alta servicio
        
    */
}
