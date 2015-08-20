/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.*;

/**
 *
 * @author Juan
 */
public class ControladoProveedor {
    private String imagenServicio;
    private String destinoServicio;
    private String categoriaServicio;
    
    public void ingresarImagen(String imagen){
        this.imagenServicio = imagen;
    }
    public void ingresarDestino(String  destino ){
        this.destinoServicio = destino;
    }
    public Set<DataCiudad> listarCiudades(){
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        return mCi.getDataCiudades();//falta implementar manejadorciudad
    }
    public void ingresarCategoria( String categoria){
        this.categoriaServicio = categoria;
    }
    public Set<DataCategorias> listarCategorias(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        return mCa.getDataCategorias();//falta implementar manejadorcategoria
    }
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor){
    
    }
    public Set<DataProveedor> listarProveedores(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        return mPr.getDataProveedores();
    }
    public Set<DataServicio> listarServiciosXCategoria( String nomCategoria){
        return null;
    }
    public void ingresarNombreCategoria( String nombre){
    
    }
    public void seleccionarPadre( String nombre){
   
    }
    public void altaCategoria(){
    }
    public Set<DataServicio> listarServiciosXProveedor( String nomProveedor){
        return null;
    }
    public void altaPromocion( String nomProveedor,Set<String> ser, String nombre){
    
    }
    public void actualizarEstadoReserva(int idReserva, String nomCliente,Estado estado){
    
    }
    public void ingresarDescripcionServicio( String desc){
    
    }
    public void ingresarImagenServicio( String imagen){
    
    }
    public void ingresarPrecioServicio(int precio){
    
    }
    public void ingresarOrigenServicio( String origen){
    
    }
    public void ingresarDestinoServicio( String destino){
    
    }
    public void ingresarCategoriaServicio(Categoria String ){
    
    }
    public void modificarServicio(){
        
    }
    public Set<DataEmpresa> listarEmpresas(){
        return null;
    }
    public void altaProveedor( String nick, String nombe, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp){//iria un dt como entrada calculo yo
    
    }
    public Set<DataPromocion> listarPromocionesXProveedor( String nomProveedor){
        return null;
    }
    public DataPromocion verInfoPromocion( String nomPromocion){
        return null;
    }
    public DataServicio verInfoServicio( String nomServicio){
        return null;
    }
    public DataProveedor verInfoProveedor( String nomProveedor){
        return null;
    }

}
