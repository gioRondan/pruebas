/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import org.json.simple.JSONObject;

/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCliente {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DataFecha fechaNac;
    private String imagen;   
    private String password;
    
    //Constructores
    public DataCliente(){
        this.nombre     = "";
        this.nickname   = "";
        this.apellido   = "";
        this.email      = "";
        this.fechaNac   = new DataFecha();
        this.imagen     = "";
        this.password = "";
    }    
     
    public DataCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String password){
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
        System.out.println(this.fechaNac.getAnio());
        this.imagen     = imagen;
        this.password = password;
    }
    /*public JSONObject ToJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre",this.nombre);
        obj.put("nickname",this.nickname);
        obj.put("apellido",this.apellido);
        obj.put("email",this.email);
        obj.put("fechaNac",this.fechaNac);
        obj.put("imagen",this.imagen);
        obj.put("password",this.password);
        
        return obj;
    }*/

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

    public String getImagen() {
        return imagen;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nickname;
    }
    public String getPassword() {
        return password;
    }
    
}
