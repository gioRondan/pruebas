/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author diego
 */
public class DataCliente {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;   
    protected String password;
    
    //Constructores
    public DataCliente(){
        this.nombre     = "";
        this.nickname   = "";
        this.apellido   = "";
        this.email      = "";
        this.fechaNac   = null;
        this.imagen     = "";
        this.password = "";
    }    
     
    public DataCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String password){
        this.nombre     = nombre;
        this.nickname   = nickname;
        this.apellido   = apellido;
        this.email      = email;
        this.fechaNac   = fechaNac;
        this.imagen     = imagen;
        this.password = password;
    }         

    //Getters
    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        return nickname;
    }
    public String getPassword() {
        return password;
    }
    
}
