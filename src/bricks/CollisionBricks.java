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

        //System.out.println(pallina.y);
        for(int i = 0; i < bricksMan.nBricks; i++){

            collisionLeftBricks(i);  

            collisionRightBricks(i);

            collisionTopBricks(i);

            collisionBottomBricks(i);

        
        }
    }

    public void collisionTopBricks(int i){

        if(bricksMan.bricks[i] != null){
                                //BLOCCO CONTROLLO X
            if(pallina.x >= (bricksMan.bricks[i].x - pallina.dimWidth) && pallina.x <= bricksMan.bricks[i].x + bricksMan.width

                                //BLOCCO CONTROLLO Y
                && (pallina.y + pallina.dimHeight) >= bricksMan.bricks[i].y && (pallina.y + pallina.dimHeight) <= (bricksMan.bricks[i].y + bricksMan.height/2) ){

                System.out.println("collisone top \n pallina.y " + (pallina.y  ) + " bricks y "  + (bricksMan.bricks[i].y) );
            
                pallina.directionUpDown = "up";
                bricksMan.bricks[i] = null;
            }
        }
    }

    public void collisionBottomBricks(int i){

        if(bricksMan.bricks[i] != null){
                            //BLOCCO CONTROLLO X
            if(pallina.x >= bricksMan.bricks[i].x && pallina.x <= bricksMan.bricks[i].x + bricksMan.width

                                //BLOCCO CONTROLLO Y
                && (pallina.y) <= (bricksMan.bricks[i].y + bricksMan.height) && pallina.y >= bricksMan.bricks[i].y){
        
                pallina.directionUpDown = "down";
        
        
                System.out.println("collisone bottom  \n "+ "pallina y" + pallina.y + " bricks y + altezza bricks " + (bricksMan.bricks[i].y + bricksMan.height));
                bricksMan.bricks[i] = null;
            }
        }
    }

    public void collisionLeftBricks(int i){

        if(bricksMan.bricks[i] != null){

            //BLOCCO CONTROLLO X
            if( (pallina.x + pallina.dimHeight) >= bricksMan.bricks[i].x && (pallina.x + pallina.dimWidth) <= bricksMan.bricks[i].x + (bricksMan.width/6) &&
            
            //BLOCCO CONTROLLO Y
                (pallina.y + pallina.dimHeight )>= bricksMan.bricks[i].y && pallina.y <= (bricksMan.bricks[i].y + bricksMan.height)){


                System.out.println ("collisone left \n pallina x + width " + (pallina.x + pallina.dimWidth) + "  bricks x " + bricksMan.bricks[i].x);
                pallina.directionLeftRight = "left";
                bricksMan.bricks[i] = null;

            }
        }
   }

   public void collisionRightBricks(int i){

    if(bricksMan.bricks[i] != null){

        //BLOCCO CONTROLLO X
        if( pallina.x <= (bricksMan.bricks[i].x + bricksMan.width ) && pallina.x >= (bricksMan.bricks[i].x + bricksMan.width - (bricksMan.width/6)) &&
        
         //BLOCCO CONTROLLO Y
         (pallina.y + pallina.dimHeight )>= bricksMan.bricks[i].y && pallina.y <= (bricksMan.bricks[i].y + bricksMan.height)){


            System.out.println ("collisone right \n pallina x " + pallina.x + "  bricks x + width " + (bricksMan.bricks[i].x + bricksMan.width));
            pallina.directionLeftRight = "right";
            bricksMan.bricks[i] = null;

        }
    }
}



}
