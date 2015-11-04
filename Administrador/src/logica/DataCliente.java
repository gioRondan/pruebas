/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import org.json.simple.JSONObject;

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
    private String password;
    
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
    public JSONObject ToJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre",this.nombre);
        obj.put("nickname",this.nickname);
        obj.put("apellido",this.apellido);
        obj.put("email",this.email);
        obj.put("fechaNac",this.fechaNac);
        obj.put("imagen",this.imagen);
        obj.put("password",this.password);
        
        return obj;
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
