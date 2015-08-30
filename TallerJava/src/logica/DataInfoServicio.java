/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.Set;
/**
 *
 * @author giovani
 */
public class DataInfoServicio {
    private String nombre;
    private String descripcion;
    private String [] imagen;
    private float precio;
    private DataCiudad origen;
    private DataCiudad destino;
    private Set<DataCategoria> categorias;
    private DataProveedor proveedor;
    public DataInfoServicio(String nombre, String descripcion, String [] imagen, float precio, DataCiudad origen, DataCiudad destino, Set<DataCategoria> categorias, DataProveedor proveedor){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
        this.categorias = categorias;
        this.proveedor = proveedor;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String[] getImagen() {
        return imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public DataCiudad getOrigen() {
        return origen;
    }

    public DataCiudad getDestino() {
        return destino;
    }

    public Set<DataCategoria> getCategorias() {
        return categorias;
    }
    public DataProveedor getProveedor(){
        return proveedor;
    }
    
}
