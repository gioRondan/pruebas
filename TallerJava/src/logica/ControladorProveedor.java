package logica;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan
 */
public class ControladorProveedor implements IControladorProveedor{
    private Set<String> imagenServicio = Collections.EMPTY_SET;
    private String destinoServicio = "";
    private String origenServicio = "";
    private Set<String> categoriasServicio = Collections.EMPTY_SET;
    private String servicio = "";
    private String proveedor = "";
    private String descripcionServicio = "";
    private float precioServicio = 0;
    private String categoria = "";
    private String nomCategoria = "";
    private String nomPadre = "";
    
    private void liberarMemoria(){
        
    }
    public void ingresarImagenServicio(String imagen){
        this.imagenServicio.add(imagen);
    }
    public void ingresarDestinoServicio(String  destino ){
        this.destinoServicio = destino;
    }
    public Set<DataCiudad> listarCiudades(){
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        return mCi.getDataCiudades();//falta implementar manejadorciudad
    }
    public void ingresarCategoriaServicio( String categoria){
        this.categoriasServicio.add(categoria);
    }
    public Set<DataCategoria> listarCategorias(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        return mCa.getDataCategorias();//falta implementar manejadorcategoria
    }
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor){
        Servicio ser = new Servicio(nombre, descripcion, precio);
        for (String im : imagenServicio){
            try {
                ser.agregarImagen(im);
            } catch (Exception ex) {
                Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        prov.asociarServicio(ser);
        //asociar servicio a proveedor??????
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        for(String cats : categoriasServicio){
            Categoria cat = mCa.getCategoria(cats);
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        ser.asociarOrigen(mCi.getCiudad(origen));
        if (!destinoServicio.isEmpty()){
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        liberarMemoria();
    }
    public Set<DataProveedor> listarProveedores(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        return mPr.getDataProveedores();
    }
    public void seleccionarCategoria(String categoria){
        this.categoria = categoria;
    }
    public Set<DataServicio> listarServiciosXCategoria( String nomCategoria){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Categoria cat = mCa.getCategoria(categoria);
        return cat.getDataServicios();
    }
    public void ingresarNombreCategoria(String nombre){
        this.nomCategoria = nombre;
    }
    public void seleccionarPadre(String nombre){
        this.nomPadre = nombre;
    }    
    public void altaCategoria(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        mCa.crearCategoria(this.nomCategoria,this.nomPadre);
    }
    public Set<DataServicio> listarServiciosXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);//nickname
        this.proveedor = nomProveedor;//para que esta linea ?
        return prov.getDataServicios();
    }
    public void seleccionarServicio(String nomServicio){
        this.servicio = nomServicio;
    }
    public void altaPromocion( String nomProveedor,Set<String> ser, String nombre, int descuento){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);//nickname
        Iterator<String> itera = ser.iterator();
        int totalPrecio=0;
        Promocion p = new Promocion(nombre, descuento, totalPrecio);
        prov.asociarPromocion(p);
        while (itera.hasNext()) {
            //recorro los servicos a agregar y voy calculando el precio de la promocion sin el descuento
            Servicio s = prov.getServicio(itera.next()); 
            totalPrecio += s.getPrecio();
            p.agregarServicio(s);
        }
        totalPrecio=(int)(totalPrecio * (0.1*descuento));//aplico el descuento
        p.setPrecioTotal(totalPrecio);//Seteo el precio total con el descuento aplicado 
    }
    public void ingresarDescripcionServicio( String desc){
        this.descripcionServicio = desc;
    }
    public void ingresarPrecioServicio(int precio){
        this.precioServicio = precio;
    }
    public void ingresarOrigenServicio( String origen){
        this.origenServicio = origen;
    }
    public void modificarServicio(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(servicio);
        if (!descripcionServicio.isEmpty()){
            ser.setDesc(descripcionServicio);
        }
        for(String im : imagenServicio){
            try {
                ser.agregarImagen(im);//revisar
            } catch (Exception ex) {
                Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (precioServicio != 0){
            ser.setPrecio(precioServicio);
        }
        if (!origenServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            ser.asociarOrigen(mCi.getCiudad(origenServicio));
        }
        if (!destinoServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        for(String im : imagenServicio){
            try {
                ser.agregarImagen(im);//revisar
            } catch (Exception ex) {
                Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(String cats : categoriasServicio){
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(cats);//hay que eliminar las categorias anteriores?
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        liberarMemoria();
    }
    public List<DataEmpresa> listarEmpresas(){
      //NO ESTA ECHA ES UNA PROEBA NADA MAS 
        List<DataEmpresa> dts ; 
        dts = new ArrayList<>();        
        DataEmpresa dte = new DataEmpresa("Antel","www.antel.com.uy");
        Boolean ok = dts.add(dte);
       
        dte = new DataEmpresa("Coonaprole", "www.coonaprole.com.uy");
        dts.add(dte);
       
        return dts;
    }
    public void altaProveedor( String nick, String nombre, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp, String linkEmp) {//iria un dt como entrada calculo yo
       
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
       
       //mPr.unicidadNick(nick);//bomba!!!!!!!!!!!!
        //mPr.unicidadEmail(email);//bomba!!!!!!!!!!!!
//        if ((nick.isEmpty()) || (nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty()) || (imagen.isEmpty()) || (nombreEmp.isEmpty())){
//           // throw new Exception("los datos ingresados no son correctos");
//        }else{
            Proveedor prov = new Proveedor(nick, nombre, apellido, email, fechaNac, imagen);
            ManejadorEmpresa mEmp =  ManejadorEmpresa.getInstance();
            Empresa emp = mEmp.getEmpresa(nombreEmp);
            if (emp == null){
                emp = new Empresa(nombreEmp, linkEmp);
                mEmp.addEmpresa(emp);
            }
            prov.asociarEmpresa(emp);
            mPr.addProveedor(prov);
            JOptionPane.showMessageDialog(null, imagen);
//        }
    }
    public Set<DataPromocion> listarPromocionesXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        return prov.getDataPromociones();
    }
    public DataInfoServicio verInfoServicio( String nomServicio){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(nomServicio);
        return ser.getDataInfoServicio();
    }
    @Override
    public DataInfoProveedor verInfoProveedor( String nomProveedor){
        return null;
    }
    @Override
    public void ingresarImagen(String imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void ingresarDestino(String destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void ingresarCategoria(String Categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void altaPromocion(String nomProveedor, Set<String> ser, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actualizarEstadoReserva(int idReserva, String nomCliente, Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DataInfoPromocion verInfoPromocion(String nomPromocion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
