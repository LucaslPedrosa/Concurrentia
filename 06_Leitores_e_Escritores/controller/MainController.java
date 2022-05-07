package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.Writer;
import model.Reader;

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

  @FXML
  private Slider escritor1Slider;

  @FXML
  private Slider escritor2Slider;

  @FXML
  private Slider escritor3Slider;

  @FXML
  private Slider leitor1Slider;

  @FXML
  private Slider leitor2Slider;

  @FXML
  private Slider leitor3Slider;

  Writer writers[] = new Writer[3];
  Reader readers[] = new Reader[3];


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setUpThreads();

    /**
     * Next methods are just sliders
     * 
     */

    
  }

  public void setUpThreads(){
    writers[0] = new Writer(escritor1Img, escritor1Status, "So sei que nada assei", serverStatus, escritor1Slider);
    writers[1] = new Writer(escritor2Img, escritor2Status, "So sei que nao dancei", serverStatus, escritor2Slider);
    writers[2] = new Writer(escritor3Img, escritor3Status, "So sei que nada sei", serverStatus, escritor3Slider);

    writers[0].start();
    writers[1].start();
    writers[2].start();

    readers[0] = new Reader(leitor1Img, leitor1Status, leitor1Slider);
    readers[1] = new Reader(leitor2Img, leitor2Status, leitor2Slider);
    readers[2] = new Reader(leitor3Img, leitor3Status, leitor3Slider);

    readers[0].start();
    readers[1].start();
    readers[2].start(); 
  }


  
}
