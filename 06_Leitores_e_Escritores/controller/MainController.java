package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Writer;

public class MainController implements Initializable{
  
  @FXML
  private ImageView escritor1Img;

  @FXML
  private ImageView escritor3Img;

  @FXML
  private ImageView escritor2Img;

  @FXML
  private ImageView leitor1Img;

  @FXML
  private ImageView leitor2Img;

  @FXML
  private ImageView leitor3Img;

  @FXML
  private Label serverStatus;

  @FXML
  private Label escritor1Status;

  @FXML
  private Label escritor2Status;

  @FXML
  private Label escritor3Status;

  @FXML
  private Label leitor1Status;

  @FXML
  private Label leitor2Status;

  @FXML
  private Label leitor3Status;
  

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setUpWriters();

    
  }

  public void setUpWriters(){
    Writer writers[] = new Writer[3];
    writers[0] = new Writer(escritor1Img, leitor1Status, "So sei que nada assei", serverStatus);
    writers[1] = new Writer(escritor2Img, leitor2Status, "So sei que nao dancei", serverStatus);
    writers[2] = new Writer(escritor3Img, leitor3Status, "So sei que nada sei", serverStatus);

    writers[0].start();
    writers[1].start();
    writers[2].start();
  }
  
}
