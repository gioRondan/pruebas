/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author giovani.rondan
 */
public class ControladorWeb implements IControladorWeb {
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%      MEMORIA     %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    private Cliente cliente;
    private Map<String, Integer> cantServicios;
    private Map<String, Servicio> servicios;
    private Map<String, Integer> cantPromociones;
    private Map<String, Promocion> promociones;
    private Map<String, DataExpira> fechasServicios;
    private Map<String, DataExpira> fechasPromociones;
    
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
    
    @Override
    public void iniciarSesion(String nickname, String password) throws Exception {
        
    }

    @Override
    public boolean ingresarNickEmail(String nickname, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarCliente(String nombre, String apellido, Date fechaNac, String password, String passwordVVerif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarServicioCarrito(String nickProveedor, String nomServicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarPromocionCarrito(String nickProveedor, String nomPromocion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
