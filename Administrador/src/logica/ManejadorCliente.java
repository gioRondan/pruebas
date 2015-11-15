/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Juan
 */
public class ManejadorCliente {
     private Map<String,Cliente> clientes;
     private  int identificador;
    private static ManejadorCliente instance = null;
    private ManejadorCliente(){
        identificador=0;
        clientes = new LinkedHashMap();
    }
    
    public static ManejadorCliente getInstance(){
        if(instance == null)
            instance = new ManejadorCliente();
        return instance;
    }
    public Cliente getCliente(String nickname){
        return clientes.get(nickname);
    }
    public void addCliente(Cliente cliente){
        clientes.put(cliente.getNickname(), cliente);
    }
    public void removeCliente(String nickname){
        clientes.remove(nickname);
    }
    void unicidadNick(String nick) throws Exception{
        if (clientes.containsKey(nick))
            throw new Exception("El nick ingresado ya pertenece a otro Cliente"); 
    }
    void unicidadEmail(String email) throws Exception{
        for(Cliente it : clientes.values()){
            if (it.getEmail().equals(email)){
                throw new Exception("El email ingresado ya pertenece a otro Cliente");
            }
        }
    }
    
    public List<DataReserva> listarReservas(){
        List<DataReserva> dts;
        dts = new ArrayList<DataReserva>();
        for( Cliente value: clientes.values()) {
             dts.addAll(value.getDataReservas());
         }
        return dts;
        
    }
    public List<DataCliente> getDataClientes(){
        List<DataCliente> dts = new ArrayList<DataCliente>();
        Iterator iter = clientes.values().iterator();
        for(Cliente c : clientes.values()){
            dts.add(c.getDataCliente());
        }
         
        return dts;
    }

    public int getUltimoid() {
        identificador++;
        return identificador;
    }
    //solo para el test
    public int testGetId(){
        return identificador;
    }

    void chequearEstadoReserva(String nickCliente, Integer id) {
        this.clientes.get(nickCliente).chequearReserva(id);
    }
    
}
