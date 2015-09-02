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
 * @author giovani.rondan
 */
public class CiudadTest {
    
    public CiudadTest() {
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
        try{
        instance.altaCategoria();}
        catch (Exception ex){}
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
        for(int i = 1; i<=10; ++i){
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
    
    /**
     * Test of altaCliente method, of class ControladorCliente.
     */
    @Test
    public void testAltaCliente() throws Exception {
        System.out.println("altaCliente");
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente("1", "nombre", "apellido", "email34", new Date(1,1,2013), "imagen");
    }
    public void testAltaCliente2(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen) throws Exception {
        System.out.println("altaCliente");
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente(nickname, nombre, apellido, email, fechaNac, imagen);
        // TODO review the generated test code and remove the default call to fail.
        
        //fail("The test case is a prototype.");
    }
    /**
     * Test of listarClientes method, of class ControladorCliente.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        try{
            for (int i=1; i<=10; ++i){
                int n = i;
                testAltaCliente2(Integer.toString(n), "giovani", "rondan", Integer.toString(n), new Date(i, i, 2015), "url");
            }
        }catch (Exception ex){
            System.out.println("throw alta cliente");
        }
        ControladorCliente instance = new ControladorCliente();
        String[] expResult ={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<DataCliente> result = instance.listarClientes();
        DataCliente dt;
        int j = 1;
        for(DataCliente it : result){
          
            assertEquals(Integer.toString(j), it.getNickname());
            j++;
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of verInfoCliente method, of class ControladorCliente.
     * @throws java.lang.Exception
     */
    @Test
    public void testVerInfoCliente() throws Exception {
        System.out.println("verInfoCliente");
        String nickname = "asd";
        String nomCliente = "NOM";
        String apellido = "AP";
        String email = "EMAIL";
        Date fechaNac = new Date(1,1,2015);
        String imagen = "imagen";
        testAltaCliente2(nickname, nomCliente, apellido, email, fechaNac, imagen);
        ControladorCliente instance = new ControladorCliente();
        DataInfoCliente result = instance.verInfoCliente(nickname);
        assertEquals(nickname, result.getNickname());
        assertEquals(nomCliente, result.getNombre());
        assertEquals(apellido, result.getApellido());
        assertEquals(fechaNac, result.getFechaNac());
        assertEquals(imagen, result.getImagen());
        //assertEquals(, result.getReservas());
    }
/**
     * Test of realizarReserva method, of class ControladorCliente.
     */
    @Test
    public void testRealizarReserva(/*String proveedor, String cliente, String servicio, int cantidad, Date fechaInicio, Date fechaFin, boolean esServicio*/) {
        /*System.out.println("realizarReserva");
        ControladorCliente instance = new ControladorCliente();
        instance.realizarReserva(proveedor, cliente, servicio, cantidad, fechaInicio, fechaFin, esServicio);
        */
    }
    
    public void testRealizarReserva2(String proveedor, String cliente, String servicio, int cantidad, Date fechaInicio, Date fechaFin, boolean esServicio) throws Exception {
        System.out.println("realizarReserva");
        ControladorCliente instance = new ControladorCliente();
        ControladorProveedor cp = new ControladorProveedor();
        testAltaCliente2(cliente, "nom", "ap", "emailo", new Date(1,1,2015),"im");
        cp.altaProveedor(proveedor, "nompr", "appr", "emailpro", new Date(1,1,2014), "impr", "nomemp", "linkemp");
        cp.altaServicio(servicio, "desc", 10, "montevideo", proveedor, "uruguay");
        
        instance.realizarReserva(proveedor, cliente, servicio, cantidad, fechaInicio, fechaFin, esServicio);
        
    }
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
        String nickname = "1";
        ControladorCliente instance = new ControladorCliente();
        Set<DataReserva> expResult = null;
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        for(int i = 1; i < 11; ++i){
        instance.realizarReserva("nickname", nickname, Integer.toString(i), 1, new Date(1,2,2013), new Date(1,3,213), true);
            
        }
        List<DataReserva> result = instance.listarReservasXCliente(nickname);
        for(int j=0;j<10;++j){
            id++;
            assertEquals(id, result.get(j).getId());
            
        }
        
    }

    /**
     * Test of listarReservasSistema method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasSistema() throws Exception {
        System.out.println("listarReservasSistema");
        String proveedor;
        String cliente;
        String servicio;
        int cantidad;
        Date fechaInicio;
        Date fechaFin;
        boolean esServicio;
        
        //testRealizarReserva(proveedor, cliente, servicio, cantidad, fechaInicio, fechaFin, esServicio);
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente("45", "cli2", "ap2", "email45", new Date(2,2,2013), "im45");
        instance.altaCliente("46", "cli2", "ap2", "email46", new Date(2,2,2013), "im46");
        
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        //id = (id-10);   //en listarreservasxcliente ya se agregaron 10 
        for(int i = 1; i < 11; ++i){
        instance.realizarReserva("nickname", "45", Integer.toString(i), 1, new Date(1,2,2013), new Date(1,3,213), true);
        }
        for(int i = 1; i < 11; ++i){
        instance.realizarReserva("nickname", "46", Integer.toString(i), 1, new Date(1,2,2013), new Date(1,3,213), true);    
        }
        List<DataReserva> result = instance.listarReservasSistema();
        /*for(int k= 0;k<10;++k){
        System.out.println(instance.listarReservasXCliente("45").get(k).getId());
        }*/
        for(int j= 10;j<30;++j){//ya habian 10 reservas ingresadas
            //System.out.println(result.get(j).getId());
            
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
        String nomCliente = "";
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        testRealizarReserva2("prov", "cli", "ser", 1, new Date(1,1,2014),new Date(2,1,2014), true);
        ControladorCliente instance = new ControladorCliente();
        DataInfoReserva expResult = null;
        int id = mcl.testGetId();
        DataInfoReserva result = instance.verInfoReserva("cli", (id));
        assertEquals(Estado.registrada, result.getEstado());
        //assertEquals(10, result.getPrecio());
        assertEquals(id, result.getId());
        /*assertEquals(, result);
        assertEquals(, result);*/
    }
    /**
     * Test of cancelarReserva method, of class ControladorCliente.
     */
    @Test
    public void testCancelarReserva2() {
        
        String nomCliente = "cli";
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        int id = mcl.testGetId();
        System.out.println("cancelarReserva");
        ControladorCliente instance = new ControladorCliente();
        instance.cancelarReserva(nomCliente, (id));
    }
}
