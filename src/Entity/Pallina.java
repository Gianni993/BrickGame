package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
        dimHeight = 20;
        dimWidth = 20;
        x = (gp.screenWidth/2) - (dimWidth/2) ;
        y = gp.screenHeight - 24 ;
        speed = 8;
        directionLeftRight = "central";
        directionUpDown = "up";
    }

    public void getPallinaImage(){
        File f1 = new File("./res/pallina/r.png");
        File f2 = new File("./res/pallina/r2.png");
        File f3 = new File("./res/pallina/r3.png");
        File f4 = new File("./res/pallina/r4.png");

        try {
            r1 = ImageIO.read(f1);
            r2 = ImageIO.read(f2);
            r3 = ImageIO.read(f3);
            r4 = ImageIO.read(f4);
        } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public String directionUpDown = "up";
    public void update(){


        //cambio directionUpDown su schermoTop
        if (y < 0){
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
        // rimbalzo su navicella
        if (y >= nav.y && x >= (nav.x - dimWidth) && x <= nav.x + nav.dimWidth ){
            System.out.println("navicella x=" + nav.x + " nav x + dim= " + (nav.x +nav.dimWidth) + " x pallina " + x + "x pallina + dim " + ( x + dimWidth));
            directionUpDown = "up";
            collisioOn = true;

            if(x <= nav.x){
                directionLeftRight = "left";
                }else if (x>= nav.x + nav.dimWidth - (dimWidth)) {
                    directionLeftRight = "right";
                    collisioOn = true;
                }

        }   else{
                collisioOn = false;
            }
            
        //game over o pallina --
        if (y > gp.screenHeight){
            System.out.println("fine partita o pallina - 1 navicella x=" + nav.x + " nav x + dim= " + (nav.x +nav.dimWidth) + " x pallina " + x + "x pallina + dim " + ( x + dimWidth));
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

            if(animCounter >= 40){
                animCounter = 0 ;

            }else{
                animCounter++;}
        }

    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        //animazione rotazione palla
       if(animCounter <= 10){ image = r1;
            }else if(animCounter <= 20){ image = r2;
            }else if(animCounter <= 30){ image = r3;
            }else if(animCounter <= 40){ image = r4;
        }

        g2.drawImage(image, x, y - dimHeight, dimWidth,dimHeight, null);

    }
}
