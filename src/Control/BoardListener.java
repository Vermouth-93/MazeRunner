/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;



import static View.ConcreteObserver.updateData;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Model.Bomb;
import Model.bullets;
import Model.bulletsPool;
import Model.Gift;
import static Model.Gift.addBeans;
import static Model.Gift.addGalleons;
import Model.Map;
import Model.Monster;
import Model.Player;
import static Model.Score.updateScore;
import Model.Wall;
import View.Board;
import static View.Board.giftType;
import static View.Board.images;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author mostafa
 */
public class BoardListener extends KeyAdapter {

    Player p;
    Map m;
    Board b;
    Wall wallType;
    Bomb bomb;
    Gift gift;
    private bullets bullet;
    public static ArrayList<bullets> bullet_array = new ArrayList<bullets>();
    public static ArrayList<Point> points_toreplace = new ArrayList<Point>();
    public static ArrayList<Image> player_position = new ArrayList<Image>();
    Point first_pos = new Point();
    Point second_pos = new Point();
    int diffx;
    int diffy;
    private boolean upflag = false;
    private boolean downflag = false;
    private boolean leftflag = false;
    private boolean rightflag = false;
    private Monster monster;
     
    public BoardListener(Map m, Board b) throws FileNotFoundException {
        p = Player.getInstance();
        this.m = m;
        this.b = b;
        wallType = new Wall();
        bomb = new Bomb();
        gift = new Gift();
        first_pos.x = p.getTilex();
        first_pos.y = p.getTiley();
        upflag = false;
        downflag = false;
        leftflag = false;
        rightflag = false;
        player_position = p.rightpos();
        monster=new Monster();
    }

    public void keyPressed(KeyEvent e) {

        int Keycode = e.getKeyCode();

        if (Keycode == KeyEvent.VK_UP) {
            if (!m.getMap(p.getTilex(), p.getTiley() - 1).equals("c") && !m.getMap(p.getTilex(), p.getTiley() - 1).equals("o")
                    && !m.getMap(p.getTilex(), p.getTiley() - 1).equals("n") && b.images[p.getTilex()][p.getTiley() - 1] != wallType.getWall("bricks")) {
                first_pos.x = p.getTilex();
                first_pos.y = p.getTiley();
                p.move(0, -32, 0, -1);
                second_pos.x = p.getTilex();
                second_pos.y = p.getTiley();
            }
            upflag = true;
            rightflag=false;
               leftflag=false;
               downflag=false;
            player_position.clear();
            player_position = p.uppos();
        }
        if (Keycode == KeyEvent.VK_DOWN) {
            if (!m.getMap(p.getTilex(), p.getTiley() + 1).equals("c") && !m.getMap(p.getTilex(), p.getTiley() + 1).equals("o")
                    && !m.getMap(p.getTilex(), p.getTiley() + 1).equals("n") && b.images[p.getTilex()][p.getTiley() + 1] != wallType.getWall("bricks")) {
                first_pos.x = p.getTilex();
                first_pos.y = p.getTiley();
                p.move(0, 32, 0, 1);
                second_pos.x = p.getTilex();
                second_pos.y = p.getTiley();
            }
            downflag = true;
            rightflag=false;
            leftflag=false;
            upflag=false;
            player_position.clear();
            player_position = p.downpos();
        }
        if (Keycode == KeyEvent.VK_LEFT) {
            if (!m.getMap(p.getTilex() - 1, p.getTiley()).equals("c") && !m.getMap(p.getTilex() - 1, p.getTiley()).equals("o")
                    && !m.getMap(p.getTilex() - 1, p.getTiley()).equals("n") && b.images[p.getTilex() - 1][p.getTiley()] != wallType.getWall("bricks")) {
                first_pos.x = p.getTilex();
                first_pos.y = p.getTiley();
                p.move(-32, 0, -1, 0);
                second_pos.x = p.getTilex();
                second_pos.y = p.getTiley();
            }
            leftflag = true;
            rightflag=false;
           upflag=false;
           downflag=false;
            player_position.clear();
            player_position = p.leftpos();
        }
        if (Keycode == KeyEvent.VK_RIGHT) {
            if (!m.getMap(p.getTilex() + 1, p.getTiley()).equals("c") && !m.getMap(p.getTilex() + 1, p.getTiley()).equals("o")
                    && !m.getMap(p.getTilex() + 1, p.getTiley()).equals("n") && b.images[p.getTilex() + 1][p.getTiley()] != wallType.getWall("bricks")) {
                first_pos.x = p.getTilex();
                first_pos.y = p.getTiley();
                p.move(32, 0, 1, 0);
                second_pos.x = p.getTilex();
                second_pos.y = p.getTiley();
            }
            rightflag = true;
             leftflag=false;
               upflag=false;
               downflag=false;
            player_position.clear();
            player_position = p.rightpos();
        }

        if (Keycode == KeyEvent.VK_SPACE) {

            //the difference between positions of the player
            diffx = second_pos.x - first_pos.x;
            diffy = second_pos.y - first_pos.y;

            bullet = bulletsPool.borrowBullet();

            // bullet to right
            if ((diffx > 0 && rightflag == true) || ( rightflag == true)) {
                System.out.println("bullet to right,diffx= " + diffx);
                for (int index = p.getTilex(); index <29; index++) {
                    if (Board.images[index + 1][p.getTiley()] != wallType.getWall("concrete1") && Board.images[index + 1][p.getTiley()] != wallType.getWall("concrete2")
                            && Board.images[index + 1][p.getTiley()] != wallType.getWall("concrete3")) {
                        if (Board.images[index + 1][p.getTiley()] == bomb.getBomb("bomb") || Board.images[index + 1][p.getTiley()] == bomb.getBomb("axe")
                                || Board.images[index + 1][p.getTiley()] == wallType.getWall("bricks")||Board.images[index+1][p.getTiley()]== monster.monster_pic().get(0)
                                ||Board.images[index+1][p.getTiley()]== monster.monster_pic().get(1)||Board.images[index+1][p.getTiley()]== monster.monster_pic().get(2)
                                ||Board.images[index+1][p.getTiley()]== monster.monster_pic().get(3)) {
                            bullet.setPosition(index + 1, p.getTiley());
                            bullet_array.add(bullet);

                            Point pt = new Point();
                            pt.x = index + 1;
                            pt.y = p.getTiley();
                            points_toreplace.add(pt);
                            // Board.images[index][p.getTiley()]=wallType.getWall("grass1");  
                            bulletsPool.releaseBullet(bullet);
                            break;
                        }
                    }
                }
            } // bullet to left
            else if ((diffx<0&&leftflag==true)||(leftflag==true)) {
                System.out.println("bullet to left,diffx= " + diffx);
                for (int index = p.getTilex(); index > 0; index--) {
                    if (Board.images[index - 1][p.getTiley()] != wallType.getWall("concrete1") && Board.images[index - 1][p.getTiley()] != wallType.getWall("concrete2")
                            && Board.images[index - 1][p.getTiley()] != wallType.getWall("concrete3")) {
                        if (Board.images[index - 1][p.getTiley()] == bomb.getBomb("bomb") || Board.images[index - 1][p.getTiley()] == bomb.getBomb("axe")
                                || Board.images[index - 1][p.getTiley()] == wallType.getWall("bricks")||Board.images[index-1][p.getTiley()]== monster.monster_pic().get(0)
                                ||Board.images[index-1][p.getTiley()]== monster.monster_pic().get(1)||Board.images[index-1][p.getTiley()]== monster.monster_pic().get(2)
                                ||Board.images[index-1][p.getTiley()]== monster.monster_pic().get(3)) {
                            bullet.setPosition(index - 1, p.getTiley());
                            bullet_array.add(bullet);

                            Point pt = new Point();
                            pt.x = index - 1;
                            pt.y = p.getTiley();
                            points_toreplace.add(pt);
                            // Board.images[index][p.getTiley()]=wallType.getWall("grass1");  
                            bulletsPool.releaseBullet(bullet);
                            break;
                        }
                    }
                }
            } // triger bullet down
            else if ((diffy>0&&downflag==true)||(downflag==true)) {
                System.out.println("bullet down,diffy= " + diffy);
                for (int index = p.getTiley(); index <29; index++) {
                    if (Board.images[p.getTilex()][index + 1] != wallType.getWall("concrete1") && Board.images[p.getTilex()][index + 1] != wallType.getWall("concrete2")
                            && Board.images[p.getTilex()][index + 1] != wallType.getWall("concrete3")) {
                        if (Board.images[p.getTilex()][index + 1] == bomb.getBomb("bomb") || Board.images[p.getTilex()][index + 1] == bomb.getBomb("axe")
                                || Board.images[p.getTilex()][index + 1] == wallType.getWall("bricks")||Board.images[p.getTilex()][index+1]== monster.monster_pic().get(0)
                                ||Board.images[p.getTilex()][index+1]== monster.monster_pic().get(1)||Board.images[p.getTilex()][index+1]== monster.monster_pic().get(2)
                                ||Board.images[p.getTilex()][index+1]== monster.monster_pic().get(3)) {
                            bullet.setPosition(p.getTilex(), index + 1);
                            bullet_array.add(bullet);

                            Point pt = new Point();
                            pt.x = p.getTilex();
                            pt.y = index + 1;
                            points_toreplace.add(pt);
                            // Board.images[index][p.getTiley()]=wallType.getWall("grass1");  
                            bulletsPool.releaseBullet(bullet);
                            break;
                        }
                    }
                }
            } // triger bullet up
            else if ((diffy<0&&upflag==true)||(upflag==true)) {
                System.out.println("bullet up,diffy= " + diffy);
                for (int index = p.getTiley(); index > 0; index--) {
                    if (Board.images[p.getTilex()][index - 1] != wallType.getWall("concrete1") && Board.images[p.getTilex()][index - 1] != wallType.getWall("concrete2")
                            && Board.images[p.getTilex()][index - 1] != wallType.getWall("concrete3")) {
                        if (Board.images[p.getTilex()][index - 1] == bomb.getBomb("bomb") || Board.images[p.getTilex()][index - 1] == bomb.getBomb("axe")
                                || Board.images[p.getTilex()][index - 1] == wallType.getWall("bricks")||Board.images[p.getTilex()][index-1]== monster.monster_pic().get(0)
                                ||Board.images[p.getTilex()][index-1]== monster.monster_pic().get(1)||Board.images[p.getTilex()][index-1]== monster.monster_pic().get(2)
                                ||Board.images[p.getTilex()][index-1]== monster.monster_pic().get(3)) {
                            bullet.setPosition(p.getTilex(), index - 1);
                            bullet_array.add(bullet);

                            Point pt = new Point();
                            pt.x = p.getTilex();
                            pt.y = index - 1;
                            points_toreplace.add(pt);
                            // Board.images[index][p.getTiley()]=wallType.getWall("grass1");  
                            bulletsPool.releaseBullet(bullet);
                            break;
                        }
                    }
                }
            }

       

        }
        
        if (images[p.getTilex()][p.getTiley()] == giftType.getGift("coin")) {
            addGalleons();
        }
        if (images[p.getTilex()][p.getTiley()] == giftType.getGift("beans")) {
            addBeans();
        }

        updateScore();
        updateData();
    }

}
