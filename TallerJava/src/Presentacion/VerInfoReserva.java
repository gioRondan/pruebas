/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import logica.DataCliente;
import logica.DataInfoReserva;
import logica.DataPromocion;
import logica.DataProveedor;
import logica.DataReserva;
import logica.DataServicio;

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
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Clientes");
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
       
        DefaultMutableTreeNode raiz2 = new DefaultMutableTreeNode("");
     
        raiz2.add(new DefaultMutableTreeNode("Servicios"));
        raiz2.add(new DefaultMutableTreeNode("Promociones"));
        DefaultTreeModel modeloArbol2 = new DefaultTreeModel(raiz2);
        jTree2.setModel(modeloArbol2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Fechacreacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Estado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Fechacreacion1 = new javax.swing.JTextField();
        Fechacreacion2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Informacion de resrva");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Servicio o promocion");

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jScrollPane2.setViewportView(jTree2);

        jLabel1.setText("Id:");

        Id.setEnabled(false);
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha creacion:");

        Fechacreacion.setEnabled(false);

        jLabel3.setText("Precio:");

        Precio.setEnabled(false);

        jLabel4.setText("Estado:");

        Estado.setEnabled(false);

        jLabel5.setText("Reservas:");

        jLabel6.setText("Promociones y servicios:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Reserva");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Fecha inicio:");

        Fechacreacion1.setEnabled(false);

        Fechacreacion2.setEnabled(false);

        jLabel10.setText("Fecha fin:");

        jTextField1.setEditable(false);

        jLabel11.setText("Cantidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Fechacreacion1)
                        .addComponent(Fechacreacion2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Fechacreacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Fechacreacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(255, 255, 255)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Id)
                                            .addComponent(Fechacreacion)
                                            .addComponent(Precio)
                                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Fechacreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
      
        javax.swing.tree.DefaultMutableTreeNode raiz2 = new javax.swing.tree.DefaultMutableTreeNode("");
        DefaultMutableTreeNode sss = new DefaultMutableTreeNode("Servicios");
        DefaultMutableTreeNode ppp = new DefaultMutableTreeNode("Promociones");
        raiz2.add(sss);
        raiz2.add(ppp);
        String pat = jTree1.getSelectionPath().toString();
        String nickC = pat.substring(pat.indexOf(",")+2, pat.lastIndexOf(",")); ;
        String reservaid = pat.substring(pat.lastIndexOf(",")+2, pat.lastIndexOf("]"));
        
        DataInfoReserva inf = pp.ICC.verInfoReserva(nickC, Integer.parseInt(reservaid));
        
        Id.setText(reservaid);
        JOptionPane.showMessageDialog(null, inf.getPrecio());
        Precio.setText(Float.toString(inf.getPrecio()));
        Estado.setText(inf.getEstado().toString());
        Fechacreacion.setText(inf.getFechaCreacion().toString());
//        List<DataProveedor> dtproveedores = pp.ICC..listarProveedores();
//        for (DataProveedor dtprv: dtproveedores){
//            DefaultMutableTreeNode prv = new DefaultMutableTreeNode();
//            prv.setUserObject(dtprv.getNickname());
//            raiz.add(prv);
//            
//            prv.add(sss);
//            prv.add(ppp);
//            List<DataServicio> dtservicios = pp.ICP.listarServiciosXProveedor(dtprv.getNickname());
//            for (DataServicio dtser: dtservicios){
//                DefaultMutableTreeNode ser = new DefaultMutableTreeNode();
//                ser.setUserObject(dtser.getNombre());
//                sss.add(ser);
//            }
//            List<DataPromocion> dtpromos = pp.ICP.listarPromocionesXProveedor(dtprv.getNickname());
//            for (DataPromocion dtpp: dtpromos){
//                DefaultMutableTreeNode np = new DefaultMutableTreeNode();
//                np.setUserObject(dtpp.getNombre());
//                ppp.add(np);
//        }
        DefaultTreeModel modeloArbol2 = new DefaultTreeModel(raiz2);
        jTree2.setModel(modeloArbol2);
    }//GEN-LAST:event_jTree1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField Fechacreacion;
    private javax.swing.JTextField Fechacreacion1;
    private javax.swing.JTextField Fechacreacion2;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables
}
