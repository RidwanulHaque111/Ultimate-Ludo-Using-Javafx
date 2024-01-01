/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeLadder;

import static java.lang.Math.abs;

/**
 *
 * @author asus
 */
public class Move {
    
    public int gutiColumn,gutiRow,dice_value;
    public boolean move_start = false;
    private boolean roundComplete;
    public Move(int gutiColumn,int gutiRow)
    {
        this.gutiColumn = gutiColumn;
        this.gutiRow = gutiRow;
    }
    
    public Move()
    {
      
    }
    
    public void move()
    {
        if(gutiRow==9 && gutiColumn>=0 && (gutiColumn+dice_value)<=9)
        {
            gutiRow = 9;
            gutiColumn +=dice_value;
        }
        else if(gutiRow==9 && gutiColumn>0 && (gutiColumn+dice_value)>9)
        {   
            int temp;
            temp = 9-gutiColumn;
            gutiColumn = 9;           
            gutiRow = 8;
            gutiColumn -= dice_value-temp-1;
        }
        else if(gutiRow==8 && (gutiColumn-dice_value)>=0)
        {
         gutiColumn -=dice_value;   
        }
        else if(gutiRow==8 && (gutiColumn-dice_value)<0)
        {
         int temp;
         temp = gutiColumn;
         gutiColumn = 0;
         gutiRow = 7;
         gutiColumn += abs(dice_value - temp)-1;
        }
        else if(gutiRow==7 && gutiColumn>=0 && (gutiColumn+dice_value)<=9)
        {
            gutiColumn +=dice_value;
        }
        else if(gutiRow==7 && gutiColumn>0 && (gutiColumn+dice_value)>9)
        {   
            int temp;
            temp = 9-gutiColumn;
            gutiColumn = 9;
            
            gutiRow = 6;
            gutiColumn -= dice_value-temp-1;
        }
        else if(gutiRow==6 && (gutiColumn-dice_value)>=0)
        {
         gutiColumn -=dice_value;   
        }
        else if(gutiRow==6 && (gutiColumn-dice_value)<0)
        {
         int temp;
         temp = gutiColumn;
         gutiColumn = 0; 
         gutiRow = 5;
         gutiColumn += abs(dice_value - temp)-1;
        }
        else if(gutiRow==5 && gutiColumn>=0 && (gutiColumn+dice_value)<=9)
        {
            gutiColumn +=dice_value;
        }
        else if(gutiRow==5 && gutiColumn>0 && (gutiColumn+dice_value)>9)
        {   
            int temp;
            temp = 9-gutiColumn;
            gutiColumn = 9;           
            gutiRow = 4;
            gutiColumn -= dice_value-temp-1;
        }
        else if(gutiRow==4 && (gutiColumn-dice_value)>=0)
        {
         gutiColumn -=dice_value;   
        }
        else if(gutiRow==4 && (gutiColumn-dice_value)<0)
        {
         int temp;
         temp = gutiColumn;
         gutiColumn = 0;
         gutiRow = 3;
         gutiColumn += abs(dice_value - temp)-1;
        }
        else if(gutiRow==3 && gutiColumn>=0 && (gutiColumn+dice_value)<=9)
        {
            gutiColumn +=dice_value;
        }
        else if(gutiRow==3 && gutiColumn>0 && (gutiColumn+dice_value)>9)
        {   
            int temp;
            temp = 9-gutiColumn;
            gutiColumn = 9;
            gutiRow = 2;
            gutiColumn -= dice_value-temp-1;
        }
        else if(gutiRow==2 && (gutiColumn-dice_value)>=0)
        {
         gutiColumn -=dice_value;   
        }
        else if(gutiRow==2 && (gutiColumn-dice_value)<0)
        {
         int temp;
         temp = gutiColumn;
         gutiColumn = 0;
         
         gutiRow = 1;
         gutiColumn += abs(dice_value - temp)-1;
        }
        
        else if(gutiRow==1 && gutiColumn>=0 && (gutiColumn+dice_value)<=9)
        {
            gutiColumn +=dice_value;
        }
        else if(gutiRow==1 && gutiColumn>0 && (gutiColumn+dice_value)>9)
        {   
            int temp;
            temp = 9-gutiColumn;
            gutiColumn = 9;
            gutiRow = 0;
            gutiColumn -= dice_value-temp-1;
        }
        else if(gutiRow==0 && (gutiColumn-dice_value)>0)
        {
         gutiColumn -=dice_value;   
        }
        
        else if(gutiRow==0 && (gutiColumn-dice_value)==0)
        {
         gutiColumn -=dice_value; 
         roundComplete = true;
        }
 
    
        
    }
    
    public boolean isComplete()
    {
        return roundComplete;
    }
    
}
