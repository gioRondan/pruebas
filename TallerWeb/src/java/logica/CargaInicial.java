/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 *
 * @author Juan
 */

public class CargaInicial {
    private Fabrica fab = Fabrica.getInstance();
    private IControladorProveedor icp = fab.getIControladorProveedor();
    private IControladorCliente icc = fab.getIControladorCliente();
    private static String Ruta = "";
    
    public CargaInicial(){}
   
    public static String getRuta(){
        return Ruta;
    }
    public  void setRuta(String Ruta){
        this.Ruta = Ruta;
    }
    public void cargar() throws Exception{
         
             //Seteo la ruta por defecto 
             Ruta="C:/";
             //PROVEEDORES Y SUS EMPRESAS
            icp.altaProveedor("tCook","Tim", "Cook", "air.f@gmail.com",toDate("1/11/1960"),  Ruta+"/Imagenes/Usuarios/tCook.png","AirFrance", "http://www.airfrance.com/","hola");
            icp.altaProveedor("moody","Alastor", "Moody", "eu.car@eucar.com",toDate("2/9/1965"), Ruta+"/Imagenes/Usuarios/moody.png","EuropCar", "http://www.europcar.com.uy/","hola");
            icp.altaProveedor("remus","Remus", "Lupin", "iberia@gmail.com",toDate("4/5/1970"), Ruta+"/Imagenes/Usuarios/remus.png","Iberia", "http://www.iberia.com/uy/","hola");
            icp.altaProveedor("adippet","Armando", "Dippet", "tam@outlook.com",toDate("12/2/1967"), Ruta+"/Imagenes/Usuarios/adippet.png","Tam", "http://www.tam.com.br/","hola");
            icp.altaProveedor("mHooch","Madam", "Hooch", "segHogar@gmail.com",toDate("5/8/1963"), Ruta+"/Imagenes/Usuarios/mHooch.png","Segundo Hogar", "http://www.segundohogar.com/","hola");
            
            // CLIENTES
            icc.altaCliente("oWood" , "Oliver", "Wood", "quidditch28@gmail.com", toDate("28/12/1988"),Ruta+"/Imagenes/Usuarios/oWood.png","hola");
            icc.altaCliente("eWaston" , "Emma", "Watson", "e.watson@gmail.com", toDate("15/4/1990"),Ruta+"/Imagenes/Usuarios/eWaston.png","hola");
            icc.altaCliente("BruceS" , "Bruce", "Sewell", "bruce.sewell@gmail.com", toDate("3/12/1978"),"","hola");
            icc.altaCliente("JeffW" , "Jeff", "Wiliams", "jeff.williams@gmail.com", toDate("27/11/1984"),"","hola");
            //CATEGORIAS
                icp.ingresarNombreCategoria("Vuelos");icp.seleccionarPadre("");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Empresas");icp.seleccionarPadre("Vuelos");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Iberia");icp.seleccionarPadre("Empresas");icp.altaCategoria();
                        icp.ingresarNombreCategoria("American Airlines");icp.seleccionarPadre("Empresas");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Air France");icp.seleccionarPadre("Empresas");icp.altaCategoria();
                        icp.ingresarNombreCategoria("TAM");icp.seleccionarPadre("Empresas");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Tipo vuelo");icp.seleccionarPadre("Vuelos");icp.altaCategoria();
                        icp.ingresarNombreCategoria("LowCost");icp.seleccionarPadre("Tipo vuelo");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Standard");icp.seleccionarPadre("Tipo vuelo");icp.altaCategoria();
                        icp.ingresarNombreCategoria("First Class");icp.seleccionarPadre("Tipo vuelo");icp.altaCategoria();
                icp.ingresarNombreCategoria("Alojamientos");icp.seleccionarPadre("");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Tipo alojamiento");icp.seleccionarPadre("Alojamientos");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Hotel");icp.seleccionarPadre("Tipo alojamiento");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Hostal");icp.seleccionarPadre("Tipo alojamiento");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Apartamento");icp.seleccionarPadre("Tipo alojamiento");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Casa");icp.seleccionarPadre("Tipo alojamiento");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Ubicación");icp.seleccionarPadre("Alojamientos");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Playa");icp.seleccionarPadre("Ubicación");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Rural");icp.seleccionarPadre("Ubicación");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Montaña");icp.seleccionarPadre("Ubicación");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Habitaciones");icp.seleccionarPadre("Alojamientos");icp.altaCategoria();
                        icp.ingresarNombreCategoria("1 ambiente");icp.seleccionarPadre("Habitaciones");icp.altaCategoria();
                        icp.ingresarNombreCategoria("1 dormitorio");icp.seleccionarPadre("Habitaciones");icp.altaCategoria();
                        icp.ingresarNombreCategoria("2 dormitorios");icp.seleccionarPadre("Habitaciones");icp.altaCategoria();
                icp.ingresarNombreCategoria("Automóviles");icp.seleccionarPadre("");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Tarifa");icp.seleccionarPadre("Automóviles");icp.altaCategoria();
                          icp.ingresarNombreCategoria("Mini");icp.seleccionarPadre("Tarifa");icp.altaCategoria();
                          icp.ingresarNombreCategoria("Económico");icp.seleccionarPadre("Tarifa");icp.altaCategoria();
//                        icp.ingresarNombreCategoria("Standard");icp.seleccionarPadre("Tarifa");icp.altaCategoria();
                          icp.ingresarNombreCategoria("Full");icp.seleccionarPadre("Tarifa");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Tipo vehículo");icp.seleccionarPadre("Automóviles");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Auto");icp.seleccionarPadre("Tipo vehículo");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Camioneta");icp.seleccionarPadre("Tipo vehículo");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Camión");icp.seleccionarPadre("Tipo vehículo");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Moto");icp.seleccionarPadre("Tipo vehículo");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Marca");icp.seleccionarPadre("Automóviles");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Chevrolet");icp.seleccionarPadre("Marca");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Peugeot");icp.seleccionarPadre("Marca");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Daihatsu");icp.seleccionarPadre("Marca");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Fiat");icp.seleccionarPadre("Marca");icp.altaCategoria();
                        icp.ingresarNombreCategoria("Ford");icp.seleccionarPadre("Marca");icp.altaCategoria();
                icp.ingresarNombreCategoria("Cruceros");icp.seleccionarPadre("");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Mediterráneo");icp.seleccionarPadre("Cruceros");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Mar Negro");icp.seleccionarPadre("Cruceros");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Caribe");icp.seleccionarPadre("Cruceros");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Nilo");icp.seleccionarPadre("Cruceros");icp.altaCategoria();
                    icp.ingresarNombreCategoria("Alaska");icp.seleccionarPadre("Cruceros");icp.altaCategoria();
             //PAISES                       
                    icp.altaPais("Uruguay");
                    icp.altaPais("Argentina");
                    icp.altaPais("Colombia");
                    icp.altaPais("EEUU");
                    icp.altaPais("España");
                    icp.altaPais("Francia");
                    icp.altaPais("Alemania");
                    icp.altaPais("Suiza");
                    icp.altaPais("Australia");
                    icp.altaPais("Brasil");    
                    icp.altaPais("China");    
                                   
             //CIUDADES String nomCiudad, String nomPais)
                    icp.altaCiudad("Montevideo", "Uruguay");
                    icp.altaCiudad("Buenos Aires", "Argentina");
                    icp.altaCiudad("Bogotá","Colombia");
                    icp.altaCiudad("Miami","EEUU");
                    icp.altaCiudad("Valencia","España");
                    icp.altaCiudad("Madrid", "España");
                    icp.altaCiudad("París","Francia");
                    icp.altaCiudad("Berlín","Alemania");
                    icp.altaCiudad("Ginebra","Suiza");
                    icp.altaCiudad("Sidney","Australia");
                    icp.altaCiudad("Pekín","China");
                    icp.altaCiudad("Cantón", "China");
                    icp.altaCiudad("Florianópolis", "Brasil");
                    icp.altaCiudad("Bariloche","Argentina");
                    
            //SERVICIOS nombre, descripcion,precio,origen,proveedor,pais
                //S1
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/remus - Euro-Vuelo-S 1.png");
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Iberia");
                icp.ingresarCategoriaServicio("Standard");    
                icp.ingresarDestinoServicio("Valencia");
                icp.altaServicio("Euro-Vuelo-S", "Vuelo con excelente atención y comodidad.", 1100, "Montevideo", "remus", "Uruguay");
                //S2
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/remus - Euro-Vuelo-LC 1.png");
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Iberia");
                icp.ingresarCategoriaServicio("LowCost");    
                icp.ingresarDestinoServicio("Valencia");
                icp.altaServicio("Euro-Vuelo-LC", "Vuelo con excelente atención y comodidad a un precio accesible.", 850, "Montevideo", "remus", "Uruguay");
                //S3
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/remus - Euro-Vuelo-FC 1.png");
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Iberia");
                icp.ingresarCategoriaServicio("First Class");    
                icp.ingresarDestinoServicio("Valencia");
                icp.altaServicio("Euro-Vuelo-FC", "Vuelo de primera clase. Excelente atención, comodidad y servicio.", 1300, "Montevideo", "remus", "Uruguay");
                //S4
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/moody - Euro-Car-1 1.png");
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Económico");
                icp.ingresarCategoriaServicio("Auto");
                icp.ingresarCategoriaServicio("Chevrolet");
                icp.ingresarDestinoServicio("Valencia");
                icp.altaServicio("Euro-Car-1", "Euro-Car. Autos de buena calidad y comodidad. Versión Económica.", 300, "Madrid", "moody", "España");
                //S5
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/moody - Euro-Car-2 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Standard");
                icp.ingresarCategoriaServicio("Auto");
                icp.ingresarCategoriaServicio("Chevrolet");
                icp.ingresarDestinoServicio("Valencia");
                icp.altaServicio("Euro-Car-2", "Euro-Car. Autos de buena calidad y comodidad. Versión Standard.", 300, "Madrid", "moody", "España");
                //S6
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/moody - Euro-Car-3 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Full");
                icp.ingresarCategoriaServicio("Chevrolet");
                icp.ingresarCategoriaServicio("Camioneta");
                icp.altaServicio("Euro-Car-3", "Euro-Car. Autos de buena calidad y comodidad. Una camioneta para toda la familia.", 300, "Valencia", "moody", "España");
                //S7
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Casa para p4 BsAs 1.png" );
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Casa para p4 BsAs 2.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Casa");
                icp.ingresarCategoriaServicio("2 dormitorios");
                icp.altaServicio("Casa para p4 BsAs", "Esta hermosa casa, se encuentra ubicada en el corazón de Buenos Aires y ofrece una capacidad\n" +
"para cuatro personas. La propiedad cuenta con un dormitorio con dos camas simples, que pueden\n" +
"transformarse en una matrimonial y dos baños completos, que incluyen toallas.", 80, "Buenos Aires", "mHooch", "Argentina");
                //S8
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Floripa G. House 1.png" );
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Floripa G. House 2.png" );
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Floripa G. House 3.png");
                icp.ingresarCategoriaServicio("Casa");
                icp.ingresarCategoriaServicio("2 dormitorios");
                icp.altaServicio("Floripa G. House", "Estamos a sólo unos pasos de un supermercado, restaurantes, cajero automático, gasolinera,\n" +
"farmacia, gimnasio, etc. Lagoa da Conceição es 7 km de nuestra casa de huéspedes y tarda sólo 10-\n" +
"15 minutos en el transporte público. Allí se encuentra una buena vida nocturna con bares y música\n" +
"en vivo", 190, "Florianópolis", "mHooch", "Brasil");
                //S9
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/tCook - Air-France-FC 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Air France");
                icp.ingresarCategoriaServicio("First Class");
                icp.ingresarDestinoServicio("Berlín");
                icp.altaServicio("Air-France-FC", "¡Un vuelo de primera! Excelencia y experiencia en mejorar sus viajes.", 100, "París", "tCook", "Francia");
                //S10
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/adippet - TAM-FC 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("TAM");
                icp.ingresarCategoriaServicio("First Class");
                icp.ingresarDestinoServicio("Pekín");
                icp.altaServicio("TAM-FC", "¡Un vuelo de primera! Excelencia y experiencia.", 150, "Florianópolis", "adippet", "Brasil");
                //S11
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Luxury south beach corner apartment 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Hotel");
                icp.ingresarCategoriaServicio("Playa");
                icp.ingresarCategoriaServicio("2 dormitorios");
                icp.altaServicio("Luxury south beach corner apartment", "Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. Marble floor throughout,\n" +
"beautiful open kitchen, granite counter top, spacious dining room area and living room area.\n" +
"Spectacular views of Miami from all windows and balcony", 300, "Miami", "mHooch", "EEUU");
                //S12
                icp.ingresarImagenServicio(Ruta+"/Imagenes/Servicios/mHooch - Coche-Miami 1.png" );
                icp.ingresarImagenServicio("");
                icp.ingresarImagenServicio("");
                icp.ingresarCategoriaServicio("Económico");
                icp.ingresarCategoriaServicio("Auto");
                icp.ingresarCategoriaServicio("Chevrolet");
                icp.altaServicio("Coche-Miami", "A useful car to travel around Miami", 360, "Miami", "mHooch", "EEUU");
      
            //PROMOCIONES nomProveedor, ser, nombre, descuento)
            List<String> ser = new ArrayList<String>(); 
            //P1
            ser.add("Euro-Car-1");
            ser.add("Euro-Car-2");
            icp.altaPromocion("moody", ser, "Euro-Cars-E-S", 30);
            ser.clear();
            //P2
            ser.add("Euro-Car-1");
            ser.add("Euro-Car-3");
            icp.altaPromocion("moody", ser, "Euro-Cars-E-F", 30);
            ser.clear();
            //P3
            ser.add("Euro-Car-2");
            ser.add("Euro-Car-3");
            icp.altaPromocion("moody", ser, "Euro-Cars-S-F", 30);
            ser.clear();
            //P4
            ser.add("Euro-Vuelo-S");
            ser.add("Euro-Vuelo-LC");
            icp.altaPromocion("remus", ser, "Euro-Vuelos-S-LC", 40);
            ser.clear();
            //P5
            ser.add("Euro-Vuelo-S");
            ser.add("Euro-Vuelo-FC");
            icp.altaPromocion("remus", ser, "Euro-Vuelos-S-FC", 40);
            ser.clear();
            //P6
            ser.add("Euro-Vuelo-LC");
            ser.add("Euro-Vuelo-FC");
            icp.altaPromocion("remus", ser, "Euro-Vuelos-LC-FC", 40);
            ser.clear();
            //P7
            ser.add("Casa para p4 BsAs");
            ser.add("Floripa G. House");
            icp.altaPromocion("mHooch", ser, "Sudamerica-Casas", 50);
            ser.clear();
            //P8
            ser.add("Luxury south beach corner apartment");
            ser.add("Coche-Miami");
            icp.altaPromocion("mHooch", ser, "Miami-Viaje", 30);
            ser.clear();
            //RESERVAS proveedor,cliente,servicio, promocion, fechas 
            Map<String, Integer> servicio = new HashMap();
            Map<String, Integer> promocion = new HashMap();
            Map<String,DataExpira> fechass = new HashMap();
            Map<String,DataExpira> fechasp = new HashMap();
            //R1
            servicio.put("Euro-Vuelo-S",1);
            DataExpira fecha = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            fechass.put("Euro-Vuelo-S",fecha);
            icc.realizarReserva("remus","oWood",servicio,promocion,fechass,fechasp,toDate("1/1/2015"));    
            icc.actualizarEstadoReserva(1, "oWood", Estado.facturada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R2
            servicio.put("Euro-Vuelo-S",2);
            servicio.put("Euro-Vuelo-LC",1);
            fecha = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            fechass.put("Euro-Vuelo-S",fecha);
            fecha = new DataExpira(toDate("1/1/2015"),toDate("1/1/2015"));
            fechass.put("Euro-Vuelo-LC",fecha);
            icc.realizarReserva("remus","eWaston",servicio,promocion,fechass,fechasp,toDate("1/1/2015"));    
            icc.actualizarEstadoReserva(2, "eWaston", Estado.cancelada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R3
            promocion.put("Sudamerica-Casas",1);
            fecha = new DataExpira(toDate("5/3/2015"),toDate("2/4/2015"));
            fechasp.put("Sudamerica-Casas",fecha);
            icc.realizarReserva("mHooch","BruceS",servicio,promocion,fechass,fechasp,toDate("5/3/2015"));    
            icc.actualizarEstadoReserva(3, "BruceS", Estado.pagada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R4
            servicio.put("Euro-Car-2",1);
            servicio.put("Euro-Car-3",1);
            fecha = new DataExpira(toDate("8/5/2015"),toDate("12/5/2015"));
            fechass.put("Euro-Car-2",fecha);
            fecha = new DataExpira(toDate("8/5/2015"),toDate("12/5/2015"));
            fechass.put("Euro-Car-3",fecha);
            icc.realizarReserva("moody","JeffW",servicio,promocion,fechass,fechasp,toDate("8/5/2015"));    
            icc.actualizarEstadoReserva(4, "JeffW", Estado.pagada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R5
            servicio.put("Air-France-FC",2);
            fecha = new DataExpira(toDate("7/8/2015"),toDate("10/8/2015"));
            fechass.put("Air-France-FC",fecha );
            icc.realizarReserva("tCook","oWood",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            icc.actualizarEstadoReserva(5, "oWood", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R6
            servicio.put("Casa para p4 BsAs",1);
            promocion.put("Miami-Viaje",1);
            fecha = new DataExpira(toDate("14/8/2015"),toDate("21/8/2015"));
            fechass.put("Casa para p4 BsAs",fecha );
            fecha = new DataExpira(toDate("7/8/2015"),toDate("14/8/2015"));
            fechasp.put("Miami-Viaje",fecha );
            icc.realizarReserva("mHooch","eWaston",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            icc.actualizarEstadoReserva(6, "eWaston", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
            //R7
            servicio.put("Euro-Vuelo-LC",2);
            fecha = new DataExpira(toDate("7/8/2015"),toDate("7/8/2015"));
            fechass.put("Euro-Vuelo-LC",fecha );
            icc.realizarReserva("remus","BruceS",servicio,promocion,fechass,fechasp,toDate("7/8/2015"));    
            icc.actualizarEstadoReserva(7, "BruceS", Estado.registrada);
            servicio.clear();
            promocion.clear();
            fechass.clear();
            fechasp.clear();
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
