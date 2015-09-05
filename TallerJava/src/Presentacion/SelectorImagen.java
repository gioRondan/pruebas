/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Juan
 */
public class SelectorImagen extends javax.swing.JInternalFrame {
      //public static File archivoSeleccionado;
     String padre;
    /**
     * Creates new form SelectorImagen
     */
    public SelectorImagen(String quien ) {
        initComponents();
        this.padre = quien;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setTitle("Selector de archivos");

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        JFileChooser selector = (JFileChooser)evt.getSource();
        FileFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        selector.setFileFilter(filtroImagen);
        selector.setAcceptAllFileFilterUsed(false);
        
        String comando = evt.getActionCommand();
        if (comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archivoSeleccionado = selector.getSelectedFile();
            if (this.padre.equals("AltaProveedor")){
                AltaProveedor.proveedorImagen.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("AltaCliente")){
              AltaCliente.clienteImagen.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("AltaServicio1")){
              AltaServicio.servicioImagen1.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("AltaServicio2")){
                 AltaServicio.servicioImagen2.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("AltaServicio3")){
              AltaServicio.servicioImagen3.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("ActualizarServicio1")){
                // Accion para la clase.
               ActualizarServicio.imagen1.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("ActualizarServicio2")){
                // Accion para la clase.
                ActualizarServicio.imagen2.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals("ActualizarServicio3")){
                // Accion para la clase.
                ActualizarServicio.imagen3.setText(archivoSeleccionado.getAbsolutePath());
            }
            if (this.padre.equals(""/*nombre clase*/)){
                // Accion para la clase.
            }
            this.dispose();
        }else if (comando.equals(JFileChooser.CANCEL_SELECTION)){
            this.dispose();
        }
   
    }//GEN-LAST:event_jFileChooser1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
