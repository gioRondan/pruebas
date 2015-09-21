/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;

/**
 *
 * @author giovani.rondan
 */
public interface IControladorWeb {
    public void iniciarSesion(String nickname, String password) throws Exception;
    public boolean ingresarNickEmail(String nickname, String password);
    public void registrarCliente(String nombre, String apellido, Date fechaNac, String password, String passwordVVerif);
    public void cerrarSesion();
    //hay que listar, capaz que usamos el listar de otro controlador
    public void agregarServicioCarrito(String nickProveedor, String nomServicio);
    public void agregarPromocionCarrito(String nickProveedor, String nomPromocion);
}
