/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Model.Time.setStart;
import View.MainView;
import static View.MainView.startLevel1;
import static View.MainView.startLevel2;
import static View.MainView.startLevel3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mostafa
 */
public class ButtonListener implements ActionListener {

    MainView view;
    public static int frameflag = 0;

    public ButtonListener(MainView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        view.currActnNum = view.buttonsActions.get(e.getActionCommand());
        switch (view.currActnNum) {

            case 1: {
                frameflag = 1;
                //view.frame1.setVisible(true);
                 startLevel1();
                view.mainframe.setVisible(false);
               
            }
            break;

            case 2: {
                frameflag = 2;
                //view.frame2.setVisible(true);
                startLevel2();
                view.mainframe.setVisible(false);
                
            }
            break;
            case 3: {
                frameflag = 3;
                //view.frame3.setVisible(true);
                startLevel3();
                view.mainframe.setVisible(false);
                
            }
            break;
            case 4:
                view.mainframe.setVisible(false);
                break;

        }
        
        setStart();
    }
}
