/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUDO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import termproject.FXMLDocumentController;


/**
 *
 * @author hp
 */
public class LUDOController implements Initializable {
    
    @FXML private ImageView rollDice;
    @FXML private Label whoseMove;
    
    @FXML private GridPane grid;
    @FXML private GridPane gridGreen;
    
    @FXML private GridPane gridRed;
    @FXML private GridPane gridBlue;
    @FXML private GridPane gridYellow;
    @FXML private StackPane stackPaneGreen;
    @FXML private StackPane stackPaneRed;
    @FXML private StackPane stackPaneBlue;
    @FXML private StackPane stackPaneYellow;
    
     public Player p;
     public Image greenGuti,redGuti,blueGuti,yellowGuti;
     public ImageView green1,green2,green3,green4;
     public ImageView red1,red2,red3,red4;
     public  ImageView blue1,blue2,blue3,blue4;
     public ImageView yellow1,yellow2,yellow3,yellow4;
     private static boolean khela_start = false;
     private static boolean guti_location_change;
     private static int count;
     private static int gutiRow,gutiColumn,dice_value;
     private static int countPlayer1,countPlayer2,countPlayer3,countPlayer4;
     private static int winner;
     private static int turn=1;
     private boolean start_bug = true;
     private boolean green1LocationChange,green2LocationChange,green3LocationChange,green4LocationChange;
     private boolean red1LocationChange,red2LocationChange,red3LocationChange,red4LocationChange;
     private boolean blue1LocationChange,blue2LocationChange,blue3LocationChange,blue4LocationChange;
     private boolean yellow1LocationChange,yellow2LocationChange,yellow3LocationChange,yellow4LocationChange;
     
     private Player player1,player2,player3,player4;
     private int player_id;
     private static Client client;

     

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ////////////DEBUG///////////
                  
            
            
            
            /////////////DEBUG/////////////
         
          
              try {
                  client = new Client();
                  client.send("getID");
                  player_id = Integer.parseInt(client.receive());
                  System.out.println(player_id);
              } catch (IOException ex) {
                  Logger.getLogger(LUDOController.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          
          
          
          
          
          p = new Player(FXMLDocumentController.playerCount);     
          single_player();
          if (p.getPlayerNum()==1) player1_er_guti_bosao();
          else if(p.getPlayerNum()==2) player2_er_guti_bosao();
          else if(p.getPlayerNum()==3) player3_er_guti_bosao();
          else player4_er_guti_bosao();
             
   
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
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();
        gridGreen.add(player1.guti.getGreen1(), 1, 0);
        gridGreen.add(player1.guti.getGreen2(), 2, 1);
        gridGreen.add(player1.guti.getGreen3(), 1, 2);
        gridGreen.add(player1.guti.getGreen4(), 0, 1);
    
    }
    public void player2_er_guti_bosao()
    {     
        player1_er_guti_bosao();
        
       
        gridRed.add(player2.guti.getRed1(), 1, 0);
        gridRed.add(player2.guti.getRed2(), 2, 1);
        gridRed.add(player2.guti.getRed3(), 1, 2);
        gridRed.add(player2.guti.getRed4(), 0, 1);
        greenPlay();
        redPlay();
 
    }
    
    public void player3_er_guti_bosao()
    {
        player2_er_guti_bosao();
        
       
        gridBlue.add(player3.guti.getBlue1(), 1, 0);
        gridBlue.add(player3.guti.getBlue2(), 2, 1);
        gridBlue.add(player3.guti.getBlue3(), 1, 2);
        gridBlue.add(player3.guti.getBlue4(), 0, 1);
        
        bluePlay();
       
    }
    public void player4_er_guti_bosao() 
    {
 
        player3_er_guti_bosao();

        gridYellow.add(player4.guti.getYellow1(), 1, 0);
        gridYellow.add(player4.guti.getYellow2(), 2, 1);
        gridYellow.add(player4.guti.getYellow3(), 1, 2);
        gridYellow.add(player4.guti.getYellow4(), 0, 1);
        yellowPlay();

    }
 
     public void greenPlay()
    {
        player1.guti.getGreen1().setOnMouseClicked(e->
        {   
            if(turn==1 && green1LocationChange==false && green2LocationChange==false && green3LocationChange==false && green4LocationChange==false)
            {
            if (dice_value==6 && player1.guti.green1Guti.move_start==false) {
                   grid.getChildren().remove(player1.guti.getGreen1());
                   grid.add(player1.guti.getGreen1(), 1, 6);
                   player1.guti.green1Guti.move_start=true;
                   player1.guti.green1Guti.gutiRow = 6;
                   player1.guti.green1Guti.gutiColumn = 1;
                   green1LocationChange = true;
                   green2LocationChange = true;
                   green3LocationChange = true;
                   green4LocationChange = true;
                   guti_location_change = true;
                  
               }
            else if(player1.guti.green1Guti.move_start==true)
                {
              
                   player1.guti.green1Guti.dice_value = dice_value;
                   player1.guti.green1Guti.greenMove();
                   grid.getChildren().remove(player1.guti.getGreen1());
                   grid.add(player1.guti.getGreen1(), player1.guti.green1Guti.gutiColumn, player1.guti.green1Guti.gutiRow);
                    green1LocationChange = true;
            green2LocationChange = true;
            green3LocationChange = true;
            green4LocationChange = true;  
            guti_location_change = true;
             
                   }
            
	 }
            kheye_felse_green(player1.guti.getGreen1());
 
        });
  
        
        player1.guti.getGreen2().setOnMouseClicked(e->
        {
            if(turn==1 && green1LocationChange==false && green2LocationChange==false && green3LocationChange==false && green4LocationChange==false)
            {
                if (dice_value==6 && player1.guti.green2Guti.move_start==false) {
                   grid.getChildren().remove(player1.guti.getGreen2());
                   grid.add(player1.guti.getGreen2(), 1, 6);
                   player1.guti.green2Guti.move_start=true;
                   player1.guti.green2Guti.gutiRow = 6;
                   player1.guti.green2Guti.gutiColumn = 1;
                   green1LocationChange = true;
                   green2LocationChange = true;
                   green3LocationChange = true;
                   green4LocationChange = true;
                   guti_location_change = true;
                  
                   
               }
            else if(player1.guti.green2Guti.move_start==true)

                  {  player1.guti.green2Guti.dice_value = dice_value;
                   player1.guti.green2Guti.greenMove();
                   grid.getChildren().remove(player1.guti.getGreen2());
                   grid.add(player1.guti.getGreen2(), player1.guti.green2Guti.gutiColumn, player1.guti.green2Guti.gutiRow);
             green1LocationChange = true;
                green2LocationChange = true;
                green3LocationChange = true;
                green4LocationChange = true;
                guti_location_change = true;
              
            }
                
	}
            kheye_felse_green(player1.guti.getGreen2());
        });
            
                
            
        
        player1.guti.getGreen3().setOnMouseClicked(e->
        {   
            if(turn==1 && green1LocationChange==false && green2LocationChange==false && green3LocationChange==false && green4LocationChange==false)
            {
               if (dice_value==6 && player1.guti.green3Guti.move_start==false) {
                   grid.getChildren().remove(player1.guti.getGreen3());
                   grid.add(player1.guti.getGreen3(), 1, 6);
                   player1.guti.green3Guti.move_start=true;
                   player1.guti.green3Guti.gutiRow = 6;
                   player1.guti.green3Guti.gutiColumn = 1;
                   green1LocationChange = true;
                   green2LocationChange = true;
                   green3LocationChange = true;
                   green4LocationChange = true;
                   guti_location_change = true;
                   
                  
               }
            else if(player1.guti.green3Guti.move_start==true)
                  {
                   player1.guti.green3Guti.dice_value = dice_value; 
                   player1.guti.green3Guti.greenMove();
                   grid.getChildren().remove(player1.guti.getGreen3());
                   grid.add(player1.guti.getGreen3(), player1.guti.green3Guti.gutiColumn, player1.guti.green3Guti.gutiRow);
                   green1LocationChange = true;
               green2LocationChange = true;
               green3LocationChange = true;
               green4LocationChange = true;
               guti_location_change = true;
               
             
            } 
               
	}			
       kheye_felse_green(player1.guti.getGreen3());
        }); 
            
            
        player1.guti.getGreen4().setOnMouseClicked(e->
        {
            if(turn==1 && green1LocationChange==false && green2LocationChange==false && green3LocationChange==false && green4LocationChange==false)
            {
                if (dice_value==6 && player1.guti.green4Guti.move_start==false) {
                   grid.getChildren().remove(player1.guti.getGreen4());
                   grid.add(player1.guti.getGreen4(), 1, 6);
                   player1.guti.green4Guti.move_start=true;
                   player1.guti.green4Guti.gutiRow = 6;
                   player1.guti.green4Guti.gutiColumn = 1;
                   green1LocationChange = true;
                   green2LocationChange = true;
                   green3LocationChange = true;
                   green4LocationChange = true;
                   guti_location_change = true;
                
                 
               }
            else if(player1.guti.green4Guti.move_start==true)
               {
                   player1.guti.green4Guti.dice_value = dice_value;
                   player1.guti.green4Guti.greenMove();
                   grid.getChildren().remove(player1.guti.getGreen4());
                   grid.add(player1.guti.getGreen4(), player1.guti.green4Guti.gutiColumn, player1.guti.green4Guti.gutiRow);
                   green1LocationChange = true;
                   green2LocationChange = true;
                   green3LocationChange = true;
                   green4LocationChange = true;
                   guti_location_change = true;
                }
                
            }
            
            
            kheye_felse_green(player1.guti.getGreen4());
        });
        
    }
    
    public void redPlay()
    {
        player2.guti.getRed1().setOnMouseClicked(e->
        {
            if(turn==2 && red1LocationChange==false && red2LocationChange==false && red3LocationChange==false && red4LocationChange==false)
            {
                if (player2.getDice()==6 && player2.guti.red1Guti.move_start==false) {
                   grid.getChildren().remove(player2.guti.getRed1());
                   grid.add(player2.guti.getRed1(), 8, 1);
                   player2.guti.red1Guti.move_start=true;
                   player2.guti.red1Guti.gutiRow = 1;
                   player2.guti.red1Guti.gutiColumn = 8;
                   red1LocationChange = true;
                   red2LocationChange = true;
                   red3LocationChange = true;
                   red4LocationChange = true;
                   guti_location_change = true;
                    
              
               }
            else if(player2.guti.red1Guti.move_start==true)
                player2.guti.getRed1().setOnMouseClicked(f->
                {
                    player2.guti.red1Guti.dice_value = dice_value;
                   player2.guti.red1Guti.redMove();
                   grid.getChildren().remove(player2.guti.getRed1());
                   grid.add(player2.guti.getRed1(), player2.guti.red1Guti.gutiColumn, player2.guti.red1Guti.gutiRow);
                   red1LocationChange = true;
                   red2LocationChange = true;
                   red3LocationChange = true;
                   red4LocationChange = true; 
                   guti_location_change = true;
                
                });
              
           }
        kheye_felse_red(player2.guti.getRed1());
        });
        
            
            
        
        player2.guti.getRed2().setOnMouseClicked(e->
        {
            
            if(turn==2 && red1LocationChange==false && red2LocationChange==false && red3LocationChange==false && red4LocationChange==false)
            {
                 if (player2.getDice()==6 && player2.guti.red2Guti.move_start==false) {
                   grid.getChildren().remove(player2.guti.getRed2());
                   grid.add(player2.guti.getRed2(), 8, 1);
                   player2.guti.red2Guti.move_start=true;
                   player2.guti.red2Guti.gutiRow = 1;
                   player2.guti.red2Guti.gutiColumn = 8;
                   red1LocationChange = true;
                   red2LocationChange = true;
                   red3LocationChange = true;
                   red4LocationChange = true;
                    guti_location_change = true;
                 
               }
            else if(player2.guti.red2Guti.move_start==true)
                {
                    player2.guti.red2Guti.dice_value = dice_value;
                   player2.guti.red2Guti.redMove();
                   grid.getChildren().remove(player2.guti.getRed2());
                   grid.add(player2.guti.getRed2(), player2.guti.red2Guti.gutiColumn, player2.guti.red2Guti.gutiRow);
                   red1LocationChange = true;
               red2LocationChange = true;
               red3LocationChange = true;
               red4LocationChange = true;
                guti_location_change = true;
                
            }
               
	}
         kheye_felse_red(player2.guti.getRed2());   
        });
        
        player2.guti.getRed3().setOnMouseClicked(e->
        {
            if(turn==2 && red1LocationChange==false && red2LocationChange==false && red3LocationChange==false && red4LocationChange==false)
            {
                if (player2.getDice()==6 && player2.guti.red3Guti.move_start==false) {
                   grid.getChildren().remove(player2.guti.getRed3());
                   grid.add(player2.guti.getRed3(), 8, 1);
                   player2.guti.red3Guti.move_start=true;
                   player2.guti.red3Guti.gutiRow = 1;
                   player2.guti.red3Guti.gutiColumn = 8;
                   red1LocationChange = true;
                   red2LocationChange = true;
                   red3LocationChange = true;
                   red4LocationChange = true;
                    guti_location_change = true;
                   
               }
            else if(player2.guti.red3Guti.move_start==true)
               {  
                   player2.guti.red3Guti.dice_value = dice_value; 
                   player2.guti.red3Guti.redMove();
                   grid.getChildren().remove(player2.guti.getRed3());
                   grid.add(player2.guti.getRed3(), player2.guti.red3Guti.gutiColumn, player2.guti.red3Guti.gutiRow);
                red1LocationChange = true;
               red2LocationChange = true;
               red3LocationChange = true;
               red4LocationChange = true; 
                guti_location_change = true;
               }
                
            
            }
            
          kheye_felse_red(player2.guti.getRed3());   
        });
        
        player2.guti.getRed4().setOnMouseClicked(e->
        {
            if(turn==2 && red1LocationChange==false && red2LocationChange==false && red3LocationChange==false && red4LocationChange==false)
            {
                if (player2.getDice()==6 && player2.guti.red4Guti.move_start==false) {
                   grid.getChildren().remove(player2.guti.getRed4());
                   grid.add(player2.guti.getRed4(), 8, 1);
                   player2.guti.red4Guti.move_start=true;
                   player2.guti.red4Guti.gutiRow = 1;
                   player2.guti.red4Guti.gutiColumn = 8;
                   red1LocationChange = true;
                   red2LocationChange = true;
                   red3LocationChange = true;
                   red4LocationChange = true;
                    guti_location_change = true;
                 
               }
            else if(player2.guti.red4Guti.move_start==true)
               {
                   player2.guti.red4Guti.dice_value = dice_value;
                   player2.guti.red4Guti.redMove();
                   grid.getChildren().remove(player2.guti.getRed4());
                   grid.add(player2.guti.getRed4(), player2.guti.red4Guti.gutiColumn, player2.guti.red4Guti.gutiRow);
                  red1LocationChange = true;
               red2LocationChange = true;
               red3LocationChange = true;
               red4LocationChange = true;
                guti_location_change = true;
               }
               
            }
          kheye_felse_red(player2.guti.getRed4());
        });
    }
    public void bluePlay()
    {
        
        player3.guti.getBlue1().setOnMouseClicked(e->
        {
            if(turn==3 && blue1LocationChange==false && blue2LocationChange==false && blue3LocationChange==false && blue4LocationChange==false)
            {
                if (player3.getDice()==6 && player3.guti.blue1Guti.move_start==false) {
                   grid.getChildren().remove(player3.guti.getBlue1());
                   grid.add(player3.guti.getBlue1(), 13, 8);
                   player3.guti.blue1Guti.move_start=true;
                   player3.guti.blue1Guti.gutiRow = 8;
                   player3.guti.blue1Guti.gutiColumn = 13;
                   blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                   
                    guti_location_change = true;
               
               }
            else if(player3.guti.blue1Guti.move_start==true)
                {
                    player3.guti.blue1Guti.dice_value = dice_value;
                   player3.guti.blue1Guti.blueMove();
                   grid.getChildren().remove(player3.guti.getBlue1());
                   grid.add(player3.guti.getBlue1(), player3.guti.blue1Guti.gutiColumn, player3.guti.blue1Guti.gutiRow);
                   blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
              }
            
            }
           kheye_felse_blue(player3.guti.getBlue1());  
        });
        
        player3.guti.getBlue2().setOnMouseClicked(e->
        {
            if(turn==3 && blue1LocationChange==false && blue2LocationChange==false && blue3LocationChange==false && blue4LocationChange==false)
            {
               if (player3.getDice()==6 && player3.guti.blue2Guti.move_start==false) {
                   grid.getChildren().remove(player3.guti.getBlue2());
                   grid.add(player3.guti.getBlue2(), 13, 8);
                   player3.guti.blue2Guti.move_start=true;
                   player3.guti.blue2Guti.gutiRow = 8;
                   player3.guti.blue2Guti.gutiColumn = 13;
                   blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
                 
               }
            else if(player3.guti.blue2Guti.move_start==true)
               {
                    player3.guti.blue2Guti.dice_value = dice_value;
                   player3.guti.blue2Guti.blueMove();
                   grid.getChildren().remove(player3.guti.getBlue2());
                   grid.add(player3.guti.getBlue2(), player3.guti.blue2Guti.gutiColumn, player3.guti.blue2Guti.gutiRow);
                  blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
               }
             
            }
           kheye_felse_blue(player3.guti.getBlue2());  
        });
        
        player3.guti.getBlue3().setOnMouseClicked(e->
        {
            if(turn==3 && blue1LocationChange==false && blue2LocationChange==false && blue3LocationChange==false && blue4LocationChange==false)
            {
                if (player3.getDice()==6 && player3.guti.blue3Guti.move_start==false) {
                   grid.getChildren().remove(player3.guti.getBlue3());
                   grid.add(player3.guti.getBlue3(), 13, 8);
                   player3.guti.blue3Guti.move_start=true;
                   player3.guti.blue3Guti.gutiRow = 8;
                   player3.guti.blue3Guti.gutiColumn = 13;
                   blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
                 
               }
            else if(player3.guti.blue3Guti.move_start==true)
               {  
                   player3.guti.blue3Guti.dice_value = dice_value; 
                   player3.guti.blue3Guti.blueMove();
                   grid.getChildren().remove(player3.guti.getBlue3());
                   grid.add(player3.guti.getBlue3(), player3.guti.blue3Guti.gutiColumn, player3.guti.blue3Guti.gutiRow);
               blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
               }
            }
            
           kheye_felse_blue(player3.guti.getBlue3());   
        });
        player3.guti.getBlue4().setOnMouseClicked(e->
        {
            if(turn==3 && blue1LocationChange==false && blue2LocationChange==false && blue3LocationChange==false && blue4LocationChange==false)
            {
               if (player3.getDice()==6 && player3.guti.blue4Guti.move_start==false) {
                   grid.getChildren().remove(player3.guti.getBlue4());
                   grid.add(player3.guti.getBlue4(), 13, 8);
                   player3.guti.blue4Guti.move_start=true;
                   player3.guti.blue4Guti.gutiRow = 8;
                   player3.guti.blue4Guti.gutiColumn = 13;
                   blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
                  
               }
            else if(player3.guti.blue4Guti.move_start==true)
               {
                   player3.guti.blue4Guti.dice_value = dice_value;
                   player3.guti.blue4Guti.blueMove();
                   grid.getChildren().remove(player3.guti.getBlue4());
                   grid.add(player3.guti.getBlue4(), player3.guti.blue4Guti.gutiColumn, player3.guti.blue4Guti.gutiRow);
                blue1LocationChange = true;
                   blue2LocationChange = true;
                   blue3LocationChange = true;
                   blue4LocationChange = true;
                    guti_location_change = true;
               }
             
            }
          kheye_felse_blue(player3.guti.getBlue4());  
        });
    }
    
  public void yellowPlay()
    {

       player4.guti.getYellow1().setOnMouseClicked(e->
        {
            if(turn==4 && yellow1LocationChange==false && yellow2LocationChange==false && yellow3LocationChange==false && yellow4LocationChange==false)
            {
                if (player4.getDice()==6 && player4.guti.yellow1Guti.move_start==false) {
                   grid.getChildren().remove(player4.guti.getYellow1());
                   grid.add(player4.guti.getYellow1(), 6, 13);
                   player4.guti.yellow1Guti.move_start=true;
                   player4.guti.yellow1Guti.gutiRow = 13;
                   player4.guti.yellow1Guti.gutiColumn = 6;
                   yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                   
               }
            else if(player4.guti.yellow1Guti.move_start==true)
                {
                    player4.guti.yellow1Guti.dice_value = dice_value;
                   player4.guti.yellow1Guti.yellowMove();
                   grid.getChildren().remove(player4.guti.getYellow1());
                   grid.add(player4.guti.getYellow1(), player4.guti.yellow1Guti.gutiColumn, player4.guti.yellow1Guti.gutiRow);
                  yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                }
            
            }
           kheye_felse_yellow(player4.guti.getYellow1());   
        });
       
       player4.guti.getYellow2().setOnMouseClicked(e->
        {
            if(turn==4)
            {
                if (player4.getDice()==6 && player4.guti.yellow2Guti.move_start==false) {
                   grid.getChildren().remove(player4.guti.getYellow2());
                   grid.add(player4.guti.getYellow2(), 6, 13);
                   player4.guti.yellow2Guti.move_start=true;
                   player4.guti.yellow2Guti.gutiRow = 13;
                   player4.guti.yellow2Guti.gutiColumn = 6;
                   yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                  
               }
            else if(player4.guti.yellow2Guti.move_start==true)
               {
                    player4.guti.yellow2Guti.dice_value = dice_value;
                   player4.guti.yellow2Guti.yellowMove();
                   grid.getChildren().remove(player4.guti.getYellow2());
                   grid.add(player4.guti.getYellow2(), player4.guti.yellow2Guti.gutiColumn, player4.guti.yellow2Guti.gutiRow);
                   yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                }
            
            }
         kheye_felse_yellow(player4.guti.getYellow2());     
        });
       
        player4.guti.getYellow3().setOnMouseClicked(e->
        {
            if(turn==4)
            {
                if (player4.getDice()==6 && player4.guti.yellow3Guti.move_start==false) {
                   grid.getChildren().remove(player4.guti.getYellow3());
                   grid.add(player4.guti.getYellow3(), 6, 13);
                   player4.guti.yellow3Guti.move_start=true;
                   player4.guti.yellow3Guti.gutiRow = 13;
                   player4.guti.yellow3Guti.gutiColumn = 6;
                   yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                  
               }
            else if(player4.guti.yellow3Guti.move_start==true)
                {  
                   player4.guti.yellow3Guti.dice_value = dice_value; 
                   player4.guti.yellow3Guti.yellowMove();
                   grid.getChildren().remove(player4.guti.getYellow3());
                   grid.add(player4.guti.getYellow3(), player4.guti.yellow3Guti.gutiColumn, player4.guti.yellow3Guti.gutiRow);
                 yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
               }
           
            }
           kheye_felse_yellow(player4.guti.getYellow3());     
        });
        
        player4.guti.getYellow4().setOnMouseClicked(e->
        {
            if(turn==4)
            {
                if (player4.getDice()==6 && player4.guti.yellow4Guti.move_start==false) {
                   grid.getChildren().remove(player4.guti.getYellow4());
                   grid.add(player4.guti.getYellow4(), 6, 13);
                   player4.guti.yellow4Guti.move_start=true;
                   player4.guti.yellow4Guti.gutiRow = 13;
                   player4.guti.yellow4Guti.gutiColumn = 6;
                   yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                 
               }
            else if(player4.guti.yellow4Guti.move_start==true)
                {
                   player4.guti.yellow4Guti.dice_value = dice_value;
                   player4.guti.yellow4Guti.yellowMove();
                   grid.getChildren().remove(player4.guti.getYellow4());
                   grid.add(player4.guti.getYellow4(), player4.guti.yellow4Guti.gutiColumn, player4.guti.yellow4Guti.gutiRow);
                 yellow1LocationChange = true;
                  yellow2LocationChange = true;
                   yellow3LocationChange = true;
                   yellow4LocationChange = true;
                    guti_location_change = true;
                }
            
            }
           kheye_felse_yellow(player4.guti.getYellow4());   
        });
    }
public void single_player()
    {   
        
        rollDice.setOnMouseClicked(e->
    {
        if(turn==1)
            {
                if(player1.guti.green1Guti.move_start==false && player1.guti.green2Guti.move_start==false && player1.guti.green3Guti.move_start==false && player1.guti.green4Guti.move_start==false)
            {
                guti_location_change = true;
            }
                if((player1.guti.green1Guti.move_start==false && player1.guti.green2Guti.move_start==false && player1.guti.green3Guti.move_start==false && player1.guti.green4Guti.move_start==false) && dice_value==6)
                {
                    guti_location_change = false;
                }
                
            }
        
        else if(turn==2)
            {
                if(player2.guti.red1Guti.move_start==false && player2.guti.red2Guti.move_start==false && player2.guti.red3Guti.move_start==false && player2.guti.red4Guti.move_start==false)
            {
                guti_location_change = true;
            }
               
                if((player2.guti.red1Guti.move_start==false && player2.guti.red2Guti.move_start==false && player2.guti.red3Guti.move_start==false && player2.guti.red4Guti.move_start==false) && dice_value==6)
                {
                    guti_location_change = false;
                }
                
            }
        else if(turn==3)
            {
                if(player3.guti.blue1Guti.move_start==false && player3.guti.blue2Guti.move_start==false && player3.guti.blue3Guti.move_start==false && player3.guti.blue4Guti.move_start==false)
            {
                guti_location_change = true;
            }
                
                if((player3.guti.blue1Guti.move_start==false && player3.guti.blue2Guti.move_start==false && player3.guti.blue3Guti.move_start==false && player3.guti.blue4Guti.move_start==false) && dice_value==6)
                {
                    guti_location_change = false;
                }
                
            }
        else if(turn==4)
            {
                if(player4.guti.yellow1Guti.move_start==false && player4.guti.yellow2Guti.move_start==false && player4.guti.yellow3Guti.move_start==false && player4.guti.yellow4Guti.move_start==false)
            {
                guti_location_change = true;
            }
                
                if((player4.guti.yellow1Guti.move_start==false && player4.guti.yellow2Guti.move_start==false && player4.guti.yellow3Guti.move_start==false && player4.guti.yellow4Guti.move_start==false) && dice_value==6)
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
        if(dice_value!=6) turn++;
        if(FXMLDocumentController.playerCount==2)
        {
            
            if(turn>2) turn = 1;
        }
        else if(FXMLDocumentController.playerCount==3)
        {
             
            if(turn>3) turn = 1;
        }
        else if(FXMLDocumentController.playerCount==4)
        {     
            if(turn>4) turn = 1;
        }
        
        
        whoseMove.setText(" Player "+turn+"'s Move");
        
        if (turn==player_id) {player1.Dice();dice_value = player1.getDice();}
        
        else { 
            
            try {
                while(true){
                String temp = null;
                client.send("dice");
                temp = client.receive();
                dice_value = Integer.parseInt(temp);
                if(!temp.equals(null)) break;
                }    
            } catch (IOException ex) {
                
                Logger.getLogger(LUDOController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        

        
        green1LocationChange = false;
        green2LocationChange = false;
        green3LocationChange = false;
        green4LocationChange = false;
        red1LocationChange = false;
        red2LocationChange = false;
        red3LocationChange = false;
        red4LocationChange = false;
        blue1LocationChange = false;
        blue2LocationChange = false;
        blue3LocationChange = false;
        blue4LocationChange = false;
        yellow1LocationChange = false;
        yellow2LocationChange = false;
        yellow3LocationChange = false;
        yellow4LocationChange = false;
        
        diceRollAnimationForward();
        diceRollAnimationBackward();
        }
        guti_location_change = false;
    });
      
        }
    
public void kheye_felse_green(ImageView img)
{
    if(grid.getRowIndex(player2.guti.getRed1())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed1());
        gridRed.add(player2.guti.getRed1(), 1, 0);
        player2.guti.red1Guti.move_start=false;
        player2.guti.red1Guti.gutiRow = 1;
        player2.guti.red1Guti.gutiColumn = 8;
        
    }
    else if(grid.getRowIndex(player2.guti.getRed2())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed2());
        gridRed.add(player2.guti.getRed2(), 2, 1);
        player2.guti.red2Guti.move_start=false;
        player2.guti.red2Guti.gutiRow = 1;
        player2.guti.red2Guti.gutiColumn = 8;
       
    }
    else if(grid.getRowIndex(player2.guti.getRed3())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed3());
        gridRed.add(player2.guti.getRed3(), 1, 2);
        player2.guti.red3Guti.move_start=false;
        player2.guti.red3Guti.gutiRow = 1;
        player2.guti.red3Guti.gutiColumn = 8;
      
    }
    else if(grid.getRowIndex(player2.guti.getRed4())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed4());
        gridRed.add(player2.guti.getRed4(), 0, 1);
        player2.guti.red4Guti.move_start=false;
        player2.guti.red4Guti.gutiRow = 1;
        player2.guti.red4Guti.gutiColumn = 8;
      
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue1())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue1());
        gridBlue.add(player3.guti.getBlue1(), 1, 0);
        player3.guti.blue1Guti.move_start=false;
        player3.guti.blue1Guti.gutiRow = 8;
        player3.guti.blue1Guti.gutiColumn = 13;
        
    }
    else if(grid.getRowIndex(player3.guti.getBlue2())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue2());
        gridBlue.add(player3.guti.getBlue2(), 2, 1);
        player3.guti.blue2Guti.move_start=false;
        player3.guti.blue2Guti.gutiRow = 8;
        player3.guti.blue2Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue3())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue3());
        gridBlue.add(player3.guti.getBlue3(), 1, 2);
        player3.guti.blue3Guti.move_start=false;
        player3.guti.blue3Guti.gutiRow = 8;
        player3.guti.blue3Guti.gutiColumn = 13;
        
    }
    else if(grid.getRowIndex(player3.guti.getBlue4())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue4());
        gridBlue.add(player3.guti.getBlue4(), 0, 1);
        player3.guti.blue4Guti.move_start=false;
        player3.guti.blue4Guti.gutiRow = 8;
        player3.guti.blue4Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player4.guti.getYellow1())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow1());
        gridYellow.add(player4.guti.getYellow1(), 1, 0);
        player4.guti.yellow1Guti.move_start=false;
        player4.guti.yellow1Guti.gutiRow = 13;
        player4.guti.yellow1Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow2())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow2());
        gridYellow.add(player4.guti.getYellow2(), 2, 1);
        player4.guti.yellow2Guti.move_start=false;
        player4.guti.yellow2Guti.gutiRow = 13;
        player4.guti.yellow2Guti.gutiColumn = 6;
        
    }
    
    else if(grid.getRowIndex(player4.guti.getYellow3())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow3());
        gridYellow.add(player4.guti.getYellow3(), 1, 2);
        player4.guti.yellow3Guti.move_start=false;
        player4.guti.yellow3Guti.gutiRow = 13;
        player4.guti.yellow3Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow4())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow4());
        gridYellow.add(player4.guti.getYellow4(), 0, 1);
        player4.guti.yellow4Guti.move_start=false;
        player4.guti.yellow4Guti.gutiRow = 13;
        player4.guti.yellow4Guti.gutiColumn = 6;
        
    }
    
    
}

public void kheye_felse_red(ImageView img)
{
    if(grid.getRowIndex(player3.guti.getBlue1())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue1());
        gridBlue.add(player3.guti.getBlue1(), 1, 0);
        player3.guti.blue1Guti.move_start=false;
        player3.guti.blue1Guti.gutiRow = 8;
        player3.guti.blue1Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue2())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue2());
        gridBlue.add(player3.guti.getBlue2(), 2, 1);
        player3.guti.blue2Guti.move_start=false;
        player3.guti.blue2Guti.gutiRow = 8;
        player3.guti.blue2Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue3())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue3());
        gridBlue.add(player3.guti.getBlue3(), 1, 2);
        player3.guti.blue3Guti.move_start=false;
        player3.guti.blue3Guti.gutiRow = 8;
        player3.guti.blue3Guti.gutiColumn = 13;
        
    }
    else if(grid.getRowIndex(player3.guti.getBlue4())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue4());
        gridBlue.add(player3.guti.getBlue4(), 0, 1);
        player3.guti.blue4Guti.move_start=false;
        player3.guti.blue4Guti.gutiRow = 8;
        player3.guti.blue4Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player4.guti.getYellow1())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow1());
        gridYellow.add(player4.guti.getYellow1(), 1, 0);
        player4.guti.yellow1Guti.move_start=false;
        player4.guti.yellow1Guti.gutiRow = 13;
        player4.guti.yellow1Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow2())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow2());
        gridYellow.add(player4.guti.getYellow2(), 2, 1);
        player4.guti.yellow2Guti.move_start=false;
        player4.guti.yellow2Guti.gutiRow = 13;
        player4.guti.yellow2Guti.gutiColumn = 6;
        
    }
    
    else if(grid.getRowIndex(player4.guti.getYellow3())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow3());
        gridYellow.add(player4.guti.getYellow3(), 1, 2);
        player4.guti.yellow3Guti.move_start=false;
        player4.guti.yellow3Guti.gutiRow = 13;
        player4.guti.yellow3Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow4())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow4());
        gridYellow.add(player4.guti.getYellow4(), 0, 1);
        player4.guti.yellow4Guti.move_start=false;
        player4.guti.yellow4Guti.gutiRow = 13;
        player4.guti.yellow4Guti.gutiColumn = 6;
        
    }
    
    else if(grid.getRowIndex(player1.guti.getGreen1())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen1());
        gridGreen.add(player1.guti.getGreen1(), 1, 0);
        player1.guti.green1Guti.move_start=false;
        player1.guti.green1Guti.gutiRow = 6;
        player1.guti.green1Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen2())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen2());
        gridGreen.add(player1.guti.getGreen2(), 2, 1);
        player1.guti.green2Guti.move_start=false;
        player1.guti.green2Guti.gutiRow = 6;
        player1.guti.green2Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen3())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen3());
        gridGreen.add(player1.guti.getGreen3(), 1, 2);
        player1.guti.green3Guti.move_start=false;
        player1.guti.green3Guti.gutiRow = 6;
        player1.guti.green3Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen4())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen4());
        gridGreen.add(player1.guti.getGreen4(), 0, 1);
        player1.guti.green4Guti.move_start=false;
        player1.guti.green4Guti.gutiRow = 6;
        player1.guti.green4Guti.gutiColumn = 1;
        
    }
    
}

public void kheye_felse_blue(ImageView img)
{
    if(grid.getRowIndex(player4.guti.getYellow1())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow1());
        gridYellow.add(player4.guti.getYellow1(), 1, 0);
        player4.guti.yellow1Guti.move_start=false;
        player4.guti.yellow1Guti.gutiRow = 13;
        player4.guti.yellow1Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow2())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow2());
        gridYellow.add(player4.guti.getYellow2(), 2, 1);
        player4.guti.yellow2Guti.move_start=false;
        player4.guti.yellow2Guti.gutiRow = 13;
        player4.guti.yellow2Guti.gutiColumn = 6;
        
    }
    
    else if(grid.getRowIndex(player4.guti.getYellow3())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow3());
        gridYellow.add(player4.guti.getYellow3(), 1, 2);
        player4.guti.yellow3Guti.move_start=false;
        player4.guti.yellow3Guti.gutiRow = 13;
        player4.guti.yellow3Guti.gutiColumn = 6;
        
    }
    else if(grid.getRowIndex(player4.guti.getYellow4())==grid.getRowIndex(img) && grid.getColumnIndex(player4.guti.getYellow4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player4.guti.getYellow4());
        gridYellow.add(player4.guti.getYellow4(), 0, 1);
        player4.guti.yellow4Guti.move_start=false;
        player4.guti.yellow4Guti.gutiRow = 13;
        player4.guti.yellow4Guti.gutiColumn = 6;
        
    }
    
    else if(grid.getRowIndex(player1.guti.getGreen1())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen1());
        gridGreen.add(player1.guti.getGreen1(), 1, 0);
        player1.guti.green1Guti.move_start=false;
        player1.guti.green1Guti.gutiRow = 6;
        player1.guti.green1Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen2())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen2());
        gridGreen.add(player1.guti.getGreen2(), 2, 1);
        player1.guti.green2Guti.move_start=false;
        player1.guti.green2Guti.gutiRow = 6;
        player1.guti.green2Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen3())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen3());
        gridGreen.add(player1.guti.getGreen3(), 1, 2);
        player1.guti.green3Guti.move_start=false;
        player1.guti.green3Guti.gutiRow = 6;
        player1.guti.green3Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen4())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen4());
        gridGreen.add(player1.guti.getGreen4(), 0, 1);
        player1.guti.green4Guti.move_start=false;
        player1.guti.green4Guti.gutiRow = 6;
        player1.guti.green4Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player2.guti.getRed1())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed1());
        gridRed.add(player2.guti.getRed1(), 1, 0);
        player2.guti.red1Guti.move_start=false;
        player2.guti.red1Guti.gutiRow = 1;
        player2.guti.red1Guti.gutiColumn = 8;
        
    }
    else if(grid.getRowIndex(player2.guti.getRed2())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed2());
        gridRed.add(player2.guti.getRed2(), 2, 1);
        player2.guti.red2Guti.move_start=false;
        player2.guti.red2Guti.gutiRow = 1;
        player2.guti.red2Guti.gutiColumn = 8;
       
    }
    else if(grid.getRowIndex(player2.guti.getRed3())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed3());
        gridRed.add(player2.guti.getRed3(), 1, 2);
        player2.guti.red3Guti.move_start=false;
        player2.guti.red3Guti.gutiRow = 1;
        player2.guti.red3Guti.gutiColumn = 8;
      
    }
    else if(grid.getRowIndex(player2.guti.getRed4())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed4());
        gridRed.add(player2.guti.getRed4(), 0, 1);
        player2.guti.red4Guti.move_start=false;
        player2.guti.red4Guti.gutiRow = 1;
        player2.guti.red4Guti.gutiColumn = 8;
      
    }
}

public void kheye_felse_yellow(ImageView img)
{
    if(grid.getRowIndex(player1.guti.getGreen1())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen1());
        gridGreen.add(player1.guti.getGreen1(), 1, 0);
        player1.guti.green1Guti.move_start=false;
        player1.guti.green1Guti.gutiRow = 6;
        player1.guti.green1Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen2())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen2());
        gridGreen.add(player1.guti.getGreen2(), 2, 1);
        player1.guti.green2Guti.move_start=false;
        player1.guti.green2Guti.gutiRow = 6;
        player1.guti.green2Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen3())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen3());
        gridGreen.add(player1.guti.getGreen3(), 1, 2);
        player1.guti.green3Guti.move_start=false;
        player1.guti.green3Guti.gutiRow = 6;
        player1.guti.green3Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player1.guti.getGreen4())==grid.getRowIndex(img) && grid.getColumnIndex(player1.guti.getGreen4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player1.guti.getGreen4());
        gridGreen.add(player1.guti.getGreen4(), 0, 1);
        player1.guti.green4Guti.move_start=false;
        player1.guti.green4Guti.gutiRow = 6;
        player1.guti.green4Guti.gutiColumn = 1;
        
    }
    else if(grid.getRowIndex(player2.guti.getRed1())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed1());
        gridRed.add(player2.guti.getRed1(), 1, 0);
        player2.guti.red1Guti.move_start=false;
        player2.guti.red1Guti.gutiRow = 1;
        player2.guti.red1Guti.gutiColumn = 8;
        
    }
    else if(grid.getRowIndex(player2.guti.getRed2())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed2());
        gridRed.add(player2.guti.getRed2(), 2, 1);
        player2.guti.red2Guti.move_start=false;
        player2.guti.red2Guti.gutiRow = 1;
        player2.guti.red2Guti.gutiColumn = 8;
       
    }
    else if(grid.getRowIndex(player2.guti.getRed3())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed3());
        gridRed.add(player2.guti.getRed3(), 1, 2);
        player2.guti.red3Guti.move_start=false;
        player2.guti.red3Guti.gutiRow = 1;
        player2.guti.red3Guti.gutiColumn = 8;
      
    }
    else if(grid.getRowIndex(player2.guti.getRed4())==grid.getRowIndex(img) && grid.getColumnIndex(player2.guti.getRed4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player2.guti.getRed4());
        gridRed.add(player2.guti.getRed4(), 0, 1);
        player2.guti.red4Guti.move_start=false;
        player2.guti.red4Guti.gutiRow = 1;
        player2.guti.red4Guti.gutiColumn = 8;
      
    }
    else if(grid.getRowIndex(player3.guti.getBlue1())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue1())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue1());
        gridBlue.add(player3.guti.getBlue1(), 1, 0);
        player3.guti.blue1Guti.move_start=false;
        player3.guti.blue1Guti.gutiRow = 8;
        player3.guti.blue1Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue2())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue2())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue2());
        gridBlue.add(player3.guti.getBlue2(), 2, 1);
        player3.guti.blue2Guti.move_start=false;
        player3.guti.blue2Guti.gutiRow = 8;
        player3.guti.blue2Guti.gutiColumn = 13;
        
    }
    
    else if(grid.getRowIndex(player3.guti.getBlue3())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue3())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue3());
        gridBlue.add(player3.guti.getBlue3(), 1, 2);
        player3.guti.blue3Guti.move_start=false;
        player3.guti.blue3Guti.gutiRow = 8;
        player3.guti.blue3Guti.gutiColumn = 13;
        
    }
    else if(grid.getRowIndex(player3.guti.getBlue4())==grid.getRowIndex(img) && grid.getColumnIndex(player3.guti.getBlue4())==grid.getColumnIndex(img))
    {
        grid.getChildren().remove(player3.guti.getBlue4());
        gridBlue.add(player3.guti.getBlue4(), 0, 1);
        player3.guti.blue4Guti.move_start=false;
        player3.guti.blue4Guti.gutiRow = 8;
        player3.guti.blue4Guti.gutiColumn = 13;
        
    }
    
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




