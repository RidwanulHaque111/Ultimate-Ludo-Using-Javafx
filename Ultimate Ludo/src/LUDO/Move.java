
package LUDO;

import static java.lang.Math.abs;

/**
 *
 * @author asus
 */

public class Move {

    public int gutiColumn,gutiRow,dice_value;
    public boolean move_start = false;
    private boolean roundComplete;

    public boolean isRoundComplete() {
        return roundComplete;
    }
    
    public Move(int gutiColumn,int gutiRow)
    {
        this.gutiColumn = gutiColumn;
        this.gutiRow = gutiRow;
    }
    
    public Move()
    {
      
    }

   
    
    public void greenMove()
    {
        
        if(gutiRow==6 && (gutiColumn+dice_value)<=5 && gutiColumn<6) //11
        {
            gutiColumn +=dice_value;
                    
        }
        
        else if((gutiColumn+dice_value)>5 && (gutiColumn+dice_value)<=11 && gutiRow==6 && gutiColumn<6) //12
        {   
            int barabo;
            barabo = abs(5-gutiColumn);
            
            gutiRow -=dice_value-barabo;
            gutiColumn =6;
                 
        }
        
        else if(gutiColumn==6 && (gutiRow-dice_value)>=0 && gutiRow<=5 && gutiRow>0)  //13
        {
            gutiRow -=dice_value;
           
        }
        
        else if(gutiColumn==6 && gutiRow<=5 && (gutiRow-dice_value)<0)  //14
        {
            int temp,barabo;
            temp = gutiRow - 0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 0;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 0;gutiColumn=8;}
            else if(barabo>2){gutiRow = 0+dice_value-(gutiRow+2);gutiColumn=8;}
          
        }
        
        else if(gutiRow==0 && gutiColumn==7)  //15
        {
            gutiRow = dice_value - 1;
            gutiColumn = 8; 
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)<=5 && gutiRow>=0 && gutiRow<=4) //16
        {
            gutiRow +=dice_value;
               
          
        }
        else if (gutiColumn==8 && (gutiRow+dice_value)>5 && gutiRow>=0 && gutiRow<=5)  //17
        {
            int barabo;
            barabo = abs(5-gutiRow);
            gutiColumn +=abs(dice_value-barabo);
            gutiRow = 6;
        
            
        }
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)<=14)  //18
            
        {
            gutiColumn +=dice_value;
            
         
        }
        
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)>14)  //19
        {
            int temp,barabo;
            temp = 14 - gutiColumn;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=14;}
            else if(barabo==2) {gutiRow = 8;gutiColumn=14;}
            else if(barabo>2){gutiColumn = 14-(dice_value-((14-gutiColumn)+2));gutiRow=8;}
          
        }
        else if(gutiRow==7 && gutiColumn==14)  //20
        {
            gutiRow = 8;
            gutiColumn = 14-(dice_value-1);
          
        }
        else if(gutiColumn<=14 && gutiColumn>=10 && (gutiColumn-dice_value)>=9)  //21
        {
            gutiRow = 8;
            gutiColumn -= dice_value;
          
        }
        
        else if(gutiColumn<=14 && gutiColumn>=9 && (gutiColumn-dice_value)<9)  //22
        {
            int temp,barabo;
            barabo = abs(9-gutiColumn);
            gutiRow +=dice_value-barabo;
            gutiColumn =8;
         
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)>9 && (gutiRow+dice_value)<=14)  //23
        {
            gutiRow +=dice_value;
          
        }
        else if(gutiColumn==8 && gutiRow>=9 && (gutiRow+dice_value)>14)  //24
        {
            int temp,barabo;
            temp = 14 - gutiRow;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 14;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 14;gutiColumn=6;}
            else if(barabo>2){gutiRow = 14-(dice_value-((14-gutiRow)+2));gutiColumn=6;}
           
        }
        else if(gutiRow ==14 && gutiColumn==7) //25
        {
            gutiColumn = 6;
            gutiRow = 14-(dice_value-1);
            
        }
        else if(gutiColumn==6 && (gutiRow-dice_value)>=9 && gutiRow<=14 && gutiRow>9)  //26
        {
            gutiRow -=dice_value;
           
        }
         else if(gutiColumn==6 && (gutiRow-dice_value)<9 && gutiRow<=14 && gutiRow>=9)  //27
        {
            int temp,barabo;
            barabo = abs(9-gutiRow);
            gutiColumn -=dice_value-barabo;
            gutiRow =8;
             
        }
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>0 && (gutiColumn-dice_value)>=0)  //28
         {
             gutiColumn -=dice_value;
             
         }
         
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>=0 && (gutiColumn-dice_value)<0)  //29
         {
            int temp,barabo;
            temp = gutiColumn-0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=0;}
            else if(barabo>1){gutiColumn = 0+(dice_value-((gutiColumn-0)+1));gutiRow=7;}
           
         }
         else if(gutiRow==7 && gutiColumn>=0 && gutiColumn<=5)  //30 Final
         {
             if((gutiColumn+dice_value)<6) 
             {
                gutiColumn +=dice_value;
               
             }
            else if((gutiColumn+dice_value)==6)
            {   
                gutiColumn +=dice_value;
                roundComplete = true;
            }
             
             
         }
           
    }
    public void redMove()
            
    {
        if(gutiRow==6 && (gutiColumn+dice_value)<=5 && gutiColumn<6) //11
        {
            gutiColumn +=dice_value;
                   
        }
        
        else if((gutiColumn+dice_value)>5 && (gutiColumn+dice_value)<=11 && gutiRow==6 && gutiColumn<6) //12
        {   
            int temp,barabo;
            barabo = abs(5-gutiColumn);
            gutiRow -=dice_value-barabo;
            gutiColumn =6;
                  
        }
        
        else if(gutiColumn==6 && (gutiRow-dice_value)>=0 && gutiRow<=5 && gutiRow>0)  //13
        {
            gutiRow -=dice_value;
          
        }
        
        else if(gutiColumn==6 && gutiRow<=5 && (gutiRow-dice_value)<0)  //14
        {
            int temp,barabo;
            temp = gutiRow - 0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 0;gutiColumn=7;}
            else if(barabo>1){gutiRow = 0+dice_value-(gutiRow+1);gutiColumn=7;}
           
        }
        
        else if(gutiRow>=0 && gutiRow<=5 && gutiColumn==7)  //15
        {
            if((gutiRow+dice_value)<6) 
             {
                gutiRow +=dice_value;
               
             }
            else if((gutiRow+dice_value)==6)
            {
                gutiRow +=dice_value;
               roundComplete = true;
            }
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)<=5 && gutiRow>0 && gutiRow<=4) //16
        {
           
            gutiRow +=dice_value;
                  
        }
        
        else if (gutiColumn==8 && (gutiRow+dice_value)>5 && gutiRow>=0 && gutiRow<=5)  //17
        {
            int barabo;
            barabo = abs(5-gutiRow);
            gutiColumn +=abs(dice_value-barabo);
            gutiRow = 6;
            
            
        }
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)<=14)  //18
            
        {
            gutiColumn +=dice_value;
            
          
        }
        
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)>14)  //19
        {
            int temp,barabo;
            temp = 14 - gutiColumn;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=14;}
            else if(barabo==2) {gutiRow = 8;gutiColumn=14;}
            else if(barabo>2){gutiColumn = 14-(dice_value-((14-gutiColumn)+2));gutiRow=8;}
            
        }
        else if(gutiRow==7 && gutiColumn==14)  //20
        {
            gutiRow = 8;
            gutiColumn = 14-(dice_value-1);
           
        }
        else if(gutiColumn<=14 && gutiColumn>=10 && (gutiColumn-dice_value)>=9)  //21
        {
            gutiRow = 8;
            gutiColumn -= dice_value;
           
        }
        
        else if(gutiColumn<=14 && gutiColumn>=9 && (gutiColumn-dice_value)<9)  //22
        {
            int barabo;
            barabo = abs(9-gutiColumn);
            gutiRow +=dice_value-barabo;
            gutiColumn =8;
          
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)>9 && (gutiRow+dice_value)<=14)  //23
        {
            gutiRow +=dice_value;
          
        }
        else if(gutiColumn==8 && gutiRow>=9 && (gutiRow+dice_value)>14)  //24
        {
            int temp,barabo;
            temp = 14 - gutiRow;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 14;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 14;gutiColumn=6;}
            else if(barabo>2){gutiRow = 14-(dice_value-((14-gutiRow)+2));gutiColumn=6;}
            
        }
        else if(gutiRow ==14 && gutiColumn==7) //25
        {
            gutiColumn = 6;
            gutiRow = 14-(dice_value-1);
           
        }
        else if(gutiColumn==6 && (gutiRow-dice_value)>=9 && gutiRow<=14 && gutiRow>9)  //26
        {
            gutiRow -=dice_value;
          
        }
         else if(gutiColumn==6 && (gutiRow-dice_value)<9 && gutiRow<=14 && gutiRow>=9)  //27
        {
            int barabo;
            barabo = abs(9-gutiRow);
            gutiColumn -=dice_value-barabo;
            gutiRow =8;
        
        }
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>0 && (gutiColumn-dice_value)>=0)  //28
         {
             gutiColumn -=dice_value;
            
         }
         
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>=0 && (gutiColumn-dice_value)<0)  //29
         {
            int temp,barabo;
            temp = gutiColumn-0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=0;}
            else if(barabo==2) { gutiRow = 6;gutiColumn=0;}
            else if(barabo>2){gutiColumn = 0+(dice_value-((gutiColumn-0)+2));gutiRow=6;}
            
         }
         else if(gutiRow==7 && gutiColumn==0) //30
         {
            gutiRow = 6;
            gutiColumn = (dice_value-1);
          
         }
        
 
        
    }
    
    public void blueMove()
            
    {
        if(gutiRow==6 && (gutiColumn+dice_value)<=5 && gutiColumn<6) //11
        {
            gutiColumn +=dice_value;
                   
        }
        
        else if((gutiColumn+dice_value)>5 && (gutiColumn+dice_value)<=11 && gutiRow==6 && gutiColumn<6) //12
        {   
            int barabo;
            barabo = abs(5-gutiColumn);
            gutiRow -=dice_value-barabo;
            gutiColumn =6;
              
        }
        
        else if(gutiColumn==6 && (gutiRow-dice_value)>=0 && gutiRow<=5 && gutiRow>0)  //13
        {
            gutiRow -=dice_value;
           
        }
        
        else if(gutiColumn==6 && gutiRow<=5 && (gutiRow-dice_value)<0)  //14
        {
            int temp,barabo;
            temp = gutiRow - 0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 0;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 0;gutiColumn=8;}
            else if(barabo>2){gutiRow = 0+dice_value-(gutiRow+2);gutiColumn=8;}
            
        }
        
        else if(gutiRow==0 && gutiColumn==7)  //15
        {
            gutiRow = dice_value - 1;
            gutiColumn = 8;
           
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)<=5 && gutiRow>=0 && gutiRow<=4) //16
        {
           
            gutiRow +=dice_value;
                  
          
        }
        else if (gutiColumn==8 && (gutiRow+dice_value)>5 && gutiRow>=0 && gutiRow<=5)  //17
        {
            int temp,barabo;
            barabo = abs(5-gutiRow);
            gutiColumn +=abs(dice_value-barabo);
            gutiRow = 6;
           
            
        }
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)<=14)  //18
            
        {
            gutiColumn +=dice_value;
            
           
        }
        
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)>14)  //19
        {
            int temp,barabo;
            temp = 14 - gutiColumn;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=14;}
            else if(barabo>1){gutiColumn = 14-(dice_value-((14-gutiColumn)+1));gutiRow=7;}
           
        }
        else if(gutiRow==7 && gutiColumn<=14 && gutiColumn>=9)  //20
        {
            if((gutiColumn-dice_value)>8) 
             {
                gutiColumn -=dice_value;
               
             }
            else if((gutiColumn-dice_value)==8)
            {
                gutiColumn -= dice_value;
                roundComplete = true;
            } 
        }
        
        else if(gutiColumn<14 && gutiColumn>=10 && (gutiColumn-dice_value)>=9)  //21
        {
            gutiRow = 8;
            gutiColumn -= dice_value;
            
        }
        
        else if(gutiColumn<=14 && gutiColumn>=9 && (gutiColumn-dice_value)<9)  //22
        {
            int temp,barabo;
            barabo = abs(9-gutiColumn);
            gutiRow +=dice_value-barabo;
            gutiColumn =8;
           
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)>9 && (gutiRow+dice_value)<=14)  //23
        {
            gutiRow +=dice_value;
          
        }
        else if(gutiColumn==8 && gutiRow>=9 && (gutiRow+dice_value)>14)  //24
        {
            int temp,barabo;
            temp = 14 - gutiRow;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 14;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 14;gutiColumn=6;}
            else if(barabo>2){gutiRow = 14-(dice_value-((14-gutiRow)+2));gutiColumn=6;}
           
        }
        else if(gutiRow ==14 && gutiColumn==7) //25
        {
            gutiColumn = 6;
            gutiRow = 14-(dice_value-1);
         
        }
        else if(gutiColumn==6 && (gutiRow-dice_value)>=9 && gutiRow<=14 && gutiRow>9)  //26
        {
            gutiRow -=dice_value;
            
        }
         else if(gutiColumn==6 && (gutiRow-dice_value)<9 && gutiRow<=14 && gutiRow>=9)  //27
        {
            int temp,barabo;
            barabo = abs(9-gutiRow);
            gutiColumn -=dice_value-barabo;
            gutiRow =8;
           
        }
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>0 && (gutiColumn-dice_value)>=0)  //28
         {
             gutiColumn -=dice_value;
          
         }
         
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>=0 && (gutiColumn-dice_value)<0)  //29
         {
            int temp,barabo;
            temp = gutiColumn-0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=0;}
            else if(barabo==2) { gutiRow = 6;gutiColumn=0;}
            else if(barabo>2){gutiColumn = 0+(dice_value-((gutiColumn-0)+2));gutiRow=6;}
           
         }
         else if(gutiRow==7 && gutiColumn==0)  //30
         {
            gutiRow = 6;
            gutiColumn = (dice_value-1);
           
         }
       
    }
    
    public void yellowMove()
            
    {
        if(gutiRow==6 && (gutiColumn+dice_value)<=5 && gutiColumn<6) //11
        {
            gutiColumn +=dice_value;
                    
        }
        
        else if((gutiColumn+dice_value)>5 && (gutiColumn+dice_value)<=11 && gutiRow==6 && gutiColumn<6) //12
        {   
            int temp,barabo;
            barabo = abs(5-gutiColumn);
            gutiRow -=dice_value-barabo;
            gutiColumn =6;
                    
        }
        
        else if(gutiColumn==6 && (gutiRow-dice_value)>=0 && gutiRow<=5 && gutiRow>0)  //13
        {
            gutiRow -=dice_value;
            
        }
        
        else if(gutiColumn==6 && gutiRow<=5 && (gutiRow-dice_value)<0)  //14
        {
            int temp,barabo;
            temp = gutiRow - 0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 0;gutiColumn=7;}
            else if(barabo==2) {gutiRow = 0;gutiColumn=8;}
            else if(barabo>2){gutiRow = 0+dice_value-(gutiRow+2);gutiColumn=8;}
             
        }
        
        else if(gutiRow==0 && gutiColumn==7)  //15
        {
            gutiRow = dice_value - 1;
            gutiColumn = 8;
             
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)<=5 && gutiRow>=0 && gutiRow<=4) //16
        {
           
            gutiRow +=dice_value;
                    
          
        }
        else if (gutiColumn==8 && (gutiRow+dice_value)>5 && gutiRow>=0 && gutiRow<=5)  //17
        {
            int temp,barabo;
            barabo = abs(5-gutiRow);
            gutiColumn +=abs(dice_value-barabo);
            gutiRow = 6;
           
            
        }
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)<=14)  //18
            
        {
            gutiColumn +=dice_value;
            
           
        }
        
        else if(gutiRow==6 && (gutiColumn)>8 && (gutiColumn+dice_value)>14)  //19
        {
            int temp,barabo;
            temp = 14 - gutiColumn;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=14;}
            else if(barabo==2) {gutiRow = 8;gutiColumn=14;}
            else if(barabo>2){gutiColumn = 14-(dice_value-((14-gutiColumn)+2));gutiRow=8;}
           
        }
        else if(gutiRow==7 && gutiColumn==14)  //20
        {
            gutiRow = 8;
            gutiColumn = 14-(dice_value-1);
            
        }
        else if(gutiColumn<=14 && gutiColumn>=10 && (gutiColumn-dice_value)>=9)  //21
        {
            gutiRow = 8;
            gutiColumn -= dice_value;
           
        }
        
        else if(gutiColumn<=14 && gutiColumn>=9 && (gutiColumn-dice_value)<9)  //22
        {
            int barabo;
            barabo = abs(9-gutiColumn);
            gutiRow +=dice_value-barabo;
            gutiColumn =8;
           
        }
        else if(gutiColumn==8 && (gutiRow+dice_value)>9 && (gutiRow+dice_value)<=14)  //23
        {
            gutiRow +=dice_value;
           
        }
        else if(gutiColumn==8 && gutiRow>=9 && (gutiRow+dice_value)>14)  //24
        {
            int temp,barabo;
            temp = 14 - gutiRow;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 14;gutiColumn=7;}
            else if(barabo>1){gutiRow = 14-(dice_value-((14-gutiRow)+1));gutiColumn=7;}
           
        }
        else if(gutiRow <=14 && gutiRow>=9 && gutiColumn==7) //25
        {
            if((gutiRow-dice_value)>8) 
             {
                gutiRow -=dice_value;
               
             }
            else if((gutiRow-dice_value)==8)
            {
               gutiRow -= dice_value;
              roundComplete = true;
            }
        }
        else if(gutiColumn==6 && (gutiRow-dice_value)>=9 && gutiRow<14 && gutiRow>9)  //26
        {
            gutiRow -=dice_value;
           
        }
         else if(gutiColumn==6 && (gutiRow-dice_value)<9 && gutiRow<=14 && gutiRow>=9)  //27
        {
            int barabo;
            barabo = abs(9-gutiRow);
            gutiColumn -=dice_value-barabo;
            gutiRow =8;
           
        }
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>0 && (gutiColumn-dice_value)>=0)  //28
         {
             gutiColumn -=dice_value;
             
         }
         
         else if(gutiRow==8 && gutiColumn<=5 && gutiColumn>=0 && (gutiColumn-dice_value)<0)  //29
         {
            int temp,barabo;
            temp = gutiColumn-0;
            barabo = abs(temp-dice_value);
            if(barabo==1) { gutiRow = 7;gutiColumn=0;}
            else if(barabo==2) { gutiRow = 6;gutiColumn=0;}
            else if(barabo>2){gutiColumn = 0+(dice_value-((gutiColumn-0)+2));gutiRow=6;}
         
         }
           
    }
    
    public int getGutiColumn() {
        return gutiColumn;
    }

    public int getGutiRow() {
        return gutiRow;
    }
    
    
    
}
