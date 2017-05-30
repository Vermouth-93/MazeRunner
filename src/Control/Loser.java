/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Player;

/**
 *
 * @author mostafa
 */
public class Loser implements State {
    
    public void doAction(Player player){
        player.setState(this);
    }
    
    public Boolean state(){
        return false;
    }
    
    
}
