/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author matias.heredia
 */
public class Proveedor extends Usuario{
    private String empresa;
    private String link_empresa;
    private Map<String, Servicio> servicios;
    
    public Proveedor(String nickname, String nombre, String apellido,String email, Date fechaNac, String url){
        super(nickname,nombre,apellido,email,fechaNac,url);
    }
    
    public void set_empresa(String emp){
        this.empresa=emp;
    }
    public void set_link_empresa(String url){
        this.link_empresa=url;
    }
    public DataProveedor getDataProveedor(){
        return new DataProveedor(this.getNombre(), this.getApellido(), this.getNickname(), this.empresa);
    }
    public Set<DataServicio> getDataServicios(){
        Set<DataServicio> dts = null;
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return dts;
    }
    public void asociarServicio(Servicio ser){
        this.servicios.put(ser.get_nombre(), ser);
    }
    public Servicio getServicio(String nombre){
        return servicios.get(nombre);
    }
}

