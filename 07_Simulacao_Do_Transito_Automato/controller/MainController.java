package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

  private int classSelected = 1;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Variables.setUpSemaphores();
    createThreads();

    speedSlider.setOnDragOver(event -> {
      switch (classSelected) {
        case (1):
          break;
        case (2):
          break;

        default:
          break;
      }
    });

    warriorImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/warrior.png"));
      classSelected = 1;
    });

  }

  public void createThreads() {
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

  }

}
