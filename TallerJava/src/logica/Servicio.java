/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Map;
/**
 *
 * @author matias.heredia
 */
public class Servicio {
    private String nombre;
    private String descripcion;
    private String [] imagen;
    private int contImagen = 0;
    private float precio;
    private Ciudad origen;
    private Ciudad destino;
    private Map<String, Categoria> categorias;
    
    public Servicio(String nombre,String descripcion,float precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.imagen=new String[3];
    }

    public void set_nombre(String nom){
        this.nombre = nom;
    }
    public void set_desc(String des){
        this.descripcion= des;
    }
    public void agregar_imagen(String img){
        if (contImagen < 4){
            this.imagen[contImagen] = img;
            contImagen++;
        }
    }
    public float set_precio(Float nom){
        return this.precio;
    }
    
    public String get_nombre(){
        return this.nombre;
    }
    public String get_desc(){
        return this.descripcion;
    }
    public float get_precio(){
        return this.precio;
    }
    public String get_imagen(int num){
        return this.imagen[num];
    }
    public void asociarOrigen(Ciudad origen){
        this.origen = origen;
    }
    public void asociardestino(Ciudad destino){
        this.destino = destino;
    }
    public void agregarCategoria(Categoria categoria){
        this.categorias.put(categoria.getNombre(), categoria);
    }
    public DataServicio getDataServicio(){
        return new DataServicio(nombre, descripcion, precio);
    }


}
