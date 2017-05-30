/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Heba
 */
public class Time {

    private static long sec_start;
    private static long min_start;
    private static long seconds;
    private static long minutes;

    public Time() {
        setStart();
    }

    public static void setStart() {
        sec_start = min_start = System.nanoTime();
    }

    public static void setSecStart() {
        sec_start = System.nanoTime();;
    }

    public static long getSeconds() {
        return seconds;
    }

    public static void setSeconds() {
        seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - sec_start);
    }

    public static long getMinutes() {
        return minutes;
    }

    public static void setMinutes() {
        minutes = TimeUnit.NANOSECONDS.toMinutes(System.nanoTime() - min_start);
    }

    public static void updateTime() {
        setSeconds();
        setMinutes();
    }

}
