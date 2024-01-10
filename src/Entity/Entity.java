package Entity;

import java.awt.image.BufferedImage;

public class Entity {
    
    //posizione
    public int x;
    public int y;
    //velocità in px/ciclo
    public int speed;
    //dimensioni
    public int dimHeight;
    public int dimWidth;
    public String directionUpDown;
    public String directionLeftRight;

    public BufferedImage r1 , r2 , r3 , r4;
    public int animCounter = 0;

    public boolean collisioOn = false;
   
}
