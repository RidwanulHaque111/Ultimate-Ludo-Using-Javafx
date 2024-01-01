/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeLadder;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author asus
 */
public class PlayerSnake {
    private int playerNum;
    private int dice;
    Image greenguti,redguti,blueguti,yellowguti ;
    ImageView imgGreen;
    ImageView imgRed;
    ImageView imgBlue;
    ImageView imgYellow;
    public GutiSnake guti;
    
    public PlayerSnake(int numberOfPlayer)
            
    {
     guti = new GutiSnake();
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
    

    
    public PlayerSnake()
            
    {
     guti = new GutiSnake();
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
