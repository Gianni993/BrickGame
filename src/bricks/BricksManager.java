package Bricks;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.io.File;

import Main.GamePanel;

public class BricksManager {
    
    GamePanel gp;
    Bricks[] bricks;
    int height = 24;
    int width = 60;
    int nBricks = 90;
    File clay = new File("./res/bricks/dmgclay.png");
    File concrete = new File("./res/bricks/dmgconcrete.png");
    File perforated = new File("./res/bricks/dmgperforated.png");


   public BricksManager(GamePanel gp){

        this.gp = gp;
        bricks = new Bricks[nBricks]; //numero di brick in mappa

        getBricks();
   }
    
   public void getBricks(){
        
       
        int colonna = 0;
        int riga = 0;
        int nColonnexRiga = 15;
        int fuga = 10;
        int x = 125; //offset
        int y = 50; //offset
        
        for(int i = 0 ; i <= nBricks; i++){
            try{
                if (colonna >= nColonnexRiga){
                    riga ++;
                    colonna = 0;
                }
                bricks[i] = new Bricks();
                bricks[i].image = ImageIO.read(perforated);
                bricks[i].collision = true;
                bricks[i].x = x + (width * colonna) + (colonna * fuga);
                bricks[i].y = y + (riga * height) + (riga * fuga); 
               
                colonna++;
            } catch (Exception e) {
                    e.printStackTrace();
            }   
        }
    }

    
    public void draw(Graphics2D g2){
          
        for (int i = 0 ; i < nBricks ; i++){
            if(bricks[i] != null){
                g2.drawImage(bricks[i].image,bricks[i].x,bricks[i].y,width,height ,null);
            }
        }
    }

}
