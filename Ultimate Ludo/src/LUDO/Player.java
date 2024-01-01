
package LUDO;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player {

    
    private int playerNum;
    private int dice;
    Image greenguti,redguti,blueguti,yellowguti ;
    ImageView imgGreen1,imgGreen2,imgGreen3,imgGreen4;
    ImageView imgRed1,imgRed2,imgRed3,imgRed4;
    ImageView imgBlue1,imgBlue2,imgBlue3,imgBlue4;
    ImageView imgYellow1,imgYellow2,imgYellow3,imgYellow4;
    public Guti guti;
    
    public Player(int numberOfPlayer)
            
    {
     guti = new Guti();
     playerNum = numberOfPlayer;
        switch (playerNum) {
            case 2:
                guti.generatePlayer1();
                guti.generatePlayer2();
                break;
            case 3:
                guti.generatePlayer1();
                guti.generatePlayer2();
                guti.generatePlayer3();
                break;
            case 4:
                guti.generatePlayer1();
                guti.generatePlayer2();
                guti.generatePlayer3();
                guti.generatePlayer4();
                break;
            default:
                break;
        }

    }
    

    
    public Player()
            
    {
     guti = new Guti();
     guti.generatePlayer1();
     guti.generatePlayer2();
     guti.generatePlayer3();
     guti.generatePlayer4();
    
    }
    
    public void Dice()
    {
       Random random = new Random();
       dice = (random.nextInt())%6;
       dice = (dice<0 ? dice*(-1):dice) + 1;
     
   
    }

    public int getDice() {
        return dice;
    }

    public int getPlayerNum() {
        return playerNum;
    }

   
    
}
