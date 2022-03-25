package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.T1Thread;
import model.T2Thread;

public class MainController implements Initializable{
  
  @FXML
  private ImageView t1;
  @FXML
  private ImageView t2;

  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    T1Thread train1 = new T1Thread(this,t1);
    T2Thread train2 = new T2Thread(this,t2);
    train1.start();
    train2.start();
  }



  /** Gets & sets */
  public ImageView getT1(){
    return this.t1;
  }



}
