/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Juan
 */
public class ManejadorCliente {
     private Map<String,Cliente> clientes;
     private int id;
    private static ManejadorCliente instance = null;
    private ManejadorCliente(){
        id=111;
        clientes = Collections.emptyMap();
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
    public boolean existeCliente(String valor){
        Cliente cliente = clientes.get(valor);
        if(cliente != null){
            return true;
        }
        else{
            return false;
        }
    }   
    
    public Set<DataReserva> listarReservas(){
        Set<DataReserva> dts;
        dts = Collections.EMPTY_SET;
        clientes.values().stream().forEach((Cliente value) -> {
             boolean ni = dts.addAll(value.getDataReservas());
         });
        return dts;
        
    }
    public Set<DataCliente> getDataClientes(){
        Set<DataCliente> dts = Collections.EMPTY_SET;
        Iterator iter = clientes.values().iterator();
        for (Cliente c : clientes.values()){
            dts.add(c.getDataCliente());
        }
         
        return dts;
    }

    public int getUltimoid() {
        id++;
        return id;
    }
    
}
