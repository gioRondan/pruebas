package logica;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Juan
 */
public class ControladorProveedor implements IControladorProveedor{
    private static Set<String> imagenServicio = new HashSet();
    private static String destinoServicio = "";
    private static String origenServicio = "";
    private static Set<String> categoriasServicio = new HashSet();
    private static String servicio = "";
    private static String proveedor = "";
    private static String descripcionServicio = "";
    private static float precioServicio = 0;
    private static String categoria = "";
    private static String nomCategoria = "";
    private static String nomPadre = "";
    private static String imagenProveedor="";
    
    private void liberarMemoria(){
        imagenServicio = new HashSet();
        destinoServicio = "";
        origenServicio = "";
        categoriasServicio = new HashSet();
        servicio = "";
        proveedor = "";
        descripcionServicio = "";
        precioServicio = 0;
        categoria = "";
        nomCategoria = "";
        nomPadre = "";
        imagenProveedor="";
    }
    @Override
    public void ingresarImagenServicio(String imagen){
        ControladorProveedor.imagenServicio.add(imagen);
    }
    @Override
    public void ingresarDestinoServicio(String  destino ){
        ControladorProveedor.destinoServicio = destino;
    }
    @Override
    public List<DataCiudad> listarCiudades(){
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        return mCi.getDataCiudades();
    }
    @Override
    public void ingresarCategoriaServicio( String categoria){
        ControladorProveedor.categoriasServicio.add(categoria);
    }
    @Override
    public List<DataCategoria> listarCategorias(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        return mCa.getDataCategorias();
    }
    @Override
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor, String pais){
        Servicio ser = new Servicio(nombre, descripcion, precio);
        for(String im : imagenServicio){
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
        altaCiudad(origen, pais);
        ser.asociarOrigen(mCi.getCiudad(origen));
        if (!destinoServicio.isEmpty()){
            altaCiudad(origen, pais);
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        liberarMemoria();
    }
    @Override
    public List<DataProveedor> listarProveedores(){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        return mPr.getDataProveedores();
    }
    public void seleccionarCategoria(String categoria){
        this.categoria = categoria;
    }
    @Override
    public List<DataServicio> listarServiciosXCategoria( String nomCategoria){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Categoria cat = mCa.getCategoria(nomCategoria);
        return cat.getDataServicios();
    }
    @Override
    public void ingresarNombreCategoria(String nombre){
        ControladorProveedor.nomCategoria = nombre;        
    }
    @Override
    public void seleccionarPadre(String nombre){
        if (!nombre.equals("Categorías")){
            ControladorProveedor.nomPadre = nombre;
        }
    }    
    @Override
    public void altaCategoria(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Categoria cat;
        if(nomPadre.equals("")){
            cat = new Categoria(nomCategoria, false);
        }else{
            cat = new Categoria(nomCategoria, true);
            Categoria pa = mCa.getCategoria(nomPadre);
            pa.setHijo(cat);
        }
        mCa.addCategoria(cat);
        liberarMemoria();
    }
    @Override
    public List<DataServicio> listarServiciosXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);//nickname
        ControladorProveedor.proveedor = nomProveedor;
        return prov.getDataServicios();
    }
    public void seleccionarServicio(String nomServicio){
        ControladorProveedor.servicio = nomServicio;
    }
    @Override
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
    @Override
    public void ingresarDescripcionServicio( String desc){
        ControladorProveedor.descripcionServicio = desc;
    }
    @Override
    public void ingresarPrecioServicio(int precio){
        ControladorProveedor.precioServicio = precio;
    }
    @Override
    public void ingresarOrigenServicio( String origen){
        ControladorProveedor.origenServicio = origen;
    }
    @Override
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
    @Override
    public List<DataEmpresa> listarEmpresas(){
        ManejadorEmpresa mEmp = ManejadorEmpresa.getInstance();
        return mEmp.getDataEmpresas();
    }
    /*public List<DataEmpresa> listarEmpresas(){
      //NO ESTA ECHA ES UNA PROEBA NADA MAS 
        List<DataEmpresa> dts ; 
        dts = new ArrayList<>();        
        DataEmpresa dte = new DataEmpresa("Antel","www.antel.com.uy");
        Boolean ok = dts.add(dte);
       
        dte = new DataEmpresa("Coonaprole", "www.coonaprole.com.uy");
        dts.add(dte);
       
        return dts;
    }*/
    
    @Override
    public void altaProveedor( String nick, String nombre, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp, String linkEmp) throws Exception{
        
       
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
       
       mPr.unicidadNick(nick);//bomba!!!!!!!!!!!!
        mPr.unicidadEmail(email);//bomba!!!!!!!!!!!!
   
       if ((nick.isEmpty()) || (nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty())  || (nombreEmp.isEmpty())){
            throw new Exception("los datos ingresados no son correctos");
        }else{
            Proveedor prov = new Proveedor(nick, nombre, apellido, email, fechaNac, imagen);
            ManejadorEmpresa mEmp =  ManejadorEmpresa.getInstance();
            Empresa emp = mEmp.getEmpresa(nombreEmp);
            if (emp == null){
                emp = new Empresa(nombreEmp, linkEmp);
                mEmp.addEmpresa(emp);
            }
            prov.asociarEmpresa(emp);
            mPr.addProveedor(prov);
        }
    }
    @Override
    public List<DataPromocion> listarPromocionesXProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);
        return prov.getDataPromociones();
    }
    @Override
    public DataInfoServicio verInfoServicio( String nomServicio){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(nomServicio);
        return ser.getDataInfoServicio();
    }
    @Override
    public DataInfoProveedor verInfoProveedor( String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);
        return prov.getDataInfoProveedor();
    }
    @Override
    public void ingresarImagen(String imagen) {
        ControladorProveedor.imagenProveedor = imagen;
    }

    
    @Override
    public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion) {
        ManejadorProveedor m = ManejadorProveedor.getInstance();
        Proveedor p = m.getProveedor(nickproveedor);
        Promocion promo = p.getPromocion(nomPromocion);
        
        return promo.getDataInfoPromocion();
    }

    private void altaCiudad(String nomCiudad, String nomPais) {
        ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        ManejadorPais mPa = ManejadorPais.getInstance();
        if(!nomCiudad.isEmpty()){
            if(mCi.getCiudad(nomCiudad) == null){
                if(mPa.getPais(nomPais) == null){
                    mPa.addPais(new Pais(nomPais));
                }
                mCi.addCiudad(new Ciudad(nomCiudad, mPa.getPais(nomPais)));
            }
        }
    }
}

