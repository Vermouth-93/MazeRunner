/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.Gift.getBeans;
import static Model.Gift.getGalleons;
import static Model.Time.getMinutes;

/**
 *
 * @author Heba
 */
public class Score {

    private static int score;
    private static int finalscore;

    public Score() {
        score = 0;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Score.score = score;
    }

    public static int getFinalscore() {
        return finalscore;
    }

    public static void setFinalscore(int finalscore) {
        Score.finalscore = finalscore;
    }

    public static void updateScore() {

        int tscore;
        int gifts = getGalleons() * 5000 + getBeans() * 2000;
        int time = (int) getMinutes();

        if (time <= 5) {
            tscore = 10000;
        } else if (time <= 10) {
            tscore = 8000;
        } else if (time <= 15) {
            tscore = 6000;
        } else if (time <= 20) {
            tscore = 4000;
        } else if (time <= 30) {
            tscore = 2000;
        } else {
            tscore = 0;
        }

        setScore(gifts);
        setFinalscore(gifts + tscore);
        
    }

}
