/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author diego
 */
public class DataInfoCliente {
    private final String nickname;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final Date fechaNac;
    private final String imagen;    
    private List<DataReserva> reservas;
    
    //Constructores
    public DataInfoCliente(){
        this.nombre     = "";
        this.nickname   = "";
        this.apellido   = "";
        this.email      = "";
        this.fechaNac   = null;
        this.imagen     = "";
        this.reservas   = null;
    }    
     
    public DataInfoCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, List<DataReserva> reservas){
        this.nombre     = nombre;
        this.nickname   = nickname;
        this.apellido   = apellido;
        this.email      = email;
        this.fechaNac   = fechaNac;
        this.imagen     = imagen;
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
    
}
