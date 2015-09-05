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
    private static String[] imagenServicio = new String[3];
    private static int tope=0;
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
    private static Set<String> categoriaBorrar = new HashSet();
    private static Set<String> imagenBorrar = new HashSet();
    
    private void liberarMemoria(){
        imagenServicio = new String[3];
        tope=0;
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
        categoriaBorrar = new HashSet();
        imagenBorrar = new HashSet();
    }
    
    @Override
    public void ingresarImagenBorrarServicio(String imagen){
        if(!imagen.isEmpty()){
            ControladorProveedor.imagenBorrar.add(imagen);
        }
    }
    @Override
    public void ingresarCategoriaBorrarServicio(String categoria){
        ControladorProveedor.categoriaBorrar.add(categoria);
    }
    @Override
    public void ingresarImagenServicio(String imagen){
        ControladorProveedor.imagenServicio[ControladorProveedor.tope]=imagen;
        ControladorProveedor.tope = ControladorProveedor.tope+1;
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
    public void ingresarCategoriaServicio( String categoria) throws Exception{
        ManejadorCategoria mCat = ManejadorCategoria.getInstance();
        Categoria cat = mCat.getCategoria(categoria);
        if(cat !=null && cat.esHoja()){
            ControladorProveedor.categoriasServicio.add(categoria);
        }
        else{
            throw new Exception("Debe seleccionar una subcategoría.");
        }
    }
    public void vaciarCategoriasServicio(){
        ControladorProveedor.categoriasServicio.clear();
        ControladorProveedor.categoriasServicio = new HashSet();
    }
    @Override
    public List<DataCategoria> listarCategorias(){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        return mCa.getDataCategorias();
    }
    @Override
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor, String pais){
        Servicio ser = new Servicio(nombre, descripcion, precio);
        for(int i=0;i<ControladorProveedor.tope;++i){
            try {            
                ser.agregarImagen(ControladorProveedor.imagenServicio[i]);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
                Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        ControladorProveedor.tope=0;
        
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        prov.asociarServicio(ser);
        ser.setProveedor(prov);
        
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
            altaCiudad(destinoServicio, pais);//no habria que chequear que no exista ya ????
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
    public void altaCategoria() throws Exception{
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        if(mCa.getCategoria(nomCategoria) != null){
            throw new Exception("Ya existe una categoría con ese nombre.");
        }
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
    public void altaPromocion( String nickProveedor,List<String> ser, String nombreProm, int descuento) throws Exception{
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nickProveedor);//nickname
        mPr.unicidadPromocion(nickProveedor, nombreProm);//controlo unicidad de la promocion apra ese proveedor
        Iterator<String> itera = ser.iterator();
        int totalPrecio = 0;
        Promocion p = new Promocion(nombreProm, descuento, totalPrecio, prov);
        prov.asociarPromocion(p);   
        while (itera.hasNext()) {
            //recorro los servicos a agregar y voy calculando el precio de la promocion sin el descuento
            Servicio s = prov.getServicio(itera.next());          
            totalPrecio += s.getPrecio();
            p.agregarServicio(s);
        }
        totalPrecio=(int)(totalPrecio - (totalPrecio * (0.01*descuento)));//aplico el descuento
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
    public void modificarServicio()throws Exception{
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(proveedor);
        Servicio ser = prov.getServicio(servicio);
        if (!descripcionServicio.isEmpty()){
            ser.setDesc(descripcionServicio);
        }
        if (precioServicio != 0){
            ser.setPrecio(precioServicio);
        }
        if (!origenServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            altaCiudad(origenServicio,"pais");//para probar
            ser.asociarOrigen(mCi.getCiudad(origenServicio));
        }
        if (!destinoServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            altaCiudad(destinoServicio,"pais");//para probar
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        for(int i=0;i<ControladorProveedor.tope;++i){
            try {            
                ser.agregarImagen(ControladorProveedor.imagenServicio[i]);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
                Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        for(String cats : categoriasServicio){
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(cats);
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        for(String it1 : categoriaBorrar){
            ser.eliminarCategoria(it1);
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(it1);
            cat.eliminarServicio(ser);
        }
        for(String it2 : imagenBorrar){
            ser.eliminarImagen(it2);
        }
        liberarMemoria();
    }
    @Override
    public List<DataEmpresa> listarEmpresas(){
        ManejadorEmpresa mEmp = ManejadorEmpresa.getInstance();
        return mEmp.getDataEmpresas();
    }
    
    @Override
    public void altaProveedor( String nick, String nombre, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp, String linkEmp) throws Exception{
               
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        ManejadorCliente mCl   = ManejadorCliente.getInstance();
        
        //Control de unicidad de usuarios
        mPr.unicidadNick(nick);
        mPr.unicidadEmail(email);
        mCl.unicidadNick(nick);
        mCl.unicidadEmail(email);

        if ((nick.isEmpty()) || (nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty())  || (nombreEmp.isEmpty())){
            throw new Exception("Los datos ingresados no son correctos");
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
    public DataInfoServicio verInfoServicio(String nomServicio, String nomProveedor){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(nomProveedor);
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

    public DataServicio informacionServicio(String prv,String ser){
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(prv);
        Servicio servi = prov.getServicio(ser);
        return servi.getDataServicio();
    }
    @Override
    public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion) {
        ManejadorProveedor m = ManejadorProveedor.getInstance();
        Proveedor p = m.getProveedor(nickproveedor);
        Promocion promo = p.getPromocion(nomPromocion);
        
        return promo.getDataInfoPromocion();
    }
    public void altaPais(String nomPais) throws Exception {
        ManejadorPais mPa = ManejadorPais.getInstance();
         if(mPa.getPais(nomPais) == null){
                    mPa.addPais(new Pais(nomPais));
         }else{
             throw new Exception("Ya Exuiste ese");
         }
             
    }
    public void altaCiudad(String nomCiudad, String nomPais) {
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

    
    public void seleccionarProveedor(String proveedor) {
        ControladorProveedor.proveedor = proveedor;
    }
    public Set<String> infoPaises(){
       ManejadorPais mPa = ManejadorPais.getInstance();
       return mPa.getNombresPaises();
    }
     public List<DataCiudad> ciudadesXpais( String pa){
       ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        ManejadorPais mPa = ManejadorPais.getInstance();
        Pais p = mPa.getPais(pa);
       return mCi.getDataCiudadesXpais(p);
    }
    

}

