/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import logica.Categoria;
import logica.DataCategoria;
import logica.DataProveedor;

/**
 *
 * @author rodrigo.linares
 */
public class AltaCategoria extends javax.swing.JInternalFrame {

           
    public Object seleccionado;
    public String padre;
    PantallaPrincipal Pantallaprin = PantallaPrincipal.getInstancia();

    public void armarArbol(DefaultMutableTreeNode raiz, List<DataCategoria> dtps){
        for (DataCategoria dtcategoria: dtps){
            DefaultMutableTreeNode cate = new DefaultMutableTreeNode();
            cate.setUserObject(dtcategoria);
            raiz.add(cate);
            armarArbol(cate, dtcategoria.getHijos());
        }
    }
    
    
    public AltaCategoria() {
        initComponents();
        TreeModel jmodel;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorías");
        List<DataCategoria> dtps = Pantallaprin.ICP.listarCategorias();
        armarArbol(raiz, dtps);
        DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
        Arbol.setModel(modeloArbol);
        Arbol.setSelectionRow(0); //Selecciono la raiz
        NombreCategoria.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Arbol = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NombreCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alta Categoría");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        Arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArbolMouseClicked(evt);
            }
        });
        Arbol.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ArbolValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Arbol);

        jLabel1.setText("Categoría padre");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        NombreCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreCategoriaFocusLost(evt);
            }
        });
        NombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel2)
                            .addComponent(NombreCategoria, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel1))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(NombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String st = NombreCategoria.getText();
        //Control de nombre de categoría vacío
        if(st.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido");
            NombreCategoria.requestFocus();
            return;
        }
        //Criterio letra capital, sirve para controlar categorias repetidas
        st = st.toLowerCase(); //pasamos a minuscula
        st = st.substring(0, 1).toUpperCase() + st.substring(1);
        DefaultTreeModel model;
        model = (DefaultTreeModel) Arbol.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.seleccionado;
        Pantallaprin.ICP.ingresarNombreCategoria(st);
        Pantallaprin.ICP.seleccionarPadre(this.padre);
        try {
            Pantallaprin.ICP.altaCategoria();
            model.insertNodeInto(new DefaultMutableTreeNode(st), root, root.getChildCount());
            NombreCategoria.setText(null);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
             NombreCategoria.selectAll();
        }
        NombreCategoria.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreCategoriaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NombreCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreCategoriaFocusLost
        
    }//GEN-LAST:event_NombreCategoriaFocusLost

    private void ArbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArbolMouseClicked
        
    }//GEN-LAST:event_ArbolMouseClicked

    private void ArbolValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ArbolValueChanged
        this.seleccionado = Arbol.getLastSelectedPathComponent();
        TreeModel model = Arbol.getModel();
        TreePath x = Arbol.getSelectionPath();
        String padreSelec = x.toString();
        padreSelec = padreSelec.substring(padreSelec.lastIndexOf(",")+2, padreSelec.lastIndexOf("]"));
        this.padre = padreSelec;
        jLabel1.setText(padreSelec);
    }//GEN-LAST:event_ArbolValueChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbol;
    private javax.swing.JTextField NombreCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
