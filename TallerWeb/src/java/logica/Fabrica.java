/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Juan
 */
public class Fabrica {
    
    private static Fabrica instancia;
    
    private Fabrica(){};
    
    public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
    }
    
    public IControladorCliente getIControladorCliente() {
        IControladorCliente IG =  new ControladorCliente();
        return IG;
    }
    public IControladorProveedor getIControladorProveedor() {
        IControladorProveedor IG =  new ControladorProveedor();
        return IG;
    }
}
