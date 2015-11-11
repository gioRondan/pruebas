/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author giovani
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInfoServicio {
    private String nombre;
    private String descripcion;
    private String[] imagen;
    private float precio;
    private DataCiudad origen;
    private DataCiudad destino;
    private List<DataCategoria> categorias;
    private DataProveedor proveedor;
    
    
    public DataInfoServicio(String nombre, String descripcion, String[] imagen, float precio, DataCiudad origen, DataCiudad destino, List<DataCategoria> categorias, DataProveedor proveedor){
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

    public List<DataCategoria> getCategorias() {
        return categorias;
    }
    public DataProveedor getProveedor(){
        return proveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String[] imagen) {
        this.imagen = imagen;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setOrigen(DataCiudad origen) {
        this.origen = origen;
    }

    public void setDestino(DataCiudad destino) {
        this.destino = destino;
    }

    public void setCategorias(List<DataCategoria> categorias) {
        this.categorias = categorias;
    }

    public void setProveedor(DataProveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
