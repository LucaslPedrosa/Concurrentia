/**
 * @Author: Lucas Pedrosa Larangeira
 * 
 * 
 * 
 *  MainController class controns the main FXML view, this class set up every thread then starts then
 * 
 * 
 */

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

public class MainController implements Initializable {

  @FXML
  private ImageView escritor1Img; // image of first writer

  @FXML
  private ImageView escritor3Img; // image of third writer

  @FXML
  private ImageView escritor2Img; // image of second writer

  @FXML
  private ImageView leitor1Img; // image of first reader

  @FXML
  private ImageView leitor2Img; // image of second reader

  @FXML
  private ImageView leitor3Img; // image of third reader

  @FXML
  private Label serverStatus; // text displayed below server

  @FXML
  private Label escritor1Status; // writer 1 status message

  @FXML
  private Label escritor2Status; // writer 2 status message

  @FXML
  private Label escritor3Status; // writer 3 status message

  @FXML
  private Label leitor1Status; // reader 1 status message

  @FXML
  private Label leitor2Status; // reader 2 status message

  @FXML
  private Label leitor3Status; // reader 3 status message

  @FXML
  private Slider escritor1Slider; // writer 1 speed slider

  @FXML
  private Slider escritor2Slider; // writer 2 speed slider

  @FXML
  private Slider escritor3Slider; // writer 3 speed slider

  @FXML
  private Slider leitor1Slider; // reader 1 speed slider

  @FXML
  private Slider leitor2Slider; // reader 2 speed slider

  @FXML
  private Slider leitor3Slider; // reader 3 speed slider

  Writer writers[] = new Writer[3]; // writer threads
  Reader readers[] = new Reader[3]; // reader threads

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    setUpThreads(); // this method will create every thread then start they

  }

  /**
   * setUpThreads method will create every single thread individually and then
   * start then
   * 
   * OBS: i know its possible to create these threads in a for loop, but since
   * theyre just a few i didnt
   * 
   */

  public void setUpThreads() {

    // Writer 1 thread create
    writers[0] = new Writer(escritor1Img, escritor1Status, "So sei que nada assei", serverStatus, escritor1Slider);
    // writer 2 thread create
    writers[1] = new Writer(escritor2Img, escritor2Status, "So sei que nao dancei", serverStatus, escritor2Slider);
    // writer 3 thread create
    writers[2] = new Writer(escritor3Img, escritor3Status, "So sei que nada sei", serverStatus, escritor3Slider);

    //writer 1 thread start
    writers[0].start();
    //writer 2 thread start
    writers[1].start();
    //writer 3 thread start
    writers[2].start();

    //reader 1 thread create
    readers[0] = new Reader(leitor1Img, leitor1Status, leitor1Slider);
    //reader 2 thread create
    readers[1] = new Reader(leitor2Img, leitor2Status, leitor2Slider);
    //reader 3 thread create
    readers[2] = new Reader(leitor3Img, leitor3Status, leitor3Slider);

    readers[0].start(); //reader 1 thread start
    readers[1].start(); //reader 2 thread start
    readers[2].start(); //reader 3 thread start
  }

}
