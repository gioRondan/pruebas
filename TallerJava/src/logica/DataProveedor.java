/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;


/**
 *
 * @author Juan
 */
public class DataProveedor {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;
    private String nombreEmpresa;
    private String urlEmpresa;
    
    
    //Constructores
    public DataProveedor(){
        this.nickname     = "";
        this.nombre       = "";
        this.apellido     = "";
        this.email        = "";
        this.fechaNac     = null;
        this.imagen       = "";
        this.nombreEmpresa= "";
        this.urlEmpresa   = "";
    }
    
    public DataProveedor(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmpresa, String urlEmpresa){
        this.nickname       = nickname;
        this.nombre         = nombre;
        this.apellido       = apellido;
        this.email          = email;
        this.fechaNac       = fechaNac;
        this.imagen         = imagen;
        this.nombreEmpresa  = nombreEmpresa;
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
    
    public String getnombreEmpresa(){
        return nombreEmpresa;
    }
    
    public String getUrlEmpresa(){
        return urlEmpresa;
    }
    
}
