/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.Collections;
import static java.util.Collections.emptyMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author matias.heredia
 */
public class ManejadorProveedor {
    private Map<String,Proveedor> proveedores;
    private static ManejadorProveedor instance = null;
    private ManejadorProveedor(){
        proveedores = new HashMap<String,Proveedor>();
    }
    
    public static ManejadorProveedor getInstance(){
        if(instance == null)
            instance = new ManejadorProveedor();
        return instance;
    }
    public Proveedor getProveedor(String nickname){
        return proveedores.get(nickname);
        
        
    }
    public void addProveedor(Proveedor proveedor){
        proveedores.put(proveedor.getNickname(), proveedor);
    }
    public void removeProveedor(String nickname){
        proveedores.remove(nickname);
    }
    public Set<DataProveedor> listarPromocionesSistemas(){
        Set<DataProveedor> dts = new HashSet();
        for (Proveedor value : proveedores.values()){
            dts.add(value.getDataProveedor());
        } 
        return dts;
    }
    
    public Set<DataProveedor> getDataProveedores(){
        Set<DataProveedor> dts =  new HashSet();
        for (Proveedor value : proveedores.values()){
            dts.add(value.getDataProveedor());
        }
        return dts;
    }

    void unicidadNick(String nick) throws Exception{
        if (proveedores.containsKey(nick))
            throw new Exception("Not supported yet."); 
    }

    void unicidadEmail(String email) throws Exception{
        for(Proveedor it : proveedores.values()){
            if (it.getEmail().equals(email)){
                throw new Exception("el email ingresado ya pertenece a otro proveedor");
            }
        }
    }
    
  
}
