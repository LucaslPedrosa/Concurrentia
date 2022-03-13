/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Created : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: Principal.java
 *  Function: Start javaFX application
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import controller.MainController;

public class Principal extends Application{
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    /*
     * This is needed to start the javaFX application
     * 
     * 
     */
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    Parent root = loader.load(); 
    Scene scene = new Scene(root);


    primaryStage.setTitle("Family Tree");
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
}