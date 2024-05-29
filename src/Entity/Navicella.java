package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Navicella extends Entity {
    
    GamePanel gp;
    KeyHandler KeyH;
    Mare mare;
    //Pallina pallina;
    int wifih = 80;
    int wifiw = 100;

    public Navicella(GamePanel gp, KeyHandler KeyH, Mare mare){
        
        this.gp = gp;
        this.KeyH = KeyH;
        this.mare = mare;
        
        setDefaultValues();
        getWiFI();
    }

    public void setDefaultValues(){

        //posizione di partenza navicella
        dimHeight = 24;
        dimWidth = 60;
        x = (gp.screenWidth/2) - (dimWidth/2) ;
        y = (gp.screenHeight) - (dimHeight);
        
        speed = 8;
    }

     public void getWiFI(){
        File w1 = new File("./res/wifi/1.png");
        File w2 = new File("./res/wifi/2.png");
        File w3 = new File("./res/wifi/3.png");

        try {
            r1 = ImageIO.read(w1);
            r2 = ImageIO.read(w2);
            r3 = ImageIO.read(w3);
            
        } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void update(){

        for (int j = x ; j <gp.screenWidth ; j++) {
            y = (-dimHeight/2) + mare.offsetY + (int) (mare.ampiezza * Math.sin(2 * Math.PI * mare.fq * (x -mare.offsetX) / gp.screenWidth));
            
        }

        //System.out.println(y);

        if (KeyH.leftPressed == true) {
            x -= speed; 

        }

        if (KeyH.rightPressed == true) {
            x += speed;
        }

        if (KeyH.spacePressed == true) {

            animCounter++;
            if (animCounter>=50) {
                animCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        if (KeyH.spacePressed){
        if(animCounter <= 10){ image = r1;
            }else if(animCounter <= 20){ image = r2;
            }else if(animCounter <= 30){ image = r3;
            }else if(animCounter <= 40){ image = null;
        } 
    }else {
        image = null;
    }


        g2.drawImage(image, x + (dimWidth/2) - (wifiw/2)    , y - wifih , wifiw,wifih, null);
        g2.setColor(Color.blue);                   //setta il colore
        g2.fillRect(x, y , dimWidth,dimHeight); //disegna dal punto x y
       // g2.fillPolygon();
       

    }
}
