package Entity;

import Main.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;

public class Mare {
    GamePanel gp;
    private int larghezza;
    public double ampiezza;
    public double fq;
    public int offsetX;
    public int offsetY ;
    public int y;
    private int fpsCounter;

    public Mare(GamePanel gp){

        this.gp = gp;

        setDefaultValues();
    }

    public int getLarghezza() {
        return larghezza;
    }

    public void setDefaultValues(){
        larghezza = gp.screenWidth;
        ampiezza = 50;
        fq = 2;
        offsetX = 0;
        offsetY = gp.screenHeight - 100;
        y = 0;
        fpsCounter = 0;
    }

    public void update(){

        if(fpsCounter>60){ 
            //fq +=0.01;
            offsetX += 2 ;
            ampiezza = ampiezza + Math.random();
        }
        else{
           //fq -= 0.01;
            offsetX -=2 ;
            ampiezza = ampiezza - Math.random();
        }
        fpsCounter++;
        if (fpsCounter>120) {fpsCounter=0;}
       
        
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        for (int x = offsetX; x < larghezza; x++) {
             y = offsetY + (int) (ampiezza * Math.sin(2 * Math.PI * fq * (x - offsetX) / larghezza));
            g2.drawLine(x - 10, y - 1, x, y);
        }

    }

}
