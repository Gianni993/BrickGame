package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.GamePanel;
import Main.KeyHandler;

public class Navicella extends Entity {
    
    GamePanel gp;
    KeyHandler KeyH;
    Pallina pallina;

    public Navicella(GamePanel gp, KeyHandler KeyH){
        
     
        this.gp = gp;
        this.KeyH = KeyH;
        
        setDefaultValues();
    }
     public void setPallina(Pallina pallina) {
         this.pallina = pallina;
     }

    public void setDefaultValues(){

        //posizione di partenza navicella
        dimHeight = 24;
        dimWidth = 60;
        x = (gp.screenWidth/2) - (dimWidth/2) ;
        y = (gp.screenHeight) - (dimHeight);
        
        speed = 8;
    }


    public void update(){

        if (KeyH.leftPressed == true) {
            x -= speed; 

        }

        if (KeyH.rightPressed == true) {
            x += speed;
        }

        if (KeyH.spacePressed == true) {
            
        }
        pallina.update();
    }
    

    public void draw(Graphics2D g2){

        g2.setColor(Color.BLUE);                   //setta il colore
        g2.fillRect(x, y , dimWidth,dimHeight); //disegna dal punto x y

    }
}
