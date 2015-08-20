/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author matias.heredia
 */
public class ManejadorProveedor {
    private Map<String,Proveedor> proveedores;
    private static ManejadorProveedor instance = null;
    private ManejadorProveedor(){}
    
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
    public Set<DataProveedor> getDataProveedores(){
        Set<DataProveedor> dts = null;
        for (Proveedor value : proveedores.values()){
            dts.add(value.getDataProveedor());
        }
        return dts;
    }
}
