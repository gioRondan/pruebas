/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;


import Servidor.PublicadorCliente;
import Servidor.PublicadorProveedor;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import logica.DataExpira;
import logica.Fabrica;
import logica.IControladorCliente;
import logica.IControladorProveedor;

/**
 *
 * @author rodrigo.linares
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    

    /**
     * Creates new form PantallaPrincipal
     */
    private static PantallaPrincipal instancia = null;
    public IControladorProveedor ICP;
    public IControladorCliente ICC;
    public static String RutaImagenes=""; 
    
    private PantallaPrincipal() {
       initComponents();
        this.setLocationRelativeTo(null);  
        Fabrica fabrica = Fabrica.getInstance();
        instancia = this;
        ICP = fabrica.getIControladorProveedor();
        ICC = fabrica.getIControladorCliente();
   
     
          try { 
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream("src/Propiedades/Propiedades.properties"));
           //properties.load(new FileInputStream("src/properties/publish.properties"));
            String url = propiedades.getProperty("rutaImagenes");
            PantallaPrincipal.RutaImagenes = url;
            } catch (IOException e) {
                // PantallaPrincipal.RutaImagenes= JOptionPane.showInputDialog("Seleccione una ruta para las imagenes");
                JOptionPane.showInputDialog("Error en cargar el archvo de propiedades "+e.getMessage());
            }
           
            File usuarios=new File(PantallaPrincipal.RutaImagenes+"Usuarios"); 
            usuarios.mkdir();
            File servicios=new File(PantallaPrincipal.RutaImagenes+"Servicios"); 
            servicios.mkdir();
            
            CargaInicial c = new CargaInicial();
            try{
                c.cargar();
                JOptionPane.showMessageDialog(null, "Los datos iniciales se cargaron correctamente.");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }      
    
    }
    
    public static PantallaPrincipal getInstancia(){
        if(instancia == null) 
            instancia = new PantallaPrincipal();
        return instancia;
    };
    public void abrirListarEmpresas(){
        ListarEmpresas al = new ListarEmpresas();
        Escritorio.add(al);
         int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }
    
    public void abrirRealizarReserva(){
        realizarReserva rr = new realizarReserva();
        Escritorio.add(rr);
        int a = (Escritorio.getWidth() - rr.getWidth())/2;
        int b = (Escritorio.getHeight() - rr.getHeight()) /2;
        rr.setLocation(a ,b);
        rr.show();
    }
    
     public void abrirAltaServicio(){
        AltaServicio als = new AltaServicio();
        Escritorio.add(als);
        int a = (Escritorio.getWidth() - als.getWidth())/2;
        int b = (Escritorio.getHeight() - als.getHeight()) /2;
        als.setLocation(a ,b);
        als.show();
    }
     public void abrirSelectorImagen(String quienMeAbre){
//el atributo quienMeAbre permite saber quien creo la ventana para luego ejecura una accion distinta para cada clase
        SelectorImagen al = new SelectorImagen(quienMeAbre);
        Escritorio.add(al);
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }
     public void abrirAltacliente(){
        AltaCliente al = new AltaCliente();
        Escritorio.add(al);
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
     }
     public void abrirMostrarDatosReservaParcial(Map<String, Integer> serviciosCant,Map<String, Integer> promocionesCant,
    Map<String,DataExpira> fechas,Map<String,DataExpira> fechasPromos,String proveedorselecionado,float total,String cliente){
        MostrarDatosReservaParcial al = new MostrarDatosReservaParcial(serviciosCant, promocionesCant,fechas,fechasPromos,proveedorselecionado,total,cliente);
        Escritorio.add(al);
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
     }
     public void abrirImagen(String ruta)  {
        Img altaCat = new Img(ruta);
        Escritorio.add(altaCat);
        try {
            altaCat.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        altaCat.show();
    }
    public void abrirVerInfoServicio(String s) {
       VerInfoServicio al = new VerInfoServicio(s);
       Escritorio.add(al);
       int a = (Escritorio.getWidth() - al.getWidth())/2;
       int b = (Escritorio.getHeight() - al.getHeight()) /2;
       al.setLocation(a ,b);
       al.show();
    }
    public void abrirAgregarCategoria() {
       AgregarCategoria al = new AgregarCategoria();
       Escritorio.add(al);
       int a = (Escritorio.getWidth() - al.getWidth())/2;
       int b = (Escritorio.getHeight() - al.getHeight()) /2;
       al.setLocation(a ,b);
       al.show();
    }
    public void abrirVerInfoReserva(String quine){
        VerInfoReserva al = new VerInfoReserva(quine);
        Escritorio.add(al);
        //cuentas para centrar
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        Servicios = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem6 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem10 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem11 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem12 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem13 = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal H4T");

        Escritorio.setAutoscrolls(true);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");

        jMenu8.setText("Usuarios");

        jMenu9.setText("Clientes");

        jMenuItem14.setText("Alta cliente");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem14);

        jMenuItem5.setText("Ver informacion clientes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem5);

        jMenu8.add(jMenu9);

        jMenu10.setText("Proveedores");

        jMenuItem1.setText("Alta proveedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem1);

        jMenuItem6.setText("Ver informacion proveedor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem6);

        jMenu8.add(jMenu10);

        jMenuBar1.add(jMenu8);

        jMenu3.setText("Reservas");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem10.setText("Realizar reserva");
        jMenuItem10.setEnabled(false);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Actualizar estado");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Cancelar reserva");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem9.setText("Ver informacion Reserva");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu7.setText("Servicos y promociones");

        jMenuItem4.setText("Alta promocion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem8.setText("Ver informacion promociones");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        Servicios.setText("Alta servicio");
        Servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiciosActionPerformed(evt);
            }
        });
        jMenu7.add(Servicios);

        jMenuItem7.setText("Ver informacion servicio");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem16.setText("Actualizar servicio");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Configuracion");

        jMenuItem3.setText("Carga inicial");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem2.setText("Añadir categoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem15.setText("Opciones");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenu5.setText("Thema");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("BlackEye");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setText("BlueMoon");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setText("BlackMoon");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem4.setText("BlueIce");
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem4);

        jRadioButtonMenuItem5.setText("BlueSteel");
        jRadioButtonMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem5);

        jRadioButtonMenuItem6.setText("Classy");
        jRadioButtonMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem6);

        jRadioButtonMenuItem7.setText("GreenDream");
        jRadioButtonMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem7);

        jRadioButtonMenuItem8.setText("MauveMetallic");
        jRadioButtonMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem8);

        jRadioButtonMenuItem9.setText("OrangeMetallic");
        jRadioButtonMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem9);

        jRadioButtonMenuItem10.setText("SilverMoon");
        jRadioButtonMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem10);

        jRadioButtonMenuItem11.setText("Simple2D");
        jRadioButtonMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem11);

        jRadioButtonMenuItem12.setText("SkyMetallic");
        jRadioButtonMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem12);

        jRadioButtonMenuItem13.setText("WhiteVision");
        jRadioButtonMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jRadioButtonMenuItem13);

        jMenu6.add(jMenu5);

        jMenuBar1.add(jMenu6);

        jMenu1.setText("Persistencia");

        jMenuItem13.setText("CrearFactura");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem17.setText("MostrarFactura");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registro de accesos");

        jMenuItem18.setText("Accesos de clientes");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuItem19.setText("Top10 Servicios");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        abrirVerInfoServicio("");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        this.abrirRealizarReserva();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        this.abrirAltacliente();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AltaCategoria altaCat = new AltaCategoria();
        Escritorio.add(altaCat);
         int a = (Escritorio.getWidth() - altaCat.getWidth())/2;
        int b = (Escritorio.getHeight() - altaCat.getHeight()) /2;
        altaCat.setLocation(a ,b);
        altaCat.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        VerInfoProveedor altaCat = new VerInfoProveedor();
        Escritorio.add(altaCat);
         int a = (Escritorio.getWidth() - altaCat.getWidth())/2;
        int b = (Escritorio.getHeight() - altaCat.getHeight()) /2;
        altaCat.setLocation(a ,b);
        altaCat.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        Opciones op = new Opciones();
        Escritorio.add(op);
         int a = (Escritorio.getWidth() - op.getWidth())/2;
        int b = (Escritorio.getHeight() - op.getHeight()) /2;
        op.setLocation(a ,b);
        op.show();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        
        VerInfoCliente al = new VerInfoCliente();
        Escritorio.add(al);
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServiciosActionPerformed
        // TODO add your handling code here:
        AltaServicio al = new AltaServicio();
        Escritorio.add(al);
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }//GEN-LAST:event_ServiciosActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        cancelarReserva CancelReserva = new cancelarReserva();
        Escritorio.add(CancelReserva);
         int a = (Escritorio.getWidth() - CancelReserva.getWidth())/2;
        int b = (Escritorio.getHeight() - CancelReserva.getHeight()) /2;
        CancelReserva.setLocation(a ,b);
        CancelReserva.show();
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        cancelarReserva CancelReserva = new cancelarReserva();
        Escritorio.add(CancelReserva);
         int a = (Escritorio.getWidth() - CancelReserva.getWidth())/2;
        int b = (Escritorio.getHeight() - CancelReserva.getHeight()) /2;
        CancelReserva.setLocation(a ,b);
        CancelReserva.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        AltaPromocion ap = new AltaPromocion();
        Escritorio.add(ap);
        int a = (Escritorio.getWidth() - ap.getWidth())/2;
        int b = (Escritorio.getHeight() - ap.getHeight()) /2;
        ap.setLocation(a ,b);
        ap.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        VerInfoPromocion ap = new VerInfoPromocion();
        Escritorio.add(ap);
        int a = (Escritorio.getWidth() - ap.getWidth())/2;
        int b = (Escritorio.getHeight() - ap.getHeight()) /2;
        ap.setLocation(a ,b);
        ap.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
        
        
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem12ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(true);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem12ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(true);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jRadioButtonMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem5ActionPerformed
        // TODO add your handling code here:
         jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(true);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem5ActionPerformed

    private void jRadioButtonMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem6ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(true);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem6ActionPerformed

    private void jRadioButtonMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem7ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(true);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem7ActionPerformed

    private void jRadioButtonMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem8ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(true);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem8ActionPerformed

    private void jRadioButtonMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem9ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(true);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem9ActionPerformed

    private void jRadioButtonMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem10ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(true);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem10ActionPerformed

    private void jRadioButtonMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem11ActionPerformed
        // TODO add your handling code here:.
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(true);
        jRadioButtonMenuItem12.setSelected(false);
         jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem11ActionPerformed

    private void jRadioButtonMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem13ActionPerformed
        // TODO add your handling code here:
        jRadioButtonMenuItem1.setSelected(false);
        jRadioButtonMenuItem2.setSelected(false);
        jRadioButtonMenuItem3.setSelected(false);
        jRadioButtonMenuItem4.setSelected(false);
        jRadioButtonMenuItem5.setSelected(false);
        jRadioButtonMenuItem6.setSelected(false);
        jRadioButtonMenuItem7.setSelected(false);
        jRadioButtonMenuItem8.setSelected(false);
        jRadioButtonMenuItem9.setSelected(false);
        jRadioButtonMenuItem10.setSelected(false);
        jRadioButtonMenuItem11.setSelected(false);
        jRadioButtonMenuItem12.setSelected(false);
        jRadioButtonMenuItem13.setSelected(true);
        jRadioButtonMenuItem13.setSelected(false);
         try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem13ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        CargaInicial c = new CargaInicial();
        try{
            c.cargar();
            JOptionPane.showMessageDialog(null, "Los datos iniciales se cargaron correctamente.");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AltaProveedor al = new AltaProveedor();
        Escritorio.add(al);
        //cuentas para centrar
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        ActualizarServicio al = new ActualizarServicio();
        Escritorio.add(al);
        //cuentas para centrar
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        abrirVerInfoReserva("");
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        ActualizarEstadoReserva al = new ActualizarEstadoReserva();
        Escritorio.add(al);
        //cuentas para centrar
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        AltaFactura al = new AltaFactura();
        Escritorio.add(al);
        //cuentas para centrar
        int a = (Escritorio.getWidth() - al.getWidth())/2;
        int b = (Escritorio.getHeight() - al.getHeight()) /2;
        al.setLocation(a ,b);
        al.show();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        RegistroDeAccesos ra = new RegistroDeAccesos();
        Escritorio.add(ra);
        int a = (Escritorio.getWidth() - ra.getWidth())/2;
        int b = (Escritorio.getHeight() - ra.getHeight()) /2;
        ra.setLocation(a ,b);
        ra.show();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        PublicadorCliente p = new PublicadorCliente();
        p.publicar();
        PublicadorProveedor pp = new PublicadorProveedor();
        pp.publicar();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                } catch (ParseException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                PantallaPrincipal x = new PantallaPrincipal();
                //Pantalla Principal maximisada
               // x.setExtendedState(MAXIMIZED_BOTH);
                x.setVisible(true);
                
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem Servicios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem10;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem11;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem12;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem13;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem6;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    // End of variables declaration//GEN-END:variables

   

   
}
