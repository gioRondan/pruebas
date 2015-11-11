/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import logica.DataCliente;
import logica.DataInfoReserva;
import logica.DataItemReserva;
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
    Set<DataItemReserva> dtIR= new HashSet(); 
    /**
     * Creates new form VerInfoReserva
     */
    public VerInfoReserva(String quien) {
        initComponents();
        
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
        panelseropromo.setVisible(false);
        tituloseropromo.setText("");
        

        
        int reserva=0; 
        if (quien.equals("VerInfoCliente")){
        
            reserva = VerInfoCliente.reservaseleccionada;
        }
        
         if (reserva > 0){
            String s= Integer.toString(reserva);
            int i = 0;
            jTree1.setSelectionRow(i);
            expandAll(jTree1, jTree1.getSelectionPath(), true);
         
            String cate = "";
            //JOptionPane.showMessageDialog(null, "Voy a comparar"+cate+" con "+reserva );
            while ( ( !(  s.equals(cate)) ) ){//busco una reserva en el arbol
               // JOptionPane.showMessageDialog(null, "Voy "+i);
                i++;
                jTree1.setSelectionRow(i);
                cate = jTree1.getSelectionPath().toString();
                cate = cate.substring(cate.lastIndexOf(",")+2, cate.lastIndexOf("]"));
                //JOptionPane.showMessageDialog(null, "Voy a comparar "+s+" con "+cate);
                
            }
            jTree1MouseClicked(null);//ejecuto el evento click para que se carge la data
        }
    }
    static private void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (@SuppressWarnings("unchecked")
            Enumeration<TreeNode> e = node.children(); e.hasMoreElements();) {
                TreeNode treeNode = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(treeNode);
                expandAll(tree, path, expand);
            }
        }   
        // Expansion or collapse must be done bottom-up
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloseropromo = new javax.swing.JLabel();
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
        panelseropromo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fechainicio = new javax.swing.JTextField();
        fechafin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Informacion de reserva");
        setFrameIcon(new javax.swing.ImageIcon("/ens/home01/r/rodrigo.linares/NetBeansProjects/tpgr07/TallerJava/src/Imagenes/iconoH4T.png")); // NOI18N
        setPreferredSize(new java.awt.Dimension(815, 460));
        setVisible(true);

        tituloseropromo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tituloseropromo.setText("Servicio o promocion");

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jTree2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree2MouseClicked(evt);
            }
        });
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

        panelseropromo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Fecha inicio:");

        fechainicio.setEnabled(false);

        fechafin.setEnabled(false);

        jLabel10.setText("Fecha fin:");

        cant.setEditable(false);

        jLabel11.setText("Cantidad:");

        javax.swing.GroupLayout panelseropromoLayout = new javax.swing.GroupLayout(panelseropromo);
        panelseropromo.setLayout(panelseropromoLayout);
        panelseropromoLayout.setHorizontalGroup(
            panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelseropromoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelseropromoLayout.createSequentialGroup()
                        .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addComponent(fechainicio)
                    .addComponent(fechafin, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelseropromoLayout.setVerticalGroup(
            panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelseropromoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelseropromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(tituloseropromo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(panelseropromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fechacreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fechacreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addComponent(tituloseropromo)
                        .addGap(7, 7, 7)
                        .addComponent(panelseropromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
      panelseropromo.setVisible(false);
      tituloseropromo.setText("");
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
        Precio.setText(Float.toString(inf.getPrecio()));
        Estado.setText(inf.getEstado().toString());
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");	
        Fechacreacion.setText(formatoFecha.format(inf.getFechaCreacion()));
        dtIR = inf.getItems();
        for (DataItemReserva dtir : dtIR){
            DefaultMutableTreeNode ir = new DefaultMutableTreeNode();
            if (dtir.getesServico()){
                ir.setUserObject(dtir.getServicio().getNombre());
                sss.add(ir);
            }else{
                ir.setUserObject(dtir.getPromocion().getNombre());
                ppp.add(ir);
            }
        }
        DefaultTreeModel modeloArbol2 = new DefaultTreeModel(raiz2);
        jTree2.setModel(modeloArbol2);
    }//GEN-LAST:event_jTree1MouseClicked

    private void jTree2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree2MouseClicked
        String pat = jTree2.getSelectionPath().toString();
        String es = pat.substring(pat.indexOf(",")+2,pat.lastIndexOf(","));
        boolean esser=false;
        if (es.equals("Servicios")){
            esser=true;
            tituloseropromo.setText("Servicio");
        }else{
            tituloseropromo.setText("Promocion");
        }
       
        
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");	
        String nombre = pat.substring(pat.lastIndexOf(",")+2, pat.lastIndexOf("]"));
        
        for (DataItemReserva dt : dtIR){
            String nomb ="";
            if (dt.getesServico()){
                nomb=dt.getServicio().getNombre();
            }else{
                nomb = dt.getPromocion().getNombre();
            }
            if ((dt.getesServico()==esser) & nomb.equals(nombre)){
                
                fechainicio.setText(formatoFecha.format(dt.getFechaInicio()));
                fechafin.setText(formatoFecha.format(dt.getFechaFin()));
                cant.setText(Integer.toString(dt.getCantidad()));  
                
            }
            
        }
        
         panelseropromo.setVisible(true);
    }//GEN-LAST:event_jTree2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField Fechacreacion;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Precio;
    private javax.swing.JTextField cant;
    private javax.swing.JTextField fechafin;
    private javax.swing.JTextField fechainicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    private javax.swing.JPanel panelseropromo;
    private javax.swing.JLabel tituloseropromo;
    // End of variables declaration//GEN-END:variables
}
