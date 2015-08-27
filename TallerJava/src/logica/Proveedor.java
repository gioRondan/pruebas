/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.emptyMap;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author matias.heredia
 */
public class Proveedor extends Usuario{
    private Empresa empresa;
    private Map<String, Promocion> promociones;
    private Map<String, Servicio> servicios;
    
    public Proveedor(String nickname, String nombre, String apellido,String email, Date fechaNac, String imagen){
        super(nickname,nombre,apellido,email,fechaNac,imagen);
       promociones =  new HashMap();
       servicios =  new HashMap();
    }

     
    public DataProveedor getDataProveedor(){
        return new DataProveedor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac(),this.getImagen() , this.empresa.getNombre(),this.empresa.getUrl());
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public List<DataServicio> getDataServicios(){
        List<DataServicio> dts =  new ArrayList<>();
        for (Servicio value : servicios.values()){
            dts.add(value.getDataServicio());
        }
        return dts;
    }
    public Promocion getPromocion(String nomPromocion){
        return this.promociones.get(nomPromocion);
    }
    public List<DataPromocion> getDataPromociones(){
        List<DataPromocion> dts =  new ArrayList<>();
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
    public Servicio getServicio(String nombre){
        return servicios.get(nombre);
    }
    public void asociarEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public DataInfoProveedor getDataInfoProveedor() {
        return new DataInfoProveedor(nickname,  nombre,  apellido, email, fechaNac,  imagen,  empresa.getDataEmpresa(), getDataServicios());
    }
}

