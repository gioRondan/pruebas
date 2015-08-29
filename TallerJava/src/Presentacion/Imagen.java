/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import java.awt.Graphics;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Imagen extends javax.swing.JPanel {
    int x, y;
    String NomImagen;

    public Imagen(JPanel jPanel1,String nom) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
        this.NomImagen = nom;
    }

    @Override
    public void paint(Graphics g) {
       
        //String s = PantallaPrincipal.RutaImagenes+this.NomImagen; //por que no anda ????
        String s = "/Imagenes/"+this.NomImagen;
        JOptionPane.showMessageDialog(null, "ruta para cear la imagen: "+s);
        
        ImageIcon Img = new ImageIcon(getClass().getResource(s));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    

}