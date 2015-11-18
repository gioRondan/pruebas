
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
    public void seleccionarProveedor(String proveedor);
    public void seleccionarServicio(String nomServicio);
    public void ingresarImagenBorrarServicio(String imagen);
    public void ingresarModificarImagenServicio(String imagen);
    public void ingresarCategoriaBorrarServicio(String categoria);
    public List<DataCiudad> listarCiudades();
    public List<DataCategoria> listarCategorias();
    public void altaServicio(String nombre, String descripcion, int precio, String origen, String proveedor, String pais)throws Exception;
    public List<DataProveedor> listarProveedores();
    public List<DataServicio> listarServiciosXCategoria(String nomCategoria);
    public void ingresarNombreCategoria(String nombre);
    public void seleccionarPadre(String nombre);
    public void altaCategoria(/*sin parametros?*/) throws Exception;
    public List<DataServicio> listarServiciosXProveedor(String nomProveedor);
    public void altaPromocion( String nomProveedor,List<String> ser, String nombre, int descuento) throws Exception;
    public void ingresarDescripcionServicio(String desc);
    public void ingresarImagenServicio(String imagen);
    public void ingresarPrecioServicio(float precio);
    public void ingresarOrigenServicio(String origen);
    public void ingresarDestinoServicio(String destino);
    public void vaciarCategoriasServicio();
    public void ingresarCategoriaServicio(String categoria)throws Exception;
    public void modificarServicio()throws Exception;
    public List<DataEmpresa> listarEmpresas();
    public void altaProveedor(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmp, String LinkEmpres, String password) throws Exception;
    public List<DataPromocion> listarPromocionesXProveedor(String nomProveedor);
    public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion);
    public DataInfoServicio verInfoServicio(String nomServicio, String nomProveedor)throws Exception;
    public DataInfoProveedor verInfoProveedor(String nomProveedor);
    public DataServicio informacionServicio(String prv,String ser) throws Exception;
    public Set<String> infoPaises();
    public List<DataCiudad> ciudadesXpais( String pais);
    public void altaPais(String pais)throws Exception;
    public void altaCiudad(String nomCiudad, String nomPais);
//################################      operaciones tarea 2 ####################################################################################
    public List<DataServicio> buscarServicios(String aBuscar); 
    public List<DataPromocion> buscarPromociones(String aBuscar);
    public DataPromocion informacionPromocion(String pvr, String nom)throws Exception;
    public DataInfoProveedor iniciarSesion(String nick, String pass);
    public void facturarReserva(String nick, Integer id);

    public List<DataInfoReserva> listarReservasXProveedor(String nick);
}
