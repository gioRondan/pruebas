/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import logica.DataCategoria;
import logica.DataProveedor;
import logica.DataServicio;

/**
 *
 * @author Mati
 */
public class AltaServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaServicio
    */
    PantallaPrincipal Pantallaprin = PantallaPrincipal.getInstancia();
    public Object seleccionado;
    public String padre;
    
    public void armarArbol(DefaultMutableTreeNode raiz, List<DataCategoria> dtps){
        for (DataCategoria dtcategoria: dtps){
            DefaultMutableTreeNode cate = new DefaultMutableTreeNode();
            cate.setUserObject(dtcategoria);
            raiz.add(cate);
            armarArbol(cate, dtcategoria.getHijos());
        }
    }
    public AltaServicio() {
        initComponents();
        int precioin=0;
        TreeModel jmodel;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorías");
        List<DataCategoria> dtps = Pantallaprin.ICP.listarCategorias();
        armarArbol(raiz, dtps);
        DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
        jTree1.setModel(modeloArbol);
        //Se agregan todos los proveedores en el conbobox
        List<DataProveedor> p = Pantallaprin.ICP.listarProveedores();
        Iterator<DataProveedor> it = p.iterator();
        while (it.hasNext()){
          DataProveedor dts = it.next();
          String n = dts.getNickname();
          proveedores.addItem(n);
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @return 
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        proveedores = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        proveedorImagen = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        ciudad1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        ciudad2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        proveedorImagen1 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        proveedorImagen2 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("Servicio");

        jLabel24.setText("Nombre:");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        jLabel25.setText("Proveedor:");

        proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresActionPerformed(evt);
            }
        });

        jLabel26.setText("Descripción:");

        jLabel27.setText("Imagen:");

        jButton13.setInheritsPopupMenu(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel28.setText("Precio:");

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jLabel29.setText("Ciudad:");

        ciudad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudad1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Ciudad destino:");

        ciudad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudad2ActionPerformed(evt);
            }
        });

        jLabel31.setText("Categorias:");

        jButton14.setText("Aceptar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Cancelar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane2.setViewportView(descripcion);

        jButton16.setInheritsPopupMenu(true);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setInheritsPopupMenu(true);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudad2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(ciudad1))
                        .addGap(257, 257, 257))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addGap(137, 137, 137))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(proveedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proveedorImagen2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proveedorImagen1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16)
                                    .addComponent(jButton13)
                                    .addComponent(jButton17)))
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(208, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(444, 444, 444))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proveedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proveedorImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proveedorImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addGap(216, 216, 216))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNickActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Pantallaprin.ICP.altaProveedor(proveedorNick.getText() ,proveedorNombre.getText(), proveedorApellido.getText(), proveedorEmail.getText() ,selectedDate , proveedorImagen.getText(), proveedorEmpresaNombre.getText(),proveedorEmpresaLink.getText());
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void clienteNick1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNick1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNick1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        //Pantallaprin.ICP.altaProveedor(proveedorNick.getText() ,proveedorNombre.getText(), proveedorApellido.getText(), proveedorEmail.getText() ,selectedDate , proveedorImagen.getText(), proveedorEmpresaNombre.getText(),proveedorEmpresaLink.getText());
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void clienteNick2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNick2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNick2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        //Pantallaprin.ICP.altaProveedor(proveedorNick.getText() ,proveedorNombre.getText(), proveedorApellido.getText(), proveedorEmail.getText() ,selectedDate , proveedorImagen.getText(), proveedorEmpresaNombre.getText(),proveedorEmpresaLink.getText());
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nombreActionPerformed

    private void proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proveedoresActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        Pantallaprin.abrirSelectorImagen("AltaServicio");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void ciudad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudad1ActionPerformed

    private void ciudad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudad2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       
        String p = proveedores.getSelectedItem().toString();
        String pre = precio.getText();
        int precioin;
        precioin=Integer.parseInt(pre);
        //Pantallaprin.ICP.altaServicio(nombre.getText(),descripcion.getText(),precioin,ciudad1.getText(),p,);
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ciudad1;
    public static javax.swing.JTextField ciudad2;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JTextField precio;
    public static javax.swing.JTextField proveedorImagen;
    public static javax.swing.JTextField proveedorImagen1;
    public static javax.swing.JTextField proveedorImagen2;
    private javax.swing.JComboBox proveedores;
    // End of variables declaration//GEN-END:variables
}
