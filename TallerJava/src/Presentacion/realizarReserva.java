/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import logica.DataCliente;

/**
 *
 * @author Mati
 */
public class realizarReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form realizarReserva2
     */
             
            PantallaPrincipal pp = PantallaPrincipal.getInstancia();
            Set<DataCliente> dts = pp.ICC.listarClientes();

    public realizarReserva() {
        //matias trabajando
        initComponents();
        jScrollPane1.getViewport().add(jList2);
        
        DefaultListModel<String> mol = new DefaultListModel<>();  
        
            //Iterator<DataCliente> itera = dts.iterator();
            //while (itera.hasNext()) {
        for(int i=1;i<=500;i++){    
            mol.addElement("nabo");
        }
         jList2.setModel(mol);
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

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
