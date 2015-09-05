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
import logica.DataCliente;
import logica.DataReserva;

/**
 *
 * @author Juan
 */
public class VerInfoReserva extends javax.swing.JInternalFrame {
 PantallaPrincipal pp = PantallaPrincipal.getInstancia();
   
     String rutaImagen;
    public static int reservaseleccionada =0;
    DefaultListModel model = new DefaultListModel();
    /**
     * Creates new form VerInfoReserva
     */
    public VerInfoReserva() {
        initComponents();
        TreeModel jmodel;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Proveedores");
          List<DataCliente> info = pp.ICC.listarClientes();
        for (DataCliente dtinfoc: info){
            DefaultMutableTreeNode cli = new DefaultMutableTreeNode();
            cli.setUserObject(dtinfoc.getNickname());
            raiz.add(cli);
            List<DataReserva> dtre =  pp.ICC.listarReservasXCliente(dtinfoc.getNickname());
            for (DataReserva dtser: dtre){
                DefaultMutableTreeNode res = new DefaultMutableTreeNode();
                res.setUserObject(dtser.getId());
                cli.add(res);
            }  
        }
        DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
        jTree1.setModel(modeloArbol);
       
        
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
        jTree1 = new javax.swing.JTree();

        setClosable(true);
        setTitle("Informacion de resrva");

        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(768, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
