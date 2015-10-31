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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author Mati
 */
public class AltaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaCliente
     */
    
    PantallaPrincipal Pantallaprin = PantallaPrincipal.getInstancia();
    public AltaCliente() {
        initComponents();
    }

    public void limpiarCampos(){
        clienteNick.setText("");
        this.clienteNombre.setText("");
        this.clienteApellido.setText("");
        this.clienteEmail.setText("");
        clienteImagen.setText("");   
        clienteNick.requestFocus();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clienteNombre = new javax.swing.JTextField();
        clienteNick = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        clienteApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        clienteEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        clienteImagen = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edt_password = new javax.swing.JPasswordField();
        edt_passwordconfirm = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Nuevo cliente");
        setToolTipText("");
        setFrameIcon(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Cliente");

        jLabel7.setText("Nickname:");

        jLabel2.setText("Nombre:");

        clienteNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteNickActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

        clienteApellido.setToolTipText("");

        jLabel8.setText("Correo electornico:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel9.setText("Imagen:");

        jButton7.setText("...");
        jButton7.setInheritsPopupMenu(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jDateChooser1.setMaxSelectableDate(new java.util.Date(253370775660000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-2208971656000L));

        jLabel1.setText("Password:");

        jLabel6.setText("Confirmar Password:");

        edt_passwordconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_passwordconfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(182, 182, 182))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clienteApellido)
                                        .addComponent(clienteNombre)
                                        .addComponent(clienteNick, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clienteEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addComponent(edt_password)
                                        .addComponent(edt_passwordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edt_passwordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(clienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNickActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Pantallaprin.abrirSelectorImagen("AltaCliente");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");	
        Date fechaNac   = jDateChooser1.getDate();
        String nickname = clienteNick.getText().toLowerCase();
        String nombre   = letraCapital(clienteNombre.getText());
        String apellido = letraCapital(clienteApellido.getText());
        String email    = clienteEmail.getText().toLowerCase();
        String imagen   = clienteImagen.getText();
        String urlImagen= "";
        String password = edt_password.getPassword().toString();
        String passwordconfirm = edt_passwordconfirm.getPassword().toString();
                

        if(nickname.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un nickname válido");
            clienteNick.requestFocus();
            return;
        }
        else if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido");
            clienteNombre.requestFocus();
            return;
        }
        else if(apellido.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un apellido válido");
            clienteApellido.requestFocus();
            return;
        }
        else if(email.isEmpty() || !email.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$")){
            JOptionPane.showMessageDialog(null, "Ingrese un email válido");
            clienteEmail.requestFocus();
            return;
        }    
        else if(!formatoFecha.format(fechaNac).matches("^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$")){
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
            jDateChooser1.requestFocus();
            return;
        }
        else if (password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese una password válida");
            edt_password.requestFocus();
            return;
        }
        else if( password.equals(passwordconfirm)){
            JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas difieren");
            edt_password.requestFocus();
            return;
        }
        //Para copiar le archivo seleccionado
        if (!imagen.isEmpty()){
            Path FROM = Paths.get(clienteImagen.getText());
            //muestro la ruta local de la imagen (teteo)
            //JOptionPane.showMessageDialog(null,"ruta local de la imagen: "+cleinteImagen.getText());
            urlImagen = PantallaPrincipal.RutaImagenes+"Usuarios/"+nickname+".png";
            Path TO = Paths.get(urlImagen);
            //JOptionPane.showMessageDialog(null, "ruta donde se copia la imagen: "+TO);
            //sobreescribir el fichero de destino, si existe, y copiar
            // los atributos, incluyendo los permisos rwx
            //CopyOption[] options = new CopyOption[]{
            //StandardCopyOption.REPLACE_EXISTING,
            //StandardCopyOption.COPY_ATTRIBUTES
            //}; 
            try {
                Files.copy(FROM,TO, StandardCopyOption.REPLACE_EXISTING);            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al copiar la imagen");
                Logger.getLogger(SelectorImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Pantallaprin.ICC.altaCliente(nickname, nombre, apellido, email, fechaNac, urlImagen, password);
            JOptionPane.showMessageDialog(null,"El Cliente se ingresó correctamente");
            limpiarCampos();
        } catch (Exception ex){
            //error en alta cliente
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void edt_passwordconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_passwordconfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_passwordconfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clienteApellido;
    private javax.swing.JTextField clienteEmail;
    public static javax.swing.JTextField clienteImagen;
    public static javax.swing.JTextField clienteNick;
    private javax.swing.JTextField clienteNombre;
    private javax.swing.JPasswordField edt_password;
    private javax.swing.JPasswordField edt_passwordconfirm;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}