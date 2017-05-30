/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AsmaaYasser
 */
public class Map {
    
    private Scanner m;
    String type;
    
    private String Map[] = new String [30];
    
    public Map(String type) throws FileNotFoundException{
        this.type = type;
        
        openFile();
        readFile();
        closeFile();
        
    }
    
     
    //x??!!
    //from specific tile
    public String getMap(int x, int y){
        
        String index = Map[y].substring( x, x + 1 );
        return index;
    }
    
   
        //must try and catch?
        public void openFile(){
            
        try {
            m = new Scanner(new File(type));
        } catch (FileNotFoundException ex) {
            System.out.println("can't open the file");
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        public void readFile(){
            
            //char[] a = null;
            
            while(m.hasNext()){
                for( int i = 0; i< 30 ; i++ ){
                     Map[i] = m.next();        
                }     
            }   
        }
        
        public void closeFile(){
            
            m.close();
            
        } 
}
