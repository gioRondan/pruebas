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
 * @author giovani.rondan
 */
public class ManejadorEmpresa {
    private Map<String,Empresa> empresas;
    private static ManejadorEmpresa instance = null;
    private ManejadorEmpresa(){
        empresas = new HashMap();
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
    public List<DataEmpresa> getDataEmpresas(){
        List<DataEmpresa> dts = new ArrayList<DataEmpresa>();
        for (Empresa value : empresas.values()){
            dts.add(value.getDataEmpresa());
        }
        return dts;
    }
    
}    

