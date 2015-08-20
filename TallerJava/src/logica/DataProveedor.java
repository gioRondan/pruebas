/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
/**
 *
 * @author Juan
 */
public class DataProveedor {
    private String nickname;
    private String nombre;
    private String apellido;
    private String empresa;
    public DataProveedor(String nombre, String apellido, String nickname, String empresa){
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
    }
}
