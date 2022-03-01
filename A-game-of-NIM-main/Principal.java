
/********************************************************************
* Author: Lucas Pedrosa Larangeira
* Registration: 202011430
* Start: 05/01/2022 23:25:00
* Last change: 02/01/2022
* Name: Principal.java
* Function: Principal class of my game of NIM in java
********************************************************************/

/*  Some imports have a warning about not being used, but are necessary
 *  To generate the .class files used by the program, dont remove anything
 * 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;
import controller.Music;
import controller.MainController;
import controller.TutorialController;
import controller.GameSecret;
import controller.Game;


public class Principal extends Application{

  /*  The principal class will handle the lauch of the javaFX
   *  application and the static Music.
   *  For the interface we extended the Application abstract class
   *  and the music used some static methods in Music class
   * 
   *  The Application will: 
   *  Construct a instance of Application class
   *  Calls the Init and start methods
   *  Wait for the Application to finish  
   *  
  */

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Music.musicPlays("util/music.mp3"); //Call the music by its archives
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    Parent root = loader.load(); 
    Scene scene = new Scene(root);


    primaryStage.setTitle("A game of NIM");
    primaryStage.setResizable(false);
    primaryStage.getIcons().add( new Image("img/icon.png") );
    primaryStage.setScene(scene);
    primaryStage.show();
  }


}