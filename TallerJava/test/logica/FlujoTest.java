/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
     * Test de flujo .
     */
    @Test
    public void testFlujo(){
//########################  variables   #######################################################
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
        String imModServicio = "immodser";
        String cat2Hoja = "otracat"; 
        String nomEmpresa = "nomempprov";
        String urlEmpresa = "url";
        String catPadre = "viajes";
        String catHoja = "tren";
        List<DataCliente> clientes = new ArrayList<>();
        List<DataProveedor> proveedores= new ArrayList<>();
        List<DataEmpresa> empresas = new ArrayList<>();
        List<DataCategoria> categorias = new ArrayList<>();
        List<DataCiudad> ciudades = new ArrayList<>();
        List<DataReserva> reservas = new ArrayList<>();
        boolean creoOrigen;
        int id;
//################################  altacliente     ##################################################
        try{
            ccl.altaCliente(nickCliente, nomCliente, apCliente, emailCliente, fechaNacCliente, imCliente);
        }catch(Exception ex){}
//################################  altaproveedor   ##################################################
        try{
            empresas = cpr.listarEmpresas();
            cpr.altaProveedor(nickProveedor, nomProveedor, apProveedor, emailProveedor, fechaNacProveedor, imProveedor, nomEmpresa, urlEmpresa);
        }catch(Exception ex){}
//###############################   altacategoria   ##################################################
       try{
            cpr.ingresarNombreCategoria(catPadre);
            cpr.altaCategoria();
            cpr.seleccionarPadre(catPadre);
            cpr.ingresarNombreCategoria(catHoja);
            cpr.altaCategoria();
            cpr.ingresarNombreCategoria(cat2Hoja);
            cpr.altaCategoria();
        }catch(Exception ex){}
//##############################    altaservicio    ###################################################
        try{
            cpr.ingresarCategoriaServicio(catHoja);
            cpr.ingresarCategoriaServicio(cat2Hoja);
        }catch(Exception ex){}
        cpr.ingresarImagenServicio(im1Servicio);
        cpr.ingresarImagenServicio(im2Servicio);
        cpr.ingresarImagenServicio(im3Servicio);
        try{
        cpr.altaServicio(nomServicio, descServicio, precioServicio, origenServicio, nickProveedor, paisServicio);
        }catch(Exception ex){}
//############################      altaReserva     #####################################################
        Map<String, Integer> serv = new HashMap();
        serv.put(nomServicio,2 );
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        Map<String, DataExpira> es = new HashMap();
        Map<String, DataExpira> es2 = new HashMap();
        es.put(nomServicio, new DataExpira(new Date(1,1,2013), new Date(2,3,2013)));
        try{
            ccl.realizarReserva(nickProveedor, nickCliente, serv, new HashMap(), es, es2, new Date(1,2,2013));
        }catch(Exception ex){}
        id = mcl.testGetId();
//###########################   chequeo de alta reserva     ###################################################
        reservas = ccl.listarReservasSistema();
        assertEquals(id,reservas.get(0).getId());
        assertEquals(precioServicio*2, reservas.get(0).getPrecio(),0);//la reserva tiene 2 servicios
        assertEquals(Estado.registrada, reservas.get(0).getEstado());
//###########################   modificar estado reserva    ###################################################
        ccl.actualizarEstadoReserva(id, nickCliente, Estado.pagada);
//###########################   chequeo estado reserva      ###################################################
        reservas = ccl.listarReservasSistema();
        assertEquals(Estado.pagada, reservas.get(0).getEstado());
//###########################   chequeo de alta servicio    ###################################################
        DataInfoServicio ser = null;
        try{
            ser = cpr.verInfoServicio(nomServicio, nickProveedor);
        }catch(Exception ex){}
        assertEquals(im1Servicio, ser.getImagen()[0]);
        assertEquals(im2Servicio, ser.getImagen()[1]);
        assertEquals(im3Servicio, ser.getImagen()[2]);
//############################  modificarservicio   ##############################################################
        cpr.ingresarImagenBorrarServicio(im2Servicio);
        cpr.ingresarImagenBorrarServicio(im1Servicio);
        cpr.seleccionarProveedor(nickProveedor);
        cpr.seleccionarServicio(nomServicio);
        cpr.ingresarModificarImagenServicio(imModServicio);
        try{
            cpr.modificarServicio(); //im3 pasa a pos [0] imMod se inserta en [1]
        }catch(Exception ex){}
//###########################   chequeo de modificar servicio   ################################################
        try{
            ser = cpr.verInfoServicio(nomServicio, nickProveedor);
        }catch(Exception ex){}
        assertEquals(im3Servicio, ser.getImagen()[0]);
        assertEquals(imModServicio, ser.getImagen()[1]);
//############################  chequeo de la ciudad origen del servicio    ####################################
        ciudades = cpr.listarCiudades();
        creoOrigen = false;
        for(DataCiudad it : ciudades){
            if(it.getNombre() == origenServicio){
                creoOrigen = true;
            }
        }
        if(!(creoOrigen )){ //si no creo origen falla test
            assertEquals("falloaltaciudad", "boom");
        }
        proveedores = cpr.listarProveedores();
//############################  chequeo del proveedor   ########################################################
        assertEquals(nickProveedor ,proveedores.get(0).getNickname());
        assertEquals(nomProveedor ,proveedores.get(0).getNombre());
        assertEquals(apProveedor ,proveedores.get(0).getApellido());
        assertEquals(emailProveedor ,proveedores.get(0).getEmail());
        assertEquals(fechaNacProveedor ,proveedores.get(0).getFechaNac());
        assertEquals(imProveedor ,proveedores.get(0).getImagen());
        assertEquals(nomEmpresa ,proveedores.get(0).getnombreEmpresa());
        assertEquals(urlEmpresa ,proveedores.get(0).getUrlEmpresa());
//############################  chequeo de las categorias   ####################################################
        categorias = cpr.listarCategorias();//la primer categoria ingresada es catPadre, catPadre tiene un solo hijo catHoja, cat2Hoja es el segundo elemento de categorias
        assertEquals(catPadre,categorias.get(0).getNombre());
        assertEquals(cat2Hoja,categorias.get(1).getNombre());
        assertEquals(catHoja,categorias.get(0).getHijos().get(0).getNombre());
//############################  chequeo del cliente     #########################################################
        clientes = ccl.listarClientes();
        assertEquals(nickCliente, clientes.get(0).getNickname());
        assertEquals(nomCliente, clientes.get(0).getNombre());
        assertEquals(apCliente, clientes.get(0).getApellido());
        assertEquals(emailCliente, clientes.get(0).getEmail());
        assertEquals(fechaNacCliente, clientes.get(0).getFechaNac());
        assertEquals(imCliente, clientes.get(0).getImagen());
        
    }
}
