/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
        clientes = new HashMap();
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
            throw new Exception("el nick ingresado ya pertenece a otro proveedor"); 
    }
    void unicidadEmail(String email) throws Exception{
        for(Cliente it : clientes.values()){
            if (it.getEmail().equals(email)){
                throw new Exception("el email ingresado ya pertenece a otro proveedor");
            }
        }
    }
    
    public List<DataReserva> listarReservas(){
        List<DataReserva> dts;
        dts = new ArrayList<>();
        clientes.values().stream().forEach((Cliente value) -> {
             boolean ni = dts.addAll(value.getDataReservas());
         });
        return dts;
        
    }
    public List<DataCliente> getDataClientes(){
        List<DataCliente> dts = new ArrayList<>();
        Iterator iter = clientes.values().iterator();
        for(Cliente c : clientes.values()){
            dts.add(c.getDataCliente());
        }
         
        return dts;
    }

    public int getUltimoid() {
        id++;
        return id;
    }
    
}
