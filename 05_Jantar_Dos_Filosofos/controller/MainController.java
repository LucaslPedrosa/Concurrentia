/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 13/04/2022
 *  last change at : 22/04/2022 01:24
 *  Name: Philosopher.java
 * 
 *  MainController class is the responsable for making the program and the main FXML run, it will start any thread and set up the sliders
 *
 * 
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.Philosopher;
import model.Var;

public class MainController implements Initializable {

  @FXML
  private ImageView imgFork4; // fork number 5

  @FXML
  private ImageView imgFork3; // fork number 4

  @FXML
  private ImageView imgFork2; // fork number 3

  @FXML
  private ImageView imgFork0; // fork number 1

  @FXML
  private ImageView imgFork1; // fork number 2

  @FXML
  private Label labelVoltairePsn; // voltaire Status message

  @FXML
  private Label labelSocratesPsn; // socrates status message

  @FXML
  private Label labelConfuciousPsn; // confucios status message

  @FXML
  private Label labelLaoTzuPsn; // Laotzu status message

  @FXML
  private Label labelSunTzuPsn; // Sun Tzu status message

  @FXML
  private Slider sliderLaoTzuEat; // Lao Tzu eating speed slider

  @FXML
  private Slider sliderLaoTzuThink; // LaoTzu think speed slider

  @FXML
  private Slider sliderSunTzuEat; // Sun Tzu eat speed slider

  @FXML
  private Slider sliderSunTzuThink; // sun tzu think speed slider

  @FXML
  private Slider sliderVoltaireEat; // voltaire eat speed slider

  @FXML
  private Slider SliderVoltaireThink; // voltaire think speed slider

  @FXML
  private Slider sliderConfuciousEat; // confucious eat speed slider

  @FXML
  private Slider sliderConfuciousThink; // confucious think speed slider

  @FXML
  private Slider sliderSocratezEat; // socrates eat speed slider

  @FXML
  private Slider sliderSocratezThink; // socrates think speed slider

  private final int PHILO_SIZE = 5; // the amount of philosophers

  private Philosopher philosophers[] = new Philosopher[7]; // philosophers array, start it bigger than necessary to use
                                                           // case necessary

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    /**
     * Sliders methods, these next methods are used whenever a slider is dragged and
     * then the philosopher value changes
     * 
     */
    try {
      sliderSocratezEat.setOnMouseDragged(Event -> {
        philosophers[0].setEatSpeed((int) sliderSocratezEat.getValue());
      });

      sliderSocratezThink.setOnMouseDragged(Event -> {
        philosophers[0].setThinkSpeed((int) sliderSocratezThink.getValue());
      });

      sliderVoltaireEat.setOnMouseDragged(Event -> {
        philosophers[1].setEatSpeed((int) sliderVoltaireEat.getValue());
      });

      SliderVoltaireThink.setOnMouseDragged(Event -> {
        philosophers[1].setThinkSpeed((int) SliderVoltaireThink.getValue());
      });

      sliderSunTzuEat.setOnMouseDragged(Event -> {
        philosophers[2].setEatSpeed((int) sliderSunTzuEat.getValue());
      });

      sliderSunTzuThink.setOnMouseDragged(Event -> {
        philosophers[2].setThinkSpeed((int) sliderSunTzuThink.getValue());
      });

      sliderLaoTzuEat.setOnMouseDragged(Event -> {
        philosophers[3].setEatSpeed((int) sliderLaoTzuEat.getValue());
      });

      sliderLaoTzuThink.setOnMouseDragged(Event -> {
        philosophers[3].setThinkSpeed((int) sliderLaoTzuThink.getValue());
      });

      sliderConfuciousEat.setOnMouseDragged(Event -> {
        philosophers[4].setEatSpeed((int) sliderConfuciousEat.getValue());
      });

      sliderConfuciousThink.setOnMouseDragged(Event -> {
        philosophers[4].setThinkSpeed((int) sliderConfuciousThink.getValue());
      });

      setPhilosophers();
    } catch (Exception e) {
      System.out.println("slider error");
    }

  }

  public void setPhilosophers() {
    /**
     * create every philosopher thread, these threads need to be created separatedly
     * since they are unique
     * 
     */
    philosophers[0] = new Philosopher("Socrates", 0, imgFork0, imgFork1, labelSocratesPsn);
    philosophers[1] = new Philosopher("Voltaire", 1, imgFork1, imgFork2, labelVoltairePsn);
    philosophers[2] = new Philosopher("Sun'Tzu", 2, imgFork2, imgFork3, labelSunTzuPsn);
    philosophers[3] = new Philosopher("Lao'Tzu", 3, imgFork3, imgFork4, labelLaoTzuPsn);
    philosophers[4] = new Philosopher("Confucious", 4, imgFork4, imgFork0, labelConfuciousPsn);

    for (int i = 0; i < PHILO_SIZE; i++) {
      Var.philo[i] = new Semaphore(1);
    }

    for (int i = 0; i < PHILO_SIZE; i++) {
      philosophers[i].start();
    }
  }

}
