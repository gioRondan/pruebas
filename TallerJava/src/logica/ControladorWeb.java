/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author giovani.rondan
 */
public class ControladorWeb implements IControladorWeb {
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%      MEMORIA     %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    private Cliente cliente;
    private String nickname;
    private String email;
    private Map<String, Integer> cantServicios;
    private Map<String, Servicio> servicios;
    private Map<String, Integer> cantPromociones;
    private Map<String, Promocion> promociones;
    private Map<String, DataExpira> fechasServicios;
    private Map<String, DataExpira> fechasPromociones;
    
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    public ControladorWeb(){
        cliente = null;
        /*nickname ;
        email;*/
        cantServicios = new HashMap();
        servicios = new HashMap();
        cantPromociones = new HashMap();
        promociones = new HashMap();
        fechasServicios = new HashMap();
        fechasPromociones = new HashMap();
    }
        
    
    @Override
    public void iniciarSesion(String nickname, String password) throws Exception {
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        Cliente aux = mcl.getCliente(nickname);
        aux.verificarPassword(password);
        cliente = aux;
    }
/*
    @Override
    public void ingresarNickEmail(String nickname, String email)throws Exception {
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        mcl.unicidadEmail(email);
        mcl.unicidadNick(nickname);
        this.nickname = nickname;
        this.email = email;
    }

    @Override
    public void registrarCliente(String nombre, String apellido, Date fechaNac, String password) {
        
    }*/

    @Override
    public void cerrarSesion() {
        cliente = null;
        cantServicios = new HashMap();
        servicios = new HashMap();
        cantPromociones = new HashMap();
        promociones = new HashMap();
        fechasServicios = new HashMap();
        fechasPromociones = new HashMap();
    }

    @Override
    public void agregarServicioCarrito(String nickProveedor, String nomServicio) {
        
    }

    @Override
    public void agregarPromocionCarrito(String nickProveedor, String nomPromocion) {
        
    }
    
}
