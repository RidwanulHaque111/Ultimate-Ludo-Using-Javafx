package LUDO;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author asus
 */

public class Guti {
    public Move green1Guti,green2Guti,green3Guti,green4Guti;
    public Move red1Guti,red2Guti,red3Guti,red4Guti;
    public Move blue1Guti,blue2Guti,blue3Guti,blue4Guti;
    public Move yellow1Guti,yellow2Guti,yellow3Guti,yellow4Guti;

    
     private Image greenGuti,redGuti,blueGuti,yellowGuti;
     private ImageView green1,green2,green3,green4;
     private ImageView red1,red2,red3,red4;
     private ImageView blue1,blue2,blue3,blue4;
     private ImageView yellow1,yellow2,yellow3,yellow4;
     
       public Guti()
       {
           green1Guti = new Move();
           green2Guti = new Move();
           green3Guti = new Move();
           green4Guti = new Move();
           
           red1Guti  = new Move();
           red2Guti  = new Move();
           red3Guti  = new Move();
           red4Guti  = new Move();
           
           blue1Guti = new Move();
           blue2Guti = new Move();
           blue3Guti = new Move();
           blue4Guti = new Move();
           
           yellow1Guti = new Move();
           yellow2Guti = new Move();
           yellow3Guti = new Move();
           yellow4Guti = new Move();
       }
     
     public void generatePlayer1()
     {
        greenGuti = new Image("file:greenguti.png");
        
        green1 = new ImageView(greenGuti);
        green1.setPreserveRatio(true);
        green1.setFitHeight(37);
        
        green2 = new ImageView(greenGuti);
        green2.setPreserveRatio(true);
        green2.setFitHeight(37);
        
        green3 = new ImageView(greenGuti);
        green3.setPreserveRatio(true);
        green3.setFitHeight(37);
        
        green4 = new ImageView(greenGuti);
        green4.setPreserveRatio(true);
        green4.setFitHeight(37);
     }
     
     public void generatePlayer2()
     {
        redGuti = new Image("file:redguti.png");
        
        red1 = new ImageView(redGuti);
        red1.setPreserveRatio(true);
        red1.setFitHeight(37);
        
        red2 = new ImageView(redGuti);
        red2.setPreserveRatio(true);
        red2.setFitHeight(37);
        
        red3 = new ImageView(redGuti);
        red3.setPreserveRatio(true);
        red3.setFitHeight(37);
        
        red4 = new ImageView(redGuti);
        red4.setPreserveRatio(true);
        red4.setFitHeight(37);
     }
     
     public void generatePlayer3()
     {
        blueGuti = new Image("file:blueguti.png");
        
        blue1 = new ImageView(blueGuti);
        blue1.setPreserveRatio(true);
        blue1.setFitHeight(37);
        
        blue2 = new ImageView(blueGuti);
        blue2.setPreserveRatio(true);
        blue2.setFitHeight(37);
        
        blue3 = new ImageView(blueGuti);
        blue3.setPreserveRatio(true);
        blue3.setFitHeight(37);
        
        blue4 = new ImageView(blueGuti);
        blue4.setPreserveRatio(true);
        blue4.setFitHeight(37);
     }
     
     public void generatePlayer4()
     {
        yellowGuti = new Image("file:yellowguti.png");
        
        yellow1 = new ImageView(yellowGuti);
        yellow1.setPreserveRatio(true);
        yellow1.setFitHeight(37);
        
        yellow2 = new ImageView(yellowGuti);
        yellow2.setPreserveRatio(true);
        yellow2.setFitHeight(37);
        
        yellow3 = new ImageView(yellowGuti);
        yellow3.setPreserveRatio(true);
        yellow3.setFitHeight(37);
        
        yellow4 = new ImageView(yellowGuti);
        yellow4.setPreserveRatio(true);
        yellow4.setFitHeight(37);
     }
     
     
         public ImageView getGreen1() {
        return green1;
    }

    public ImageView getGreen2() {
        return green2;
    }

    public ImageView getGreen3() {
        return green3;
    }

    public ImageView getGreen4() {
        return green4;
    }

    public ImageView getRed1() {
        return red1;
    }

    public ImageView getRed2() {
        return red2;
    }

    public ImageView getRed3() {
        return red3;
    }

    public ImageView getRed4() {
        return red4;
    }

    public ImageView getBlue1() {
        return blue1;
    }

    public ImageView getBlue2() {
        return blue2;
    }

    public ImageView getBlue3() {
        return blue3;
    }

    public ImageView getBlue4() {
        return blue4;
    }

    public ImageView getYellow1() {
        return yellow1;
    }

    public ImageView getYellow2() {
        return yellow2;
    }

    public ImageView getYellow3() {
        return yellow3;
    }

    public ImageView getYellow4() {
        return yellow4;
    }
     
     
    
     
}
