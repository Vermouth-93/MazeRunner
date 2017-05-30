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
public class bulletsPool {
 
        
        private static int counter=0;
        private static int max_num_of_bullets=60;
        private static ArrayList<bullets> available_pool=new ArrayList<bullets>();
        private static ArrayList<bullets> used_pool=new ArrayList<bullets>();
        
        
        
         private bulletsPool(){
             
        }
        
      
      // set the size of the pool 
        private static void setPoolsize(int poolSize) {
            max_num_of_bullets=poolSize;
            
        }
        
       // 3ashan lama ya5od gifts kteer nzawedlo el bullets  
        public static void addBullet(){
            max_num_of_bullets++;
          
        }

        
     // borrowBullet  to get the next free bullet from the pool 
        public static bullets borrowBullet() {
            
             bullets object=null;
            if(counter<max_num_of_bullets){
                object=new bullets();
                available_pool.add(object);
                counter++;
            }
               
                return object;
          
       }

        
      // after we use the bullet by pressing the key of bullets we are going to release it  
      // and put it in the used pool array so if we add a bullet according to the playerps score
      // we are going to take the bullet from it  
        public static void releaseBullet(bullets object) {
       
            if (object != null) {
               used_pool.add(object);
            }
        
       }


 /*   // 3ashan lama atleq el bullet :D
    // bta5od el graphics w el makan elly 7ytrasam fi el bullet
    // el position bta3o bnesba l arkam el moraba3at    
       public void trigerBullet_horz(Graphics g,Point position1,Point position2){
          for(int i=position1.x+1;i<=position2.x;i++){
              g.drawImage(bull, i, position1.y, null);
          }
       }
       
       public void trigerBullet_vert(Graphics g,Point position1,Point position2){
          for(int i=position1.y+1;i<=position2.y;i++){
              g.drawImage(bull, position1.x, i, null);
          }
       }*/
       
       
       
}
