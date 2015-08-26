/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;
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
public class ControladorClienteTest {
    
    public ControladorClienteTest() {
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
     * Test of actualizarEstadoReserva method, of class ControladorCliente.
     */
    @Test
    public void testActualizarEstadoReserva() {
        System.out.println("actualizarEstadoReserva");
        int id = 0;
        String nomCliente = "";
        Estado estado = null;
        ControladorCliente instance = new ControladorCliente();
        instance.actualizarEstadoReserva(id, nomCliente, estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarReserva method, of class ControladorCliente.
     */
    @Test
    public void testRealizarReserva() {
        System.out.println("realizarReserva");
        String proveedor = "";
        String cliente = "";
        String servicio = "";
        int cantidad = 0;
        Date fechaInicio = null;
        Date fechaFin = null;
        boolean esServicio = false;
        ControladorCliente instance = new ControladorCliente();
        instance.realizarReserva(proveedor, cliente, servicio, cantidad, fechaInicio, fechaFin, esServicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaCliente method, of class ControladorCliente.
     */
    @Test
    public void testAltaCliente() throws Exception {
        System.out.println("altaCliente");
        String nickname = "gio";
        String nombre = "giovani";
        String apellido = "rondan";
        String email = "grondan93@gmail.com";
        Date fechaNac = new Date(26, 8, 2015);
        String imagen = "url";
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
        ControladorCliente instance = new ControladorCliente();
        Set<DataCliente> expResult = null;
        Set<DataCliente> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarReserva method, of class ControladorCliente.
     */
    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        String nomCliente = "";
        int id = 0;
        ControladorCliente instance = new ControladorCliente();
        instance.cancelarReserva(nomCliente, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarReservasSistema method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasSistema() {
        System.out.println("listarReservasSistema");
        ControladorCliente instance = new ControladorCliente();
        Set<DataReserva> expResult = null;
        Set<DataReserva> result = instance.listarReservasSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarReservasXCliente method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasXCliente() {
        System.out.println("listarReservasXCliente");
        String nomCliente = "";
        ControladorCliente instance = new ControladorCliente();
        Set<DataReserva> expResult = null;
        Set<DataReserva> result = instance.listarReservasXCliente(nomCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verInfoReserva method, of class ControladorCliente.
     */
    @Test
    public void testVerInfoReserva() {
        System.out.println("verInfoReserva");
        String nomCliente = "";
        int id = 0;
        ControladorCliente instance = new ControladorCliente();
        DataInfoReserva expResult = null;
        DataInfoReserva result = instance.verInfoReserva(nomCliente, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verInfoCliente method, of class ControladorCliente.
     */
    @Test
    public void testVerInfoCliente() {
        System.out.println("verInfoCliente");
        String nomCliente = "";
        ControladorCliente instance = new ControladorCliente();
        DataInfoCliente expResult = null;
        DataInfoCliente result = instance.verInfoCliente(nomCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
