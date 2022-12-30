/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class BackGround extends JPanel{
    private Image image;
    public BackGround() {
        image = new ImageIcon(getClass().getResource("/Gambar/unnamed.jpg")).getImage();
    }
     @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D gd = (Graphics2D) grphcs.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}