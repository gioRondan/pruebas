/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Presentacion.PantallaPrincipal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import logica.DataExpira;
import logica.DataInfoCliente;
import logica.DataItemReserva;
import logica.DataPromocion;
import logica.DataReserva;
import logica.DataServicio;
import logica.Estado;
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
            ICP.altaProveedor("tCook","Tim", "Cook", "air.f@gmail.com",toDate("1/11/1960"), PantallaPrincipal.RutaImagenes+"Usuarios/tCook.png","AirFrance", "http://www.airfrance.com/","hola");
            ICP.altaProveedor("moody","Alastor", "Moody", "eu.car@eucar.com",toDate("2/9/1965"), PantallaPrincipal.RutaImagenes+"Usuarios/moody.png","EuropCar", "http://www.europcar.com.uy/","hola");
            ICP.altaProveedor("remus","Remus", "Lupin", "iberia@gmail.com",toDate("4/5/1970"), PantallaPrincipal.RutaImagenes+"Usuarios/remus.png","Iberia", "http://www.iberia.com/uy/","hola");
            ICP.altaProveedor("adippet","Armando", "Dippet", "tam@outlook.com",toDate("12/2/1967"), PantallaPrincipal.RutaImagenes+"Usuarios/adippet.png","Tam", "http://www.tam.com.br/","hola");
            ICP.altaProveedor("mHooch","Madam", "Hooch", "segHogar@gmail.com",toDate("5/8/1963"), PantallaPrincipal.RutaImagenes+"Usuarios/mHooch.png","Segundo Hogar", "http://www.segundohogar.com/","hola");
            
            // CLIENTES
            ICC.altaCliente("oWood" , "Oliver", "Wood", "quidditch28@gmail.com", toDate("28/12/1988"),PantallaPrincipal.RutaImagenes+"Usuarios/oWood.png","hola");
            ICC.altaCliente("eWaston" , "Emma", "Watson", "e.watson@gmail.com", toDate("15/4/1990"),PantallaPrincipal.RutaImagenes+"Usuarios/eWaston.png","hola");
            ICC.altaCliente("BruceS" , "Bruce", "Sewell", "bruce.sewell@gmail.com", toDate("3/12/1978"),"","hola");
            ICC.altaCliente("JeffW" , "Jeff", "Wiliams", "jeff.williams@gmail.com", toDate("27/11/1984"),"","hola");
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
             //PAISES                       
                    ICP.altaPais("Uruguay");
                    ICP.altaPais("Argentina");
                    ICP.altaPais("Colombia");
                    ICP.altaPais("EEUU");
                    ICP.altaPais("España");
                    ICP.altaPais("Francia");
                    ICP.altaPais("Alemania");
                    ICP.altaPais("Suiza");
                    ICP.altaPais("Australia");
                    ICP.altaPais("Brasil");    
                    ICP.altaPais("China");    
                                   
             //CIUDADES String nomCiudad, String nomPais)
                    ICP.altaCiudad("Montevideo", "Uruguay");
                    ICP.altaCiudad("Buenos Aires", "Argentina");
                    ICP.altaCiudad("Bogotá","Colombia");
                    ICP.altaCiudad("Miami","EEUU");
                    ICP.altaCiudad("Valencia","España");
                    ICP.altaCiudad("Madrid", "España");
                    ICP.altaCiudad("París","Francia");
                    ICP.altaCiudad("Berlín","Alemania");
                    ICP.altaCiudad("Ginebra","Suiza");
                    ICP.altaCiudad("Sidney","Australia");
                    ICP.altaCiudad("Pekín","China");
                    ICP.altaCiudad("Cantón", "China");
                    ICP.altaCiudad("Florianópolis", "Brasil");
                    ICP.altaCiudad("Bariloche","Argentina");
                    
            //SERVICIOS nombre, descripcion,precio,origen,proveedor,pais
                //S1
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-S 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("Standard");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-S", "Vuelo con excelente atención y comodidad.", 1100, "Montevideo", "remus", "Uruguay");
                //S2
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-LC 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("LowCost");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-LC", "Vuelo con excelente atención y comodidad a un precio accesible.", 850, "Montevideo", "remus", "Uruguay");
                //S3
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/remus - Euro-Vuelo-FC 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Iberia");
                ICP.ingresarCategoriaServicio("First Class");    
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Vuelo-FC", "Vuelo de primera clase. Excelente atención, comodidad y servicio.", 1300, "Montevideo", "remus", "Uruguay");
                //S4
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-1 1.png");
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Económico");
                ICP.ingresarCategoriaServicio("Auto");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Car-1", "Euro-Car. Autos de buena calidad y comodidad. Versión Económica.", 300, "Madrid", "moody", "España");
                //S5
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-2 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Standard");
                ICP.ingresarCategoriaServicio("Auto");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarDestinoServicio("Valencia");
                ICP.altaServicio("Euro-Car-2", "Euro-Car. Autos de buena calidad y comodidad. Versión Standard.", 300, "Madrid", "moody", "España");
                //S6
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/moody - Euro-Car-3 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Full");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.ingresarCategoriaServicio("Camioneta");
                ICP.altaServicio("Euro-Car-3", "Euro-Car. Autos de buena calidad y comodidad. Una camioneta para toda la familia.", 300, "Valencia", "moody", "España");
                //S7
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Casa para p4 BsAs 1.png" );
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Casa para p4 BsAs 2.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Casa");
                ICP.ingresarCategoriaServicio("2 dormitorios");
                ICP.altaServicio("Casa para p4 BsAs", "Esta hermosa casa, se encuentra ubicada en el corazón de Buenos Aires y ofrece una capacidad\n" +
"para cuatro personas. La propiedad cuenta con un dormitorio con dos camas simples, que pueden\n" +
"transformarse en una matrimonial y dos baños completos, que incluyen toallas.", 80, "Buenos Aires", "mHooch", "Argentina");
                //S8
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Floripa G. House 1.png" );
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Floripa G. House 2.png" );
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Floripa G. House 3.png");
                ICP.ingresarCategoriaServicio("Casa");
                ICP.ingresarCategoriaServicio("2 dormitorios");
                ICP.altaServicio("Floripa G. House", "Estamos a sólo unos pasos de un supermercado, restaurantes, cajero automático, gasolinera,\n" +
"farmacia, gimnasio, etc. Lagoa da Conceição es 7 km de nuestra casa de huéspedes y tarda sólo 10-\n" +
"15 minutos en el transporte público. Allí se encuentra una buena vida nocturna con bares y música\n" +
"en vivo", 190, "Florianópolis", "mHooch", "Brasil");
                //S9
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/tCook - Air-France-FC 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Air France");
                ICP.ingresarCategoriaServicio("First Class");
                ICP.ingresarDestinoServicio("Berlín");
                ICP.altaServicio("Air-France-FC", "¡Un vuelo de primera! Excelencia y experiencia en mejorar sus viajes.", 100, "París", "tCook", "Francia");
                //S10
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/adippet - TAM-FC 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("TAM");
                ICP.ingresarCategoriaServicio("First Class");
                ICP.ingresarDestinoServicio("Pekín");
                ICP.altaServicio("TAM-FC", "¡Un vuelo de primera! Excelencia y experiencia.", 150, "Florianópolis", "adippet", "Brasil");
                //S11
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Luxury south beach corner apartment 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Hotel");
                ICP.ingresarCategoriaServicio("Playa");
                ICP.ingresarCategoriaServicio("2 dormitorios");
                ICP.altaServicio("Luxury south beach corner apartment", "Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. Marble floor throughout,\n" +
"beautiful open kitchen, granite counter top, spacious dining room area and living room area.\n" +
"Spectacular views of Miami from all windows and balcony", 300, "Miami", "mHooch", "EEUU");
                //S12
                ICP.ingresarImagenServicio(PantallaPrincipal.RutaImagenes+"Servicios/mHooch - Coche-Miami 1.png" );
                ICP.ingresarImagenServicio("");
                ICP.ingresarImagenServicio("");
                ICP.ingresarCategoriaServicio("Económico");
                ICP.ingresarCategoriaServicio("Auto");
                ICP.ingresarCategoriaServicio("Chevrolet");
                ICP.altaServicio("Coche-Miami", "A useful car to travel around Miami", 360, "Miami", "mHooch", "EEUU");
      
            //PROMOCIONES nomProveedor, ser, nombre, descuento)
            List<String> ser = new ArrayList<>(); 
            //P1
            ser.add("Euro-Car-1");
            ser.add("Euro-Car-2");
            ICP.altaPromocion("moody", ser, "Euro-Cars-E-S", 30);
            ser.clear();
            //P2
            ser.add("Euro-Car-1");
            ser.add("Euro-Car-3");
            ICP.altaPromocion("moody", ser, "Euro-Cars-E-F", 30);
            ser.clear();
            //P3
            ser.add("Euro-Car-2");
            ser.add("Euro-Car-3");
            ICP.altaPromocion("moody", ser, "Euro-Cars-S-F", 30);
            ser.clear();
            //P4
            ser.add("Euro-Vuelo-S");
            ser.add("Euro-Vuelo-LC");
            ICP.altaPromocion("remus", ser, "Euro-Vuelos-S-LC", 40);
            ser.clear();
            //P5
            ser.add("Euro-Vuelo-S");
            ser.add("Euro-Vuelo-FC");
            ICP.altaPromocion("remus", ser, "Euro-Vuelos-S-FC", 40);
            ser.clear();
            //P6
            ser.add("Euro-Vuelo-LC");
            ser.add("Euro-Vuelo-FC");
            ICP.altaPromocion("remus", ser, "Euro-Vuelos-LC-FC", 40);
            ser.clear();
            //P7
            ser.add("Casa para p4 BsAs");
            ser.add("Floripa G. House");
            ICP.altaPromocion("mHooch", ser, "Sudamerica-Casas", 50);
            ser.clear();
            //P8
            ser.add("Luxury south beach corner apartment");
            ser.add("Coche-Miami");
            ICP.altaPromocion("mHooch", ser, "Miami-Viaje", 30);
            ser.clear();
            //RESERVAS proveedor,cliente,servicio, promocion, fechas 
            Map<String, Integer> servicio = new HashMap();
            Map<String, Integer> promocion = new HashMap();
            Map<String,DataExpira> fechass = new HashMap();
            Map<String,DataExpira> fechasp = new HashMap();
            //R1
            DataServicio dtser = new DataServicio( "Euro-Vuelo-S", "Vuelo con excelente atención y comodidad", 1100, null, "remus");
            DataItemReserva dtitem = new DataItemReserva(1, null, null, dtser, null, true, "remus", Estado.registrada);
            List<DataItemReserva> aux = new ArrayList<>();
            aux.add(dtitem);
            DataInfoCliente dtRemus = ICC.verInfoCliente("oWood");
            ICC.confirmarReserva(aux, dtRemus);
            //servicio.put("Euro-Vuelo-S",1);
            DataExpira f = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            /*fechass.put("Euro-Vuelo-S",f);
            ICC.realizarReserva("remus","oWood",servicio,promocion,fechass,fechasp,toDate("1/1/2015"));    
            ICC.actualizarEstadoReserva(1, "oWood", Estado.facturada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();*/
            //R2
            servicio.put("Euro-Vuelo-S",2);
            servicio.put("Euro-Vuelo-LC",1);
            f = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            fechass.put("Euro-Vuelo-S",f);
            f = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            fechass.put("Euro-Vuelo-LC",f);
            ICC.realizarReserva("remus","eWaston",servicio,promocion,fechass,fechasp,toDate("1/1/2015"));    
            ICC.actualizarEstadoReserva(2, "eWaston", Estado.cancelada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R3
            promocion.put("Sudamerica-Casas",1);
            f = new DataExpira(toDate("5/3/2015"),toDate("2/4/2015"));
            fechasp.put("Sudamerica-Casas",f);
            ICC.realizarReserva("mHooch","BruceS",servicio,promocion,fechass,fechasp,toDate("5/3/2015"));    
            ICC.actualizarEstadoReserva(3, "BruceS", Estado.pagada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R4
            servicio.put("Euro-Car-2",1);
            servicio.put("Euro-Car-3",1);
            f = new DataExpira(toDate("8/5/2015"),toDate("12/5/2015"));
            fechass.put("Euro-Car-2",f);
            f = new DataExpira(toDate("8/5/2015"),toDate("12/5/2015"));
            fechass.put("Euro-Car-3",f);
            ICC.realizarReserva("moody","JeffW",servicio,promocion,fechass,fechasp,toDate("8/5/2015"));    
            ICC.actualizarEstadoReserva(4, "JeffW", Estado.pagada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R5
            servicio.put("Air-France-FC",2);
            f = new DataExpira(toDate("7/8/2015"),toDate("10/8/2015"));
            fechass.put("Air-France-FC",f);
            ICC.realizarReserva("tCook","oWood",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            ICC.actualizarEstadoReserva(5, "oWood", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R6
            servicio.put("Casa para p4 BsAs",1);
            promocion.put("Miami-Viaje",1);
            f = new DataExpira(toDate("14/8/2015"),toDate("21/8/2015"));
            fechass.put("Casa para p4 BsAs",f);
            f = new DataExpira(toDate("7/8/2015"),toDate("14/8/2015"));
            fechasp.put("Miami-Viaje",f);
            ICC.realizarReserva("mHooch","eWaston",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            ICC.actualizarEstadoReserva(6, "eWaston", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R7
            servicio.put("Euro-Vuelo-LC",2);
            f = new DataExpira(toDate("7/8/2015"),toDate("7/8/2015"));
            fechass.put("Euro-Vuelo-LC",f);
            ICC.realizarReserva("remus","BruceS",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            ICC.actualizarEstadoReserva(7, "BruceS", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
                
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
