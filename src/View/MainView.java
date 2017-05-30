/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ButtonListener;
import Model.Map;
import Model.Player;
import static Model.Score.getFinalscore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author mostafa
 */
public class MainView {

    public JFrame mainframe;
    public static JFrame frame1;
    public static JFrame frame2;
    public static JFrame frame3;
    public JFrame loserFrame;
    public JFrame winnerFrame;
    public JButton level1;
    public JButton level2;
    public JButton level3;
    public JButton exit;
    public static Board board1;
    public static Board board2;
    public static Board board3;
    public JPanel buttonsPanel;
    public JPanel logopanel;
    public JPanel container1;
    public JPanel loserPanel;
    public JPanel winnerPanel;
    public static JPanel dataPanel;
    public BorderLayout frameLayout;
    public Box buttonsLayout;
    public Box exitLayout;
    public Hashtable<String, Integer> buttonsActions;
    public int currActnNum;
    public Map m1, m2, m3;
    public Player p;
    public ButtonListener butListen;

    public ImageIcon hplogo;
    public ImageIcon cuplogo;
    public JLabel header1;
    public JLabel header2;
    public JLabel header3;
    public JLabel header4;

    public ImageIcon beans_icon;
    public ImageIcon coins_icon;
    public ImageIcon score_icon;
    public ImageIcon time_icon;
    public static JLabel scoreLabel;
    public static JLabel coinsLabel;
    public static JLabel beansLabel;
    public static JLabel timeLabel;
    private static Font font = new Font("Comic Sans MS", Font.BOLD, 20);
    private static Font font1 = new Font("Castellar", Font.BOLD, 35);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new MainView().run();
    }

    public MainView() throws FileNotFoundException {

        buttonsActions = new Hashtable<String, Integer>();
        MainView.dataPanel = new JPanel();

        this.level1 = new JButton("Level 1");
        this.level2 = new JButton("Level 2");
        this.level3 = new JButton("Level 3");
        this.exit = new JButton("Exit");
        level1.setBackground(Color.getHSBColor(200, 240, 200));
        level1.setFont(font);
        level2.setBackground(Color.getHSBColor(200, 240, 200));
        level2.setFont(font);
        level3.setBackground(Color.getHSBColor(200, 240, 200));
        level3.setFont(font);
        exit.setBackground(Color.getColor("brown"));
        exit.setForeground(Color.getHSBColor(200, 240, 200));
        exit.setFont(font);
        
        this.mainframe = new JFrame();
        this.logopanel = new JPanel();
        this.currActnNum = -1;
        p = Player.getInstance();
        butListen = new ButtonListener(this);
        this.buttonsPanel = new JPanel();
        this.frameLayout = new BorderLayout();
        this.buttonsLayout = Box.createHorizontalBox();
        this.exitLayout = Box.createHorizontalBox();

        m1 = new Map("Map1.txt");
        MainView.frame1 = new JFrame();
        MainView.frame1.setTitle("Maze Runner - Level 1");
        this.container1 = new JPanel();
        MainView.board1 = new Board(this, m1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        m2 = new Map("Map2.txt");
        MainView.frame2 = new JFrame();
        MainView.frame2.setTitle("Maze Runner - Level 2");
        MainView.board2 = new Board(this, m2);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        m3 = new Map("Map3.txt");
        MainView.frame3 = new JFrame();
        MainView.frame3.setTitle("Maze Runner - Level 3");
        MainView.board3 = new Board(this, m3);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.loserFrame = new JFrame();
        this.loserFrame.setTitle("Loser Frame");
        this.loserPanel = new JPanel();
        loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.winnerFrame = new JFrame();
        this.winnerFrame.setTitle("Winner Frame");
        this.winnerPanel = new JPanel();
        winnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        beans_icon = new ImageIcon("beans.jpg");
        coins_icon = new ImageIcon("coin.jpg");
        score_icon = new ImageIcon("owl32.jpeg");
        time_icon = new ImageIcon("hourglass-icon.png");
        beansLabel = new JLabel(" ", beans_icon, JLabel.LEFT);
        coinsLabel = new JLabel(" ", coins_icon, JLabel.LEFT);
        scoreLabel = new JLabel(" ", score_icon, JLabel.LEFT);
        timeLabel = new JLabel(" ", time_icon, JLabel.LEFT);

        hplogo = new ImageIcon("harry-potter-logo.jpg");
        header1 = new JLabel(hplogo, JLabel.CENTER);
        cuplogo = new ImageIcon("cup-logo.jpg");
        header2 = new JLabel(cuplogo, JLabel.CENTER);
        header3 = new JLabel("Welcome to the");
        header4 = new JLabel("Triwizard Tournment !");
        header3.setFont(font1);
        header4.setFont(font1);
        header3.setForeground(Color.getHSBColor(200, 240, 200));
        header4.setForeground(Color.getHSBColor(200, 240, 200));
    }

    public void run() throws IOException {

        mainframe.setSize(700, 450);
        logopanel.setBackground(Color.BLACK);
        logopanel.add(header1);
        logopanel.add(header2);
        logopanel.add(header3);
        logopanel.add(header4);
        mainframe.add(buttonsPanel, BorderLayout.SOUTH);
        mainframe.add(logopanel, BorderLayout.CENTER);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);

        buttonsLayout.add(level1);
        buttonsLayout.add(level2);
        buttonsLayout.add(level3);
        exitLayout.add(exit);
        buttonsPanel.add(buttonsLayout);
        buttonsPanel.add(exitLayout);
        buttonsPanel.setBackground(Color.BLACK);

        buttonsActions.put(level1.getText(), 1);
        buttonsActions.put(level2.getText(), 2);
        buttonsActions.put(level3.getText(), 3);
        buttonsActions.put(exit.getText(), 4);

        level1.addActionListener(butListen);
        level2.addActionListener(butListen);
        level3.addActionListener(butListen);
        exit.addActionListener(butListen);

        dataPanel.setLayout(new GridLayout(2, 2));
        dataPanel.setBackground(Color.DARK_GRAY);

        //JScrollPane pane1 = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //frame1.setContentPane(pane1);
        //JScrollPane pane2 = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //frame2.setContentPane(pane2);
        //JScrollPane pane3 = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //frame3.setContentPane(pane3);
        
        loserFrame.setLayout(new GridBagLayout());
        JLabel jlabel = new JLabel("Game Over .. Better Luck Next Time !!!");
        jlabel.setFont(new Font("Verdana", 1, 20));
        JLabel jlabel1 = new JLabel(" Your Total Score is: " + getFinalscore());
        loserPanel.add(jlabel);
        loserPanel.add(jlabel1);
        loserPanel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        loserFrame.add(loserPanel, new GridBagConstraints());
        loserFrame.setSize(400, 400);
        loserFrame.setLocationRelativeTo(null);
        loserFrame.setVisible(false);

        winnerFrame.setLayout(new GridBagLayout());
        JLabel jlabel2 = new JLabel("Congratulations .. You Win !!!");
        jlabel1.setFont(new Font("Verdana", 1, 20));
        JLabel jlabel3 = new JLabel(" Your Total Score is: " + getFinalscore());
        winnerPanel.add(jlabel2);
        winnerPanel.add(jlabel3);
        winnerPanel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        winnerFrame.add(winnerPanel, new GridBagConstraints());
        winnerFrame.setSize(400, 400);
        winnerFrame.setLocationRelativeTo(null);
        winnerFrame.setVisible(false);

        /*b.setSize(5, 5);
         b.setBounds(1, 1, 900, 900);
        
         //JScrollPane pane = new JScrollPane(new Board(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         //f.setContentPane(pane);
         frame.add(board);
         f.setSize(500,400);
         JScrollPane pane = new JScrollPane(b, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         f.setContentPane(pane);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        //JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //f.setContentPane(pane);
    }

    public static void startLevel1() {
        frame1.setLayout(new BorderLayout());
        frame1.setSize(975, 1000);
        frame1.add(board1, BorderLayout.CENTER);
        frame1.add(dataPanel, BorderLayout.NORTH);

        beansLabel.setFont(font);
        beansLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(beansLabel);

        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(scoreLabel);

        coinsLabel.setFont(font);
        coinsLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(coinsLabel);

        timeLabel.setFont(font);
        timeLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(timeLabel);

        dataPanel.setVisible(true);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    public static void startLevel2() {
        frame2.setSize(975, 1000);
        frame2.add(board2, BorderLayout.CENTER);
        frame2.add(dataPanel, BorderLayout.NORTH);

        beansLabel.setFont(font);
        beansLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(beansLabel);

        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(scoreLabel);

        coinsLabel.setFont(font);
        coinsLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(coinsLabel);

        timeLabel.setFont(font);
        timeLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(timeLabel);

        dataPanel.setVisible(true);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

    public static void startLevel3() {
        frame3.setSize(975, 1000);
        frame3.add(board3, BorderLayout.CENTER);
        frame3.add(dataPanel, BorderLayout.NORTH);

        beansLabel.setFont(font);
        beansLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(beansLabel);

        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(scoreLabel);

        coinsLabel.setFont(font);
        coinsLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(coinsLabel);

        timeLabel.setFont(font);
        timeLabel.setForeground(Color.getHSBColor(200, 240, 200));
        dataPanel.add(timeLabel);

        dataPanel.setVisible(true);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }

}
