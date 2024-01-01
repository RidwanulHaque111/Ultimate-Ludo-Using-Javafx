/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeLadder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author asus
 */
public class GutiSnake {
    public Move greenGutiMove;
    public Move redGutiMove;
    public Move blueGutiMove;
    public Move yellowGutiMove;

    
     private Image greenGuti,redGuti,blueGuti,yellowGuti;
     private ImageView green;
     private ImageView red;
     private ImageView blue;
     private ImageView yellow;
     
       public GutiSnake()
       {
           greenGutiMove = new Move();
           redGutiMove  = new Move();
           blueGutiMove = new Move();
           yellowGutiMove = new Move();

       }
     
     public void generatePlayer1()
     {
        greenGuti = new Image("file:greenguti.png");
        
        green = new ImageView(greenGuti);
        green.setPreserveRatio(true);
        green.setFitHeight(60);
 
     }
     
     public void generatePlayer2()
     {
        redGuti = new Image("file:redguti.png");
        
        red = new ImageView(redGuti);
        red.setPreserveRatio(true);
        red.setFitHeight(60);
 
     }
     
     public void generatePlayer3()
     {
        blueGuti = new Image("file:blueguti.png");
        
        blue = new ImageView(blueGuti);
        blue.setPreserveRatio(true);
        blue.setFitHeight(60);
   
     }
     
     public void generatePlayer4()
     {
        yellowGuti = new Image("file:yellowguti.png");
        yellow = new ImageView(yellowGuti);
        yellow.setPreserveRatio(true);
        yellow.setFitHeight(60);
     }

    public ImageView getGreen() {
        return green;
    }

    public ImageView getRed() {
        return red;
    }

    public ImageView getBlue() {
        return blue;
    }

    public ImageView getYellow() {
        return yellow;
    }
    
    
    
}
