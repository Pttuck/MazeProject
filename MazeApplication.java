//The purpose of this code is to 
//Author Patrick TUcker
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.stage.*;

public class MazeApplication extends Application
{
   KeyCode pressed; 
   MazeCanvas mc = new MazeCanvas();
   
   public void start(Stage stage) //The stage that everything is drawn on
   {
      FlowPane root = new FlowPane(); //Create a flow pane
      root.getChildren().add(mc);
      Scene scene = new Scene(root, 525, 525); //The scene the pane is created in
      stage.setTitle("Maze Game");
      stage.setScene(scene);
      stage.show();
      mc.requestFocus();
      
      root.setOnKeyPressed(new KeyListenerDown());
      
    }

   
   public static void main(String[] args)
   {
      launch(args);
   }
   public class KeyListenerDown implements EventHandler<KeyEvent>  //The class to pause with A and play with S
   {
      public void handle(KeyEvent event) 
      {
         pressed = event.getCode();
         mc.moveBox(pressed);
      }
   }   

}