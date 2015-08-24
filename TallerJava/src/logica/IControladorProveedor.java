
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Set;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Juan
 */
public interface IControladorProveedor {
    public void ingresarImagen(String imagen);
    public Set<DataCiudad> listarCiudades();
    public Set<DataCategoria> listarCategorias();
    public void altaServicio(String nombre, String descripcion, int precio, String origen, String proveedor);
    public Set<DataProveedor> listarProveedores();
    public Set<DataServicio> listarServiciosXCategoria(String nomCategoria);
    public void ingresarNombreCategoria(String nombre);
    public void seleccionarPadre(String nombre);
    public void altaCategoria(/*sin parametros?*/);
    public Set<DataServicio> listarServiciosXProveedor(String nomProveedor);
    public void altaPromocion( String nomProveedor,Set<String> ser, String nombre, int descuento);
    public void ingresarDescripcionServicio(String desc);
    public void ingresarImagenServicio(String imagen);
    public void ingresarPrecioServicio(int precio);
    public void ingresarOrigenServicio(String origen);
    public void ingresarDestinoServicio(String destino);
    public void ingresarCategoriaServicio(String categoria);
    public void modificarServicio();
    public List<DataEmpresa> listarEmpresas();
    public void altaProveedor(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmp, String LinkEmpres)throws Exception;
    public Set<DataPromocion> listarPromocionesXProveedor(String nomProveedor);
    public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion);
    public DataInfoServicio verInfoServicio(String nomServicio);
    public DataInfoProveedor verInfoProveedor(String nomProveedor);
}
