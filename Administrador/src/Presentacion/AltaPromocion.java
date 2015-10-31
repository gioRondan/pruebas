/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import logica.DataInfoServicio;
import logica.DataProveedor;
import logica.DataServicio;

/**
 *
 * @author Juan
 */
public class AltaPromocion extends javax.swing.JInternalFrame {
    PantallaPrincipal pp = PantallaPrincipal.getInstancia();
    /**
     * Creates new form AltaPromocion
     */
    
   
    public AltaPromocion() {
        initComponents();
        int precioin=0;
        TreeModel jmodel;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Proveedores");
        List<DataProveedor> dtproveedores = pp.ICP.listarProveedores();
        for (DataProveedor dtprv: dtproveedores){
            DefaultMutableTreeNode prv = new DefaultMutableTreeNode();
            prv.setUserObject(dtprv.getNickname());
            raiz.add(prv);
            List<DataServicio> dtservicios = pp.ICP.listarServiciosXProveedor(dtprv.getNickname());
            for (DataServicio dtser: dtservicios){
                DefaultMutableTreeNode ser = new DefaultMutableTreeNode();
                ser.setUserObject(dtser.getNombre());
                prv.add(ser);
            }  
        }
        precioTotal.setText("0");
        DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
        jTree1.setModel(modeloArbol);
        jTree1.setSelectionRow(0); //Selecciono la raiz
        promocionNombre.requestFocus();        
    }
    
    public void limpiarCampos(){
        promocionNombre.setText("");
        promocionNombre.requestFocus();
    }
    
    public String letraCapital(String texto){
    //Convierte la primera letra de una texto a mayuscula, el resto a minusculas
        String resultado = "";
        if(!texto.isEmpty()){
            texto = texto.toLowerCase(); //pasamos a minuscula
            String[] palabras = texto.split("\\s"); //partimos si tiene mas de una palabra
            for(String palabra : palabras) {
                resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1)+ " ";
            }
        }
        return resultado;
    }
    
    public static boolean esNumerico(String str){
        return str.matches("\\d+(\\.\\d+)?");  //matchea numeros con decimales
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        promocionNombre = new javax.swing.JTextField();
        promocionDescuento = new javax.swing.JSpinner();
        precioTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nomser = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descser = new javax.swing.JTextArea();
        preser = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Nueva promocion");
        setFrameIcon(new javax.swing.ImageIcon("/ens/home01/r/rodrigo.linares/NetBeansProjects/tpgr07/TallerJava/src/Imagenes/iconoH4T.png")); // NOI18N

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Precio total:");

        jLabel3.setText("Descuento:");

        promocionDescuento.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        precioTotal.setEditable(false);
        precioTotal.setToolTipText("Precio de los servicios seleccionado sin el descuento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Promocion");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Info servico:");

        nomser.setEditable(false);
        nomser.setText("Nombre");
        nomser.setToolTipText("nombre del ultimo servicio seleccionado");

        descser.setEditable(false);
        descser.setColumns(20);
        descser.setLineWrap(true);
        descser.setRows(5);
        descser.setText("Descripcion");
        jScrollPane2.setViewportView(descser);

        preser.setEditable(false);
        preser.setText("Precio");
        preser.setToolTipText("precio del ultimo servicio seleccionado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(promocionDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(promocionNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomser)))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(preser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(40, 40, 40))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(promocionNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(promocionDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(precioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nomser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(preser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        List<String> ser = new ArrayList<>();
        TreePath[] seleccionados = jTree1.getSelectionPaths();
        String proveedor="";        
        if(promocionNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para la promoción");
            promocionNombre.requestFocus();
            return;
        }
        else if(promocionDescuento.getValue().toString().isEmpty() || 
                !esNumerico(promocionDescuento.getValue().toString())){
            JOptionPane.showMessageDialog(null, "Ingrese un descuento válido");
            promocionDescuento.requestFocus();
            return;
        }

        String nombre = letraCapital(promocionNombre.getText());
        int descuento = Integer.parseInt(promocionDescuento.getValue().toString());        
        for (TreePath x : seleccionados){
            String path = x.toString();
            String servicio = path.substring(path.lastIndexOf(",")+2, path.lastIndexOf("]"));            
            proveedor = path.substring(path.indexOf(",")+2,path.lastIndexOf(","));
            ser.add(servicio);
        }
        try{
            pp.ICP.altaPromocion(proveedor, ser, nombre, descuento);
            JOptionPane.showMessageDialog(null, "La promoción se ingresó correctamente");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());            
        }        
        finally{
            limpiarCampos();            
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        precioTotal.setText( "0" );
        TreePath[] seleccionados = jTree1.getSelectionPaths();
         String proveedor="";
         String proveedorAnt="";
        for (TreePath x : seleccionados){
            String path = x.toString();
            String servicio = path.substring(path.lastIndexOf(",")+2, path.lastIndexOf("]")); 
            proveedor = path.substring(path.indexOf(",")+2,path.lastIndexOf(","));
            if(!proveedorAnt.isEmpty()){
                if (!proveedorAnt.equals(proveedor)){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar servicios del mismo proveedor");
                    return;
                }
            }
            nomser.setText(servicio);
            
            proveedorAnt = proveedor;
            DataServicio serinfo=null;
            try {
                serinfo = pp.ICP.informacionServicio(proveedor,servicio);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            descser.setText(serinfo.getDescripcion());
            preser.setText(Float.toString(serinfo.getPrecio()));
            float total = Float.parseFloat(precioTotal.getText())+serinfo.getPrecio();
            precioTotal.setText( Float.toString(total) );
        }
    }//GEN-LAST:event_jTree1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField nomser;
    private javax.swing.JTextField precioTotal;
    private javax.swing.JTextField preser;
    private javax.swing.JSpinner promocionDescuento;
    private javax.swing.JTextField promocionNombre;
    // End of variables declaration//GEN-END:variables
}