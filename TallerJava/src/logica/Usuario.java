/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.*;
/**
 *
 * @author matias.heredia
 */
public class Usuario {
    
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String email  ;
    protected Date fechaNac;
    protected String imagen;
    protected String password;

    public Usuario(String nickname,String nombre, String apellido, String email, Date fechaNac, String imagen, String password) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.password = password;
    }    
     
    public String getNombre() {
        return nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void verificarPassword(String password) throws Exception{
        if(!this.password.equals(password))
            throw new Exception ("la password introducida no es correcta");
    }
   
    
}
