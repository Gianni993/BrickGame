package bricks;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.io.File;

import Main.GamePanel;

public class BricksManager {
    
   GamePanel gp;
   Bricks[] bricks;

   public BricksManager(GamePanel gp){

        this.gp = gp;
        
        bricks = new Bricks[10]; //numero di mattoncini

        getBricksImage();
   }

        File clay = new File("./res/bricks/dmgclay.png");
        File concrete = new File("./res/bricks/dmgconcrete.png");
        File perforated = new File("./res/bricks/dmgperforated.png");

   public void getBricksImage(){

        

        try {

            bricks[0] = new Bricks();
            bricks[0].image = ImageIO.read(clay);
            bricks[0].collision = true;

            bricks[1] = new Bricks();
            bricks[1].image = ImageIO.read(concrete);
            bricks[1].collision = true;

            bricks[2] = new Bricks();
            bricks[2].image = ImageIO.read(perforated);
            bricks[2].collision = true;



           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        g2.drawImage(bricks[2].image,0,0,60,24,null);
    }

}
