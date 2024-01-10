package Main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
    
        JFrame window = new JFrame();  //crea la finestra
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // X per chiudere la finestra
        window.setResizable(false);                   //finestra non ridimensionabile
        window.setTitle("Block Game");                    //nome nella barra della finestra
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();                                          //mostra la finestra con le dimensioni scelte nel game panel

        window.setLocationRelativeTo(null);                   //finestra sempre a centro schermo
        window.setVisible(true);                              //finestra visibile
        
        gamePanel.startGameThread();
        
        
    }
}