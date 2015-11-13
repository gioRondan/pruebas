/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInfoCliente {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DataFecha fechaNac;
    private String imagen;    
    private DataReserva[] reservas;
    private String password;
    private String hola;
    //Constructores
    public DataInfoCliente(){
        this.nombre     = "";
        this.nickname   = "";
        this.apellido   = "";
        this.email      = "";
        this.fechaNac   = new DataFecha();
        this.imagen     = "";
        this.reservas   = null;
        this.password = "";
    }    
     
    public DataInfoCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, List<DataReserva> reservas, String password){
        this.nombre     = nombre;
        this.nickname   = nickname;
        this.apellido   = apellido;
        this.email      = email;
         System.out.println(fechaNac);
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha    = formatoFecha.format(fechaNac);
        System.out.println(fecha);
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]); //dd
        int mes = Integer.parseInt(partes[1]); // mm
        int anio = Integer.parseInt(partes[2]); // aaaa
        this.fechaNac   = new DataFecha(dia, mes, anio);
        this.imagen     = imagen;
        this.password = password;
        DataReserva[] ret = new DataReserva[reservas.size()];
        int i = 0;
        for (DataReserva value : reservas){
            ret[i] = value;
            i++;
        }
        this.reservas = ret;
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

    public DataFecha getFechaNac() {
        return fechaNac;
    }

    public void setHola(String hola) {
        this.hola = hola;
    }

    public String getHola() {
        return hola;
    }

    public String getImagen() {
        return imagen;
    }
    
    public DataReserva[] getReservas(){
        
        return reservas;
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

    public void setFechaNac(DataFecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setReservas(DataReserva[] reservas) {
        this.reservas = reservas;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
