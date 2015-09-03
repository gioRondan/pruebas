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
            // CLIENTES
            ICC.altaCliente("oWood" , "Oliver", "Wood", "quidditch28@gmail.com", toDate("28/12/1988"),PantallaPrincipal.RutaImagenes+"Usuarios/oWood.png");
            ICC.altaCliente("eWaston" , "Emma", "Watson", "e.watson@gmail.com", toDate("15/4/1990"),PantallaPrincipal.RutaImagenes+"Usuarios/eWaston.png");
            ICC.altaCliente("BruceS" , "Bruce", "Sewell", "bruce.sewell@gmail.com", toDate("3/12/1978"),"");
            ICC.altaCliente("JeffW" , "Jeff", "Wiliams", "jeff.williams@gmail.com", toDate("27/11/1984"),"");
            
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
