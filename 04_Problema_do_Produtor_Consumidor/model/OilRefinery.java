/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 31/03/2022
 *  last change at : 10/04/2022 17:46
 *  Name: Principal.java
 * 
 *  
 * OilRefinery class is the class producer of this concurrent problem, it should 
 * share memory with the consumer and add whenever is possible more Oil to the tank
 * 
 * 
 *
 * 
 */

package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OilRefinery extends Thread {

  private int speed = 1000; // amount of time this Thread should wait
  private boolean online = false; // Repeating itself Boolean
  private MainController controller; // Controller class from MainController
  private ImageView img; // refinery image
  private ImageView onlineButton; // online image
  private ImageView progressBar[]; // Each refinery progress bar inside loading bar
  private ImageView loadingBar; // each refinery loading bar
  private Button speeds[]; // Speed buttons
  private boolean isSpeed[] = new boolean[3]; // See if determined speed is unlocked

  /**
   * OilRefinery construct sets everything should be needed to producer class to
   * start
   * 
   * @param controller   : mainController only one class
   * @param img          : refinery image
   * @param onlineButton : turn refinery on/off image
   * @param loadingBar   : progress laoding bar
   * @param progressBar  : progress bar inside each loading bar
   * @param speeds       : this Refinery speed to produce
   */
  public OilRefinery(MainController controller, ImageView img, ImageView onlineButton, ImageView loadingBar,
      ImageView progressBar[], Button speeds[]) {
    this.controller = controller;
    this.img = img;
    this.onlineButton = onlineButton;
    this.loadingBar = loadingBar;
    this.progressBar = progressBar;
    this.speeds = speeds;
  }

  /**
   * run method is called whenever OilRefinery is called, it should produce an
   * amount of oil and STOP everytime the tank is FULL
   * 
   * 
   */
  @Override
  public void run() {
    while (true) {
      while (online) {
        try {
          collect(); // collects the oil
          produce(); // produce it
          reset(); // reset the refinery
          wait(1000); // wait then do it again
        } catch (Exception e) {
          System.out.println("Production error");
        }
      }
      wait(3000);
    }

  }

  /**
   * 
   * produce method is the main reason of this concurrent problem, it should
   * produce oil and share an buffer with the consumer
   * 
   * @throws InterruptedException : semaphore exception
   */
  public void produce() throws InterruptedException {
    Buffer.semaphoreEmpty.acquire(); // Look if we can add one more
    Buffer.mutex.acquire(); // Enter critical region
    Buffer.addLiters(1); // add oil
    Platform.runLater(() -> {
      controller.updateOil(); // update FXML oil
    });
    Buffer.mutex.release(); // exit critical region
    Buffer.semaphoreFull.release(); // Update Numbers
    wait(speed); // wait to do it again
  }

  /**
   * wait method puts the Thread to sleep then return its
   * 
   * @param speed : amount of miliseconds to sleep
   */
  public void wait(int speed) {
    try {
      Thread.sleep(speed);
    } catch (Exception e) {
      System.out.println("Error waiting");
    }
  }

  /**
   * turnOnOff method to turn the refinery on or Off
   * 
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
   * makeAmericaGreat method starts the OilRefinery method and start producing OIL
   * 
   */

  public void makeAmericaGreat() {
    this.img.setVisible(true);
    loadingBar.setVisible(true);
    onlineButton.setVisible(true);
    speeds[0].setVisible(true);

    if (isSpeed[1])
      speeds[1].setVisible(true);
    if (isSpeed[2])
      speeds[2].setVisible(true);
  }

  /**
   * unlockSpeed method unlocks the speed passed as param
   * 
   * 
   * @param speed : index to being unlocked
   */

  public void unlockSpeed(int speed) {
    isSpeed[speed] = true;
    if (img.isVisible())
      Platform.runLater(() -> {
        speeds[speed].setVisible(true);
      });
  }

  /**
   * collect method is used to wait an amount of time and updates the progress bar
   * on the loading bar
   * 
   * 
   */
  public void collect() {

    wait(speed);
    Platform.runLater(() -> {
      progressBar[0].setVisible(true);
    });
    wait(speed);
    Platform.runLater(() -> {
      progressBar[1].setVisible(true);
    });
    wait(speed);
    Platform.runLater(() -> {
      progressBar[2].setVisible(true);
    });

  }


  /**
   * reset method resets refinery progress bar and the it invisible
   * 
   */
  public void reset() {
    Platform.runLater(() -> {
      progressBar[0].setVisible(false);
      progressBar[1].setVisible(false);
      progressBar[2].setVisible(false);
    });
  }

  /**
   * set speed method changes this refinery Speed
   * 
   * @param speed : speed number
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

}
