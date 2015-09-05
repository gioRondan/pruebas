/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

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
    /**
     * Test de flujo 1.
     */
    @Test
    public void testFlujo1(){
        Fabrica fabrica = Fabrica.getInstance();
        IControladorProveedor cpr = fabrica.getIControladorProveedor();
        IControladorCliente ccl = fabrica.getIControladorCliente();
        
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
