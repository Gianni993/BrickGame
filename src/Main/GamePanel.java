package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Bricks.BricksManager;
import Bricks.CollisionBricks;
import Entity.Mare;
import Entity.Navicella;
import Entity.Pallina;


public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    public final int screenWidth = 1280; //px
    public final int screenHeight = 720;  //px raporto 16:9

    int fps = 60;       //fps targhet
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;                 //istanza per esecuzione in parallelo

    Navicella nav = new Navicella(this, keyH);
    Pallina pallina = new Pallina(this, keyH ,nav);
    Mare mare = new Mare(this);
    
    BricksManager bricksMan = new BricksManager(this);
    CollisionBricks collisionBricks = new CollisionBricks(this, pallina, bricksMan);


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight)); // mostra il pannello con le dimensioni di screen W/H
        this.setBackground(Color.cyan);                                 //colore sfondo
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);                  //gamePanel cosi puo riconoscere gli input da tastiera
        this.setFocusable(true);          //finche la finestra di gioco è attiva, riceve gli input
    }


    public void startGameThread(){

       gameThread = new Thread(this);
       gameThread.start();
    }


    @Override
    public void run() {
       
        double drawInterval = 1000000000/fps; 
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1){
                //UPDATE
                update();
                //DRAW
                repaint();      //richiama il paintComponent
                delta --;
            }
            
        }
    }
    //UPDATE
    public void update() {

    pallina.update();
    
    nav.update();

    collisionBricks.CollisionPallinaBricks();


    }
    //DRAW
    public void paintComponent(Graphics g) {        //metodo integrato di java
        super.paintComponent(g);                    //dipende dal metodo

        Graphics2D g2 = (Graphics2D)g;              //per estendere le funzioni di graphics
        
        //navicella draw
        nav.draw(g2);
        
        bricksMan.draw(g2);

        mare.draw(g2);

        pallina.draw(g2);
  
        g2.dispose();                               //rilascia le risorse
    }

}
