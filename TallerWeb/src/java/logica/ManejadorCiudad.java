/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author giovani
 */
public class ManejadorCiudad {
    private Map<String,Ciudad> ciudades;
    private static ManejadorCiudad instance = null;
    private ManejadorCiudad(){
        ciudades = new HashMap();
    }
    
    public static ManejadorCiudad getInstance(){
        if(instance == null)
            instance = new ManejadorCiudad();
        return instance;
    } 
    
   public List<DataCiudad> getDataCiudades(){
       List<DataCiudad> dts =  new ArrayList<DataCiudad>();
        for (Ciudad value : ciudades.values()){
            dts.add(value.getDataCiudad());
        }
        return dts;
   }
    public Ciudad getCiudad(String a){
        return ciudades.get(a);
    }
    public void addCiudad(Ciudad ciudad){
        ciudades.put(ciudad.getNombre(), ciudad);
    }
    public List<DataCiudad> getDataCiudadesXpais(Pais p){
       List<DataCiudad> dts =  new ArrayList<DataCiudad>();
        for (Ciudad value : ciudades.values()){
            if (value.getPais().getNombre().equals(p.getNombre())){
                dts.add(value.getDataCiudad());
            }
        }
        return dts;
   }
}
