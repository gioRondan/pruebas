/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;

import javax.swing.JPanel;

public class Imagen extends javax.swing.JPanel {
    int x, y;
    String RutaImagen;

    public Imagen(JPanel jPanel1,String ruta) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
        this.RutaImagen = ruta;
    }

    @Override
    public void paint(Graphics g) {
        String s = this.RutaImagen;
        File f = new File(s);
        if (f.exists()){
            ImageIcon Img = new ImageIcon(s);
            g.drawImage(Img.getImage(), 0, 0, x, y, null);
        }else{
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/noImagen.png"));
            g.drawImage(Img.getImage(), 0, 0, x, y, null);
        }
        
   }    

}