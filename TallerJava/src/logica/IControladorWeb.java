/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author giovani.rondan
 */
public interface IControladorWeb {
    public void iniciarSesion(String nickname, String password);
    public boolean ingresarNickEmail(String nickname, String password);
    public void registrarCliente(String nombre, String apellido);
}
