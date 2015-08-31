/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;


import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
   
       this.RutaImagenes= JOptionPane.showInputDialog("Selecciones una ruta para las imagenes");
            if (this.RutaImagenes==null){
                 this.RutaImagenes = "C:\\Imagenes\\";
            }
            else if (this.RutaImagenes.isEmpty()){
                this.RutaImagenes = "C:\\Imagenes\\";
            }
            File usuarios=new File(this.RutaImagenes+"Usuarios"); 
            usuarios.mkdir();
            File servicios=new File(this.RutaImagenes+"Servicios"); 
            servicios.mkdir();
    
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Servicios = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal H4T");

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");

        jMenu1.setText("Altas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenu4.setText("Usuario");

        jMenuItem1.setText("Proveedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem14.setText("Cliente");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenu1.add(jMenu4);

        jMenuItem2.setText("Categoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        Servicios.setText("Servicios");
        Servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiciosActionPerformed(evt);
            }
        });
        jMenu1.add(Servicios);

        jMenuItem4.setText("Promocion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("VerInfo");

        jMenuItem5.setText("Clientes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Proveedor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Servicio");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Promocion");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Reserva");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reservas");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem10.setText("Realizar reserva");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Actualizar estado");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Cancelar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Configuracion");

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

        jMenu6.add(jMenu5);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

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
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
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
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
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
        
        try {
            UIManager.removeAuxiliaryLookAndFeel(UIManager.getLookAndFeel());
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

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
                x.setExtendedState(MAXIMIZED_BOTH);
                x.setVisible(true);
                
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem Servicios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    // End of variables declaration//GEN-END:variables

   

   
}
