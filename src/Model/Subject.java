/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Observer;
import java.util.ArrayList;

/**
 *
 * @author Heba
 */
public class Subject {

    ArrayList observers = new ArrayList();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (int i = 0; i< observers.size(); i++) {
            Observer ob = (Observer) observers.get(i);
            ob.update();
        }
    }

}
