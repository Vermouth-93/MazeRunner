/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bomb {

    private ImageIcon img;

    public Image getBomb(String bombType) {
        if (bombType == null) {
            return null;
        }

        if (bombType.equalsIgnoreCase("bomb")) {
            //img = new ImageIcon("bomb.jpg");
            img = new ImageIcon("boo.jpg");
            return img.getImage();

        }

        if (bombType.equalsIgnoreCase("axe")) {
            img = new ImageIcon("ax.jpg");
            return img.getImage();

        }

        return null;
    }

}
