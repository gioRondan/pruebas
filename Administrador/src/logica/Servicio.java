/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author matias.heredia
 */
public class Servicio {
    private String nombre;
    private String descripcion;
    private String[] imagen;
    private int contImagen = 0;
    private float precio;
    private Ciudad origen=null;
    private Ciudad destino=null;
    private Map<String, Categoria> categorias;
    private Proveedor proveedor;
    private int visitas;
    
    public Servicio(String nombre,String descripcion,float precio){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.imagen=new String[3];
        this.categorias = new HashMap();
        proveedor = null;
        visitas = 0;
    }

    public int getVisitas() {
        return visitas;
    }
    public void addVisita(){
        visitas++;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setDesc(String des){
        this.descripcion = des;
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

    public Proveedor getProveedor() {
        return proveedor;
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
    public DataInfoServicio getDataInfoServicio(){
        DataCiudad des = null;
        if (destino!= null){
            des = destino.getDataCiudad();
        }
        return new DataInfoServicio(nombre, descripcion, imagen, precio, origen.getDataCiudad(), des, getDataCategorias(), proveedor.getDataProveedor());
    }
    public List<DataCategoria> getDataCategorias(){
        List<DataCategoria> dts = new ArrayList<DataCategoria>();
        for (Categoria c : categorias.values()){
            dts.add(c.getDataCategoria());
        }
        return dts;
    }
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    public void esdeProveedor(String nomProv) throws Exception{
        if (!(nomProv.equals(proveedor.getNickname()))){
            throw new Exception("Los servicios deben ser de un mismo proveedor");
        }
    }
    public void eliminarImagen(String imagen) throws Exception{
        int itera = 0;
        while((itera < contImagen)&&(!this.imagen[itera].equals(imagen)))
            ++itera;
        if(itera==contImagen)
            throw new Exception("la imagen seleccionada no pertenece al servicio");
        else{
            Files.deleteIfExists(Paths.get(this.imagen[itera]));
            //Files.delete(Paths.get(this.imagen[it]));
            this.imagen[itera] = this.imagen[contImagen-1];
            this.imagen[contImagen-1] = "";
            contImagen--;
        }
    }
    public void eliminarCategoria(String categoria) throws Exception{
        if(categorias.containsKey(categoria)){
            this.categorias.remove(categoria);
        }else{
            throw new Exception("la categoria no pertenece al servicio"); 
        }
    }

    boolean buscado(String aBuscar) {
        return this.nombre.contains(aBuscar) || this.categorias.containsKey(aBuscar) || this.descripcion.contains(aBuscar);
    }
}
