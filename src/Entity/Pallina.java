package Entity;

import java.awt.Graphics2D;
import java.io.File;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Pallina extends Entity{

    GamePanel gp;
    KeyHandler KeyH;
    Navicella nav;

    public Pallina(GamePanel gp, KeyHandler KeyH, Navicella nav){
        this.gp = gp;
        this.KeyH = KeyH;
        this.nav = nav;

        setDefaultValues();
        getPallinaImage();
        
    }
    public void setDefaultValues(){
        dimHeight = 10;
        dimWidth = 10;
        x = (gp.screenWidth/2) - (dimHeight/2);
        y = gp.screenHeight - nav.dimHeight*2;
        speed = 8;
        directionLeftRight = "central";
        directionUpDown = "up";
    }

    public void getPallinaImage(){
        File f1 = new File("./res/pallina/r.png");
        
        try {
            r1 = ImageIO.read(f1);
        } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public String directionUpDown = "up";
    public void update(){


        //cambio directionUpDown su schermoTop
        if (y <= 0){
            directionUpDown = "down";}

            switch (directionUpDown) {
                case "down": y += speed;
                break;
        
                case "up": y -= speed;
                break;
            }
            //rimbalzo su schermo sx
            if( x <= 0){
                directionLeftRight = "right";
                System.out.println("pallina x =" + x);
            }
        //rimbalzo suchermo dx;
        if( x >= gp.screenWidth){
            directionLeftRight = "left";
            System.out.println("pallina x =" + x);
        }
        switch (directionLeftRight) {
            case "left":
                 x -= speed;
                break;
            case "right":
                 x += speed;
                break;
        
            default:
                break;
        }
        // rimbalzo verso l alto su navicella
        if (y + dimHeight*2 >= nav.y  && (x + dimWidth) >= nav.x && x <= nav.x + nav.dimWidth){

            System.out.println("navicella x=" + nav.x + " nav x + dim= " + (nav.x +nav.dimWidth) + " x pallina " + x + "x pallina + dim " + ( x + dimWidth));
            directionUpDown = "up";
            

            if(x <= nav.x){
                directionLeftRight = "left";
                }else if (x>= nav.x + (nav.dimWidth - (dimWidth))) {
                    directionLeftRight = "right";
            }
                collisioOn = true;

        }   else{
                collisioOn = false;
            }
            
        //game over o pallina --
        if (y > gp.screenHeight){
            directionUpDown = "up";
            System.out.println("pallina out");

        }
       
        //animazione movimento & blocco pallina su navicella
        if (KeyH.spacePressed == true && collisioOn == true) {
            
           speed = 0;

             if (KeyH.rightPressed == true) {
            x += nav.speed;}

            if (KeyH.leftPressed == true) {
                x -= nav.speed;
            }
        }else{

            speed = 8;
          
        }

    }

    public void draw(Graphics2D g2){

      
        g2.drawLine(x, y, x, y);
        g2.drawImage(r1, x, y, dimHeight,dimHeight, null);

    }
}
