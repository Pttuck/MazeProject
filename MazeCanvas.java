//The purpose of this code is to create a square and circle based of a file read in

//Patrick Tucker

//imports
import java.util.*;
import java.io.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

//canvas
public class MazeCanvas extends Canvas
{
   //init variables
   String fileName;
   int mazeArray[][] = new int[21][21]; 
   GraphicsContext gc = getGraphicsContext2D();
   
   int posX;
   int posY = 0;
   
   KeyCode pressed;
   int checkY, checkX;

   //constructor
   public MazeCanvas() //The canvas class that takes in file 
   {  
      //set width and height
      super(525,525);
     
      //try and catch
      try
      {  
         //scanner 
         Scanner scan = new Scanner(new File("MazeData.txt"));      
    
          for(int j = 0; j < 21; j++) //For loop to create the board setup
          {   
             for(int i = 0; i < 21; i++)
             {
               int number = scan.nextInt();
               mazeArray[i][j] = number;
             }	
          }
      }
       
      catch(FileNotFoundException FNFE)
      {
         System.out.println("File not found");
      }
            draw(gc);
   }
   
   public void draw(GraphicsContext gc) //Draw class to set up the canvas and draw the shapes with jors etc...
   {
      for(int i = 0; i < 21; i++)
      {  
         for(int j = 0; j < 21; j++)
         {
               if (mazeArray[i][j] == 0)
               {
                  gc.setFill(Color.WHITE);
               }                                            
               if (mazeArray[i][j] == 1)
               {
                  gc.setFill(Color.BLACK);
               }      
               gc.fillRect(i*25, j*25, 25, 25);
         }
      }
      
      for(int i = 0; i < 21; i++)
      {
           if(mazeArray[i][0]==0)
           {
              posX = i*25;
           }              
      }
        
      gc.setFill(Color.CYAN);
      gc.fillRect(posX, 0, 25, 25);
              
   }          
   public void moveBox(KeyCode pressed)
   {
         this.pressed=pressed;
         
         gc.setFill(Color.CYAN);
         gc.clearRect(posX, posY, 25, 25);
         
         checkY = posY/25;
         checkX = posX/25;
         
         if (pressed == KeyCode.UP)  //Move player up
         {  
            if (posY > 0)
            {
               if (mazeArray[checkX][(checkY)-(1)] == 0)
               {
               posY = posY - 25;
               }
            }   
         }
        
         if (pressed == KeyCode.DOWN) //Move player down
         {  
            if (posY < 500)
            {
               if (mazeArray[checkX][(checkY)+(1)] == 0)
               {
               posY = posY + 25;
               }
            }   
         } 
         
         if (pressed == KeyCode.LEFT) //Move player left
         {  
             if (posX > 0)
             {
                if (mazeArray[(checkX)-(1)][(checkY)] == 0)
                {
                posX = posX - 25;
                }
             }   
         } 
         
         if (pressed == KeyCode.RIGHT) //Move player right
         {   
             if (posX < 500)
             {
                if (mazeArray[(checkX)+(1)][(checkY)] == 0)
                {
                posX = posX + 25;
                }
             }  
         }
     
         gc.setFill(Color.CYAN);
         gc.fillRect(posX, posY, 25, 25);
         
        if (posY/25 == 20)
        { 
           if (mazeArray[checkX][checkY] == 0)
           {
           System.out.println("You Win");
           }
        }          
   }  
}   
  