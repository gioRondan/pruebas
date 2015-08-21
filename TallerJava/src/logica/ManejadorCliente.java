/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Juan
 */
public class ManejadorCliente {
     private Map<String,Cliente> clientes;
    private static ManejadorCliente instance = null;
    private ManejadorCliente(){}
    
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
    public Set<DataCliente> getDataCliente(){
        Set<DataCliente> dts = null;
        for (Cliente value : clientes.values()){
            dts.add(value.getDataCliente());
        }
        return dts;
    }
    
}
