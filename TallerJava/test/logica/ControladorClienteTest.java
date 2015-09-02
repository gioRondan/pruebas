/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;
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
     * Test of altaCliente method, of class ControladorCliente.
     */
    @Test
    public void testAltaCliente() throws Exception {
        /*System.out.println("altaCliente");
        ControladorCliente instance = new ControladorCliente();
        instance.altaCliente(nickname, nombre, apellido, email, fechaNac, imagen);*/
        // TODO review the generated test code and remove the default call to fail.
        
        //fail("The test case is a prototype.");
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
    
    public void testRealizarReserva2(String proveedor, String cliente, String servicio, int cantidad, Date fechaInicio, Date fechaFin, boolean esServicio) {
        System.out.println("realizarReserva");
        ControladorCliente instance = new ControladorCliente();
        
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
     * Test of cancelarReserva method, of class ControladorCliente.
     * @param nomCliente
     * @param id
     */
    @Test
    public void testCancelarReserva2() {
        
        String nomCliente = "";
        int id= 1;
        System.out.println("cancelarReserva");
        ControladorCliente instance = new ControladorCliente();
        instance.cancelarReserva(nomCliente, id);
    }

    /**
     * Test of listarReservasSistema method, of class ControladorCliente.
     */
    @Test
    public void testListarReservasSistema() {
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
        Set<DataReserva> expResult = null;
        List<DataReserva> result = instance.listarReservasSistema();
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
        List<DataReserva> result = instance.listarReservasXCliente(nomCliente);
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

    
    
}
