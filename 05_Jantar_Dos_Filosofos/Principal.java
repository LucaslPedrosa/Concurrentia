/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 13/04/2022
 *  last change at : 10/04/2022 15:24
 *  Name: Principal.java
 * 
 *  
 *  Principal.java class is the main class from the producer/ consumer problem
 *  application, it should be used
 *  to extend the Application method and use it to launch javaFX
 *  application
 * 
 *
 * 
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.MainController;


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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    
    Parent root = loader.load();
    
    Scene scene = new Scene(root);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Problema do Produtor/consumidor");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }

}