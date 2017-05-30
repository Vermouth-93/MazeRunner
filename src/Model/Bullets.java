/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author HP-
 */
public class bullets {
 
        public int posX;
        public int posY;
        private ImageIcon img1 = new ImageIcon("bullet.png");
        private Image bull= img1.getImage();
        
        
      //constructor  
         public bullets(){
              posX=0;
              posY=0;
        }
         
    // 7traga3ly el soura bta3et el bullet
       public Image getBulletImage(){
           return bull;
       }
       
       
     // te3mel set ll makan ellly 7ytrasam fih el bullet 
        public void setPosition(int newX, int newY){
             posX=newX;
             posY=newY;
       }
       
}
