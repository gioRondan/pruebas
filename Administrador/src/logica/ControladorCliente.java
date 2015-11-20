/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Persistencia.Factura;
import Persistencia.Linea;
import RegistroAcceso.ManejadorRegistro;
import RegistroAcceso.Registro;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




/**
 *
 * @author Juan
 */
public class ControladorCliente implements IControladorCliente{
    
    @Override
    public void actualizarEstadoReserva(final int identificador, final String nomCliente,final Estado estado){
        ManejadorCliente.getInstance().getCliente(nomCliente).modificarEstadoReserva(identificador, estado);
    }
    
    @Override
    public void realizarReserva(String proveedor, String cliente,Map<String, Integer> servicio, Map<String,Integer> promocion,Map<String,DataExpira> fechas,Map<String,DataExpira> fechaspromos,Date fecha_creacion )throws Exception{
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        Cliente aux_cliente = mcli.getCliente(cliente);
        int clave1 = mcli.getUltimoid();
        ManejadorProveedor mpr = ManejadorProveedor.getInstance();
        Reserva res = new Reserva(clave1,fecha_creacion,fecha_creacion,fecha_creacion,0,Estado.registrada, aux_cliente.getNickname());
        aux_cliente.addReserva(res.getId(),res);
        Proveedor prov = mpr.getProveedor(proveedor);
        float preciototal=0;
        for(Map.Entry<String, Integer> entries : servicio.entrySet()){
           
            aux_cliente.reservarServicio(clave1, prov.getServicio(entries.getKey()),entries.getValue(),fechas.get(entries.getKey()).getFechai(),fechas.get(entries.getKey()).getFechaf(),null);
           
            preciototal= preciototal + prov.getServicio(entries.getKey()).getPrecio()*entries.getValue();
        }
        
        
        for(Map.Entry<String, Integer> entries : promocion.entrySet()){
            aux_cliente.reservarPromocion(clave1, prov.getPromocion(entries.getKey()),entries.getValue(),fechaspromos.get(entries.getKey()).getFechai(),fechaspromos.get(entries.getKey()).getFechaf(), null);
            
            preciototal= preciototal + prov.getPromocion(entries.getKey()).getPrecioTotal()*entries.getValue();
        }
        res.setPrecio(preciototal);
    }
    public BufferedImage leerImgURL(String imgURL) throws Exception{
        File imgF = new File(imgURL);
       
            return ImageIO.read(imgF);
      
    }
    @Override
    public void altaCliente(String nick, String nombre, String apellido, String email, Date fechaNac, String imagen, String password) throws Exception{
        
        ManejadorProveedor mPr = ManejadorProveedor.getInstance();
        ManejadorCliente mCl   = ManejadorCliente.getInstance();
        
        //Control de unicidad de usuarios
        mPr.unicidadNick(nick);
        mPr.unicidadEmail(email);
        mCl.unicidadNick(nick);
        mCl.unicidadEmail(email);/*
        if(!password.equals(passwordVerif))
            throw new Exception("Las contraseñas ingresadas no coinciden");*/
        if ((nick.isEmpty()) || (nombre.isEmpty()) || (apellido.isEmpty()) || (email.isEmpty())){
            throw new Exception("Los datos ingresados no son correctos");
        }else{
            Cliente cliente = new Cliente(nick, nombre, apellido, email, fechaNac, imagen, password);
            mCl.addCliente(cliente);        
        }
        
    }
    
    @Override
    public List<DataCliente> listarClientes(){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getDataClientes();
    }
    
    @Override
    public void cancelarReserva(String nomCliente, int identificador){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        Cliente cli = mCl.getCliente(nomCliente);
        cli.cancelarReserva(identificador);
    }
    
    @Override
    public List<DataReserva> listarReservasSistema(){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.listarReservas();
        
    }
    
    @Override
    public List<DataReserva> listarReservasXCliente(String nomCliente){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataReservas();
    }
    
    @Override
    public DataInfoReserva verInfoReserva(String nomCliente, int identificador){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        Cliente cliente = mCl.getCliente(nomCliente);
        Reserva reserva = cliente.getReserva(identificador);
        return reserva.getDataInfoReserva();
    }
    
    @Override
    public DataInfoCliente verInfoCliente( String nomCliente){
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataInfoCliente();
    }
    @Override
    public DataInfoCliente iniciarSesion(String nickCliente, String password) {
        ManejadorCliente mcl = ManejadorCliente.getInstance();
        Cliente aux = mcl.getCliente(nickCliente);
        if ((aux !=null) &&( !aux.verificarPassword(password))){
            aux =null;
        }
        if (aux == null){
            return null ;
        }else{
            return aux.getDataInfoCliente();
        }
            
    }
     public Date toDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date date =new Date();
        try {
            date = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }

    public DataFecha toDataFecha(String fecha) {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = formatoFecha.format(fecha);
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]); //dd
        int mes = Integer.parseInt(partes[1]); // mm
        int anio = Integer.parseInt(partes[2]); // aaaa
        DataFecha dtfecha = new DataFecha(dia, mes, anio);
        
        return dtfecha;
    }
       
    public void confirmarReserva(List<DataItemReserva> itemreserva,DataInfoCliente dtcliente) throws Exception{
        ManejadorCliente mcli = ManejadorCliente.getInstance();
        ManejadorProveedor mprov = ManejadorProveedor.getInstance();
        Cliente cliente = mcli.getCliente(dtcliente.getNickname());
        int clave1 = mcli.getUltimoid();
        Reserva res = new Reserva(clave1,new Date(), new Date(), new Date(),0,Estado.registrada, cliente.getNickname());
        cliente.addReserva(res.getId(),res);
        float preciototal=0;
        for (DataItemReserva dtir : itemreserva){
            if (dtir.getesServico()){
                Servicio servicio;
                    Proveedor proveedor = mprov.getProveedor(dtir.getServicio().getProveedor());
                    servicio = proveedor.getServicio( dtir.getServicio().getNombre() );
                    ItemReserva item = new ItemReserva(dtir.getCantidad(), servicio, dtir.getFechaInicio(), dtir.getFechaFin(), cliente.getNickname() );
                    proveedor.addReserva(res.getId(), res);
                    cliente.reservarServicio(clave1, servicio,dtir.getCantidad(), dtir.getFechaInicio(), dtir.getFechaFin(), item);
                    preciototal= preciototal + servicio.getPrecio()*dtir.getCantidad();
         
            }else{
                Proveedor proveedor = mprov.getProveedor(dtir.getPromocion().getNickProveedor());
                Promocion promo = proveedor.getPromocion(dtir.getPromocion().getNombre());
                ItemReserva item = new ItemReserva(dtir.getCantidad(), promo, dtir.getFechaInicio(), dtir.getFechaFin(), cliente.getNickname() );
                proveedor.addReserva(res.getId(), res);
                cliente.reservarPromocion(clave1, promo,dtir.getCantidad(), dtir.getFechaInicio(), dtir.getFechaFin(), item);
                preciototal= preciototal + promo.getPrecioTotal()*dtir.getCantidad();
            }
            res.setPrecio(preciototal);
        }
    }
    public boolean existeNickName(String nickName){
        boolean aux=false;
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        List<DataCliente> list = mCl.getDataClientes();
        for(DataCliente dtc : list){
            if (dtc.getNickname().equals(nickName)){
                return true;
            }
        }
        return false;
    }
    public boolean existeEmail(String email){
        boolean aux=false;
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        List<DataCliente> list = mCl.getDataClientes();
        for(DataCliente dtc : list){
            if (dtc.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void confirmarReserva2(DataItemReserva item, DataInfoCliente cli) {
        
    }
    
    
    
    
    // operacines persistencia
    public void CrearFactura(long id,Date fecha, int IdRes,String nick,int total,List<DataItemReserva> items){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "AdministradorPU");
        EntityManager em = emf.createEntityManager();
            Factura fact = new Factura();
            long Autonum = 1;
            Collection<Linea> lines = null;
            for (DataItemReserva dtir : items){
                
                Linea lin = new Linea();
                lin.setId(Autonum);
                Autonum ++;
                if (dtir.getesServico()){
                    lin.setCantidad(dtir.getCantidad());
                    lin.setNombre(dtir.getServicio().getNombre());
                    lin.setNombreProveedor(dtir.getServicio().getProveedor());
                    lin.setPrecio(dtir.getServicio().getPrecio());
                }else{
                    lin.setCantidad(dtir.getCantidad());
                    lin.setNombre(dtir.getServicio().getNombre());
                    lin.setNombreProveedor(dtir.getServicio().getProveedor());
                    lin.setPrecio(dtir.getServicio().getPrecio());
                }
            lines.add(lin);
            }
            
            
            fact.setId(id);
            fact.setFechaGenerada(fecha);
            fact.setIdReserva(IdRes);
            fact.setLineas(lines);
            fact.setNickCliente(nick);
            fact.setTotal(total);
            em.getTransaction().begin();
            em.persist(fact);
            em.getTransaction().commit();
            em.close();
            emf.close();
    }
    public String ImprimirFactura(){
        String salida = "******** Factura ********" + "/n";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "AdministradorPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a FROM Factura f WHERE f.id = ?1");
        
        return salida;
    }

    @Override
    public List<DataReserva> listarReservasXClienteRegistradas(String nomCliente) {
        ManejadorCliente mCl = ManejadorCliente.getInstance();
        return mCl.getCliente(nomCliente).getDataReservasRegistradas();
    }

    @Override
    public void actualizarRegistro(String ip, String url, String browser, String so) {
        ManejadorRegistro mr = ManejadorRegistro.getInstance();
        mr.addRegistro(new Registro(ip, url, browser, so));
    }

    @Override
    public List<Registro> obtenerRegistros() {
        ManejadorRegistro mr = ManejadorRegistro.getInstance();
        return mr.getRegistros();
    }
    
}