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
        System.out.println(pallina.y);
        for(int i = 0; i < bricksMan.nBricks; i++){

            if(bricksMan.bricks[i] != null){

                
            collisionTopBricks(i);
            //collisionBottomBricks(i);
            
        
            }
      
        }

    }
    

    public void collisionTopBricks(int i){
                                //BLOCCO CONTROLLO X
        if(pallina.x >= (bricksMan.bricks[i].x - pallina.dimWidth) && pallina.x <= bricksMan.bricks[i].x + bricksMan.width

                                //BLOCCO CONTROLLO Y
            && (pallina.y + pallina.dimHeight) >= bricksMan.bricks[i].y && (pallina.y + pallina.dimHeight) <= (bricksMan.bricks[i].y + bricksMan.height/2) ){

            System.out.println("collisone top @ pallina.y  " + (pallina.y  ) + " bricks y "  + (bricksMan.bricks[i].y) );
            
            pallina.directionUpDown = "up";
            System.out.println("collisone top");
            bricksMan.bricks[i] = null;
        }
    }

    public void collisionBottomBricks(int i){

                            //BLOCCO CONTROLLO X
        if(pallina.x >= (bricksMan.bricks[i].x - pallina.dimWidth) && pallina.x <= bricksMan.bricks[i].x + bricksMan.width

                                //BLOCCO CONTROLLO Y
        && (pallina.y) <= (bricksMan.bricks[i].y + bricksMan.height)){
        
        pallina.directionUpDown = "down";
        
        
        System.out.println("collisone bottom @ "+ "pallina y" + pallina.y + " bricks y + altezza " + bricksMan.bricks + bricksMan.height);
        bricksMan.bricks[i] = null;
    }

        

    }

   public void collisionLeftBricks(int i){

    if((pallina.x + pallina.dimWidth) >=  bricksMan.bricks[i].x && pallina.x <= (bricksMan.bricks[i].x +5) &&

            //controllo sulle y
                (pallina.y + pallina.dimWidth ) >= bricksMan.bricks[i].y && pallina.y <= (bricksMan.bricks[i].y + bricksMan.width)){}


   }


}
