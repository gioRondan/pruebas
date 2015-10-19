/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;


/**
 *
 * @author diego
 */
public class DataInfoCliente {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;    
    private List<DataReserva> reservas;
    private String password;
    
    //Constructores
    public DataInfoCliente(){
        this.nombre     = "";
        this.nickname   = "";
        this.apellido   = "";
        this.email      = "";
        this.fechaNac   = null;
        this.imagen     = "";
        this.reservas   = null;
        this.password = "";
    }    
     
    public DataInfoCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, List<DataReserva> reservas, String password){
        this.nombre     = nombre;
        this.nickname   = nickname;
        this.apellido   = apellido;
        this.email      = email;
        this.fechaNac   = fechaNac;
        this.imagen     = imagen;
        this.password = password;
        this.reservas = reservas;
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
    
    public List<DataReserva> getReservas(){
        return reservas;
    }
    public String getPassword() {
        return password;
    }
    
}
