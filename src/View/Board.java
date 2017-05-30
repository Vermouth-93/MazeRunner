package View;

//import Control.KeyListen;
import Control.BoardListener;
import Control.Loser;
import Control.Winner;
import Model.Bomb;
import Model.Gift;
import Model.Map;
import Model.Monster;
import Model.Player;
import Model.Score;
import Model.Subject;
import static Model.Time.updateTime;
import Model.Wall;
import static View.ConcreteObserver.updateData;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.*;

import Control.BoardListener;
import Control.Loser;
import Control.Winner;
import Model.Bomb;
import Model.bullets;
import Model.Gift;
import static Model.Gift.getBeans;
import static Model.Gift.getGalleons;
import Model.Map;
import Model.Monster;
import Model.Player;
import Model.Score;
import static Model.Score.getScore;
import static Model.Time.getMinutes;
import static Model.Time.getSeconds;
import static Model.Time.setSecStart;

import static Model.Time.updateTime;
import Model.Wall;
import Model.bullets;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    Subject sub = new Subject();
    ConcreteObserver conc = new ConcreteObserver(sub);
    
    Winner winner = new Winner();
    Loser loser = new Loser();

    BoardListener boardListen;
    MainView view;
    Random rando = new Random();
    int[][] z = new int[30][30];
    public static Image[][] images;

    //private String message = "";
    //private boolean won = false;
    private static Font font = new Font("serif", Font.BOLD, 10);
    private static Font font1 = new Font("serif", Font.BOLD, 20);

    Wall wallType = new Wall();
    public static Gift giftType = new Gift();
    Bomb bombType = new Bomb();

    //private Timer timer;
    private Map m;
    private Player p;
    private boolean finishdrawingbullet = false;
    private Point pnt = new Point();
    private Monster monster;
    private Timer timer;
    boolean go_flag=false;
   
    //private KeyListen k;
    public Board(MainView view, Map m) throws FileNotFoundException {

        
        Score s = new Score();
        Gift g = new Gift();
        //Time time = new Time();
        images = new Image[30][30];
        this.m = m;
        p = Player.getInstance();
        this.view = view;
        monster=new Monster();

        /*
         for (int i = 0; i < 900; i++ )
         {
         z[i] = rando.nextInt(51);
         }
         */
        for (int y = 0; y < 30; y++) {

            for (int x = 0; x < 30; x++) {

                z[x][y] = rando.nextInt(51);
            }

        }

        loser.doAction(p);
        p.getState();

        boardListen = new BoardListener(m, this);
        addKeyListener(boardListen);

        //addKeyListener(new Al());
        //Al() k = new Al();
        //addKeyListener(k);
        setFocusable(true);
        timer = new Timer(45, this);
        timer.start();

    }



    public void actionPerformed(ActionEvent e) {

        if (m.getMap(p.getTilex(), p.getTiley()).equalsIgnoreCase("e")) {

            //won = true;
            winner.doAction(p);
            view.winnerFrame.setVisible(true);

        }

        /* if (p.getState().state()) {
            
         message = "WINNER!!!";

         }*/
        if (finishdrawingbullet) {
            BoardListener.bullet_array.clear();
            finishdrawingbullet = false;
        }
        go_flag=true;
        repaint();

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        
        //if (!p.getState().state()) {
        for (int y = 0; y < 30; y++) {

            for (int x = 0; x < 30; x++) {

                if (m.getMap(x, y).equals("g")) {
                    g.drawImage(wallType.getWall("grass1"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("grass1");
                } else if (m.getMap(x, y).equals("r")) {
                    g.drawImage(wallType.getWall("grass2"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("grass2");
                } else if (m.getMap(x, y).equals("s")) {
                    g.drawImage(wallType.getWall("grass3"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("grass3");
                } else if (m.getMap(x, y).equals("c")) {
                    g.drawImage(wallType.getWall("concrete1"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("concrete1");
                } else if (m.getMap(x, y).equals("o")) {
                    g.drawImage(wallType.getWall("concrete2"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("concrete2");
                } else if (m.getMap(x, y).equals("n")) {
                    g.drawImage(wallType.getWall("concrete3"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("concrete3");
                } else if (m.getMap(x, y).equals("e")) {
                    g.drawImage(wallType.getWall("end"), x * 32, y * 32, null);
                    images[x][y] = wallType.getWall("end");
                }
                //super.paint(g);
            }

        }

        for (int y = 2; y < 30; y++) {

            for (int x = 2; x < 30; x++) {

                //z = rando.nextInt(51);
                if (!m.getMap(x, y).equals("c") && !m.getMap(x, y).equals("o") && !m.getMap(x, y).equals("n") && !m.getMap(x, y).equals("e")) {

                     
                    //BOMBS
                    //if(z[x][y] == 0|| z[x][y] == 11){
                    if (z[x][y] == 11) {
                        g.drawImage(bombType.getBomb("bomb"), x * 32, y * 32, null);
                        images[x][y] = bombType.getBomb("bomb");
                        // 3ashan el bullet 
                        pnt.x = x;
                        pnt.y = y;
                        if (BoardListener.points_toreplace.contains(pnt)) {
                            z[x][y] = 1;
                        }
                        if (images[p.getTilex()][p.getTiley()] == bombType.getBomb("bomb")) {
                            loser.doAction(p);
                            view.loserFrame.setVisible(true);

                        }

                    }

                    //if(z[x][y] == 21|| z[x][y] == 13){
                    if (z[x][y] == 21) {
                        g.drawImage(bombType.getBomb("axe"), x * 32, y * 32, null);
                        images[x][y] = bombType.getBomb("axe");
                        // 3ashan el bullet 
                        pnt.x = x;
                        pnt.y = y;
                        if (BoardListener.points_toreplace.contains(pnt)) {
                            z[x][y] = 1;
                        }

                        if (images[p.getTilex()][p.getTiley()] == bombType.getBomb("axe")) {
                            loser.doAction(p);
                            view.loserFrame.setVisible(true);
                        }
                    }

                    //GIFTS
                    if (z[x][y] == 29 || z[x][y] == 9) {
                        g.drawImage(giftType.getGift("coin"), x * 32, y * 32, null);
                        images[x][y] = giftType.getGift("coin");
                        if (images[p.getTilex()][p.getTiley()] == giftType.getGift("coin")) {
                            //put grass
                            z[p.getTilex()][p.getTiley()] = 1;
                        }
                    }

                    if (z[x][y] == 3 || z[x][y] == 15) {
                        g.drawImage(giftType.getGift("beans"), x * 32, y * 32, null);
                        images[x][y] = giftType.getGift("beans");
                        if (images[p.getTilex()][p.getTiley()] == giftType.getGift("beans")) {
                            //put grass
                            z[p.getTilex()][p.getTiley()] = 1;
                        }
                    }

                    //WALL
                    if (z[x][y] == 7 || z[x][y] == 26 || z[x][y] == 18) {
                        g.drawImage(wallType.getWall("bricks"), x * 32, y * 32, null);
                        images[x][y] = wallType.getWall("bricks");
                        // 3ashan el bullet 
                        pnt.x = x;
                        pnt.y = y;
                        if (BoardListener.points_toreplace.contains(pnt)) {
                            z[x][y] = 1;
                        }
                    }
                        // the monsters part
                        if(z[x][y]==20){
                            images[x][y] = monster.monster_pic().get(0);
                            g.drawImage(images[x][y], x*32, y*32, null);
                            monster.setx(x);
                            monster.sety(y);
                             if(images[x+1][y]!=wallType.getWall("bricks")||images[x+1][y]!=wallType.getWall("concrete1")||images[x+1][y]!=wallType.getWall("concrete2")
                                      ||images[x+1][y]!=wallType.getWall("concrete3")&&go_flag==true){
                                 monster.setx(x+1);
                                 monster.sety(y);
                                 for(Image image:monster.monster_pic()){
                                 g.drawImage(image, monster.getx()*32, monster.gety()*32, null);
                                }
                                 go_flag=false;
                             }
                            else  if(images[x][y+1]!=wallType.getWall("bricks")||images[x][y+1]!=wallType.getWall("concrete1")||images[x][y+1]!=wallType.getWall("concrete2")
                                      ||images[x][y+1]!=wallType.getWall("concrete3")&&go_flag==true){
                                 monster.setx(x);
                                 monster.sety(y+1);
                                 for(Image image:monster.monster_pic()){
                                 g.drawImage(image, monster.getx()*32, monster.gety()*32, null);
                                }
                                 go_flag=false;
                             }
                             else if(images[x-1][y]!=wallType.getWall("bricks")||images[x-1][y]!=wallType.getWall("concrete1")||images[x-1][y]!=wallType.getWall("concrete2")
                                      ||images[x-1][y]!=wallType.getWall("concrete3")&&go_flag==true){
                                 monster.setx(x-1);
                                 monster.sety(y);
                                 for(Image image:monster.monster_pic()){
                                 g.drawImage(image, monster.getx()*32, monster.gety()*32, null);
                                }
                                 go_flag=false;
                             }
                             else if(images[x][y-1]!=wallType.getWall("bricks")||images[x][y-1]!=wallType.getWall("concrete1")||images[x][y-1]!=wallType.getWall("concrete2")
                                      ||images[x][y-1]!=wallType.getWall("concrete3")&&go_flag==true){
                                 monster.setx(x);
                                 monster.sety(y-1);
                                 for(Image image:monster.monster_pic()){
                                 g.drawImage(image, monster.getx()*32, monster.gety()*32, null);
                                }
                                 go_flag=false;
                             }
                          
                            if(BoardListener.points_toreplace.contains(pnt)){
                                images[x][y] = wallType.getWall("grass1");
                                g.drawImage(images[x][y], x*32, y*32, null);
                            }
                        }                   //monsters
                    

                    //else nothing
                }
                //super.paint(g);
            }

        }

        //}

        /*if (p.getState().state()) {
         g.setColor(Color.red);
         g.setFont(font);
         g.drawString(message, 490, 300);

         g.setColor(Color.BLACK);
         g.setFont(font);
         g.drawRect(10, 10, 1345, 695);
         }*/
        if (!BoardListener.bullet_array.isEmpty()) {
            for (bullets bull : BoardListener.bullet_array) {
                g.drawImage(bull.getBulletImage(), bull.posX * 32, bull.posY * 32, null);
            }
            finishdrawingbullet = true;

        }

        if (!BoardListener.player_position.isEmpty()) {
            for (Image image : BoardListener.player_position) {
                g.drawImage(image, (p.getTilex() * 32)+8, p.getTiley() * 32, null);

            }
            // finishdrawingplayer=true;
        }

        updateTime();
        updateData();
        repaint();
    }

}
