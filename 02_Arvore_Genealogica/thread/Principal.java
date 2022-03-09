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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    Parent root = loader.load(); 
    Scene scene = new Scene(root);


    primaryStage.setTitle("Family Tree");
    primaryStage.setResizable(false);
    //primaryStage.getIcons().add( new Image("img/icon.png") );
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
}