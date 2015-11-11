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
     * Test of listarProveedores method, of class ControladorProveedor.
     */
    @Test
    public void testListarProveedores() {
        System.out.println("listarProveedores");
        ControladorProveedor cp = new ControladorProveedor();
        try{
            for (int i=1; i<=10; ++i){
                int n = i;
                cp.altaProveedor(Integer.toString(n), "giovani", "rondan", Integer.toString(n), new Date(i, i, 2015), "imagen","url","link","hola");
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
    public void testIngresarCategoriaServicio2(String categoria) {
        //System.out.println("ingresarCategoriaServicio");
        ControladorProveedor instance = new ControladorProveedor();
        
        try{
        instance.ingresarCategoriaServicio(categoria);
        }catch(Exception ex){}
    }

    /**
     * Test of listarServiciosXCategoria method, of class ControladorProveedor.
     */
    @Test
    public void testListarServiciosXCategoria() {
        System.out.println("listarServiciosXCategoria");
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nicknamesercat", "nombre", "apellido", "emailsercat", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por categoria");
        }
        String nombre = "vuelo123";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "cardona";
        String proveedor = "nicknamesercat";
        String nomcat = "turismotren";
        instance.ingresarNombreCategoria(nomcat);
        try{
        instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2(nomcat);
        for(int i = 1; i<=10; i++){
            int n = i;
            testIngresarCategoriaServicio2(nomcat);
            try{
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"uruguay");
            }catch(Exception ex){}
        }
        List<DataServicio> result = instance.listarServiciosXCategoria(nomcat);
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
        instance.altaProveedor("nickname111", "nombre", "apellido", "email111", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en listar servicios por proveedor");
        }
        try{
        instance.altaProveedor("nickname1111", "nombre", "apellido", "email1111", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
            try{
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
            }catch(Exception ex){}
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
        List<String> ser = new ArrayList<String>();
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
        instance.altaProveedor("nickname11111", "nombre", "apellido", "email11111", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
            instance.altaCiudad("origenmodificado","prueba");
            instance.altaCiudad("4","prueba");
            instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        
        testIngresarNombreCategoria2("catmodificada");
        try{
            instance.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        try{
        instance.ingresarCategoriaServicio("transporte2222");
        }catch(Exception ex){}
        instance.ingresarImagenServicio("imser");
        try{
        instance.altaServicio("amodificar", descripcion, precio, origen, proveedor,"0");
        }catch(Exception ex){}
//DataInfoServicio result2 = instance.verInfoServicio("amodificar", proveedor);
        testSeleccionarServicio("amodificar");
        testIngresarDescripcionServicio("modificado");
        instance.ingresarImagenBorrarServicio("imser");
        instance.ingresarModificarImagenServicio("modificada");
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
        DataInfoServicio result = null;
        try{
         result = instance.verInfoServicio("amodificar", proveedor);
        }catch(Exception ex){}
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
            instance.altaProveedor("nickname6", "nombre", "apellido", "email6", new Date(2,2,2000), "imagen","url","link","hola");
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
        instance.altaProveedor("nickname111111", "nombre", "apellido", "email111111", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        List<String> serv = new ArrayList<String>();
        for(int i = 50; i<=60; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte2222222");
            try{
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
            }catch(Exception ex){}
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
            assertEquals(99, result.get(j).getPrecioTotal(),0);//preciototal = 10*11-(10*11/10)
        }
        DataInfoPromocion infprom = instance.verInfoPromocion(proveedor, "71");
        assertEquals("71", infprom.getNombre());
        assertEquals(99, infprom.getPrecioTotal());//preciototal = 10*11-(10*11/10)
        assertEquals(10, infprom.getDescuento());
    }

    /**
     * Test of verInfoProveedor method, of class ControladorProveedor.
     */
    @Test
    public void testVerInfoProveedor() {
        System.out.println("verInfoProveedor");
        String nomProveedor = "";
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname11111111", "nombre", "apellido", "email11111111", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
     * Test of verInfoPromocion method, of class ControladorProveedor.
     * 
     */
    @Test
    public void testVerInfoPromocion() {
        System.out.println("verInfoPromocion");
        ControladorProveedor instance = new ControladorProveedor();
        try{
        instance.altaProveedor("nickname13", "nombre", "apellido", "email13", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        List<String> serv = new ArrayList<String>();
        for(int i = 50; i<=60; i++){
            int n = i;
            testIngresarCategoriaServicio2("transporte13");
            try{
            instance.altaServicio(Integer.toString(n), descripcion, precio, origen, proveedor,"0");
            }catch(Exception ex){}
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
    
    /**
     * Test of verInfoCliente method, of class ControladorCliente.
     * @throws java.lang.Exception
     */
    @Test
    public void testVerInfoCliente() throws Exception {
        System.out.println("verInfoCliente");
        ControladorCliente instance = new ControladorCliente();
        try{
            
                
                instance.altaCliente("infocliente", "giovani2", "rondan2", "infocliente", new Date(4, 4, 2015), "im2","hola");
            
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
     * Test of listarReservasXCliente method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasXCliente() {
        System.out.println("listarReservasXCliente");
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli12", "giovani2", "rondan2", "cli12", new Date(4, 4, 2015), "im2","hola");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname23", "nombre", "apellido", "email23", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        try{
        instancepr.altaServicio("hola", descripcion, precio, origen, proveedor,"0");
        }catch(Exception ex){}
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        for(int i = 1; i < 11; ++i){
            try{
            instance.realizarReserva(proveedor, "cli12", serv, new HashMap(), es, es2, new Date(1,2,2013));
            }catch(Exception ex){}
        }
        List<DataReserva> result = instance.listarReservasXCliente("cli12");
        for(int j=0;j<10;++j){
            id++;
            assertEquals(id, result.get(j).getId());
            
        }
        DataReserva dtr = result.get(0);
        assertEquals(Estado.registrada, dtr.getEstado());
        assertEquals(20, dtr.getPrecio(),0);
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
            instance.altaCliente("cli123", "giovani2", "rondan2", "cli123", new Date(4, 4, 2015), "im2","hola");
            instance.altaCliente("cli1234", "giovani2", "rondan2", "cli1234", new Date(4, 4, 2015), "im2","hola");
        
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname34", "nombre", "apellido", "email34", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
        instancepr.altaProveedor("nickname45", "nombre", "apellido", "email45", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        try{
        instancepr.altaServicio("hola1", descripcion, precio, origen, proveedor1,"0");
        }catch(Exception ex){}
        Map<String, Integer> serv = new HashMap();
        serv.put("hola1",2 );
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola1", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola1", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        for(int i = 1; i < 11; ++i){
            try{
            instance.realizarReserva(proveedor1, "cli123", serv, new HashMap(), es, es2, new Date(1,2,2013));    
            }catch(Exception ex){}
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
            instance.altaCliente("cli123456", "giovani2", "rondan2", "cli123456", new Date(4, 4, 2015), "im2","hola");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname78", "nombre", "apellido", "email78", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        assertEquals(20, result.getPrecio(),0);
        assertEquals(id, result.getId());
        assertEquals(new Date(1,2,2013), result.getFechaCreacion());
        
    }
    /**
     * Test of cancelarReserva method, of class ControladorCliente.
     */
    @Test
    public void testCancelarReserva() {
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
            instance.altaCliente("cli12345678", "giovani2", "rondan2", "cli12345678", new Date(4, 4, 2015), "im2","hola");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
        instancepr.altaProveedor("nickname89", "nombre", "apellido", "email89", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
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
        try{
        instancepr.altaServicio("hola", descripcion, precio, origen, proveedor,"0");
        }catch(Exception ex){}
        Map<String, Integer> serv = new HashMap();
        serv.put("hola",2 );
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("hola", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        try{
        instance.realizarReserva(proveedor, "cli12345678", serv, new HashMap(), es, es2, new Date(1,2,2013));
        }catch(Exception ex){}
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        boolean dioalta = false;
        boolean cancelo = true;
        for(DataReserva it : instance.listarReservasXCliente("cli12345678")){
            if(it.getId()==id){
                dioalta = true;
            }
        }
        if(dioalta){
            instance.cancelarReserva("cli12345678", id);
            for(DataReserva it : instance.listarReservasXCliente("cli12345678")){
                if(it.getId()==id){
                    cancelo = false;
                }
            }
            if(cancelo)
                assertEquals("1","1");//cancelo correctamente
            else
                assertEquals("1","2");//agrego pero no cancelo
                
        }else
            assertEquals("1","3");//no agrego reserva
        
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
            instance.altaCliente(nickCliente, "gio", "rondan", nickCliente, new Date(4, 4, 2015), "im1","hola");
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        try{
            instancepr.altaProveedor(nickProveedor, "nombre", "apellido", nickProveedor, new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "servPromo";
        String descripcion = "servicio de promocion";
        int precio = 10;
        String origen = "zimbawe";
        testIngresarNombreCategoria2("transporte123");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte123");
        try{
        instancepr.altaServicio("hola", descripcion, precio, origen, nickProveedor,"0");
        }catch(Exception ex){}
        List<String> serProm = new ArrayList<String>();
        serProm.add("hola");
        try{
        instancepr.altaPromocion(nickProveedor, serProm, "promoprueba", 10);
        }catch(Exception ex){}
        Map<String, Integer> serv = new HashMap();
        serv.put("promoprueba",2 );
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put("promoprueba", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        es.put("promoprueba", new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        try{
        instance.realizarReserva(nickProveedor, nickCliente, new HashMap(), serv, es2, es, new Date(1,2,2013));
        }catch(Exception ex){}
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        instance.actualizarEstadoReserva(id, nickCliente, Estado.pagada);
        DataInfoReserva result = instance.verInfoReserva(nickCliente, id);
        assertEquals(Estado.pagada, result.getEstado());
        assertEquals(id, result.getId());
        assertEquals(new Date(1,2,2013),result.getFechaCreacion());
    }
    /*
    * Test of informacion servicio
    */
    @Test
    public void testInformacionServicio(){
        ControladorProveedor instancepr = new ControladorProveedor();
        try{
        instancepr.altaProveedor("nick78", "nombre", "apellido", "e78", new Date(2,2,2000), "imagen", "nomemp","linkemp","hola");
        }catch(Exception ex){
            System.out.println("throw alta proveedor en modificar servicio");
        }
        String nombre = "vuelo567";
        String descripcion = "cardona-montevideo en 5 minutos";
        int precio = 10;
        String origen = "fing";
        String proveedor = "nick78";
        testIngresarNombreCategoria2("transporte567");
        try{
        instancepr.altaCategoria();}
        catch(Exception ex){
            System.out.println("throw alta categoria en listar servicios por categoria");
        }
        testIngresarCategoriaServicio2("transporte567");
        instancepr.ingresarImagenServicio("imagenser");
        instancepr.ingresarDestinoServicio("destinoser");
        try{
        instancepr.altaServicio(nombre, descripcion, precio, origen, proveedor,"0");
        }catch(Exception ex){}
        DataServicio result = null;
        try{
            result = instancepr.informacionServicio(proveedor, nombre);
        }catch(Exception ex){}
        assertEquals(descripcion,result.getDescripcion());
        assertEquals("imagenser",result.getImagen()[0]);
        assertEquals(nombre,result.getNombre());
        assertEquals(precio,result.getPrecio(),0);
        assertEquals(proveedor,result.getProveedor());
        assertEquals(nombre + " - " + proveedor,result.toString());
    }
    
}
