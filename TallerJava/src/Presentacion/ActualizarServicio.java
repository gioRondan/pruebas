/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;

import logica.DataCategoria;
import logica.DataCiudad;
import logica.DataInfoServicio;
import logica.DataProveedor;
import logica.DataServicio;

/**
 *
 * @author rodrigo.linares
 */
public class ActualizarServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    
    DefaultListModel modeloServicios = new DefaultListModel();
    PantallaPrincipal Pantallaprin = PantallaPrincipal.getInstancia();
    public static DefaultListModel modeloCategorias = new DefaultListModel();
    public static DefaultListModel modeloCategoriasnuevas = new DefaultListModel();
    public  String nombreservicioseleccionado ="";
    public ActualizarServicio() {
        initComponents();
        List<DataProveedor> p = Pantallaprin.ICP.listarProveedores();
        Iterator<DataProveedor> it = p.iterator();
        while (it.hasNext()) {
            DataProveedor dts = it.next();
            String n = dts.getNickname();
            Combo_Proveedores.addItem(n);
        }
        List<DataCiudad> ciudades = Pantallaprin.ICP.listarCiudades();
        Iterator<DataCiudad> iter = ciudades.iterator();
        while (iter.hasNext()) {
            DataCiudad dts = iter.next();
            String n = dts.getNombre();
            Combo_Destino.addItem(n);
            Combo_Origen.addItem(n);
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

        Combo_Proveedores = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Servicios = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        imagen1 = new javax.swing.JTextField();
        imagen3 = new javax.swing.JTextField();
        imagen2 = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        List_Categorias = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        List_CategoriasNuevas = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        Combo_Origen = new javax.swing.JComboBox();
        Combo_Destino = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Modificar servicio");
        setFrameIcon(null);

        Combo_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_ProveedoresActionPerformed(evt);
            }
        });

        jLabel1.setText("Proveedor:");

        List_Servicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                List_ServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(List_Servicios);

        jLabel2.setText("Descripción:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Origen:");

        jLabel5.setText("Destino:");

        jLabel6.setText("Imagen:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross5.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross5.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross5.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(List_Categorias);

        jLabel7.setText("Categorías nuevas:");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross5.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setText("Salir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Descripcion.setColumns(20);
        Descripcion.setLineWrap(true);
        Descripcion.setRows(5);
        jScrollPane2.setViewportView(Descripcion);

        jScrollPane4.setViewportView(List_CategoriasNuevas);

        jLabel8.setText("Categorías actuales:");

        Combo_Origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_OrigenActionPerformed(evt);
            }
        });

        Combo_Destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_DestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(precio, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(Combo_Origen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Combo_Destino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Combo_Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(Combo_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(imagen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(imagen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Combo_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_ProveedoresActionPerformed
        modeloServicios.removeAllElements();
        String proveedor = Combo_Proveedores.getSelectedItem().toString();
        List<DataServicio> servi = Pantallaprin.ICP.listarServiciosXProveedor(proveedor);
        //Pantallaprin.ICP.seleccionarProveedor(proveedor);
        for (DataServicio it: servi){
            modeloServicios.addElement(it);
        }
        List_Servicios.setModel(modeloServicios);
    }//GEN-LAST:event_Combo_ProveedoresActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Pantallaprin.abrirAgregarCategoria();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void List_ServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_List_ServiciosMouseClicked

        String servicio = List_Servicios.getSelectedValue().toString();
        servicio = servicio.substring(0,servicio.lastIndexOf("-")-1);

        DataInfoServicio info=null;
        try {
            info = Pantallaprin.ICP.verInfoServicio(servicio,Combo_Proveedores.getSelectedItem().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        nombreservicioseleccionado = info.getNombre();
        precio.setText(Float.toString(info.getPrecio()));
        Combo_Origen.setSelectedItem(info.getOrigen().getNombre());
        if (info.getDestino() == null){
            Combo_Destino.setVisible(false);
        }else{
            Combo_Destino.setVisible(true);
            Combo_Destino.setSelectedItem(info.getDestino().getNombre());
        }
        imagen1.setText(info.getImagen()[0]);
        imagen2.setText(info.getImagen()[1]);
        imagen3.setText(info.getImagen()[2]);
        Descripcion.setText(info.getDescripcion());
        modeloCategorias.removeAllElements();
        List<DataCategoria> xx = info.getCategorias();
        for (DataCategoria x : xx){
            modeloCategorias.addElement(x);
        }
        List_Categorias.setModel(modeloCategorias);
        modeloCategoriasnuevas.clear();
        List_CategoriasNuevas.setModel(modeloCategoriasnuevas);
        //Pantallaprin.ICP.seleccionarServicio(servicio);
    }//GEN-LAST:event_List_ServiciosMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String categoria = List_Categorias.getSelectedValue().toString();
        modeloCategorias.remove(List_Categorias.getSelectedIndex());
        List_Categorias.removeAll();
        List_Categorias.setModel(modeloCategorias);
        Pantallaprin.ICP.ingresarCategoriaBorrarServicio(categoria);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String proveedor = Combo_Proveedores.getSelectedItem().toString();
        Pantallaprin.ICP.ingresarDescripcionServicio(Descripcion.getText());
        Pantallaprin.ICP.seleccionarProveedor(proveedor);
        Pantallaprin.ICP.seleccionarServicio(List_Servicios.getSelectedValue().toString().substring(0,List_Servicios.getSelectedValue().toString().lastIndexOf("-")-1));
        Pantallaprin.ICP.ingresarDestinoServicio(Combo_Destino.getSelectedItem().toString());
        Pantallaprin.ICP.ingresarOrigenServicio(Combo_Origen.getSelectedItem().toString());
        Pantallaprin.ICP.ingresarPrecioServicio(Float.parseFloat(precio.getText())); 
        
        if (!imagen1.getText().isEmpty()) {
            Path FROM = Paths.get(imagen1.getText());
            //armo la ruta destino
            String urlImagenDestino = PantallaPrincipal.RutaImagenes + "Servicios/" + proveedor + " - " + nombreservicioseleccionado + " 1.png";
            Path TO = Paths.get(urlImagenDestino);
            try {
                Files.copy(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
                Pantallaprin.ICP.ingresarModificarImagenServicio(urlImagenDestino);//luego del alta el servicio deve quedar en memoria
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al copiar la imagen 1");
                Logger.getLogger(SelectorImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } else {
            Pantallaprin.ICP.ingresarModificarImagenServicio("");//siempre se carga una ruta aunque sea vacia
        }
        if (!imagen2.getText().isEmpty()) {
            Path FROM = Paths.get(imagen2.getText());
            //armo la ruta destino
            String urlImagenDestino = PantallaPrincipal.RutaImagenes + "Servicios/" + proveedor + " - " + nombreservicioseleccionado + " 2.png";
            Path TO = Paths.get(urlImagenDestino);
            try {
                Files.copy(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
                Pantallaprin.ICP.ingresarModificarImagenServicio(urlImagenDestino);//luego del alta el servicio deve quedar en memoria
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al copiar la imagen 2");
                Logger.getLogger(SelectorImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        } else {
            Pantallaprin.ICP.ingresarModificarImagenServicio("");//siempre se carga una ruta aun que sea vacia
        }
        if (!imagen3.getText().isEmpty()) {
            Path FROM = Paths.get(imagen3.getText());
            //armo la ruta destino
            String urlImagenDestino = PantallaPrincipal.RutaImagenes + "Servicios/" + proveedor + " - " + nombreservicioseleccionado + " 3.png";
            Path TO = Paths.get(urlImagenDestino);
            try {
                Files.copy(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
                Pantallaprin.ICP.ingresarModificarImagenServicio(urlImagenDestino);//luego del alta el servicio deve quedar en memoria
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al copiar la imagen 3");
                Logger.getLogger(SelectorImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Pantallaprin.ICP.ingresarModificarImagenServicio("");//siempre se carga una ruta aun que sea vacia
        }
        
        try {
            Pantallaprin.ICP.modificarServicio();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ActualizarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Pantallaprin.ICP.ingresarImagenBorrarServicio(imagen1.getText());
        imagen1.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Pantallaprin.ICP.ingresarImagenBorrarServicio(imagen2.getText());
        imagen2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Pantallaprin.ICP.ingresarImagenBorrarServicio(imagen3.getText());
        imagen3.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Combo_OrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_OrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_OrigenActionPerformed

    private void Combo_DestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_DestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_DestinoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Pantallaprin.abrirSelectorImagen("ActualizarServicio1");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       Pantallaprin.abrirSelectorImagen("ActualizarServicio2");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pantallaprin.abrirSelectorImagen("ActualizarServicio3");
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_Destino;
    private javax.swing.JComboBox Combo_Origen;
    private javax.swing.JComboBox Combo_Proveedores;
    private javax.swing.JTextArea Descripcion;
    public static javax.swing.JList List_Categorias;
    public static javax.swing.JList List_CategoriasNuevas;
    private javax.swing.JList List_Servicios;
    public static javax.swing.JTextField imagen1;
    public static javax.swing.JTextField imagen2;
    public static javax.swing.JTextField imagen3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
