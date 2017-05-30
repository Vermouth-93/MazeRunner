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

public interface State {
    
    public void doAction(Player player);
    
    public Boolean state();
    
}
