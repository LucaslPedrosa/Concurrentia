package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Variables.setUpSemaphores();
    createThreads();
    
  }

  public void createThreads(){
    Warrior warrior = new Warrior("Warrior", warriorImg);
    warrior.start();

    Archer archer = new Archer("Archer",archerImg);
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
