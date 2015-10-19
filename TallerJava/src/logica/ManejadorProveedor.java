/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author matias.heredia
 */
public class ManejadorProveedor {
    private Map<String,Proveedor> proveedores;
    private static ManejadorProveedor instance = null;
    private ManejadorProveedor(){
        proveedores = new HashMap();
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
   
    public List<DataProveedor> getDataProveedores(){
        List<DataProveedor> dts =  new ArrayList<DataProveedor>();
        for (Proveedor value : proveedores.values()){
            dts.add(value.getDataProveedor());
        }
        return dts;
    }

    void unicidadNick(String nick) throws Exception{
        if (proveedores.containsKey(nick))
            throw new Exception("El nick ingresado ya pertenece a otro proveedor"); 
    }

    void unicidadEmail(String email) throws Exception{
        for(Proveedor it : proveedores.values()){
            if (it.getEmail().equals(email)){
                throw new Exception("El email ingresado ya pertenece a otro proveedor");
            }
        }
    }
    
    void unicidadPromocion(String nickProveedor, String nomPromocion) throws Exception{
        Proveedor prov = proveedores.get(nickProveedor);
        Promocion prom = prov.getPromocion(nomPromocion);
        if(prom != null){            
            throw new Exception("El proveedor seleccionado ya tiene una promoción con ese nombre");            
        }
    }
    List<DataServicio> obtenerServiciosBuscados(String aBuscar){
        List<DataServicio> result = new ArrayList<DataServicio>();
        for(Proveedor it : proveedores.values()){
            result.addAll(it.getServiciosBuscados(aBuscar));
        }
        return result;
    }

    List<DataPromocion> obtenerPromocionesBuscados(String aBuscar) {
         List<DataPromocion> result = new ArrayList<DataPromocion>();
        for(Proveedor it : proveedores.values()){
            result.addAll(it.getPromocionesBuscados(aBuscar));
        }
        return result;
    }
   

}
