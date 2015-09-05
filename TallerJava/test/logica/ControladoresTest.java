/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author giovani.rondan
 */
public class ControladoresTest {
    
    public ControladoresTest() {
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
     * Test of getNombre method, of class Ciudad.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Pais uruguay = new Pais("uruguay");
        Ciudad instance = new Ciudad("soriano", uruguay);
        String expResult = "soriano";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Ciudad.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "artigas";
        Pais uruguay = new Pais("uruguay");
        Ciudad instance = new Ciudad("soriano", uruguay);
        instance.setNombre(nombre);
        String result = instance.getNombre();
        String expResult = "artigas";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPais method, of class Ciudad.
     */
    @Test
    public void testGetPais() {
        System.out.println("getPais");
        String nombre = "artigas";
        Pais uruguay = new Pais("uruguay");
        Ciudad instance = new Ciudad("soriano", uruguay);
        String expResult = "uruguay";
        Pais result = instance.getPais();
        assertEquals(expResult, result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPais method, of class Ciudad.
     */
    @Test
    public void testSetPais() {
        System.out.println("setPais");
        String nombre = "artigas";
        Pais uruguay = new Pais("uruguay");
        Ciudad instance = new Ciudad("soriano", uruguay);
        Pais pais = new Pais("argentina");
        instance.setPais(pais);
        String expResult = "argentina";
        assertEquals(expResult, instance.getPais().getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCiudad method, of class Ciudad.
     */
    @Test
    public void testGetDataCiudad() {
        System.out.println("getDataCiudad");
        Pais uruguay = new Pais("uruguay");
        Ciudad instance = new Ciudad("soriano", uruguay);
        String expResult = "soriano";
        DataCiudad result = instance.getDataCiudad();
        assertEquals(expResult, result.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of listarProveedores method, of class ControladorProveedor.
     */
    @Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        ControladorProveedor cp = new ControladorProveedor();
        try{
            for (int i=1; i<=10; ++i){
                int n = i;
                cp.altaProveedor(Integer.toString(n), "giovani", "rondan", Integer.toString(n), new Date(i, i, 2015), "imagen","url","link");
            }
        }catch (Exception ex){
        System.out.println("throw alta proveedor");
        }
        ControladorProveedor instance = new ControladorProveedor();
        List<DataProveedor> result = instance.listarProveedores();
        DataProveedor dt;
        
        /*for(int j = 1; j<11;++j){
          
            assertEquals(Integer.toString(j), result.get(j-1).getNickname());
            j++;
        }*/
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
    }*/
    
    
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
     
    public void testAltaCategoria() {
        System.out.println("altaCategoria");
        ControladorProveedor instance = new ControladorProveedor();
        
        try{
        instance.altaCategoria();}
        catch (Exception ex){}
    }*/
    public void recorrerCategorias(List<DataCategoria> categorias, int i, int j){
        DataCategoria cat = categorias.get(i);
        assertEquals(Integer.toString(j), cat.getNombre());
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
       /* System.out.println("listarCategorias");
        testIngresarNombreCategoria2("1");
        //testAltaCategoria();
        ControladorProveedor instance = new ControladorProveedor();
       try{
        instance.altaCategoria();
        //try{
            for (int i=2; i<=10; ++i){
                int n = i;
                testSeleccionarPadre2(Integer.toString(n-1));
                testIngresarNombreCategoria2(Integer.toString(n));
                instance.altaCategoria();
            }
        }catch (Exception ex){
            System.out.println("throw alta categoria en listar categoria");  
        }
        
        List<DataCategoria> result = instance.listarCategorias();
        System.out.println(result.size());
        recorrerCategorias(result, 0, 1);*/
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
        /*System.out.println("listarCiudades");
        ControladorProveedor instance = new ControladorProveedor();
        for(int i =1; i < 11; ++i){
            instance.altaCiudad(Integer.toString(i),"1");
        }
        List<DataCiudad> result = instance.listarCiudades();
        for(int j = 1; j < 11; ++j){
            assertEquals(Integer.toString(j), result.get(j-1).getNombre());
            assertEquals("1", result.get(j-1).getPais());
        }*/
        //
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
        //System.out.println("ingresarCategoriaServicio");
        ControladorProveedor instance = new ControladorProveedor();
        
        try{
        instance.ingresarCategoriaServicio("transporte2222");
        }catch(Exception ex){}
    }
    /**
     * Test of altaServicio method, of class ControladorProveedor.
     *//*
    @Test
    public void testAltaServicio() {
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname11", "nombre", "apellido", "email", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por categoria");
        }
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
    }*/


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
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname11", "nombre", "apellido", "email", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por categoria");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname11";
        testIngresarNombreCategoria2("transporte2");
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte2");
        for(int i = 1; i<=10; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte2");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
        }
        List<DataServicio> result = instance.listarServiciosXCategoria("transporte2");
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
        
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname111", "nombre", "apellido", "email111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por proveedor");
        }
        try{
        instance.altaProveedor("nickname1111", "nombre", "apellido", "email1111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por categoria");
        }
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname111";
        String proveedor2 = "nickname1111";
        testIngresarNombreCategoria2("transporte");
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por proveedor");
        }
        testIngresarCategoriaServicio2("transporte");
        for(int i = 11; i<=20; ++i){
            int n = i;
            testIngresarCategoriaServicio2("transporte");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
        }
        List<DataServicio> result = instance.listarServiciosXProveedor("nickname111");
        System.out.println(result.size());
        for(int j = 0; j <10;j++){
            assertEquals(Integer.toString(j+11), result.get(j).getNombre());
        }/*
        testIngresarCategoriaServicio2("transporte");
            instance.altaServicio("1", descripcion, precio, origen, proveedor2,"0");
            assertEquals("1", result.get(0).getNombre());*/
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
        List<String> ser = new ArrayList<>();
        ser.add("1");
        ser.add("2");
        String nombre = "promo1";
        int descuento = 10;
        ControladorProveedor instance = new ControladorProveedor();
        try{
        for(int j = 0; j <10;j++){
            instance.altaPromocion(nomProveedor, ser, Integer.toString(j+1), descuento);
        }}catch(Exception ex){}
        
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
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor instance = fabrica.getIControladorProveedor();
        try{
        instance.altaProveedor("nickname11111", "nombre", "apellido", "email11111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname11111";
        testIngresarNombreCategoria2("transporte2222");
        try{
            instance.altaCiudad("4","prueba");
            instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        try{
        instance.ingresarCategoriaServicio("transporte2222");
        }catch(Exception ex){}
        instance.ingresarImagenServicio("imser");
        instance.altaServicio("amodificar", descripcion, precio, origen, proveedor,"0");
        DataInfoServicio result2 = instance.verInfoServicio("amodificar", proveedor);
        testSeleccionarServicio("amodificar");
        testIngresarDescripcionServicio("modificado");
        instance.ingresarImagenBorrarServicio("imser");
        testIngresarImagenServicio("modificada");
        testIngresarPrecioServicio(9999);
        testIngresarOrigenServicio("origenmodificado");
        
        testIngresarDestinoServicio("4");
        instance.seleccionarProveedor(proveedor);
        instance.ingresarCategoriaBorrarServicio("transporte2222");
        try{
            instance.ingresarCategoriaServicio("catmodificada");
        }catch(Exception ex){}
        try{
        instance.modificarServicio();
        }catch(Exception ex){}
        DataInfoServicio result = instance.verInfoServicio("amodificar", proveedor);
        assertEquals("modificado", result.getDescripcion());
        assertEquals(9999, result.getPrecio(), 0);
        assertEquals("modificada", result.getImagen()[0]);
        assertEquals("origenmodificado", result.getOrigen().getNombre());
        assertEquals("4", result.getDestino().getNombre());
        assertEquals("catmodificada", result.getCategorias().get(0).getNombre());
    }

    /**
     * Test of listarEmpresas method, of class ControladorProveedor.
     */
    @Test
    public void testListarEmpresas() {
        System.out.println("listarEmpresas");
        ControladorProveedor instance = new ControladorProveedor();
        try{
            instance.altaProveedor("nickname6", "nombre", "apellido", "email6", new Date(2,2,2000), "imagen","url","link");
        }catch(Exception ex){}
        
        String expResult = "url";
        List<DataEmpresa> result = instance.listarEmpresas();
//        assertEquals(expResult, result.get(0).getNombre());
    }



    /**
     * Test of listarPromocionesXProveedor method, of class ControladorProveedor.
     */
    @Test
    public void testListarPromocionesXProveedor() {
        System.out.println("listarPromocionesXProveedor");
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname111111", "nombre", "apellido", "email111111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar promociones por proveedor");
        }
        String nombre = "vuelo12345";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname111111";
        testIngresarNombreCategoria2("transporte2222222");
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        List<String> serv = new ArrayList<>();
        for(int i = 50; i<=60; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte2222222");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
            serv.add(Integer.toString(n));
        }
        try{
        for(int k = 70; k<81;++k){
            instance.altaPromocion(proveedor, serv, Integer.toString(k), 10);
        }
        }catch(Exception ex){}
        List<DataPromocion> result = instance.listarPromocionesXProveedor(proveedor);
        for(int j = 0; j <11;j++){
            assertEquals(Integer.toString(j+70), result.get(j).getNombre());
            //mas chequeos faltan
        }
    }

    /**
     * Test of verInfoServicio method, of class ControladorProveedor.
     */
    /*@Test
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
    }*/

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
        instance.altaProveedor("nickname11111111", "nombre", "apellido", "email11111111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar promociones por proveedor");
        }
        DataInfoProveedor result = instance.verInfoProveedor("nickname11111111");
        assertEquals("nickname11111111", result.getNickname());
        assertEquals("nombre", result.getNombre());
        assertEquals("apellido", result.getApellido());
        assertEquals("email11111111", result.getEmail());
        assertEquals(new Date(2,2,2000), result.getFechaNac());
        assertEquals("imagen", result.getImagen());
        
    }

    /**
     * Test of ingresarImagen method, of class ControladorProveedor.
     */
    public void testIngresarImagen() {
        System.out.println("ingresarImagen");
        String imagen = "im";
        ControladorProveedor instance = new ControladorProveedor();
        instance.ingresarImagen(imagen);
    }

    /**
     * Test of verInfoPromocion method, of class ControladorProveedor.
     * 
     */
    @Test
    public void testVerInfoPromocion() {
        System.out.println("verInfoPromocion");
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname13", "nombre", "apellido", "email13", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar promociones por proveedor");
        }
        String nombre = "vuelo123456";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname13";
        testIngresarNombreCategoria2("transporte13");
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        List<String> serv = new ArrayList<>();
        for(int i = 50; i<=60; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte13");
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
            serv.add(Integer.toString(n));
        }
        try{
            instance.altaPromocion(proveedor, serv, "promo", 10);
        }catch(Exception ex){}
        DataInfoPromocion result = instance.verInfoPromocion("nickname13", "promo");
        assertEquals("promo", result.getNombre());
        assertEquals(10, result.getDescuento());
        //assertEquals(, result.getPrecioTotal());
        //assertEquals(promocion.getNombre(), result.getNombre());
        //faltan chequeos
    }
    /*
    /**
     * Test of altaCliente method, of class ControladorCliente.
     */
    /*@Test
    public void testAltaCliente() throws Exception {
        System.out.println("altaCliente");
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente("111", "nombre", "apellido", "email34", new Date(1,1,2013), "imagen");
    }*//*
    public void testAltaCliente2(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) throws Exception {
        System.out.println("altaCliente");
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente(nickname, nombre, apellido, email, fechaNac, imagen);
        // TODO review the generated test code and remove the default call to fail.
        
        //fail("The test case is a prototype.");
    }*/
    /**
     * Test of listarClientes method, of class ControladorCliente.
     */
    @Test
    public void testListarClientes() {
/*        System.out.println("listarClientes");
        ControladorCliente instance = new ControladorCliente();
        try{
            for (int i=70; i<=80; ++i){
                int n = i;
                instance.altaCliente(Integer.toString(n), "giovani", "rondan", Integer.toString(n), new Date(4, 4, 2015), "im");
            }
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        List<DataCliente> result = instance.listarClientes();
        DataCliente dt;
        
        for(int j = 0; j <=10;++j){
          
//            assertEquals(Integer.toString(j+70), result.get(j).getNickname());
            assertEquals("giovani", result.get(j).getNombre());
            assertEquals("rondan", result.get(j).getApellido());
            assertEquals(Integer.toString(j+70), result.get(j).getEmail());
            assertEquals(new Date(4,4,2015), result.get(j).getFechaNac());
            assertEquals("im", result.get(j).getImagen());
            
            
        }
  */      
    }
    
    /**
     * Test of verInfoCliente method, of class ControladorCliente.
     * @throws java.lang.Exception
     */
    @Test
    public void testVerInfoCliente() throws Exception {
        System.out.println("verInfoCliente");
        ControladorCliente instance = new ControladorCliente();
        try{
            
                
                instance.altaCliente("infocliente", "giovani2", "rondan2", "infocliente", new Date(4, 4, 2015), "im2");
            
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        DataInfoCliente result = instance.verInfoCliente("infocliente");
        assertEquals("infocliente", result.getNickname());
        assertEquals("giovani2", result.getNombre());
        assertEquals("rondan2", result.getApellido());
        assertEquals(new Date(4,4,2015), result.getFechaNac());
        assertEquals("im2", result.getImagen());
        //assertEquals(, result.getReservas());
    }
/**
     * Test of realizarReserva method, of class ControladorCliente.
     */
   /*@Test
    public void testRealizarReserva(String proveedor, String cliente, String servicio, int cantidad, Date fechaInicio, Date fechaFin, boolean esServicio) {
        System.out.println("realizarReserva");
        ControladorCliente instance = new ControladorCliente();
        instance.realizarReserva(proveedor, cliente, servicio, cantidad, fechaInicio, fechaFin, esServicio);
        
    }*/
    /*
    public void testRealizarReserva2(String proveedor, String cliente, String servicio, int cantidad, Date fechaInicio, Date fechaFin, boolean esServicio) throws Exception {
        System.out.println("realizarReserva");
        ControladorCliente instance = new ControladorCliente();
        try{
            instance.altaCliente("infocliente", "giovani2", "rondan2", "infocliente", new Date(4, 4, 2015), "im2");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname11111", "nombre", "apellido", "email11111", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname11111";
        testIngresarNombreCategoria2("transporte2222");
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte2222");
        instance.altaServicio("amodificar", descripcion, precio, origen, proveedor,"0");
        
        cp.altaProveedor(proveedor, "nompr", "appr", "emailpro", new Date(1,1,2014), "impr", "nomemp", "linkemp");
        cp.altaServicio(servicio, "desc", 10, "montevideo", proveedor, "uruguay");
        Map<Integer, String> serv = new HashMap();
        Map<Integer, String> prom = new HashMap();
        
        serv.put(1,servicio);
        
        instance.realizarReserva(proveedor, cliente, serv, prom , fechaInicio, fechaFin);
        
    }*/
        /**
     * Test of actualizarEstadoReserva method, of class ControladorCliente.
     * @param id
     * @param nomCliente
     * @param estado
     */
    /*@Test
    public void testActualizarEstadoReserva2(int id, String nomCliente, Estado estado) {
        System.out.println("actualizarEstadoReserva");
        ControladorCliente instance = new ControladorCliente();
        instance.actualizarEstadoReserva(id, nomCliente, estado);
    }*/
    


    /**
     * Test of listarReservasXCliente method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasXCliente() {
        System.out.println("listarReservasXCliente");
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli12", "giovani2", "rondan2", "cli12", new Date(4, 4, 2015), "im2");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname23", "nombre", "apellido", "email23", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname23";
        testIngresarNombreCategoria2("transporte23456");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte23456");
        instancepr.altaServicio("hola", descripcion, precio, origen, proveedor,"0");
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        for(int i = 1; i < 11; ++i){
            
            instance.realizarReserva(proveedor, "cli12", serv, new HashMap(), es, es2, new Date(1,2,2013));
            
        }
        List<DataReserva> result = instance.listarReservasXCliente("cli12");
        for(int j=0;j<10;++j){
            id++;
            assertEquals(id, result.get(j).getId());
            
        }
        
    }

    /**
     * Test of listarReservasSistema method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasSistema() {
        System.out.println("listarReservasSistema");
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli123", "giovani2", "rondan2", "cli123", new Date(4, 4, 2015), "im2");
            instance.altaCliente("cli1234", "giovani2", "rondan2", "cli1234", new Date(4, 4, 2015), "im2");
        
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname34", "nombre", "apellido", "email34", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        instancepr.altaProveedor("nickname45", "nombre", "apellido", "email45", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor1 = "nickname34";
        
        testIngresarNombreCategoria2("transporte12345");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte12345");
        instancepr.altaServicio("hola1", descripcion, precio, origen, proveedor1,"0");
        
        //instancepr.altaServicio("hola2", descripcion, precio, origen, proveedor2,"0");
        Map<String, Integer> serv = new HashMap();
        serv.put("hola1",2 );
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola1", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola1", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        for(int i = 1; i < 11; ++i){
            
            instance.realizarReserva(proveedor1, "cli123", serv, new HashMap(), es, es2, new Date(1,2,2013));
            
            //instance.realizarReserva(proveedor1, "cli1234", serv, new HashMap(), new Date(1,2,2013), new Date(1,3,213));
        }
        List<DataReserva> result = instance.listarReservasSistema();
        int aux = id;
        
        for(int j= aux;j<(aux +10); ++j){
            id++;
            assertEquals(id, result.get(j).getId());
        }
        
    }
    /**
     * Test of verInfoReserva method, of class ControladorCliente.
     * @throws java.lang.Exception
     */
    @Test
    public void testVerInfoReserva() throws Exception {
        System.out.println("verInfoReserva");
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli123456", "giovani2", "rondan2", "cli123456", new Date(4, 4, 2015), "im2");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname78", "nombre", "apellido", "email78", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname78";
        testIngresarNombreCategoria2("transporte2222");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte2222");
        instancepr.altaServicio("hola", descripcion, precio, origen, proveedor,"0");
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        instance.realizarReserva(proveedor, "cli123456", serv, new HashMap(), es, es2, new Date(1,2,2013));
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        
        DataInfoReserva result = instance.verInfoReserva("cli123456", id);
        assertEquals(Estado.registrada, result.getEstado());
        //assertEquals(10, result.getPrecio());
        assertEquals(id, result.getId());
        //assertEquals(new Date(1,2,2013), result.getFechaInicio());
        //assertEquals(new Date(1,3,213), result.getFechaFin());
        /*assertEquals(, result);
        assertEquals(, result);*/
    }
    /**
     * Test of cancelarReserva method, of class ControladorCliente.
     */
    @Test
    public void testCancelarReserva2() {
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli12345678", "giovani2", "rondan2", "cli12345678", new Date(4, 4, 2015), "im2");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname89", "nombre", "apellido", "email89", new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nickname89";
        testIngresarNombreCategoria2("transporte2222");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte2222");
        instancepr.altaServicio("hola", descripcion, precio, origen, proveedor,"0");
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        instance.realizarReserva(proveedor, "cli12345678", serv, new HashMap(), es, es2, new Date(1,2,2013));
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        instance.cancelarReserva("cli12345678", id);
    }
    /**
     * Test of paises.
     */
    @Test
    public void testPaises(){
        ControladorProveedor cpr = new ControladorProveedor();
        try{
            cpr.altaPais("zambia");
        }catch(Exception ex){}
        Set <String> paises = cpr.infoPaises();
        if(paises.contains("zambia")){
            cpr.altaCiudad("lusaka", "zambia");
        }
        List<DataCiudad> result = cpr.ciudadesXpais("zambia");
        assertEquals("lusaka", result.get(0).getNombre());
    }
    /*
    * Test of actualizar reserva
    */
    @Test
    public void testActualizarReserva(){
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        String nickCliente = "actualizar";
        String nickProveedor = "actprov";
        try{
            instance.altaCliente(nickCliente, "gio", "rondan", nickCliente, new Date(4, 4, 2015), "im1");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
            instancepr.altaProveedor(nickProveedor, "nombre", "apellido", nickProveedor, new Date(2,2,2000), "imagen", "nomemp","linkemp");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "servPromo";
        String descripcion = "servicio de promocion";
        int precio = 10;
        String origen = "zimbawe";
        testIngresarNombreCategoria2("transporte2222");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte2222");
        instancepr.altaServicio("hola", descripcion, precio, origen, nickProveedor,"0");
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        instance.realizarReserva(nickProveedor, nickCliente, new HashMap(), serv, es2, es, new Date(1,2,2013));
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        instance.actualizarEstadoReserva(id, nickCliente, Estado.pagada);
        DataInfoReserva result = instance.verInfoReserva(nickCliente, id);
        assertEquals(Estado.pagada, result.getEstado());
        assertEquals(id, result.getId());
        assertEquals(new Date(1,2,2013),result.getFechaCreacion());
        //assertEquals(new Date(2,3,2013),result.getFechaFin());
    }
}
