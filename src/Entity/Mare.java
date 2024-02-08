package Entity;

import Main.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;

public class Mare {

    GamePanel gp;
    
    private static int larghezza;
    private int altezza;
    public int ampiezza;
    public int fq;
    private int offsetX;
    public int offsetY ;

    public Mare(GamePanel gp){

        this.gp = gp;

        setDefaultValues();
    }

    public void setDefaultValues(){
        larghezza = gp.screenWidth;
        altezza = 600;
        ampiezza = 50;
        fq = 2;
        offsetX = 0;
        offsetY = gp.screenHeight - 100;
    }

    public void update(){


    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        for (int x = offsetX; x < larghezza; x++) {
            int y = offsetY + (int) (ampiezza * Math.sin(2 * Math.PI * fq * (x - offsetX) / larghezza));
            g2.drawLine(x - 1, y - 1, x, y);
        }

    }

}
