/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

/**
 *
 * @author matias.heredia
 */
public class Proveedor extends Usuario{
    private Empresa empresa;
    private Map<String, Promocion> promociones;
    private Map<String, Servicio> servicios;
    
    public Proveedor(String nickname, String nombre, String apellido,String email, Date fechaNac, String url){
        super(nickname,nombre,apellido,email,fechaNac,url);
    }

     
    public DataProveedor getDataProveedor(){
        return new DataProveedor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),this.getImagen() , this.empresa.getNombre(),this.empresa.getUrl());
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public Set<DataServicio> getDataServicios(){
        Set<DataServicio> dts = Collections.EMPTY_SET;
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return dts;
    }
    public Promocion getPromocion(String nomPromocion){
        return this.promociones.get(nomPromocion);
    }
    public Set<DataPromocion> getDataPromociones(){
        Set<DataPromocion> dts = Collections.EMPTY_SET;
        for (Promocion value : promociones.values()){
            dts.add(value.getDataPromocion());
        }
        return dts;
    }
    public void asociarServicio(Servicio ser){
        this.servicios.put(ser.getNombre(), ser);
    }
    public Servicio getServicio(String nombre){
        return servicios.get(nombre);
    }
}

