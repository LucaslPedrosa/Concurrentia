package controller;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import util.threads.ThreadFather;
import util.threads.ThreadGrandson1;
import util.threads.ThreadGrandson2;
import util.threads.ThreadGreatGrandson;
import util.threads.ThreadSon1;
import util.threads.ThreadSon2;
import util.threads.ThreadSon3;

public class MainController implements Initializable {

  // Images
  @FXML private ImageView imgFather;
  @FXML private ImageView imgFilho1;
  @FXML private ImageView imgFilho3;
  @FXML private ImageView imgFilho2;
  @FXML private ImageView imgNeto1;
  @FXML private ImageView imgBisneto;
  @FXML private ImageView imgNeto2;

  // Button to start the tree
  @FXML private Button buttonStart;

  // Labels used for display the ages
  @FXML private Label labelFatherAge;
  @FXML private Label labelSon1Age;
  @FXML private Label labelSon2Age;
  @FXML private Label labelSon3Age;
  @FXML private Label labelGrandson1Age;
  @FXML private Label labelGrandson2Age;
  @FXML private Label labelGreatGrandsonAge;

  private MediaPlayer mediaPlayer;


  // Threads:
  private ThreadFather threadFather = new ThreadFather();

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Set on the controllers
    threadFather.setController(this);

    buttonStart.setOnAction(Event -> {
      buttonStart.setDisable(true);
      slashMusicPlays();
      threadFather.start();
    });
  }

  // @Override
  // public void run() {
  //   threadFather.start();
  // }

  // Methods

  public void slashMusicPlays(){
    Media media = new Media(Paths.get("util/champions.mp3").toUri().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setVolume(0.3);
    mediaPlayer.play();
  }

  public void killFather(){
    imgFather.setImage(new Image("/img/paiIMORTAL.png"));
  }

  public void killSon1(){
    imgFilho1.setImage(new Image("/img/filho1morto.png"));
  }

  public void killSon2(){
    imgFilho2.setImage(new Image("/img/filho2morto.png"));
  }

  public void killSon3(){
    imgFilho3.setImage(new Image("/img/filho3morto.png"));
  }

  public void killGrandson1(){
    imgNeto1.setImage(new Image("/img/neto1morto.png"));
  }
  
  public void killGrandson2(){
    imgNeto2.setImage(new Image("/img/neto2morto.png"));
  }

  public void killGreatGrandson(){
    imgBisneto.setImage(new Image("/img/bisneto1morto.png"));
  }

  // gets and sets
  public void setFatherVisible() {
    imgFather.setVisible(true);
  }

  public void setFatherAge(int age) {
    this.labelFatherAge.setText(String.valueOf(age));
  }

  public void setSon1Age(int age) {
    this.labelSon1Age.setText(String.valueOf(age));
  }

  public void setSon2Age(int age) {
    this.labelSon2Age.setText(String.valueOf(age));
  }

  public void setSon3Age(int age) {
    this.labelSon3Age.setText(String.valueOf(age));
  }

  public void setGrandson1Age(int age) {
    this.labelGrandson1Age.setText(String.valueOf(age));
  }

  public void setGrandson2Age(int age) {
    this.labelGrandson2Age.setText(String.valueOf(age));
  }

  public void setGreatGrandsonAge(int age) {
    this.labelGreatGrandsonAge.setText(String.valueOf(age));
  }

  public void setSon1Visible() {
    imgFilho1.setVisible(true);
  }

  public void setSon2Visible() {
    imgFilho2.setVisible(true);
  }

  public void setSon3Visible() {
    imgFilho3.setVisible(true);
  }

  public void setGrandson1Visible() {
    imgNeto1.setVisible(true);
  }

  public void setGrandson2Visible() {
    imgNeto2.setVisible(true);
  }

  public void setGreatGrandsonVisible() {
    imgBisneto.setVisible(true);
  }

}