/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author matias.heredia
 */
public class Proveedor extends Usuario{
    private Empresa empresa;
    private Map<Integer, Reserva> reservas;     //<cliente<id,reserva>> un cliente puede tener varias reservas de un mismo proveedor
    private Map<String, Promocion> promociones;
    private Map<String, Servicio> servicios;
    
    public Proveedor(String nickname, String nombre, String apellido,String email, Date fechaNac, String imagen, String pasword){
       super(nickname,nombre,apellido,email,fechaNac,imagen, pasword);
       promociones =  new LinkedHashMap();
       servicios =  new LinkedHashMap();
       reservas = new LinkedHashMap();
    }

     
    public DataProveedor getDataProveedor(){
        return new DataProveedor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),this.getImagen() , this.empresa.getNombre(),this.empresa.getUrl(), this.getPassword());
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public List<DataServicio> getDataServicios(){
        List<DataServicio> dts =  new ArrayList<DataServicio>();
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return dts;
    }
    public Promocion getPromocion(String nomPromocion){
        return this.promociones.get(nomPromocion);
    }
    public List<DataPromocion> getDataPromociones(){
        List<DataPromocion> dts =  new ArrayList<DataPromocion>();
        for (Promocion value : promociones.values()){
            dts.add(value.getDataPromocion());
        }
        return dts;
    }
    public void asociarServicio(Servicio ser){
        this.servicios.put(ser.getNombre(), ser);
    }
    public void asociarPromocion(Promocion prom){
        this.promociones.put(prom.getNombre(), prom);
    }
    public Servicio getServicio(String nombre)throws Exception{
        if (servicios.containsKey(nombre))
            return servicios.get(nombre);
        else
            throw new Exception("El servicio seleccionado no pertenece al proveedor");
    
        
    }
    public void asociarEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public DataInfoProveedor getDataInfoProveedor() {
        return new DataInfoProveedor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),  this.getImagen(),  empresa.getDataEmpresa(), getDataServicios(), this.getPassword());
    }

    List<DataServicio> getServiciosBuscados(String aBuscar) {
        List<DataServicio> result = new ArrayList<>();
        for(Servicio value : servicios.values()){
            if(value.buscado(aBuscar)){
                result.add(value.getDataServicio());
            }
        }
        return result;
    }

    List<DataPromocion> getPromocionesBuscados(String aBuscar) {
        List<DataPromocion> result = new ArrayList<>();
        for(Promocion value : promociones.values()){
            if(value.buscado(aBuscar)){
                result.add(value.getDataPromocion());
            }
        }
        return result;
    }
    void addReserva(Integer id, Reserva reserva){
//        Map<Integer, Reserva> mapRes = this.reservas.get(nickCliente);
//        if(mapRes.isEmpty()){
//            mapRes = new LinkedHashMap();
//        }else{
//            this.reservas.remove(nickCliente);
//        }
//        mapRes.put(reserva.getId(), reserva);
        this.reservas.put(id, reserva);
    }
    List<DataInfoReserva> getDataReservas(){
        List<DataInfoReserva> result = new ArrayList<>();
        for(Reserva value : reservas.values()){
            result.add(value.getDataInfoReserva());
        }
        return result;
    }
    List<DataInfoReserva> getDataReservasXProveedor(String proveedor){
        List<DataInfoReserva> result = new ArrayList<>();
        for(Reserva value : reservas.values()){
            result.add(value.getDataInfoReservaXProveedor(proveedor));
        }
        return result;
    }
    void facturarReserva(Integer id) {
        Reserva res = this.reservas.get(id);
        res.facturar(this.nickname);
    }

}

