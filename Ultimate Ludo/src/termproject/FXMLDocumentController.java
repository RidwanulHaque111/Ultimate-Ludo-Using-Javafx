
package termproject;


import LUDO.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FXMLDocumentController implements Initializable {
   
    @FXML private Button snake;
    @FXML private Button classic;
    @FXML private Button twoplayer;
    @FXML private Button threeplayer;
    @FXML private Button fourplayer;
    @FXML private Button back;
    @FXML private Button quit;

    
    
    //new buttons
    @FXML private Button stwoplayer;
    @FXML private Button sthreeplayer;
    @FXML private Button sfourplayer;
    private int backFlag = 0;
     
    private TranslateTransition move1,move2,move3;
    public static int playerCount=4;
    private static Client client;

    public static Client getClient() {
        return client;
    }
    
  
    @FXML
    public void quitbuttonhandler(ActionEvent e)
    {
        System.exit(0);
    }
    
    @FXML
    public void snakehandlebutton(ActionEvent e)
    {
        backFlag = 1;
        movebuttonout(snake,classic,quit);
        movebuttonin(stwoplayer,sthreeplayer,sfourplayer);
        movebutton(back,-300,1);
    }
    
    @FXML
    public void classichandlebutton(ActionEvent e)
    {
        backFlag = 2;
        movebuttonout(snake,classic,quit);
        movebuttonin(twoplayer,threeplayer,fourplayer);
        movebutton(back,-300,1);
    }
    
    @FXML
    public void backhandlebutton(ActionEvent e)
    {
        if(backFlag==2) movebuttonout(twoplayer,threeplayer,fourplayer);
        else if(backFlag==1) movebuttonout(stwoplayer,sthreeplayer,sfourplayer);
        movebuttonin(snake,classic,quit);
        movebutton(back,300,1);
        backFlag = 0;
    }
    
    //new snake handlers
    //all fx:id and handlers linked with buttons! check scene builder > code > fx:id
    //
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movebutton(snake,900,2);
        movebutton(classic,-900,2);
        movebutton(quit,900,2);
       
    }
    
    public void movebuttonin(Button a, Button b, Button c)
    {
        movebutton(a,-900,0.8);
        movebutton(b,900,0.8);
        movebutton(c,-900,0.8);
    }

    public void movebuttonout(Button a, Button b, Button c)
    {
        movebutton(a,900,0.8);
        movebutton(b,-900,0.8);
        movebutton(c,900,0.8);

    }
    
    public void movebutton(Button b, double n, double dur)
    {
        move1 = new TranslateTransition();
        move1.setDuration(Duration.seconds(dur));
        move1.setNode(b);
        move1.setByX(n);
        move1.play();
        
    }
    
    
    @FXML public void LUDO_START_2(ActionEvent event) throws IOException
    {   
        
       playerCount = 2;      
        Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/LUDO/LUDO.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show(); 
        
        ////////DEBUG SERVER//////////
        
        
        //////////////////////////////////
       
    }
    
    @FXML public void LUDO_START_3(ActionEvent event) throws IOException
    {
         playerCount = 3;
         Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/LUDO/LUDO.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show(); 
    }
    @FXML public void LUDO_START_4(ActionEvent event) throws IOException
    {
         playerCount = 4;
         Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/LUDO/LUDO.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show();  

    }
    //new snake handlers
    //all fx:id and handlers linked with buttons! check scene builder > code > fx:id
    //
    @FXML public void SNAKE_START_2(ActionEvent event) throws IOException
    {
        playerCount = 2;

        Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/SnakeLadder/SnakeLadder.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show();  
    }
    @FXML public void SNAKE_START_3(ActionEvent event) throws IOException
    {
        playerCount = 3;

        Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/SnakeLadder/SnakeLadder.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show();  
    }
    @FXML public void SNAKE_START_4(ActionEvent event) throws IOException
    {
        playerCount = 4;

        Node source = (Node) event.getSource();
        Stage s = (Stage) source.getScene().getWindow();
        s.close();
        Parent root = FXMLLoader.load(getClass().getResource("/SnakeLadder/SnakeLadder.fxml"));
        Scene mainmenuscene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(mainmenuscene);
        stage.show();  
    }
    
    

}


