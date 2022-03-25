/**
 * @Author : Lucas Pedrosa Larangeira
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
import javafx.stage.Stage;
import controller.MainController;
import model.T1Thread;
import model.TrainThread;


public class Principal extends Application{
  public static void main(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    
    Parent root = loader.load();
    
    Scene scene = new Scene(root);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Problema do Trem!");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }//fim metodo start

}