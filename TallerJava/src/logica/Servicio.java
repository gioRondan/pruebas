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
import java.util.Set;
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
    private Ciudad origen=null;
    private Ciudad destino=null;
    private Map<String, Categoria> categorias;
    private Proveedor proveedor;
    
    public Servicio(String nombre,String descripcion,float precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.imagen=new String[3];
        this.categorias = new HashMap();
        proveedor = null;
    }

    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setDesc(String des){
        this.descripcion= des;
    }
    public void agregarImagen(String img)throws Exception{
        if (contImagen < 3){
            this.imagen[contImagen] = img;
            contImagen++;
        }else
            throw new Exception("El servicio ya tiene asignado 3 imagenes");
    }
    public void setPrecio(float precio){
         this.precio = precio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getDesc(){
        return this.descripcion;
    }
    public float getPrecio(){
        return this.precio;
    }
    public String getImagen(int num){
        return this.imagen[num];
    }
    public void asociarOrigen(Ciudad origen){
        this.origen = origen;
    }
    public void asociarDestino(Ciudad destino){
        this.destino = destino;
    }
    public void agregarCategoria(Categoria categoria){
        this.categorias.put(categoria.getNombre(), categoria);
    }
    public DataServicio getDataServicio(){
        return new DataServicio(nombre, descripcion, precio, imagen, proveedor.getNickname());
    }
    public DataInfoServicio getDataInfoServicio (){
        DataCiudad des = null;
        if (destino!= null){
            des = destino.getDataCiudad();
        }
        return new DataInfoServicio(nombre, descripcion, imagen, precio, origen.getDataCiudad(), des, getDataCategorias(), proveedor.getDataProveedor());
    }
    public List<DataCategoria> getDataCategorias(){
        List<DataCategoria> dts = new ArrayList<>();
        for (Categoria c : categorias.values()){
            dts.add(c.getDataCategoria());
        }
        return dts;
    }
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    public void esdeProveedor(String nomProv) throws Exception{
        if (!(nomProv.equals(proveedor.getNombre()))){
            throw new Exception("Los servicios deben ser de un mismo proveedor");
        }
    }

}
