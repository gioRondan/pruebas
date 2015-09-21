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

/**
 *
 * @author giovani.rondan
 */
public class ControladorWeb implements IControladorWeb {
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%      MEMORIA     %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    private Cliente cliente;
    private String nickname;
    private String email;
    private Map<String, Integer> cantServicios;     //servicio-cantidad
    private Map<String, Servicio> servicios;        //proveedor-servicio
    private Map<String, Integer> cantPromociones;   //promocion-cantidad
    private Map<String, Promocion> promociones;     //servicio-cantidad
    private Map<String, DataExpira> fechasServicios;    //servicio-fechas
    private Map<String, DataExpira> fechasPromociones;      //promocion-fechas
    
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
        if (aux == null){
            throw new Exception ("El nickname ingresado no es correcto");
        }
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
    public void agregarServicioCarrito(String nickProveedor, String nomServicio, Integer cantidad, Date fechaInicio, Date fechaFin) throws Exception{
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor proveedor = mpr.getProveedor(nickProveedor);
        Servicio servicio = proveedor.getServicio(nomServicio);
        cantServicios.put(nomServicio, cantidad);
        servicios.put(nickProveedor, servicio);
        fechasServicios.put(nomServicio, new DataExpira(fechaInicio, fechaFin));
    }

    @Override
    public void agregarPromocionCarrito(String nickProveedor, String nomPromocion, Integer cantidad, Date fechaInicio, Date fechaFin) {
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor proveedor = mpr.getProveedor(nickProveedor);
        Promocion promocion = proveedor.getPromocion(nomPromocion);
        cantPromociones.put(nomPromocion, cantidad);
        promociones.put(nickProveedor, promocion);
        fechasPromociones.put(nomPromocion, new DataExpira(fechaInicio, fechaFin));
    }
    
    @Override
    public void confirmarReserva(){
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        int clave1 = mcli.getUltimoid();
        Reserva res = new Reserva(clave1,new Date(), new Date(), new Date(),0,Estado.registrada);
        cliente.addReserva(res.getId(),res);
        float preciototal=0;
        for(Map.Entry<String, Servicio> entries : servicios.entrySet()){
            cliente.reservarServicio(clave1, entries.getValue(),cantServicios.get(entries.getKey()), fechasServicios.get(entries.getKey()).getFechai(), fechasServicios.get(entries.getKey()).getFechaf());
            preciototal= preciototal + entries.getValue().getPrecio()*cantServicios.get(entries.getKey());
        }
        for(Map.Entry<String, Promocion> entries : promociones.entrySet()){
            cliente.reservarPromocion(clave1, entries.getValue(),cantPromociones.get(entries.getKey()), fechasPromociones.get(entries.getKey()).getFechai(), fechasPromociones.get(entries.getKey()).getFechaf());
            preciototal= preciototal + entries.getValue().getPrecioTotal()*cantPromociones.get(entries.getKey());
        }
        res.setPrecio(preciototal);
        cantServicios = new HashMap();
        servicios = new HashMap();
        cantPromociones = new HashMap();
        promociones = new HashMap();
        fechasServicios = new HashMap();
        fechasPromociones = new HashMap();
    }

    @Override
    public List<DataServicio> serviciosCarrito() {
        List<DataServicio> dts = new ArrayList<>();
        for(Map.Entry<String, Servicio> entries : servicios.entrySet()){
            dts.add(entries.getValue().getDataServicio());
        }
        return dts;
    }

    @Override
    public List<DataPromocion> promocionesCarrito() {
        List<DataPromocion> dts = new ArrayList<>();
        for(Map.Entry<String, Promocion> entries : promociones.entrySet()){
            dts.add(entries.getValue().getDataPromocion());
        }
        return dts;
    }
    
}
