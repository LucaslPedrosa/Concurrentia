/*
 *  @author: Lucas Pedrosa Larangeira
 * 
 * 
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
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainController implements Initializable{

  /*
   *  The MainController class is responsable to
   *  make everything on the main menu game works, it will
   *  change the main menu screen to the other 3 options
   *  {game,tutorial,game secret}
   * 
   *  and should be able to manage the music audio and mute it
   *  (if your pc supports it)
   *  
   * 
   *
   *  
   */

  @FXML
  private Button buttonPlay;  //Go to game screen

  @FXML
  private Button buttonHowToPlay; //Go to how to play screen

  @FXML
  private Button buttonGameSecrets; // Go to game secrets screen

  @FXML
  private Button buttonVolume;  // Mute / unmute the music
  
  @FXML
  private ImageView imageFromButtonVolume;  //Image displayed on the @buttonVolume button

  @FXML
  private Slider sliderVolume;  //Change the audio by sliding

  private Stage stage;  // Used to change screens
  private Scene scene;  // Used to change screens
  private Parent root;  // Used to change screens

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    /*
     *  This initialize method will do the tricks
     * 
     *  all buttons will be here, nothing else
     * 
     */



    /*
     *  buttonVolume.setOnAction will get the value (double) from the slider
     *  and use it to know the volume.
     *  
     *  If the volume is equal to 0, then the button should unmute since its
     *  already muted
     *  The inverse also exists
     *  
     *  Also besides changing the music volume, it should change the 
     *  @imageFromButtonVolume to a muted version or unmuted one
     * 
     */
    
    buttonVolume.setOnAction(Event -> {
      double volume = sliderVolume.getValue();
      if(volume == 0){
        imageFromButtonVolume.setImage(new Image("img/MainMenu/volume.png"));
        volume = 100;
        sliderVolume.setValue(volume);
      }else
      {
        imageFromButtonVolume.setImage(new Image("img/MainMenu/mute.png"));
        volume = 0;
        sliderVolume.setValue(volume);
      }
      Music.setVolume(volume);
    });


    /*
     *  This slider as previosly mentioned should get 
     *  his own value and use it to call from Music class the
     *  set volume method every time he dettecs a mouse drag
     * 
     */

    sliderVolume.setOnMouseDragged(Event -> {
      double volume = sliderVolume.getValue();

      if(volume == 0){
        imageFromButtonVolume.setImage(new Image("img/MainMenu/mute.png"));
      }else
      {
        imageFromButtonVolume.setImage(new Image("img/MainMenu/volume.png"));
      }
      System.out.println(volume);
      Music.setVolume(volume);
    });


    /*
     *  buttonPlay should change the application screen to the game
     *  screen by calling {@link #switchToGame event} function
     * 
     */

    buttonPlay.setOnAction(event -> {
      try{
        switchToGame(event);

      }catch(Exception e){
        System.out.println(e.getMessage());
      }

    });

    /*
     *  buttonHowToPlay should change the application screen to the game
     *  screen by calling {@link #switchToTutorial event} function
     * 
     */

    buttonHowToPlay.setOnAction(event -> {
      try{
        switchToTutorial(event);
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
    });

    /*
     *  buttonGameSecrets should change the application screen to the game
     *  screen by calling {@link #switchToGameSecrets event} function
     * 
     */

    buttonGameSecrets.setOnAction(event -> {
      try{
        switchToGameSecrets(event);
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    });

  }

  /*
   *  Down there are placed the methods
   * 
   * 
   */


  /*
   *  switchToGame method loads the game_view.fxml from /view/
   *  and use it to change the screen
   */

  public void switchToGame(ActionEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game_view.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /*
   *  switchToTutorial method loads the howToPlay_view.fxml from /view/
   *  and use it to change the screen
   */

  public void switchToTutorial(ActionEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/howToPlay_view.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  } 

  /*
   *  switchToGameSecrets method loads the gameSecret_view.fxml from /view/
   *  and use it to change the screen
   */
  public void switchToGameSecrets(ActionEvent event)throws IOException{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gameSecret_view.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
}
