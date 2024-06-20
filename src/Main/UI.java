package Main;

import Bricks.Bricks;
import Bricks.BricksManager;
import java.awt.*;

public class UI {
    private GamePanel gp;
    private Font arial_30;
    private BricksManager bm;

    public  UI(GamePanel gp , BricksManager bm){
        this.gp = gp;
        this.bm = bm;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
    }

    public void draw(Graphics2D g2){
        int count = 0;
        g2.setFont(arial_30);
        g2.setColor(Color.white);
        g2.drawString("Palline = " +"1",50,50);

        for(Bricks b : bm.bricks){
            if(b == null){count++;}
        }
        g2.drawString("Bricks = " + (bm.bricks.length - count) + "/ " + bm.bricks.length, 50, 100);

    }
}
