/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giovani
 */
public class ControladorProveedorTest {
    
    public ControladorProveedorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of altaProveedor method, of class ControladorProveedor.
     */
   /* @Test
    public void testAltaProveedor() {
        System.out.println("altaProveedor");
        String nick = "gio2";
        String nombre = "giovani";
        String apellido = "rondan";
        String email = "grondan93@gmail.com";
        Date fechaNac = new Date(1,1,2015);
        String imagen = "url";
        String nombreEmp = "hola";
        String linkEmp = "mundo";
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor(nick, nombre, apellido, email, fechaNac, imagen, nombreEmp, linkEmp);
        }catch (Exception e){
            System.out.println("fallo altaproveedor");
        }
    }
    */
    public void testAltaProveedor2(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) throws Exception  {
        System.out.println("altaProveedor2");
        String nombreEmp = "hola";
        String linkEmp = "mundo";
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor(nickname, nombre, apellido, email, fechaNac, imagen, nombreEmp, linkEmp);
        }catch (Exception e){
            System.out.println("fallo altaproveedor2");
        }
    }
    /**
     * Test of listarProveedores method, of class ControladorProveedor.
     */
    @Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        try{
            for (int i=1; i<=10; ++i){
                int n = i;
                testAltaProveedor2(Integer.toString(n), "giovani", "rondan", Integer.toString(n), new Date(i, i, 2015), "url");
            }
        }catch (Exception ex){}
        ControladorProveedor instance = new ControladorProveedor();
        String[] expResult ={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<DataProveedor> result = instance.listarProveedores();
        DataProveedor dt;
        int j = 1;
        for(DataProveedor it : result){
          
            assertEquals(Integer.toString(j), it.getNickname());
            j++;
        }
    }
    
    /*
     * Test of ingresarNombreCategoria method, of class ControladorProveedor.
     */
    /*@Test
    public void testIngresarNombreCategoria() {
        System.out.println("ingresarNombreCategoria");
        String nombre = "vuelos";
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarNombreCategoria(nombre);
    }

    /**
     * Test of seleccionarPadre method, of class ControladorProveedor.
     *//*
    @Test
    public void testSeleccionarPadre() {
        System.out.println("seleccionarPadre");
        String nombre = "transporte";
        ControladorProveedor instance = new ControladorProveedor();
        instance.seleccionarPadre(nombre);
    }*/
    public void testIngresarNombreCategoria2(String nombre) {
        System.out.println("ingresarNombreCategoria2");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarNombreCategoria(nombre);
    }

    /**
     * Test of seleccionarPadre method, of class ControladorProveedor.
     */
    public void testSeleccionarPadre2(String nombre) {
        System.out.println("seleccionarPadre2");
        ControladorProveedor instance = new ControladorProveedor();
        instance.seleccionarPadre(nombre);
    }
    /**
     * Test of altaCategoria method, of class ControladorProveedor.
     */
    public void testAltaCategoria() {
        System.out.println("altaCategoria");
        ControladorProveedor instance = new ControladorProveedor();
        instance.altaCategoria();
    }
    public void recorrerCategorias(List<DataCategoria> categorias, int i, int j){
        DataCategoria cat = categorias.get(i);
        assertEquals(Integer.toString(j), cat.getNombre());
        System.out.println(j);
        i++;
        j++;
        if((!cat.getHijos().isEmpty())){
            recorrerCategorias(cat.getHijos(), 0, j);
        }
        if(i < categorias.size()){
            recorrerCategorias(categorias, i, j);
        }
    }
    /**
     * Test of listarCategorias method, of class ControladorProveedor.
     */
    @Test
    public void testListarCategorias() {//la lista no queda ordenada ej agregar 99 sin padre y lo lista antes que 1
        System.out.println("listarCategorias");
        testIngresarNombreCategoria2("1");
        testAltaCategoria();
        //try{
            for (int i=2; i<=10; ++i){
                int n = i;
                testSeleccionarPadre2(Integer.toString(n-1));
                testIngresarNombreCategoria2(Integer.toString(n));
                testAltaCategoria();
            }
        //}catch (Exception ex)
        
        ControladorProveedor instance = new ControladorProveedor();
        List<DataCategoria> result = instance.listarCategorias();
        System.out.println(result.size());
        recorrerCategorias(result, 0, 1);
        /*DataCategoria dt;
        int j = 1;
        for(DataCategoria it : result){
            //if(it != null){
            assertEquals(Integer.toString(j), it.getNombre());
            List<DataCategoria> dt2 = it.getHijos();
            for(DataCategoria it2 : dt2){
                assertEquals(Integer.toString(j), it.getNombre());
                System.out.println(j);
                j++;
            }
            System.out.println(j);
            j++;
        }*/
    }

    
    /**
     * Test of ingresarImagenServicio method, of class ControladorProveedor.
     */
    public void testIngresarImagenServicio(String imagen) {
        System.out.println("ingresarImagenServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarImagenServicio(imagen);
    }

    /**
     * Test of ingresarDestinoServicio method, of class ControladorProveedor.
     */
    
    public void testIngresarDestinoServicio(String destino) {
        System.out.println("ingresarDestinoServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarDestinoServicio(destino);
    }

    /**
     * Test of listarCiudades method, of class ControladorProveedor.
     */
    @Test
    public void testListarCiudades() {
        System.out.println("listarCiudades");
        ControladorProveedor instance = new ControladorProveedor();
        Set<DataCiudad> expResult = null;
        List<DataCiudad> result = instance.listarCiudades();
        //assertEquals(expResult, result);
    }

    /**
     * Test of ingresarCategoriaServicio method, of class ControladorProveedor.
     */
    /*@Test
    public void testIngresarCategoriaServicio() {
        System.out.println("ingresarCategoriaServicio");
        String categoria = "transporte";
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarCategoriaServicio(categoria);
    }*/
    public void testIngresarCategoriaServicio2(String categoria) {
        System.out.println("ingresarCategoriaServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarCategoriaServicio(categoria);
    }
    /**
     * Test of altaServicio method, of class ControladorProveedor.
     */
    @Test
    public void testAltaServicio() {
        try{
        testAltaProveedor2("nickname11", "nombre", "apellido", "email", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        System.out.println("altaServicio");
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname11";
        testIngresarNombreCategoria2("transporte");
        testAltaCategoria();
        testIngresarCategoriaServicio2("transporte");
        
        ControladorProveedor instance = new ControladorProveedor();
        instance.altaServicio(nombre, descripcion, precio, origen, proveedor,"0");
    }


    /**
     * Test of seleccionarCategoria method, of class ControladorProveedor.
     * @param categoria
     */
   
    public void testSeleccionarCategoria(String categoria) {
        System.out.println("seleccionarCategoria");
        ControladorProveedor instance = new ControladorProveedor();
        instance.seleccionarCategoria(categoria);
    }

    /**
     * Test of listarServiciosXCategoria method, of class ControladorProveedor.
     */
    @Test
    public void testListarServiciosXCategoria() {
        System.out.println("listarServiciosXCategoria");
        try{
            testAltaProveedor2("nickname6", "nombre", "apellido", "email6", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname6";
        testIngresarNombreCategoria2("transporte");
        testAltaCategoria();
        testIngresarCategoriaServicio2("transporte");
        ControladorProveedor instance = new ControladorProveedor();
        for(int i = 1; i<=10; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
        }
        List<DataServicio> result = instance.listarServiciosXCategoria("transporte");
        System.out.println(result.size());
        for(int j = 0; j <10;j++){
            assertEquals(Integer.toString(j+1), result.get(j).getNombre());
        }
    }


    /**
     * Test of listarServiciosXProveedor method, of class ControladorProveedor.
     */
    @Test
    public void testListarServiciosXProveedor() {
        try{
            testAltaProveedor2("nickname", "nombre", "apellido", "email3", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        try{
            testAltaProveedor2("nickname2", "nombre", "apellido", "email2", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname";
        testIngresarNombreCategoria2("transporte");
        testAltaCategoria();
        testIngresarCategoriaServicio2("transporte");
        ControladorProveedor instance = new ControladorProveedor();
        for(int i = 1; i<=10; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
        }
        List<DataServicio> result = instance.listarServiciosXProveedor("nickname");
        System.out.println(result.size());
        for(int j = 0; j <10;j++){
            assertEquals(Integer.toString(j+1), result.get(j).getNombre());
        }
        testIngresarCategoriaServicio2("transporte");
            instance.altaServicio("1", descripcion, precio, origen, "nickname2","0");
            assertEquals("1", result.get(0).getNombre());
    }

    /**
     * Test of seleccionarServicio method, of class ControladorProveedor.
     * @param nomServicio
     */
    
    public void testSeleccionarServicio(String nomServicio) {
        System.out.println("seleccionarServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.seleccionarServicio(nomServicio);
    }

    /**
     * Test of altaPromocion method, of class ControladorProveedor.
     */
    
    public void testAltaPromocion() {
        System.out.println("altaPromocion");
        
        testListarServiciosXProveedor();
        String nomProveedor = "nickname";
        Set<String> ser = new HashSet();
        ser.add("1");
        ser.add("2");
        String nombre = "promo1";
        int descuento = 10;
        ControladorProveedor instance = new ControladorProveedor();
        for(int j = 0; j <10;j++){
            instance.altaPromocion(nomProveedor, ser, Integer.toString(j+1), descuento);
        }
        
    }

    /**
     * Test of ingresarDescripcionServicio method, of class ControladorProveedor.
     * @param desc
     */
    
    public void testIngresarDescripcionServicio(String desc) {
        System.out.println("ingresarDescripcionServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarDescripcionServicio(desc);
    }

    /**
     * Test of ingresarPrecioServicio method, of class ControladorProveedor.
     * @param precio
     */
    
    public void testIngresarPrecioServicio(int precio) {
        System.out.println("ingresarPrecioServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarPrecioServicio(precio);
    }

    /**
     * Test of ingresarOrigenServicio method, of class ControladorProveedor.
     * @param origen
     */
   
    public void testIngresarOrigenServicio(String origen) {
        System.out.println("ingresarOrigenServicio");
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarOrigenServicio(origen);
    }

    /**
     * Test of modificarServicio method, of class ControladorProveedor.
     */
    @Test
    public void testModificarServicio() {
        System.out.println("modificarServicio");
        ControladorProveedor instance = new ControladorProveedor();
        testListarServiciosXProveedor();
        List<DataServicio> servicios = instance.listarServiciosXProveedor("nickname");
        testSeleccionarServicio("1");
        testIngresarDescripcionServicio("modificado");
        testIngresarImagenServicio("modificada");
        testIngresarPrecioServicio(9999);
        //testListarCiudades();
        testIngresarOrigenServicio("4");
        testIngresarDestinoServicio("4");
        //testListarCategorias();
        testIngresarCategoriaServicio2("transporte");
        instance.modificarServicio();
    }

    /**
     * Test of listarEmpresas method, of class ControladorProveedor.
     */
    @Test
    public void testListarEmpresas() {
        System.out.println("listarEmpresas");
        try{
            testAltaProveedor2("nickname6", "nombre", "apellido", "email6", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        ControladorProveedor instance = new ControladorProveedor();
        String expResult = "hola";
        List<DataEmpresa> result = instance.listarEmpresas();
        assertEquals(expResult, result.get(0).getNombre());
    }



    /**
     * Test of listarPromocionesXProveedor method, of class ControladorProveedor.
     */
    @Test
    public void testListarPromocionesXProveedor() {
        System.out.println("listarPromocionesXProveedor");
        
        
        testAltaPromocion();
        ControladorProveedor instance = new ControladorProveedor();
        List<DataPromocion> result = instance.listarPromocionesXProveedor("nickname");
        for(int j = 0; j <10;j++){
            assertEquals(Integer.toString(j+1), result.get(j).getNombre());
        }
    }

    /**
     * Test of verInfoServicio method, of class ControladorProveedor.
     */
    @Test
    public void testVerInfoServicio() {
        System.out.println("verInfoServicio");
        String nomServicio = "vuelo123";
        String nomProveedor = "nickname11";
        String descripcion = "cardona-montevideo en 5 minutos";
        float precio = 10;
        String origen = "cardona";
        testAltaServicio();
        testIngresarNombreCategoria2("transporte");
        ControladorProveedor instance = new ControladorProveedor();
        DataInfoServicio expResult = new DataInfoServicio(nomServicio, descripcion, null, precio, null, null, new ArrayList<>(), null);
        DataInfoServicio result = instance.verInfoServicio(nomServicio, nomProveedor);
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getDescripcion(), result.getDescripcion());
        //assertEquals(expResult.getPrecio(), result.getPrecio());
    }

    /**
     * 
     * 
     * Test of verInfoProveedor method, of class ControladorProveedor.
     */
    @Test
    public void testVerInfoProveedor() {
        System.out.println("verInfoProveedor");
        String nomProveedor = "";
        ControladorProveedor instance = new ControladorProveedor();
        try{
            testAltaProveedor2("nickname8", "nombre", "apellido", "email8", new Date(2,2,2000), "imagen");
        }catch(Exception ex){}
        DataInfoProveedor expResult = new DataInfoProveedor("nickname8", "nombre", "apellido", "email8", new Date(2,2,2000), "imagen",null, null);
        DataInfoProveedor result = instance.verInfoProveedor("nickname8");
        assertEquals(expResult.getNickname(), result.getNickname());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getApellido(), result.getApellido());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getFechaNac(), result.getFechaNac());
        assertEquals(expResult.getImagen(), result.getImagen());
    }

    /**
     * Test of ingresarImagen method, of class ControladorProveedor.
     */
    @Test
    public void testIngresarImagen() {
        System.out.println("ingresarImagen");
        String imagen = "im";
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarImagen(imagen);
    }

    /**
     * Test of verInfoPromocion method, of class ControladorProveedor.
     * @param promocion
     */
    //@Test
    public void testVerInfoPromocion(Promocion promocion, String nickproveedor) {
        System.out.println("verInfoPromocion");
        ControladorProveedor instance = new ControladorProveedor();
        DataInfoPromocion result = instance.verInfoPromocion(nickproveedor, promocion.getNombre());
        assertEquals(promocion.getNombre(), result.getNombre());
        assertEquals(promocion.getDescuento(), result.getDescuento());
        assertEquals(promocion.getPrecioTotal(), result.getPrecioTotal());
        assertEquals(promocion.getNombre(), result.getNombre());
    }
    
}
