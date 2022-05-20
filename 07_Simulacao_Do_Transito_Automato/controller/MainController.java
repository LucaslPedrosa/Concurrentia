package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Archer;
import model.BaseCharacter;
import model.Knight;
import model.Mage;
import model.Ninja;
import model.Paladin;
import model.Rogue;
import model.Variables;
import model.Warrior;

public class MainController implements Initializable {

  @FXML
  private ImageView warriorImg;

  @FXML
  private ImageView archerImg;

  @FXML
  private ImageView knightImg;

  @FXML
  private ImageView mageImg;

  @FXML
  private ImageView ninjaImg;

  @FXML
  private ImageView paladinImg;

  @FXML
  private ImageView rogueImg;

  @FXML
  private ImageView selectedImg;

  @FXML
  private ImageView routeImg;

  @FXML
  private Label selectedText;

  @FXML
  private Slider speedSlider;

  @FXML
  private Label attLabel;

  @FXML
  private Label spdLabel;

  @FXML
  private Label vitLabel;

  @FXML
  private Label defLabel;

  @FXML
  private Label dexLabel;

  @FXML
  private Label wisLabel;

  @FXML
  private Label charText;

  @FXML
  private Button pauseButton;

  private int classSelected = 1;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Variables.setUpSemaphores();

    Warrior warrior = new Warrior("Warrior", warriorImg);
    warrior.start();

    Archer archer = new Archer("Archer", archerImg);
    archer.start();

    Knight knight = new Knight("Knight", knightImg);
    knight.start();

    Rogue rogue = new Rogue("Rogue", rogueImg);
    rogue.start();

    Mage mage = new Mage("Mage", mageImg);
    mage.start();

    Ninja ninja = new Ninja("Ninja", ninjaImg);
    ninja.start();

    Paladin paladin = new Paladin("Paladin", paladinImg);
    paladin.start();

    speedSlider.setOnMouseDragged(event -> {
      switch (classSelected) {
        case (1):
          warrior.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (2):
          archer.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (3):
          knight.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (4):
          mage.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (5):
          ninja.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (6):
          rogue.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        case (7):
          paladin.setSpeed((int) Math.round(speedSlider.getValue()));
          System.out.println(Math.round(speedSlider.getValue()));
          break;
        default:
          break;
      }
    });

    pauseButton.setOnAction(event -> {
      switch (classSelected) {
        case (1):
          warrior.changePause();
          break;
        case (2):
          archer.changePause();
          break;
        case (3):
          knight.changePause();
          break;
        case (4):
          mage.changePause();
          break;
        case (5):
          ninja.changePause();
          break;
        case (6):
          rogue.changePause();
          break;
        case (7):
          paladin.changePause();
          break;

      }
    });

    warriorImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/warrior.png"));
      selectedText.setText("Warrior");
      classSelected = 1;
      charText.setText(
          "A classe mais forte do jogo, Warrior possui o maior ataque do jogo alem de alta defesa e poder 'buffar' sua velocidade e destreza");
      attLabel.setText("75");
      defLabel.setText("69");
      spdLabel.setText("50");
      dexLabel.setText("50");
      vitLabel.setText("75");
      wisLabel.setText("50");
      routeImg.setImage(new Image("/img/routes/warRoute.png"));
    });

    archerImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/archer.png"));
      selectedText.setText("Archer");
      classSelected = 2;
      charText.setText(
          "Uma das classes mais fracas do jogo, o arqueiro possui ataque fraco devido a sua arma e sua utilidade e bem limitada");
      attLabel.setText("75");
      defLabel.setText("42");
      spdLabel.setText("50");
      dexLabel.setText("50");
      vitLabel.setText("50");
      wisLabel.setText("50");
      routeImg.setImage(new Image("/img/routes/archerRoute.png"));
    });

    knightImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/knight.png"));
      selectedText.setText("Knight");
      classSelected = 3;
      charText.setText(
          "A classe mais facil de se jogar, a sua alta defesa e vida permita com que voce nao morra com facilidade");
      attLabel.setText("50");
      defLabel.setText("80");
      spdLabel.setText("50");
      dexLabel.setText("50");
      vitLabel.setText("75");
      wisLabel.setText("50");
      routeImg.setImage(new Image("/img/routes/knightRoute.png"));
    });

    mageImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/mage.png"));
      selectedText.setText("Mage");
      classSelected = 4;
      charText.setText(
          "A segunda classe mais forte do jogo, alto dano e distancia de ataque permite com que voce jogue tranquilo");
      attLabel.setText("75");
      defLabel.setText("35");
      spdLabel.setText("50");
      dexLabel.setText("75");
      vitLabel.setText("50");
      wisLabel.setText("75");
      routeImg.setImage(new Image("/img/routes/mageRoute.png"));
    });

    ninjaImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/ninja.png"));
      selectedText.setText("Ninja");
      classSelected = 5;
      charText.setText(
          "A pior classe do jogo, suas habilidades nao ajudam o coletivo, nao possui dano alto e taopouco defesa");
      attLabel.setText("75");
      defLabel.setText("42");
      spdLabel.setText("75");
      dexLabel.setText("75");
      vitLabel.setText("50");
      wisLabel.setText("50");
      routeImg.setImage(new Image("/img/routes/ninjaRoute.png"));
    });

    rogueImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/rogue.png"));
      selectedText.setText("Rogue");
      classSelected = 6;
      charText.setText(
          "Uma classe extremamente individual e de baixo dano, entretanto sua capacidade de ficar invisivel ajuda o grupo em momentos especificos");
      attLabel.setText("50");
      defLabel.setText("42");
      spdLabel.setText("75");
      dexLabel.setText("75");
      vitLabel.setText("50");
      wisLabel.setText("60");
      routeImg.setImage(new Image("/img/routes/rogueRoute.png"));
    });

    paladinImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/paladin.png"));
      selectedText.setText("Paladin");
      classSelected = 7;
      charText.setText(
          "Nao e das mais fortes, mas e a segunda mais necessaria, pode curar os aliados e aumentar o seu dano");
      attLabel.setText("50");
      defLabel.setText("52");
      spdLabel.setText("50");
      dexLabel.setText("45");
      vitLabel.setText("50");
      wisLabel.setText("75");
      routeImg.setImage(new Image("/img/routes/paladinRoute.png"));
    });

  }

}
