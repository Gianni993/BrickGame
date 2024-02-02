package Bricks;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Main.GamePanel;

public class BricksManager {
    
    GamePanel gp;
    Bricks[] bricks;
    int height = 24;
    int width = 60;
    int nBricks = 50;
    File[] mattone;
    int[] mattoneMap;
    
    int nColonnexRiga = 10;
    
    public BricksManager(GamePanel gp){

        this.gp = gp;
        bricks = new Bricks[nBricks]; //numero di brick in mappa
    
        caricaMappa();
        getMattoni();
        getBricks();
   }
   public void caricaMappa(){

        String pathFileName= "./res/bMap/map01.txt";
		File inputFile = new File(pathFileName);
		
        mattoneMap = new int[nBricks];
		
		Scanner scannerDaFile = null;
		try {
			scannerDaFile = new Scanner(inputFile);
			
			int i = 0;
			while(scannerDaFile.hasNextLine()) {
               
                mattoneMap[i] =(scannerDaFile.nextInt());
				System.out.println(mattoneMap[i]);
                i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(scannerDaFile!=null) {
				scannerDaFile.close();
			}
		}

   }

   public void getMattoni(){

    mattone = new File[3];

    try {
        mattone[0] = new File("./res/bricks/dmgclay.png");
        mattone[1] = new File("./res/bricks/dmgconcrete.png");
        mattone[2] = new File("./res/bricks/dmgperforated.png");

    } catch(Exception e) { //IOexeption
        e.printStackTrace();        
    }
   }

    
   public void getBricks(){
        
        int colonna = 0;
        int riga = 0;
        //int nColonnexRiga = 10;
        int fuga = 5;
        int x = 150; //offset
        int y = 50; //offset
        
        for(int i = 0 ; i < nBricks; i++){
            try{
                if (colonna >= nColonnexRiga){
                    riga ++;
                    colonna = 0;
                }
                bricks[i] = new Bricks();
                bricks[i].image = ImageIO.read(mattone[mattoneMap[i]]);
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
