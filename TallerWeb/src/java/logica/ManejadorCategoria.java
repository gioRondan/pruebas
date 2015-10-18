/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManejadorCategoria {
    private Map<String,Categoria> categorias;
    private static ManejadorCategoria instance = null;
    private ManejadorCategoria(){
        categorias = new LinkedHashMap();
    }
    
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
    public List<DataCategoria> getDataCategorias(){
        List<DataCategoria> dts = new ArrayList<DataCategoria>();
        for (Categoria value : categorias.values()) {
            if(value.esRaiz())
            dts.add(value.getDataCategoria());
        }
        return dts;
    }/*
    public void crearCategoria(String nomCategoria, String nomPadre){
        Categoria nueva = new Categoria(nomCategoria);
        if (!(nomPadre.isEmpty())){
            Categoria padre = categorias.get(nomPadre);
            padre.setHijo(nueva);
        }else       //solo quedan en el manejador las categorias de mayor jerarquia, el resto se consiguen por medio de sus hijos. Para mayor informacion consultar a gio
            categorias.put(nomCategoria, nueva);
    }*/
    
}
