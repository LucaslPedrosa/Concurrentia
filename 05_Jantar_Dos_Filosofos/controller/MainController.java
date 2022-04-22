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
  private ImageView imgFork4;

  @FXML
  private ImageView imgFork3;

  @FXML
  private ImageView imgFork2;

  @FXML
  private ImageView imgFork0;

  @FXML
  private ImageView imgFork1;

  @FXML
  private Label labelVoltairePsn;

  @FXML
  private Label labelSocratesPsn;

  @FXML
  private Label labelConfuciousPsn;

  @FXML
  private Label labelLaoTzuPsn;

  @FXML
  private Label labelSunTzuPsn;

  @FXML
  private Slider sliderLaoTzuEat;

  @FXML
  private Slider sliderLaoTzuThink;

  @FXML
  private Slider sliderSunTzuEat;

  @FXML
  private Slider sliderSunTzuThink;

  @FXML
  private Slider sliderVoltaireEat;

  @FXML
  private Slider SliderVoltaireThink;

  @FXML
  private Slider sliderConfuciousEat;

  @FXML
  private Slider sliderConfuciousThink;

  @FXML
  private Slider sliderSocratezEat;

  @FXML
  private Slider sliderSocratezThink;

  private final int PHILO_SIZE = 5;

  private Philosopher philosophers[] = new Philosopher[5];

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    setPhilosophers();

    /**
     * Sliders methods
     * 
     */

    sliderSocratezEat.setOnDragDetected(Event -> {
      philosophers[0].setEatSpeed(Integer.valueOf(Double.toString(sliderSocratezEat.getValue())));
    });

    sliderSocratezThink.setOnDragDetected(Event -> {
      philosophers[0].setThinkSpeed(Integer.valueOf(Double.toString(sliderSocratezThink.getValue())));
    });

    // sliderSocratezThink.setOnDragDetected(Event -> {
    //   philosophers[0].setThinkSpeed(Integer.valueOf(Double.toString(sliderSocratezThink.getValue())));
    // });

    sliderLaoTzuEat.setOnDragDetected(Event -> {
      philosophers[3].setEatSpeed(Integer.valueOf(Double.toString(sliderLaoTzuEat.getValue())));
    });

  }

  public void setPhilosophers() {

    philosophers[0] = new Philosopher("Socrates", 0, imgFork0, imgFork1, labelSocratesPsn);
    philosophers[1] = new Philosopher("Voltaire", 1, imgFork1, imgFork2, labelVoltairePsn);
    philosophers[2] = new Philosopher("Sun'Tzu", 2, imgFork2, imgFork3, labelSunTzuPsn);
    philosophers[3] = new Philosopher("Lao Tzu", 3, imgFork3, imgFork4, labelLaoTzuPsn);
    philosophers[4] = new Philosopher("Confucious", 4, imgFork4, imgFork1, labelConfuciousPsn);

    for (int i = 0; i < PHILO_SIZE; i++) {
      philosophers[i].start();
      Var.philo[i] = new Semaphore(1);
    }
  }

}
