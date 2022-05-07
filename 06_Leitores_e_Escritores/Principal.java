/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment :
 *  Created:
 *  last change at :
 *  Name: Principal.java
 * 
 *  
 *  Principal.java class is the main class from the producer/ consumer problem
 *  application, it should be used
 *  to extend the Application method and use it to launch javaFX
 *  application
 * 
 *
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Principal extends Application{
  public static void main(String[] args){
    launch(args);
  }

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

  @Override
  public void start(Stage primaryStage) throws Exception {
    try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    
    Parent root = loader.load();
    
    Scene scene = new Scene(root);
    primaryStage.getIcons().add(new Image("img/icon.png"));
    primaryStage.setResizable(false);
    primaryStage.setTitle("Leitores e Escritores");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();

    }catch(Exception e){
      System.out.println("Doidera");
    }
  }

}