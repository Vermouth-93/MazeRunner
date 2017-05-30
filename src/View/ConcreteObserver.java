/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.Observer;
import static Model.Gift.getBeans;
import static Model.Gift.getGalleons;
import static Model.Score.getScore;
import Model.Subject;
import static Model.Time.getMinutes;
import static Model.Time.getSeconds;
import static Model.Time.setSecStart;
import static Model.Time.setSeconds;
import static View.MainView.beansLabel;
import static View.MainView.coinsLabel;
import static View.MainView.scoreLabel;
import static View.MainView.timeLabel;

/**
 *
 * @author Heba
 */
public class ConcreteObserver extends Observer {

    private final Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public static void updateData() {

        int beans = getBeans();
        beansLabel.setText("Beans Collected = " + beans);

        int galleons = getGalleons();
        coinsLabel.setText("Galleons Collected = " + galleons);

        int total = getScore();
        scoreLabel.setText("Total Score = " + total);

        long sec = getSeconds();
        long min = getMinutes();
        if (sec == 60) {
            setSecStart();
            setSeconds();
        }
        timeLabel.setText("Time Elapsed = " + min + " : " + sec);

    }

    @Override
    public void update() {
        updateData();
    }
    
}
