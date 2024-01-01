/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeLadder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import termproject.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SnakeLadderController implements Initializable {

    @FXML ImageView rollDice;
    @FXML GridPane grid;
    @FXML GridPane gridTemp;
    @FXML Label whoseMove;
    
    PlayerSnake p,player1,player2,player3,player4;
    static boolean start_bug = true;
    static boolean guti_location_change = true;
    static int turn = 1;
    static int dice_value;
    private boolean greenLocationChange,redLocationChange,blueLocationChange,yellowLocationChange;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = new PlayerSnake(FXMLDocumentController.playerCount);
        
        if(p.getPlayerNum()==1) player1_er_guti_bosao();
        else if(p.getPlayerNum()==2) player2_er_guti_bosao();
        else if(p.getPlayerNum()==3) player3_er_guti_bosao();
        else if(p.getPlayerNum()==4) player4_er_guti_bosao();
        play();
       
       
    }
    @FXML public void backToMainMenu(ActionEvent event) throws IOException
    {
        Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/termproject/FXMLDocument.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setHeight(800);
        stage.setWidth(1330);
        stage.setScene(mainmenuscene);
        stage.show();  
        turn = 1;
 
    }
    
    public void player1_er_guti_bosao()
    {
        
        player1 = new PlayerSnake();
        player2 = new PlayerSnake();
        player3 = new PlayerSnake();
        player4 = new PlayerSnake();
        
        gridTemp.add(player1.guti.getGreen(), 0, 0);
    }
    
    public void player2_er_guti_bosao()
    {
        player1_er_guti_bosao();
        gridTemp.add(player2.guti.getRed(), 0, 1);
        startMatch();
    }
     public void player3_er_guti_bosao()
    {
        player2_er_guti_bosao();
        gridTemp.add(player3.guti.getBlue(), 1, 0);
    }
     
      public void player4_er_guti_bosao()
    {
        player3_er_guti_bosao();
        gridTemp.add(player4.guti.getYellow(), 1, 1);
    }
      
      public void play()
      {
          rollDice.setOnMouseClicked(e->
        {
            
            if(turn==1)
            {
                if(player1.guti.greenGutiMove.move_start==false)
            {
                guti_location_change = true;
            }
//                if(player1.guti.greenGutiMove.dice_value==1)
//                {
//                    guti_location_change = true;
//                }
                if(player1.guti.greenGutiMove.move_start==false && dice_value==1)
                {
                    guti_location_change = false;
                }
                
            }
            else if(turn==2)
            {
               if(player2.guti.redGutiMove.move_start==false)
            {
                guti_location_change = true;
            }
               if(player2.guti.redGutiMove.dice_value==1)
                {
                    guti_location_change = true;
                }
               if(player2.guti.redGutiMove.move_start==false && dice_value==1)
                {
                    guti_location_change = false;
                }
            }
            
            
            else if(turn==3)
            {
                if(player3.guti.blueGutiMove.move_start==false)
            {
                guti_location_change = true;
            }
                if(player3.guti.blueGutiMove.dice_value==1)
                {
                    guti_location_change = true;
                }
                if(player3.guti.blueGutiMove.move_start==false && dice_value==1)
                {
                    guti_location_change = false;
                }
            }
            else if(turn==4)
            {
                if(player4.guti.yellowGutiMove.move_start==false)
            {
                guti_location_change = true;
            }
                if(player4.guti.yellowGutiMove.dice_value==1)
                {
                    guti_location_change = true;
                }
                if(player4.guti.yellowGutiMove.move_start==false && dice_value==1)
                {
                    guti_location_change = false;
                }
            }
        if(guti_location_change==true)
        {
           if(start_bug==true)
        {
            turn--;
            start_bug = false;
        }
        if(dice_value!=1) turn++;
        if(p.getPlayerNum()==2)
        {
            
            if(turn>2) turn = 1;
        }
        else if(p.getPlayerNum()==3)
        {
             
            if(turn>3) turn = 1;
        }
        else if(p.getPlayerNum()==4)
        {     
            if(turn>4) turn = 1;
        }

        whoseMove.setText("Player "+turn+"'s Move");
        if (turn==1) {
            player1.Dice();
            dice_value = player1.getDice();
            
        }
        
        else if (turn==2) {
            player2.Dice();
            dice_value = player2.getDice();
            
        }
        else if (turn==3) {
            player3.Dice();
            dice_value = player3.getDice();
           
        }
        else if (turn==4) {
            player4.Dice();
            dice_value = player4.getDice();
    
        }

        diceRollAnimationForward();
        diceRollAnimationBackward();
        greenLocationChange = false;
        redLocationChange = false;
        blueLocationChange = false;
        yellowLocationChange = false;
        }
        guti_location_change = false;
      });
    
}
      
      public void startMatch()
      {
         player1.guti.getGreen().setOnMouseClicked(e->
        {   
            if(turn==1 && greenLocationChange==false)
            {
            if (dice_value==1 && player1.guti.greenGutiMove.move_start==false) {
                   gridTemp.getChildren().remove(player1.guti.getGreen());
                   grid.add(player1.guti.getGreen(), 0, 9);
                   player1.guti.greenGutiMove.move_start=true;
                   player1.guti.greenGutiMove.gutiRow = 9;
                   player1.guti.greenGutiMove.gutiColumn = 0;
                   guti_location_change = true;

               }
            else if(player1.guti.greenGutiMove.move_start==true)
                {
              
                   player1.guti.greenGutiMove.dice_value = dice_value;
                   grid.getChildren().remove(player1.guti.getGreen());
                   player1.guti.greenGutiMove.move();
                   grid.add(player1.guti.getGreen(), player1.guti.greenGutiMove.gutiColumn, player1.guti.greenGutiMove.gutiRow);
                   greenLocationChange = true;  
                   guti_location_change = true;
                   
                   }
            }
      });
         
         player2.guti.getRed().setOnMouseClicked(e->
        {   
            if(turn==2 && redLocationChange==false)
            {
            if (dice_value==1 && player2.guti.redGutiMove.move_start==false) {
                   gridTemp.getChildren().remove(player1.guti.getRed());
                   grid.add(player2.guti.getRed(), 0, 9);
                   player2.guti.redGutiMove.move_start=true;
                   player2.guti.redGutiMove.gutiRow = 9;
                   player2.guti.redGutiMove.gutiColumn = 0;
                    guti_location_change = true;
               }
            else if(player2.guti.redGutiMove.move_start==true)
                {
              
                   player2.guti.redGutiMove.dice_value = dice_value;
                    grid.getChildren().remove(player2.guti.getRed());
                   player2.guti.redGutiMove.move();  
                   grid.add(player2.guti.getRed(), player2.guti.redGutiMove.gutiColumn, player2.guti.redGutiMove.gutiRow);
                    redLocationChange = true;
                    guti_location_change = true;
                   
                   }
            }
      });         
         player3.guti.getBlue().setOnMouseClicked(e->
        {   
            if(turn==3 && blueLocationChange==false)
            {
            if (dice_value==1 && player3.guti.blueGutiMove.move_start==false) {
                   gridTemp.getChildren().remove(player3.guti.getBlue());
                   grid.add(player3.guti.getBlue(), 0, 9);
                   player3.guti.blueGutiMove.move_start=true;
                   player3.guti.blueGutiMove.gutiRow = 9;
                   player3.guti.blueGutiMove.gutiColumn = 0;
                   guti_location_change = true;
               }
            else if(player3.guti.blueGutiMove.move_start==true)
                {
              
                   player3.guti.blueGutiMove.dice_value = dice_value;
                  
                   grid.getChildren().remove(player3.guti.getBlue());
                   player3.guti.blueGutiMove.move();
                   grid.add(player3.guti.getBlue(), player3.guti.blueGutiMove.gutiColumn, player3.guti.blueGutiMove.gutiRow);
                   blueLocationChange = true;
                   guti_location_change = true; 
                   
                    
                   
                    
                   }
            }
      });
         
         player4.guti.getYellow().setOnMouseClicked(e->
        {   
            if(turn==4 && yellowLocationChange==false)
            {
            if (dice_value==1 && player4.guti.yellowGutiMove.move_start==false) {
                   gridTemp.getChildren().remove(player4.guti.getYellow());
                   grid.add(player4.guti.getYellow(), 0, 9);
                   player4.guti.yellowGutiMove.move_start=true;
                   player4.guti.yellowGutiMove.gutiRow = 9;
                   player4.guti.yellowGutiMove.gutiColumn = 0;
                   guti_location_change = true;
                 
               }
            else if(player4.guti.yellowGutiMove.move_start==true)
                {             
                   player4.guti.yellowGutiMove.dice_value = dice_value;  
                   grid.getChildren().remove(player4.guti.getYellow());
                   player4.guti.yellowGutiMove.move();
                   grid.add(player4.guti.getYellow(), player4.guti.yellowGutiMove.gutiColumn, player4.guti.yellowGutiMove.gutiRow);
                   yellowLocationChange  =  true;
                   guti_location_change = true;
                  
                   }
            }
      });
    }
      
    private void diceRollAnimationForward()
    {
      TranslateTransition t = new TranslateTransition(Duration.seconds(1));
      RotateTransition r = new RotateTransition(Duration.seconds(0.25));
      r.setNode(rollDice);
      r.setByAngle(360);
      r.setFromAngle(0);
      t.setNode(rollDice);
      r.setCycleCount(4);
      t.setToX(70);
      r.setAutoReverse(true);
      t.setAutoReverse(true);
      //t.play();
      r.play();
    }
    
    private void diceRollAnimationBackward()
    {
      TranslateTransition t = new TranslateTransition(Duration.seconds(0.5));
      RotateTransition r = new RotateTransition(Duration.seconds(0.125));
      r.setNode(rollDice);
      r.setByAngle(360);
      r.setFromAngle(0);
      t.setNode(rollDice);
      r.setCycleCount(4);     
      //t.play();
      r.play();
      shuffleDice();
    }
    
    private void shuffleDice()
    {
        
        switch (dice_value) {
            case 6:
                rollDice.setImage(new Image("file:d6.png"));
                break;
            case 5:
                rollDice.setImage(new Image("file:d5.png"));
                break;
            case 4:
                rollDice.setImage(new Image("file:d4.png"));
                break;
            case 3:
                rollDice.setImage(new Image("file:d3.png"));
                break;
            case 2:
                rollDice.setImage(new Image("file:d2.png"));
                break;
            default:
                rollDice.setImage(new Image("file:d1.png"));
                break;
        }
    }
}