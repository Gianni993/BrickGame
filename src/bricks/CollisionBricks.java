package Bricks;

import Entity.Pallina;
import Main.GamePanel;


public class CollisionBricks {

    GamePanel gp;
    Pallina pallina;
    BricksManager bricksMan;

    
    public CollisionBricks (GamePanel gp,Pallina pallina, BricksManager bricksMan){

        this.gp = gp;
        this.pallina = pallina;
        this.bricksMan = bricksMan;

    }
    
    public void CollisionPallinaBricks(){
        
        for(int i = 0; i < bricksMan.nBricks; i++){

            if(bricksMan.bricks[i] != null){
                //collisone con top bricks
               if(pallina.x >= (bricksMan.bricks[i].x - pallina.dimWidth) && pallina.x <= bricksMan.bricks[i].x + bricksMan.width && bricksMan.bricks[i].y <= (pallina.y + pallina.dimHeight) && 
                    bricksMan.bricks[i].y >= pallina.y){
            
                    pallina.directionUpDown = "up";
                    System.out.println("collisone top");
                    bricksMan.bricks[i] = null;
                }
            }
       
            //collisone con bottom bricks
            if(bricksMan.bricks[i] != null){
                
                if(pallina.x >= (bricksMan.bricks[i].x - pallina.dimWidth) && pallina.x <= bricksMan.bricks[i].x + bricksMan.width && bricksMan.bricks[i].y + bricksMan.height <= pallina.y && 
                    bricksMan.bricks[i].y + bricksMan.height + pallina.speed >= pallina.y){  //toglieno speed i px della pallina non potrebbero coinicdere con i px del bricks poiche senza speed potrebbe saltare il multiplo e non far avvenire la collisione
                                                                                        
                    pallina.directionUpDown = "down";
                    System.out.println("collisone down y" + pallina.y);
                    bricksMan.bricks[i] = null;
                }
            }





            
        }
    }

   

}
