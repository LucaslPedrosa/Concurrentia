/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 31/03/2022
 *  last change at : 10/04/2022 17:36
 *  Name: Principal.java
 * 
 *  
 * GasStation class is the producer from this concurrent problem, it
 * moves the car to the gas stations and then consumes one unity of oil
 *
 * 
 */

package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GasStation extends Thread {

  private ImageView img; // car image
  private ImageView onlineButton; // image to turn it ON/OFF
  private MainController controller; // MainController
  private int speed = 1000; // Speed of moving car
  private boolean online = false; // boolean to make producer keeps producing
  private int pricePerLitter = 10; // money earned from each litter
  private double ORIGINAL_X; // Original X value used to reset X
  private double ORIGINAL_Y; // Original Y value used to reset Y
  private Button speeds[]; // Speed buttons
  private boolean isSpeed[] = new boolean[3]; // See if the speed buttons are visible

  /**
   * GasStation construct sets everything used in this class
   * 
   * @param controller   : mainController, the only one
   * @param img          : car image
   * @param onlineButton : FXML IMG used to turn it on
   * @param speeds       : FXML buttons used to change speeds
   */
  public GasStation(MainController controller, ImageView img, ImageView onlineButton, Button speeds[]) {
    this.img = img;
    this.controller = controller;
    this.onlineButton = onlineButton;
    this.ORIGINAL_X = img.getLayoutX();
    this.ORIGINAL_Y = img.getLayoutY();
    this.speeds = speeds;
  }

  /**
   * run method is called whenever gasStation thread is started
   * 
   */

  @Override
  public void run() {
    while (true) { // Run forever
      while (online) { // only executes if gas station is ON
        try {
          img.setVisible(true); // Car appears
          moveCar(); // Move car to station
          consume(); // Consumes an OIL
          wait(500); // sleeps method
          reset(); // reset car X and Y
          wait(500); // sleeps method
        } catch (Exception e) {
          System.out.println("Consumption error");
        }
      }
      wait(3000);
    }

  }

  /**
   * moveCar method moves the car to the gas Station
   * 
   */
  public void moveCar() {
    int temp = 0;
    while (temp < 100) {
      temp++;
      Platform.runLater(() -> {
        img.setLayoutX(img.getLayoutX() + 2);
        img.setLayoutY(img.getLayoutY() - 1);
      });
      wait(speed / 100);
    }
  }

  /**
   * consume method is the primary objective of this concurrent work, it should
   * work as fine when entering on the critical regions
   * 
   */

  public void consume() {
    try {
      Buffer.semaphoreFull.acquire(); // look if we can remove another one
      Buffer.mutex.acquire(); // Enter critical region
      Buffer.addLiters(-1); // add litters
      Platform.runLater(() -> {
        controller.updateOil();
        controller.addMoney(pricePerLitter);
      });
      Buffer.mutex.release(); // exit critical region
      Buffer.semaphoreEmpty.release(); // make possible to remove another one
      wait(speed);
    } catch (Exception e) {
      System.out.println("Erro de consumo.");
    }
  }

  /**
   * reset method resets car X and Y and make it invisible
   * 
   */
  public void reset() {
    img.setVisible(false);
    img.setLayoutX(ORIGINAL_X);
    img.setLayoutY(ORIGINAL_Y);
  }

  /**
   * wait method forces the thread to sleep for a determined amout of time
   * 
   * @param speed : this gasStation speed
   */
  public void wait(int speed) {
    try {
      Thread.sleep(speed);
    } catch (Exception e) {
    }
  }

  /**
   * turnOnOff method is used to turn the gas station on or off and change its FXML image
   * 
   */
  public void turnOnOff() {
    this.online = !(this.online);

    Platform.runLater(() -> {
      if (online)
        this.onlineButton.setImage(new Image("/img/powerOn.png"));
      else
        this.onlineButton.setImage(new Image("/img/powerOff.png"));
    });
  }


  /**
   * start this gasStation
   * 
   */
  public void makeAmericaGreat() {
    Platform.runLater(() -> {
      onlineButton.setVisible(true);
      speeds[0].setVisible(true);
      if (isSpeed[1])
        speeds[1].setVisible(true);
      if (isSpeed[2])
        speeds[2].setVisible(true);
    });
  }

  /**
   * unlock defined speed
   * 
   * @param speed : index of witch speed should be unlocked
   */

  public void unlockSpeed(int speed) {
    isSpeed[speed] = true;
    if (onlineButton.isVisible())
      Platform.runLater(() -> {
        speeds[speed].setVisible(true);
      });
  }


  /**
   * set determined speed
   * 
   * @param speed : set this class speed to this value
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

}
