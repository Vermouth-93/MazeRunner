/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Wall {
    
    private ImageIcon img;
    
    
    public Image getWall(String shapeType){
        if(shapeType == null){
            return null;
        }
        
        if(shapeType.equalsIgnoreCase("concrete1")){
            img = new ImageIcon("tileerror_image - bro.png");
            return img.getImage();
           
        }
        else if(shapeType.equalsIgnoreCase("concrete2")){
            img = new ImageIcon("tileerror_image - bro purp copy.jpg");
            return img.getImage();
           
        }
        else if(shapeType.equalsIgnoreCase("concrete3")){
            img = new ImageIcon("tileerror_image - bro blu copy.jpg");
            return img.getImage();
           
        }
        
        else if(shapeType.equalsIgnoreCase("grass1")){
            img = new ImageIcon("tileerror_image - gr.png");
            return img.getImage();   
        }
        else if(shapeType.equalsIgnoreCase("grass2")){
            img = new ImageIcon("tileerror_image - gr bl.jpg");
            return img.getImage();  
        }
        else if(shapeType.equalsIgnoreCase("grass3")){
            img = new ImageIcon("tileerror_image - gr copy pi.jpg");
            return img.getImage();    
        }
        
        else if(shapeType.equalsIgnoreCase("bricks")){
            img = new ImageIcon("yellow-brick-wall.jpg");
            return img.getImage();  
        }
        
        else if(shapeType.equalsIgnoreCase("end")){
            img = new ImageIcon("triwizard-cup.jpg");
            return img.getImage();  
        }
        
        
      return null;  
    }
    
}
