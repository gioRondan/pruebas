/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import RegistroAcceso.Registro;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Juan
 */
public interface IControladorCliente {
    public void actualizarEstadoReserva(int identificador, String nomCliente, Estado estado);
    public void altaCliente(String nickname, String nombre, String apellido, String email, Date fechaNac, String imagen, String password)throws Exception;
    public List<DataCliente> listarClientes();
    public void cancelarReserva(String nomCliente, int identificador);
    public List<DataReserva> listarReservasXCliente(String nomCliente);
    public List<DataReserva> listarReservasSistema();
    public DataInfoReserva verInfoReserva(String nomCliente, int identificador);
    public DataInfoCliente verInfoCliente(String nomCliente);
    public void realizarReserva(String proveedor,String cliente,Map<String,Integer> servicio, Map<String,Integer> promocion,Map<String,DataExpira> fechas,Map<String,DataExpira> fechaspromos,Date fecha_creacion )throws Exception;
//###################################   Operaciones Tarea2      #########################################################################
    public DataInfoCliente iniciarSesion(String nickCliente, String password);
    public Date toDate(String fecha);
    public void confirmarReserva(List<DataItemReserva> itemsr,DataInfoCliente cli)throws Exception;
    public boolean existeEmail(String email);
    public boolean existeNickName(String nickName);
    public BufferedImage leerImgURL(String imgURL)throws Exception;

    public void confirmarReserva2(DataItemReserva item, DataInfoCliente cli);
    public void CrearFactura(long id,Date fecha, int IdRes,String nick,int total,List<DataItemReserva> items);
    public List<DataReserva> listarReservasXClienteRegistradas(String nomCliente);

    public void actualizarRegistro(String ip, String url, String browser, String so);
    public List<Registro> obtenerRegistros();
}