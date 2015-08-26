/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

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
    
}
