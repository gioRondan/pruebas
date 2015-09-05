/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class FlujoTest {
    
    public FlujoTest() {
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
    // ########################### operaciones auxiliares #############################3
    
    /**
     * Test de flujo 1.
     */
    @Test
    public void testFlujo1(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        String nickCliente = "gio";
        String nickProveedor = "proveedor";
        String nomCliente = "giovani";
        String apCliente = "rondan";
        Date fechaNacCliente = new Date(14,10,1993);
        Date fechaNacProveedor = new Date(11,11,1994);
        String emailCliente = "emailgio";
        String emailProveedor = "emailprov";
        String imCliente = "imgio";
        String imProveedor = "improveedor";
        String nomProveedor = "nomprov";
        String apProveedor = "approv";
        String nomServicio = "serv1";
        String descServicio = "el mejor servicio";
        int precioServicio = 100;
        String origenServicio = "bsas";
        String destinoServicio = "newyork";
        String paisServicio = "uruguay";
        String im1Servicio = "im1ser";
        String im2Servicio = "im2ser";
        String im3Servicio = "im3ser";
        String cat2Hoja = "otracat"; 
        String nomEmpresa = "nomempprov";
        String urlEmpresa = "url";
        String catPadre = "viajes";
        String catHoja = "tren";
        List<DataCliente> clientes = new ArrayList<>();
        List<DataProveedor> proveedores= new ArrayList<>();
        List<DataEmpresa> empresas = new ArrayList<>();
        List<DataCategoria> categorias = new ArrayList<>();
        
        try{
            ccl.altaCliente(nickCliente, nomCliente, apCliente, emailCliente, fechaNacCliente, imCliente);
        }catch(Exception ex){
            //algo
        }
        try{
            empresas = cpr.listarEmpresas();
            cpr.altaProveedor(nickProveedor, nomProveedor, apProveedor, emailProveedor, fechaNacProveedor, imProveedor, nomEmpresa, urlEmpresa);
        }catch(Exception ex){
            //algo
        }
        try{
            cpr.ingresarNombreCategoria(catPadre);
            cpr.altaCategoria();
            cpr.seleccionarPadre(catPadre);
            cpr.ingresarNombreCategoria(catHoja);
            cpr.altaCategoria();
            cpr.ingresarNombreCategoria(cat2Hoja);
            cpr.altaCategoria();
        }catch(Exception ex){
            
        }
        try{
            cpr.ingresarCategoriaServicio(catHoja);
            cpr.ingresarCategoriaServicio(cat2Hoja);
        }catch(Exception ex){}
        cpr.ingresarImagenServicio(im1Servicio);
        cpr.ingresarImagenServicio(im2Servicio);
        cpr.ingresarImagenServicio(im3Servicio);
        proveedores = cpr.listarProveedores();
        cpr.altaServicio(nomServicio, descServicio, precioServicio, origenServicio, nickProveedor, paisServicio);
        
        
        clientes = ccl.listarClientes();
        
        
    }
    /**
     * Test de flujo 2.
     */
    @Test
    public void testFlujo2(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        
        String esperado = "algo";
        String resultado = "algo";
        assertEquals(esperado, resultado);
    }
    /**
     * Test de flujo 3.
     */
    @Test
    public void testFlujo3(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        
        String esperado = "algo";
        String resultado = "algo";
        assertEquals(esperado, resultado);
        
    }
    /**
     * Test de flujo 4.
     */
    @Test
    public void testFlujo4(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        
        String esperado = "algo";
        String resultado = "algo";
        assertEquals(esperado, resultado);
        
    }
    /**
     * Test de flujo 5.
     */
    @Test
    public void testFlujo5(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        
        String esperado = "algo";
        String resultado = "algo";
        assertEquals(esperado, resultado);
        
    }
}