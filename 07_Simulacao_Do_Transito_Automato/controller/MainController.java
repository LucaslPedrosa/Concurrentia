/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: MainController.java 
 *  
 * 
 *  
 *  Main Controller is the principal class that take care of creating
 *  any threads and changing everything on the FXML
 * 
 * 
 *
 */

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
  private ImageView warriorImg; // image of warrior 'car'

  @FXML
  private ImageView archerImg; // img of archer 'car'

  @FXML
  private ImageView knightImg; // img of knight 'car'

  @FXML
  private ImageView mageImg; // img of mage 'car'

  @FXML
  private ImageView ninjaImg; // img of ninja 'car'

  @FXML
  private ImageView paladinImg; // img of paladin 'car'

  @FXML
  private ImageView rogueImg; // img of rogue 'car'

  @FXML
  private ImageView selectedImg; // img actual selected 'car', appears on the right of the screen

  @FXML
  private ImageView routeImg; // img of actual selected 'car' route, appears on the right of the screen

  @FXML
  private Label selectedText; // the name of the selected 'car', appears on the right of the screen

  @FXML
  private Slider speedSlider; // slider used to change speed of every car, apperas on the right of the screen

  @FXML
  private Label attLabel; // attack status of selected class

  @FXML
  private Label spdLabel; // speed status of selected class

  @FXML
  private Label vitLabel; // vitality status of selected class

  @FXML
  private Label defLabel; // defense status of selected class

  @FXML
  private Label dexLabel; // dexterity status of selected class

  @FXML
  private Label wisLabel; // wisdom status of selected class

  @FXML
  private Label charText; // the character description of selected class

  @FXML
  private Button pauseButton; // button to pause determined 'car' moving, it may cause performance issues if
                              // your machine isn't good enough

  private int classSelected = 1; // this integer is used to slider know witch class he is working on,
                                 // 1 = warrior, 2 = archer, 3 = knight
                                 // 4 = mage, 5 = ninja, 6 = rogue, 7 = paladin

  /**
   * Called to initialize a controller after its root element has been
   * completely processed.
   *
   * @param location
   *                  The location used to resolve relative paths for the root
   *                  object, or
   *                  <tt>null</tt> if the location is not known.
   *
   * @param resources
   *                  The resources used to localize the root object, or
   *                  <tt>null</tt> if
   *                  the root object was not localized.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    Variables.setUpSemaphores(); // create all semaphores needed

    Warrior warrior = new Warrior("Warrior", warriorImg); // create warrior class
    warrior.start(); // warrior start

    Archer archer = new Archer("Archer", archerImg); // create archer class
    archer.start(); // archer start

    Knight knight = new Knight("Knight", knightImg); // create knight class
    knight.start(); // knight start

    Rogue rogue = new Rogue("Rogue", rogueImg); // create rogue class
    rogue.start(); // rogue start

    Mage mage = new Mage("Mage", mageImg); // create mage class
    mage.start(); // mage start

    Ninja ninja = new Ninja("Ninja", ninjaImg); // create ninja class
    ninja.start(); // ninja start

    Paladin paladin = new Paladin("Paladin", paladinImg); // create paladin class
    paladin.start(); // paladin start

    /**
     * method setOnMouseDragged defines a function to be called when a mouse button
     * has been clicked (pressed and released) on this {@code Node}.
     */
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

    /**
     * the button's action is invoked whenever the button is fired. This may be by
     * the user clicking the button or by an event or other reasons
     * 
     */

    pauseButton.setOnAction(event -> {
      switch (classSelected) {
        case (1):
          warrior.changePause(); // disable warrior movement
          break;
        case (2):
          archer.changePause(); // disable archer movement
          break;
        case (3):
          knight.changePause(); // disable knight movement
          break;
        case (4):
          mage.changePause(); // disable mage movement
          break;
        case (5):
          ninja.changePause(); // disable ninja movement
          break;
        case (6):
          rogue.changePause(); // disable rogue movement
          break;
        case (7):
          paladin.changePause(); // disable paladin movement
          break;

      }
    });

    /**
     * WarriorImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */

    warriorImg.setOnMouseClicked(event -> {
      selectedImg.setImage(new Image("/img/characters/warrior.png")); // set selected img
      selectedText.setText("Warrior"); // set name
      classSelected = 1;
      charText.setText(
          "A classe mais forte do jogo, Warrior possui o maior ataque do jogo alem de alta defesa e poder 'buffar' sua velocidade e destreza");
      // set status
      attLabel.setText("75");
      defLabel.setText("69");
      spdLabel.setText("50");
      dexLabel.setText("50");
      vitLabel.setText("75");
      wisLabel.setText("50");
      routeImg.setImage(new Image("/img/routes/warRoute.png"));
      speedSlider.setValue(warrior.getSpeed());
    });

    /**
     * archerImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */

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
      speedSlider.setValue(archer.getSpeed());
    });

    /**
     * knightImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */

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
      speedSlider.setValue(knight.getSpeed());
      routeImg.setImage(new Image("/img/routes/knightRoute.png"));
    });

    /**
     * mageImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */

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
      speedSlider.setValue(mage.getSpeed());
      routeImg.setImage(new Image("/img/routes/mageRoute.png"));
    });

    /**
     * ninjaImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */

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
      speedSlider.setValue(ninja.getSpeed());
      routeImg.setImage(new Image("/img/routes/ninjaRoute.png"));
    });

    /**
     * rogueImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */
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
      speedSlider.setValue(rogue.getSpeed());
      routeImg.setImage(new Image("/img/routes/rogueRoute.png"));
    });

    /**
     * paladinImg.setOnMouseClicked defines a action to occur whenever a event
     * happens, in tis case the mouse clicked event
     * 
     * 
     */
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
      speedSlider.setValue(paladin.getSpeed());
      routeImg.setImage(new Image("/img/routes/paladinRoute.png"));
    });

  }

}
