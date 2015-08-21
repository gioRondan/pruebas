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
    private Set<String> imagenServicio;
    private String destinoServicio;
    private String origenServicio;
    private Set<String> categoriasServicio;
    private String servicio;
    private String proveedor;
    private String descripcionServicio;
    private float precioServicio = 0;
    private String categoria;
    private String nomCategoria;
    private String nomPadre = "";
    
    private void liberarMemoria(){
        
    }
    
    public void ingresarImagenServicio(String imagen){
        this.imagenServicio.add(imagen);
    }
    public void ingresarDestinoServicio(String  destino ){
        this.destinoServicio = destino;
    }
    public Set<DataCiudad> listarCiudades(){
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        return mCi.getDataCiudades();//falta implementar manejadorciudad
    }
    public void ingresarCategoriaServicio( String categoria){
        this.categoriasServicio.add(categoria);
    }
    public Set<DataCategoria> listarCategorias(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        return mCa.getDataCategorias();//falta implementar manejadorcategoria
    }
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor){
        Servicio ser = new Servicio(nombre, descripcion, precio);
        for (String im : imagenServicio){
            ser.agregarImagen(im);
        }
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        prov.asociarServicio(ser);
        //asociar servicio a proveedor??????
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Set<Categoria> categorias;
        for(String cats : categoriasServicio){
            Categoria cat = mCa.getCategoria(cats);
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        ser.asociarOrigen(mCi.getCiudad(origen));
        if (!destinoServicio.isEmpty()){
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        liberarMemoria();
    }
    public Set<DataProveedor> listarProveedores(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        return mPr.getDataProveedores();
    }
    public void seleccionarCategoria(String categoria){
        this.categoria = categoria;
    }
    public Set<DataServicio> listarServiciosXCategoria( String nomCategoria){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Categoria cat = mCa.getCategoria(categoria);
        return cat.getDataServicios();
    }
    public void ingresarNombreCategoria(String nombre){
        this.nomCategoria = nombre;
    }
    public void seleccionarPadre(String nombre){
        this.nomPadre = nombre;
    }    
    public void altaCategoria(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        mCa.crearCategoria(this.nomCategoria,this.nomPadre);
    }
    public Set<DataServicio> listarServiciosXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);//nickname
        this.proveedor = nomProveedor;//para que esta linea ?
        return prov.getDataServicios();
    }
    public void seleccionarServicio(String nomServicio){
        this.servicio = nomServicio;
    }
    public void altaPromocion( String nomProveedor,Set<String> ser, String nombre, int descuento){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);//nickname
        Iterator<String> itera = ser.iterator();
        int totalPrecio=0;
        Promocion p = new Promocion(nombre, descuento, totalPrecio);
        while (itera.hasNext()) {
            //recorro los servicos a agregar y voy calculando el precio de la promocion sin el descuento
            Servicio s = prov.getServicio(itera.next()); 
            totalPrecio += s.getPrecio();
            p.agregarServicio(s);
        }
        totalPrecio=(int)(totalPrecio * (0.1*descuento));//aplico el descuento
        p.setPrecioTotal(totalPrecio);//Seteo el precio total con el descuento aplicado 
    }
    public void actualizarEstadoReserva(int idReserva, String nomCliente,Estado estado){
    
    }
    public void cancelarReserva(int idReserva, String nomCliente){
    //Rodrigo
    }
    public void ingresarDescripcionServicio( String desc){
        this.descripcionServicio = desc;
    }
    public void ingresarPrecioServicio(int precio){
        this.precioServicio = precio;
    }
    public void ingresarOrigenServicio( String origen){
        this.origenServicio = origen;
    }
    public void modificarServicio(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(servicio);
        if (!descripcionServicio.isEmpty()){
            ser.setDesc(descripcionServicio);
        }
        for(String im : imagenServicio){
            ser.agregarImagen(im);//revisar
        }
        if (precioServicio != 0){
            ser.setPrecio(precioServicio);
        }
        if (!origenServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            ser.asociarOrigen(mCi.getCiudad(origenServicio));
        }
        if (!destinoServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        for(String im : imagenServicio){
            ser.agregarImagen(im);//revisar
        }
        for(String cats : categoriasServicio){
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(cats);//hay que eliminar las categorias anteriores?
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        liberarMemoria();
    }
    public Set<DataEmpresa> listarEmpresas(){
        return null;
    }
    public void altaProveedor( String nick, String nombe, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp){//iria un dt como entrada calculo yo
    
    }
    public Set<DataPromocion> listarPromocionesXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        
        return prov.getDataPromociones();
    }
    public DataInfoPromocion verInfoPromocion( String nomPromocion){
        
        return null;
    }
    public DataInfoServicio verInfoServicio( String nomServicio){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(nomServicio);
        return ser.getDataInfoServicio();
    }
    public DataInfoProveedor verInfoProveedor( String nomProveedor){
        return null;
    }
    public DataInfoCliente verInfoCliente( String nomCliente){
        //Rodrigo
        return null;
    }
}
