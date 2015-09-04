/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import logica.DataCategoria;
import logica.DataInfoServicio;
import logica.DataServicio;

/**
 *
 * @author Rodrigo
 */
public class VerInfoServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInfoServicio
     */
    
    public Object seleccionado;
    public String padre;
    PantallaPrincipal Pantallaprin = PantallaPrincipal.getInstancia();
    DefaultListModel modeloServicios = new DefaultListModel();
    String[] rutaImagen;
    int imagenSelecc = 0;
    
    public void armarArbol(DefaultMutableTreeNode raiz, List<DataCategoria> dtps){
        for (DataCategoria dtcategoria: dtps){
            DefaultMutableTreeNode cate = new DefaultMutableTreeNode();
            cate.setUserObject(dtcategoria);
            raiz.add(cate);
            armarArbol(cate, dtcategoria.getHijos());
        }
    }
    
    public VerInfoServicio(String quien) {
        initComponents();
        TreeModel jmodel;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorías");
        List<DataCategoria> dtps = Pantallaprin.ICP.listarCategorias();
        armarArbol(raiz, dtps);
        DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
        Arbol.setModel(modeloArbol);
        edt_destino.setVisible(false);
        jLabel5.setVisible(false);
        DataInfoServicio mostrar =null;
        if (quien.equals("VerInfoProveedor")){
            String nombre = VerInfoProveedor.Servicioseleccionado;
            String proveedor = VerInfoProveedor.proveedorSeleccionado;
            mostrar = Pantallaprin.ICP.verInfoServicio(nombre, proveedor);
        }
        if (quien.equals("VerInfoPromocion")){
        
        }
        
        if (mostrar != null){
            edt_nombre.setText(mostrar.getNombre());
            edt_descripcion.setText(mostrar.getDescripcion());

            if (!(mostrar.getDestino()==null)){
               edt_destino.setText(mostrar.getDestino().getNombre());
               edt_destino.setVisible(true);
               jLabel5.setVisible(true);
            }else{
               edt_destino.setVisible(false);
               jLabel5.setVisible(false);
            }

            edt_origen.setText(mostrar.getOrigen().getNombre());
            edt_precio.setText(Float.toString(mostrar.getPrecio()));
            edt_proveedor.setText(mostrar.getProveedor().getNickname());
            rutaImagen = mostrar.getImagen();
            if (jPanel1.getComponentCount() == 0){//si no tiene ninguan imagen 
                Imagen im = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                jPanel1.add(im).repaint();        
            }else{ // si tiene borro y agrego la nueva 
                 jPanel1.removeAll();
                 Imagen im2 = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                 jPanel1.add(im2).repaint(); 
            }
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_next = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edt_nombre = new javax.swing.JTextField();
        edt_origen = new javax.swing.JTextField();
        edt_destino = new javax.swing.JTextField();
        edt_precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edt_descripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Arbol = new javax.swing.JTree();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListServicios = new javax.swing.JList();
        edt_proveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Informacion de servicio");
        setToolTipText("");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Precio:");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_previous.setText("<<");
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        jLabel4.setText("Ciduad origen:");

        jLabel5.setText("Ciudad destino:");

        edt_nombre.setEditable(false);

        edt_origen.setEditable(false);

        edt_destino.setEditable(false);

        edt_precio.setEditable(false);

        edt_descripcion.setEditable(false);
        edt_descripcion.setColumns(20);
        edt_descripcion.setRows(5);
        jScrollPane1.setViewportView(edt_descripcion);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        Arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Arbol.setToolTipText("");
        Arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArbolMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Arbol);

        jLabel6.setText("Categorias");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ListServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListServiciosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListServicios);

        edt_proveedor.setEditable(false);

        jLabel7.setText("Proveedor:");

        jLabel8.setText("Servicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(59, 59, 59)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edt_origen)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(edt_nombre)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(edt_proveedor)
                            .addComponent(edt_destino))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btn_previous)
                                .addGap(31, 31, 31)
                                .addComponent(btn_next))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_previous)
                                .addComponent(btn_next)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(edt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edt_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArbolMouseClicked
        modeloServicios.clear();
        TreePath x = Arbol.getSelectionPath();
        String padreSelec = x.toString();
        padreSelec = padreSelec.substring(padreSelec.lastIndexOf(",")+2, padreSelec.lastIndexOf("]"));
        this.padre = padreSelec;
        jLabel6.setText(padreSelec);
        List<DataServicio> servi = Pantallaprin.ICP.listarServiciosXCategoria(this.padre);
        for (DataServicio it: servi){
            modeloServicios.addElement(it);
        }
        ListServicios.setModel(modeloServicios);
    }//GEN-LAST:event_ArbolMouseClicked

    private void ListServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListServiciosMouseClicked
        String selecc = modeloServicios.elementAt(ListServicios.getAnchorSelectionIndex()).toString();
        String nombre = selecc.substring(0, selecc.lastIndexOf("-")-1);
        String proveedor = selecc.substring(selecc.lastIndexOf("-")+2,selecc.length());
        DataInfoServicio mostrar = Pantallaprin.ICP.verInfoServicio(nombre, proveedor);
        edt_nombre.setText(mostrar.getNombre());
        edt_descripcion.setText(mostrar.getDescripcion());
        
        if (!(mostrar.getDestino()==null)){
           edt_destino.setText(mostrar.getDestino().getNombre());
           edt_destino.setVisible(true);
           jLabel5.setVisible(true);
        }else{
           edt_destino.setVisible(false);
           jLabel5.setVisible(false);
        }
        
        edt_origen.setText(mostrar.getOrigen().getNombre());
        edt_precio.setText(Float.toString(mostrar.getPrecio()));
        edt_proveedor.setText(mostrar.getProveedor().getNickname());
        rutaImagen = mostrar.getImagen();
        if (jPanel1.getComponentCount() == 0){//si no tiene ninguan imagen 
            Imagen im = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
            jPanel1.add(im).repaint();        
        }else{ // si tiene borro y agrego la nueva 
             jPanel1.removeAll();
             Imagen im2 = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
             jPanel1.add(im2).repaint(); 
        }
        
        
    }//GEN-LAST:event_ListServiciosMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if(imagenSelecc < 3){ 
           imagenSelecc++;
        }
        else{
            imagenSelecc = 0;
        }
        if(!rutaImagen[imagenSelecc].isEmpty()){
            if (jPanel1.getComponentCount() == 0){//si no tiene ninguan imagen 
                Imagen im = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                jPanel1.add(im).repaint();        
            }else{ // si tiene borro y agrego la nueva 
                 jPanel1.removeAll();
                 Imagen im2 = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                 jPanel1.add(im2).repaint(); 
            }
        }
        else{
            imagenSelecc = 0;
            if (jPanel1.getComponentCount() == 0){//si no tiene ninguan imagen 
                Imagen im = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                jPanel1.add(im).repaint();        
            }else{ // si tiene borro y agrego la nueva 
                 jPanel1.removeAll();
                 Imagen im2 = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
                 jPanel1.add(im2).repaint(); 
            }
        }     
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        if(imagenSelecc == 0){ 
           //imagenSelecc.getTope();
           if(!rutaImagen[2].isEmpty()){ 
               imagenSelecc = 2;
           }
           else if(!rutaImagen[1].isEmpty()){ 
               imagenSelecc = 1;
           }
           else if(!rutaImagen[0].isEmpty()){
               imagenSelecc = 0;
           }     
           else{
               return;
           }     
        }
        else{
            imagenSelecc--;
        } 
        jPanel1.removeAll();
        Imagen im2 = new Imagen(jPanel1, rutaImagen[imagenSelecc]);
        jPanel1.add(im2).repaint();         
    }//GEN-LAST:event_btn_previousActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Pantallaprin.abrirImagen(rutaImagen[imagenSelecc]);
    }//GEN-LAST:event_jPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbol;
    private javax.swing.JList ListServicios;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JTextArea edt_descripcion;
    private javax.swing.JTextField edt_destino;
    private javax.swing.JTextField edt_nombre;
    private javax.swing.JTextField edt_origen;
    private javax.swing.JTextField edt_precio;
    private javax.swing.JTextField edt_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
