/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Gift {

    private ImageIcon img;
    private static int galleons;
    private static int beans;

    public Gift() {
        galleons = 0;
        beans = 0;
    }

    public static int getGalleons() {
        return galleons;
    }

    private static void setGalleons(int galleons) {
        Gift.galleons = galleons;
    }

    public static void addGalleons() {
        setGalleons(galleons + 1);
    }

    public static int getBeans() {
        return beans;
    }

    private static void setBeans(int beans) {
        Gift.beans = beans;
    }

    public static void addBeans() {
        setBeans(beans + 1);
    }

    public Image getGift(String giftType) {
        if (giftType == null) {
            return null;
        }

        if (giftType.equalsIgnoreCase("coin")) {
            //img = new ImageIcon("galleon.jpg");
            img = new ImageIcon("coin.jpg");
            return img.getImage();

        }

        if (giftType.equalsIgnoreCase("beans")) {
            //img = new ImageIcon("galleon.jpg");
            img = new ImageIcon("beans.jpg");
            return img.getImage();

        }

        return null;
    }

}
