/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author diego
 */
public class DataInfoProveedor {
    
    private final String nickname;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final Date fechaNac;
    private final String imagen;   
    private final DataEmpresa empresa;
    private final List<DataServicio> servicios;
    
    
    //Constructores
    public DataInfoProveedor(){
        this.nickname       = "";
        this.nombre         = "";
        this.apellido       = "";
        this.email          = "";
        this.fechaNac       =new Date();
        this.imagen         = "";
        this.empresa        = new DataEmpresa();
        this.servicios      = new HashSet();
    }
    
    public DataInfoProveedor(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, DataEmpresa empresa, List<DataServicio> servicios){
        this.nickname      = nickname;
        this.nombre        = nombre;
        this.apellido      = apellido;
        this.email         = email;
        this.fechaNac      = fechaNac;
        this.imagen        = imagen;
        this.empresa       = empresa;
        this.servicios     = servicios;
    }

    //Getters
    public String getNickname(){
        return nickname;
    }

    public String getNombre(){
        return nombre;
    }
        
    public String getApellido(){
        return apellido;
    }

    public String getEmail(){
        return email;
    }

    public Date getFechaNac(){
        return fechaNac;
    }

    public String getImagen() {
        return imagen;
    }
    
    public DataEmpresa getEmpresa(){
        return empresa;
    }
    
    public Set<DataServicio> getServicios(){
        return servicios;
    }
}
