/*
 *  @author : Lucas Pedrosa Larangeira
 * 
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;  
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class GameSecret implements Initializable{

  private Stage stage;//Used to get back to main menu
  private Scene scene;//Used to get back to main menu
  private Parent root;//Used to get back to main menu
  @FXML
  private Button buttonVoltar;//Used to get back to main menu

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    /*
     * when buttonVoltar fire, it will try to {@backToMenu : event}
     */
    buttonVoltar.setOnAction(event ->{
      try{
      backToMenu(event);
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    });
    
  }

  /*
   *  backToMenu function loads the /view/main_view.fxml
   *  and change the stage scene to main_view.fxml
  */
  public void backToMenu(ActionEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }





  
}
