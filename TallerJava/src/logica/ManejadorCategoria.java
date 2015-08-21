/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author giovani
 */
public class ManejadorCategoria {
    private Map<String,Categoria> categorias;
    private static ManejadorCategoria instance = null;
    private ManejadorCategoria(){}
    
    public static ManejadorCategoria getInstance(){
        if(instance == null)
            instance = new ManejadorCategoria();
        return instance;
    }
    public Categoria getCategoria(String nombre){
        return categorias.get(nombre);
    }
    public void addCategoria(Categoria proveedor){
        categorias.put(proveedor.getNombre(), proveedor);
    }
    public void removeCategoria(String nombre){
        categorias.remove(nombre);
    }
    public Set<DataCategoria> getDataCategorias(){
        Set<DataCategoria> dts = null;
        for (Categoria value : categorias.values()){
            dts.add(value.getDataCategoria());
        }
        return dts;
    }
    public void crearCategoria(String nomCategoria, String nomPadre){
        
    }
    /* operaciones para alta servicio
        getDataCategorias()
        getCategoria()
        getInstance()
    */
}
