/**
 * @Author: Lucas Pedrosa Larangeira
 * 
 * 
 * 
 *  Reader class extends Thread is the responsable for making the
 *  readers decisions in our program, it will read whenever it wants and can, and then afk for a while
 * 
 * 
 */

package model;

import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Reader extends Thread {

  private double speed = 1000; // amount of miliseconds the reader will wait
  private ImageView img; // reader image
  private Label stats; // status displayed of what reader is doing
  private Slider slider; // reader speed slider
  private boolean programRunning = true; // is the program running?
  private Semaphore changeSpeed = new Semaphore(1); // semaphore for changing speed or using the speed

  /**
   * Reader construct
   * 
   * @param img    // set up reader image
   * @param stats  //set up reader stats
   * @param slider //set up reader speed slider
   */
  public Reader(ImageView img, Label stats, Slider slider) {
    this.img = img;
    this.stats = stats;
    this.slider = slider;
    setUpSlider(); // this method will create a listener to change speed whenever slider is changed
  }

  /**
   * run method overriders from Thread and is called whenever Reader method is
   * started
   * 
   */
  @Override
  public void run() {
    while (programRunning) {
      toIdle(); // just sleeps for speed amount of seconds
      toRead(); // reads
      toSleeep(200); // waits a little until restarting it so the thread doesnt overload
    }
  }

  public void toRead() {

    try {
      Platform.runLater(() -> {
        stats.setText("Quero ler!!!!!"); // Reader wants to read
      });

      /**
       * CRITICAL REGION: Variables.getReaders may ocurr error in multiple threads
       * so we need to acquire a mutex
       * 
       */

      Variables.mutex.acquire();
      if (Variables.getReaders() == 0) {
        Variables.wrmutex.acquire(); // There is no readers reading, so we need to fight against the writers
      }
      Variables.increaseReaders(); // Readers++
      Variables.mutex.release(); // we are not using readers variables anymore, so we release mutex

      Platform.runLater(() -> { // set up visual of reader
        img.setImage(new Image("/img/lendo.gif"));
        stats.setText("Estou lendo nao atrapalhe");
      });

      toSleeep((int) getSpeed()); // wait a little to simulate a reading

      Variables.mutex.acquire(); // CRITICAL REGION: We are going to use readers variable
      Variables.decreaseReaders(); // readers--

      if (Variables.getReaders() == 0) { // if theres no one else reading, we can make server possible for writing
        Variables.wrmutex.release(); // release writers mutex
      }
      Variables.mutex.release(); // we are no longer using readers variable

      Platform.runLater(() -> { // not reading anymore, just set up visuals
        img.setImage(new Image("/img/LeitorAFK.png"));
        stats.setText("fzndo nada");
      });
    } catch (Exception e) {

    }

  }

  /**
   * toIdle method is the responsable for making reader do nothing until he wants
   * to read
   * it will just sleep a thread for a while
   * 
   */

  public void toIdle() {
    toSleeep((int) getSpeed());
  }

  /**
   * toSleep method is a easier way to call for Thread.sleep method, it works just
   * as fine
   * 
   * @param miliseconds the amount of miliseconds the thread will sleep
   */

  public void toSleeep(int miliseconds) {
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
    }
  }

  /**
   * setUpSlider method will add a listener to our slider passed as argument, the
   * slider will change speed
   * 
   */

  public void setUpSlider() {
    slider.valueProperty().addListener((observable, oldValue, newValue) -> {
      try {
        changeSpeed.acquire();  //Critical region, we can only use speed or change it, so we acquire semaphore
        speed = newValue.intValue();
        changeSpeed.release();  // speed variable no longer being used

      } catch (Exception e) {

      }
    });
  }

  /**
   * getSpeed returns value of speed, it acquires a semaphore and then set up speed to return
   * 
   * {@return} this returns the speed variable
   */

  public double getSpeed() {
    double toReturn = 0;
    try {
      changeSpeed.acquire();
      toReturn = this.speed;
      changeSpeed.release();
    } catch (Exception e) {
    }
    return toReturn;
  }

}
