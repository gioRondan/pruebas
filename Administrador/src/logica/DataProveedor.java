/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


/**
 *
 * @author Juan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProveedor {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;
    private String nombreEmpresa;
    private String urlEmpresa;
    private String password;
    
    
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
        this.password = "";
    }
    
    public DataProveedor(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String nombreEmpresa, String urlEmpresa, String password){
        this.nickname       = nickname;
        this.nombre         = nombre;
        this.apellido       = apellido;
        this.email          = email;
        this.fechaNac       = fechaNac;
        this.imagen         = imagen;
        this.nombreEmpresa  = nombreEmpresa;
        this.urlEmpresa = urlEmpresa;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setUrlEmpresa(String urlEmpresa) {
        this.urlEmpresa = urlEmpresa;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
