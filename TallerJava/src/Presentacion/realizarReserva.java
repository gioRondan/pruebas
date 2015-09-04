/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import logica.DataCliente;
import logica.DataExpira;
import logica.DataInfoPromocion;
import logica.DataPromocion;
import logica.DataProveedor;
import logica.DataServicio;

/**
 *
 * @author Mati
 */
public class realizarReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form realizarReserva2
     */
    
    PantallaPrincipal pp = PantallaPrincipal.getInstancia();
    private Map<String, Integer> serviciosCant;
    private Map<String, Integer> promocionesCant;
    private Map<String,DataExpira> fechas;
    private String proveeElegido;
    private Map<String,DataExpira> fechasPromos;
    
            

    public realizarReserva() {
        //matias trabajando
        initComponents();
        jScrollPane1.getViewport().add(jList2);

        serviciosCant = new HashMap();
        promocionesCant = new HashMap();
        fechas = new HashMap();
        fechasPromos = new HashMap();
       
        
        DefaultListModel<String> mol = new DefaultListModel<>(); 
        List<DataCliente> dts = pp.ICC.listarClientes();
        Iterator<DataCliente> itera = dts.iterator();
        while (itera.hasNext()) {
            DataCliente dt = itera.next();
            String aux = dt.getNickname();
            mol.addElement(aux);
        }

        jList2.setModel(mol);
        // ahi quedo la lista
        TreeModel jmodel;
        javax.swing.tree.DefaultMutableTreeNode raiz = new javax.swing.tree.DefaultMutableTreeNode("Proveedores");
        
        List<DataProveedor> dtproveedores = pp.ICP.listarProveedores();
        for (DataProveedor dtprv: dtproveedores){
            DefaultMutableTreeNode prv = new DefaultMutableTreeNode();
            prv.setUserObject(dtprv.getNickname());
            raiz.add(prv);
            DefaultMutableTreeNode sss = new DefaultMutableTreeNode("Servicios");
            DefaultMutableTreeNode ppp = new DefaultMutableTreeNode("Promociones");
            prv.add(sss);
            prv.add(ppp);
            List<DataServicio> dtservicios = pp.ICP.listarServiciosXProveedor(dtprv.getNickname());
            for (DataServicio dtser: dtservicios){
                DefaultMutableTreeNode ser = new DefaultMutableTreeNode();
                ser.setUserObject(dtser.getNombre());
                sss.add(ser);
            }
            List<DataPromocion> dtpromos = pp.ICP.listarPromocionesXProveedor(dtprv.getNickname());
            for (DataPromocion dtpp: dtpromos){
                DefaultMutableTreeNode np = new DefaultMutableTreeNode();
                np.setUserObject(dtpp.getNombre());
                ppp.add(np);
        }
            
            
        }   // agregamos todos los proveedores al jtree {matias heredia}
        /*for(int i=1;i<=500;i++){
            javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("nabo");
            treeNode1.add(treeNode2);
        }*/
        
        precioTotal.setText("0");
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
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        precioTotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        cant = new javax.swing.JSpinner();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        label3 = new java.awt.Label();

        setClosable(true);
        setTitle("Realizar reserva");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList2);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione un servicio o promocion");
        jLabel1.setAlignmentY(0.0F);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione un cliente");
        jLabel2.setAlignmentY(0.0F);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio total:");

        precioTotal.setEditable(false);
        precioTotal.setToolTipText("Precio de los servicios seleccionado sin el descuento");

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        label1.setText("Seleccione fecha de inicio");

        label2.setText("Cantidad");

        label3.setText("Seleccione fecha de fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(precioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
            
    }//GEN-LAST:event_jTree1ValueChanged

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_jTree1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
    try{
        JOptionPane.showMessageDialog(null,jList2.getSelectedValue().toString());
        pp.ICC.realizarReserva(proveeElegido,jList2.getSelectedValue().toString(),serviciosCant,promocionesCant, fechas,fechasPromos,null);
        JOptionPane.showMessageDialog(null,"la reserva se realizo correctamente");
        //hay que vacial los mapps
    }   catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Error al ingresar reserva" + ex.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        TreePath[] seleccionados = jTree1.getSelectionPaths();
        String proveedor="";
        String es="";
        String proveedorAnt="";
        for (TreePath x : seleccionados){
            String path = x.toString();
            String servicioopromo = path.substring(path.lastIndexOf(",")+2, path.lastIndexOf("]")); 
            proveedor = path.substring(path.indexOf(",")+2,path.lastIndexOf(","));
            es = proveedor.substring(proveedor.indexOf(",")+2,proveedor.length() );
            proveedor = proveedor.substring(0,proveedor.indexOf(",") );            
            if(!proveedorAnt.isEmpty()){
                if (!proveedorAnt.equals(proveedor)){
                    JOptionPane.showMessageDialog(null, "Selecione servicios o promociones de un mismo proveedor");
                    return;
                }
            }
            proveedorAnt = proveedor;
            Date fecha1   = jDateChooser1.getDate();
            Date fecha2   = jDateChooser2.getDate();
            JOptionPane.showMessageDialog(null, "que es :"+es);
             float total;
            if (es.equals("Servicios")){ 
                DataServicio serinfo =  pp.ICP.informacionServicio(proveedor,servicioopromo);
                DataExpira dtx= new DataExpira(fecha1,fecha2);
                fechas.put(serinfo.getNombre(),dtx);
                serviciosCant.put(serinfo.getNombre(),Integer.parseInt(cant.getValue().toString()));
                total = Float.parseFloat(precioTotal.getText())+serinfo.getPrecio();
            }else{
                DataInfoPromocion proinfo =  pp.ICP.verInfoPromocion(proveedor, servicioopromo) ;
                DataExpira dtx= new DataExpira(fecha1,fecha2);
                fechasPromos.put(proinfo.getNombre(),dtx);
                promocionesCant.put(proinfo.getNombre(),Integer.parseInt(cant.getValue().toString()));
                total = Float.parseFloat(precioTotal.getText())+proinfo.getPrecioTotal();
            
            }    
            
            proveeElegido=proveedor;
            precioTotal.setText( Float.toString(total) );
        
        }   
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner cant;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField precioTotal;
    // End of variables declaration//GEN-END:variables
}
