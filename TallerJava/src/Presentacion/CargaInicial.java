/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Presentacion.PantallaPrincipal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Fabrica;
import logica.IControladorCliente;
import logica.IControladorProveedor;


/**
 *
 * @author Juan
 */

public class CargaInicial {
    Fabrica fab = Fabrica.getInstance();
    IControladorProveedor ICP = fab.getIControladorProveedor();
    private IControladorCliente ICC = fab.getIControladorCliente();

    public CargaInicial() {
     
        
    }

    
    public void cargar(){
         
        try {
             //PROVEEDORES Y SUS EMPRESAS
            ICP.altaProveedor("tCook","Tim", "Cook", "air.f@gmail.com",toDate("1/11/1960"), PantallaPrincipal.RutaImagenes+"Usuarios/tCook.png","AirFrance", "http://www.airfrance.com/");
            ICP.altaProveedor("moody","Alastor", "Moody", "eu.car@eucar.com",toDate("2/9/1965"), PantallaPrincipal.RutaImagenes+"Usuarios/moody.png","EuropCar", "http://www.europcar.com.uy/");
            ICP.altaProveedor("remus","Remus", "Lupin", "iberia@gmail.com",toDate("4/5/1970"), PantallaPrincipal.RutaImagenes+"Usuarios/remus.png","Iberia", "http://www.iberia.com/uy/");
            ICP.altaProveedor("adippet","Armando", "Dippet", "tam@outlook.com",toDate("12/2/1967"), PantallaPrincipal.RutaImagenes+"Usuarios/adippet.png","Tam", "http://www.tam.com.br/");
            ICP.altaProveedor("mHooch","Madam", "Hooch", "segHogar@gmail.com",toDate("5/8/1963"), PantallaPrincipal.RutaImagenes+"Usuarios/mHooch.png","Segundo Hogar", "http://www.segundohogar.com/");
            
            // CLIENTES
            ICC.altaCliente("oWood" , "Oliver", "Wood", "quidditch28@gmail.com", toDate("28/12/1988"),PantallaPrincipal.RutaImagenes+"Usuarios/oWood.png");
            ICC.altaCliente("eWaston" , "Emma", "Watson", "e.watson@gmail.com", toDate("15/4/1990"),PantallaPrincipal.RutaImagenes+"Usuarios/eWaston.png");
            ICC.altaCliente("BruceS" , "Bruce", "Sewell", "bruce.sewell@gmail.com", toDate("3/12/1978"),"");
            ICC.altaCliente("JeffW" , "Jeff", "Wiliams", "jeff.williams@gmail.com", toDate("27/11/1984"),"");
            //CATEGORIAS
                ICP.ingresarNombreCategoria("Vuelos");ICP.seleccionarPadre("");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Empresas");ICP.seleccionarPadre("Vuelos");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Iberia");ICP.seleccionarPadre("Empresas");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("American Airlines");ICP.seleccionarPadre("Empresas");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Air France");ICP.seleccionarPadre("Empresas");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("TAM");ICP.seleccionarPadre("Empresas");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Tipo vuelo");ICP.seleccionarPadre("Vuelos");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("LowCost");ICP.seleccionarPadre("Tipo vuelo");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Standard");ICP.seleccionarPadre("Tipo vuelo");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("First Class");ICP.seleccionarPadre("Tipo vuelo");ICP.altaCategoria();
                ICP.ingresarNombreCategoria("Alojamientos");ICP.seleccionarPadre("");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Tipo alojamiento");ICP.seleccionarPadre("Alojamientos");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Hotel");ICP.seleccionarPadre("Tipo alojamiento");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Hostal");ICP.seleccionarPadre("Tipo alojamiento");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Apartamento");ICP.seleccionarPadre("Tipo alojamiento");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Casa");ICP.seleccionarPadre("Tipo alojamiento");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Ubicación");ICP.seleccionarPadre("Alojamientos");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Playa");ICP.seleccionarPadre("Ubicación");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Rural");ICP.seleccionarPadre("Ubicación");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Montaña");ICP.seleccionarPadre("Ubicación");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Habitaciones");ICP.seleccionarPadre("Alojamientos");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("1 ambiente");ICP.seleccionarPadre("Habitaciones");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("1 dormitorio");ICP.seleccionarPadre("Habitaciones");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("2 dormitorios");ICP.seleccionarPadre("Habitaciones");ICP.altaCategoria();
                ICP.ingresarNombreCategoria("Automóviles");ICP.seleccionarPadre("");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Tarifa");ICP.seleccionarPadre("Automóviles");ICP.altaCategoria();
                          ICP.ingresarNombreCategoria("Mini");ICP.seleccionarPadre("Tarifa");ICP.altaCategoria();
                          ICP.ingresarNombreCategoria("Económico");ICP.seleccionarPadre("Tarifa");ICP.altaCategoria();
//                        ICP.ingresarNombreCategoria("Standard");ICP.seleccionarPadre("Tarifa");ICP.altaCategoria();
                          ICP.ingresarNombreCategoria("Full");ICP.seleccionarPadre("Tarifa");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Tipo vehículo");ICP.seleccionarPadre("Automóviles");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Auto");ICP.seleccionarPadre("Tipo vehículo");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Camioneta");ICP.seleccionarPadre("Tipo vehículo");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Camión");ICP.seleccionarPadre("Tipo vehículo");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Moto");ICP.seleccionarPadre("Tipo vehículo");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Marca");ICP.seleccionarPadre("Automóviles");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Chevrolet");ICP.seleccionarPadre("Marca");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Peugeot");ICP.seleccionarPadre("Marca");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Daihatsu");ICP.seleccionarPadre("Marca");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Fiat");ICP.seleccionarPadre("Marca");ICP.altaCategoria();
                        ICP.ingresarNombreCategoria("Ford");ICP.seleccionarPadre("Marca");ICP.altaCategoria();
                ICP.ingresarNombreCategoria("Cruceros");ICP.seleccionarPadre("");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Mediterráneo");ICP.seleccionarPadre("Cruceros");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Mar Negro");ICP.seleccionarPadre("Cruceros");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Caribe");ICP.seleccionarPadre("Cruceros");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Nilo");ICP.seleccionarPadre("Cruceros");ICP.altaCategoria();
                    ICP.ingresarNombreCategoria("Alaska");ICP.seleccionarPadre("Cruceros");ICP.altaCategoria();
                                    
                    
                
            //SERVICIOS nombre, descripcion,precio,origen,proveedor,pais
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-S 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("Standard");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-S", "Vuelo con excelente atención y comodidad.", 1100, "Montevideo", "remus", "Uruguay");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-LC 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("LowCost");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-LC", "Vuelo con excelente atención y comodidad a un precio accesible.", 850, "Montevideo", "remus", "Uruguay");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-FC 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("First Class");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-FC", "Vuelo de primera clase. Excelente atención, comodidad y servicio.", 1300, "Montevideo", "remus", "Uruguay");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-1 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Económico");
                ICP.ingresarCategoriaServicio("Auto");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Car-1", "Euro-Car. Autos de buena calidad y comodidad. Versión Económica.", 300, "Madrid", "moody", "España");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-2 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Standard");
                ICP.ingresarCategoriaServicio("Auto");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Car-2", "Euro-Car. Autos de buena calidad y comodidad. Versión Standard.", 300, "Madrid", "moody", "España");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-3 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Full");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarCategoriaServicio("Camioneta");
                ICP.altaServicio("Euro-Car-3", "Euro-Car. Autos de buena calidad y comodidad. Una camioneta para toda la familia.", 300, "Valencia", "moody", "España");
                
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Casa para p4 BsAs 1.png" );
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Casa para p4 BsAs 2.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Casa");
                ICP.ingresarCategoriaServicio("2 dormitorios");
                ICP.altaServicio("Casa para p4 BsAs", "Esta hermosa casa, se encuentra ubicada en el corazón de Buenos Aires y ofrece una capacidad\n" +
"para cuatro personas. La propiedad cuenta con un dormitorio con dos camas simples, que pueden\n" +
"transformarse en una matrimonial y dos baños completos, que incluyen toallas.", 80, "Buenos Aires", "mHooch", "Argentina");
                
            //PROMOCIONES
                
        } catch (Exception ex) {
            Logger.getLogger(CargaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Date toDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date date =new Date();
        try {
            date = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }
}
