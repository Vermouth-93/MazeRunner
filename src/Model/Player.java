/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.State;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author mostafa
 */
public class Player {
    
    private State state;
    
    private static Player instance = null;
    
    private int x, y, tilex, tiley;
    
    private Image player;
   
    
   public ArrayList<Image> rightpos(){
        ArrayList<Image> im=new ArrayList<Image>();
        im.add(new ImageIcon("gifplayer 9.png").getImage());
        im.add(new ImageIcon("gifplayer 10.png").getImage());
        im.add(new ImageIcon("gifplayer 11.png").getImage());
        im.add(new ImageIcon("gifplayer 8.png").getImage());
        return im;
    }
    
    public ArrayList<Image> leftpos(){
        ArrayList<Image> im=new ArrayList<Image>();
        im.add(new ImageIcon("gifplayer 5.png").getImage());
        im.add(new ImageIcon("gifplayer 6.png").getImage());
        im.add(new ImageIcon("gifplayer 7.png").getImage());
        im.add(new ImageIcon("gifplayer 4.png").getImage());
        return im;
    }
    
    public  ArrayList<Image> uppos(){
        ArrayList<Image> im=new ArrayList<Image>();
        im.add(new ImageIcon("gifplayer 13.png").getImage());
        im.add(new ImageIcon("gifplayer 14.png").getImage());
        im.add(new ImageIcon("gifplayer 15.png").getImage());
        im.add(new ImageIcon("gifplayer 12.png").getImage());
        return im;
    }
    
    public  ArrayList<Image> downpos(){
        ArrayList<Image> im=new ArrayList<Image>();
        im.add(new ImageIcon("gifplayer 1.png").getImage());
        im.add(new ImageIcon("gifplayer 2.png").getImage());
        im.add(new ImageIcon("gifplayer 3.png").getImage());
        im.add(new ImageIcon("gifplayer 0.jpg").getImage());
        return im;
    }
    private Player(){
        
        ImageIcon img = new ImageIcon("harry_potter_lego_video_game_1_4_minifigs.jpg");
        player = img.getImage();
       // the image to extract the gif out of it
       
       
        
        x = 32;
        y = 32;
        state = null;
        
        tilex = 1;
        tiley = 1;
        
    }
    
    
    public static Player getInstance() {
      if(instance == null) {
         instance = new Player();
      }
      return instance;
   }
    
    
    public void move( int dx, int dy, int tx, int ty){
        
        x += dx;
        y += dy;
        
        tilex += tx;
        tiley += ty;
          
    }
    
    
    
    public Image getPlayer(){
        return player;
    }

    
    public int getTilex() {
        return tilex;
    }

   
    public int getTiley() {
        return tiley;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }
    
}
