/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author HP-
 */
public class Monster {
    
    private int x=0;
    private int y=0;
    private ArrayList<Image> pic=new ArrayList<Image>(); 
    
    
    public Monster(){
        this.pic.add(new ImageIcon("monster1.png").getImage());
        this.pic.add(new ImageIcon("monster2.png").getImage());
        this.pic.add(new ImageIcon("monster3.png").getImage());
        this.pic.add(new ImageIcon("monster4.png").getImage());
    }
   
    public ArrayList<Image> monster_pic(){
       
        return this.pic;
    }
    
    public void setx(int x){
        this.x=x;
    }
    
     public void sety(int y){
        this.y=y;
    }
     
      public int getx(){
        return this.x;
    }
      
       public int gety(){
         return this.y;
    }
    
}
