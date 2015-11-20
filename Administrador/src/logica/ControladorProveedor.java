package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;




/**
 *
 * @author Juan
 */
public class ControladorProveedor implements IControladorProveedor{
    private static String[] imagenServicio = new String[3];
    private static int tope=0;
     private static String[] imagenModificarServicio = new String[3];
    private static int tope2=0;
    private static String destinoServicio = "";
    private static String origenServicio = "";
    private static Set<String> categoriasServicio = new HashSet();
    private static String servicio = "";
    private static String proveedor = "";
    private static String descripcionServicio = "";
    private static float precioServicio = 0;
    private static String nomCategoria = "";
    private static String nomPadre = "";
    private static Set<String> categoriaBorrar = new HashSet();
    private static Set<String> imagenBorrar = new HashSet();
    
    private void liberarMemoria(){
        imagenServicio = new String[3];
        tope=0;
        imagenModificarServicio = new String[3];
        tope2=0;
        destinoServicio = "";
        origenServicio = "";
        categoriasServicio = new HashSet();
        servicio = "";
        proveedor = "";
        descripcionServicio = "";
        precioServicio = 0;
        nomCategoria = "";
        nomPadre = "";
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
        if(!imagen.isEmpty()){
            ControladorProveedor.imagenServicio[ControladorProveedor.tope]=imagen;
            ControladorProveedor.tope = ControladorProveedor.tope+1;
        }
    }
    @Override
    public void ingresarModificarImagenServicio(String imagen){
        if(!imagen.isEmpty()){
            ControladorProveedor.imagenModificarServicio[ControladorProveedor.tope2]=imagen;
            ControladorProveedor.tope2 = ControladorProveedor.tope2+1;
        }
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
    @Override
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
    public void altaServicio(String nombre , String descripcion, int precio, String origen, String proveedor, String pais)throws Exception{
        Servicio ser = new Servicio(nombre, descripcion, precio);
        for(int i=0;i<ControladorProveedor.tope;++i){            
                ser.agregarImagen(ControladorProveedor.imagenServicio[i]);
                       
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
    @Override
    public List<DataServicio> listarServiciosXCategoria( String nom2Categoria){
        ManejadorCategoria mCa = ManejadorCategoria.getInstance();
        Categoria cat = mCa.getCategoria(nom2Categoria);
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
        Categoria categoria;
        if(nomPadre.equals("")){
            categoria = new Categoria(nomCategoria, false);
        }else{
            categoria = new Categoria(nomCategoria, true);
            Categoria padre = mCa.getCategoria(nomPadre);
            padre.setHijo(categoria);
        }
        mCa.addCategoria(categoria);
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
        Promocion promo = new Promocion(nombreProm, descuento, totalPrecio, prov);
        prov.asociarPromocion(promo);   
        while (itera.hasNext()) {
            //recorro los servicos a agregar y voy calculando el precio de la promocion sin el descuento
            Servicio servicio = prov.getServicio(itera.next());          
            totalPrecio += servicio.getPrecio();
            promo.agregarServicio(servicio);
        }
        totalPrecio=(int)(totalPrecio - (totalPrecio * (0.01*descuento)));//aplico el descuento
        promo.setPrecioTotal(totalPrecio);//Seteo el precio total con el descuento aplicado 
    }
    @Override
    public void ingresarDescripcionServicio( String desc){
        ControladorProveedor.descripcionServicio = desc;
    }
    @Override
    public void ingresarPrecioServicio(float precio){
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
            ser.asociarOrigen(mCi.getCiudad(origenServicio));
        }
        if (!destinoServicio.isEmpty()){
            ManejadorCiudad mCi = ManejadorCiudad.getInstance();
            ser.asociarDestino(mCi.getCiudad(destinoServicio));
        }
        
        for(String it1 : categoriaBorrar){
            ser.eliminarCategoria(it1);
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(it1);
            cat.eliminarServicio(ser);
        }
        for(String cats : categoriasServicio){
            ManejadorCategoria mCa = ManejadorCategoria.getInstance();
            Categoria cat = mCa.getCategoria(cats);
            cat.setServicio(ser);
            ser.agregarCategoria(cat);
        }
        for(String it2 : imagenBorrar){
            ser.eliminarImagen(it2);
        }
        
        for(int i=0;i<ControladorProveedor.tope2;++i){
                ser.agregarImagen(ControladorProveedor.imagenModificarServicio[i]);
                       
        }
        liberarMemoria();
    }
    @Override
    public List<DataEmpresa> listarEmpresas(){
        ManejadorEmpresa mEmp = ManejadorEmpresa.getInstance();
        return mEmp.getDataEmpresas();
    }
    
    
    public void altaProveedor( String nick, String nombre, String  apellido,String email ,Date fechaNac, String imagen, String nombreEmp, String linkEmp, String password) throws Exception{
               
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
            Proveedor prov = new Proveedor(nick, nombre, apellido, email, fechaNac, imagen, password);
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
    public DataInfoServicio verInfoServicio(String nomServicio, String nomProveedor)throws Exception{
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

    public DataServicio informacionServicio(String prv,String ser) throws Exception{
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(prv);
        Servicio servi = prov.getServicio(ser);
        return servi.getDataServicio();
    }
    public DataPromocion informacionPromocion(String pvr, String nom)throws Exception{
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        Proveedor prov = mPr.getProveedor(pvr);
        Promocion servi = prov.getPromocion(nom);
        return servi.getDataPromocion();
    }
    @Override
    public DataInfoPromocion verInfoPromocion(String nickproveedor, String nomPromocion) {
        Promocion promo = ManejadorProveedor.getInstance().getProveedor(nickproveedor).getPromocion(nomPromocion);
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
     public List<DataCiudad> ciudadesXpais( String nombrepais){
       ManejadorCiudad mCi = ManejadorCiudad.getInstance();
        ManejadorPais mPa = ManejadorPais.getInstance();
        Pais pais = mPa.getPais(nombrepais);
       return mCi.getDataCiudadesXpais(pais);
    }

    @Override
    public List<DataServicio> buscarServicios(String aBuscar) {
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        return mpr.obtenerServiciosBuscados(aBuscar);
    }
    
    public List<DataPromocion> buscarPromociones(String aBuscar) {
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        return mpr.obtenerPromocionesBuscados(aBuscar);
    }

    @Override
    public DataInfoProveedor iniciarSesion(String nick, String pass) {
        ManejadorProveedor mcl = ManejadorProveedor.getInstance();
        Proveedor aux = mcl.getProveedor(nick);
        if ((aux !=null) &&( !aux.verificarPassword(pass))){
            aux =null;
        }
        if (aux == null){
            return null ;
        }else{
            return aux.getDataInfoProveedor();
        }
    }

    @Override
    public void facturarReserva(String nick, Integer id) {
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor proveedor = mpr.getProveedor(nick);
        proveedor.facturarReserva(id);
        /*String nickCliente = proveedor.facturarReserva(id);
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        mcl.chequearEstadoReserva(nickCliente, id);*/
    }

    @Override
    public List<DataInfoReserva> listarReservasXProveedor(String nick) {
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Proveedor proveedor = mpr.getProveedor(nick);
        return proveedor.getDataReservasXProveedor(nick);
    }

}

