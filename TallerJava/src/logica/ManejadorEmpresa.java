/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author giovani.rondan
 */
public class ManejadorEmpresa {
    private Map<String,Empresa> empresas;
    private static ManejadorEmpresa instance = null;
    private ManejadorEmpresa(){
        empresas = new HashMap<String,Empresa>();
    }
    
    public static ManejadorEmpresa getInstance(){
        if(instance == null)
            instance = new ManejadorEmpresa();
        return instance;
    }
    public Empresa getEmpresa(String nombre){
        return empresas.get(nombre);
    }
    public void addEmpresa(Empresa empresa){
        empresas.put(empresa.getNombre(), empresa);
    }
    public void removeEmpresa(String nombre){
        empresas.remove(nombre);
    }
    public Set<DataEmpresa> getDataProveedores(){
        Set<DataEmpresa> dts = new HashSet();
        for (Empresa value : empresas.values()){
            dts.add(value.getDataEmpresa());
        }
        return dts;
    }  
}    

