/**
 * @Author: Lucas Pedrosa Larangeira
 * 
 * 
 *
 * Writer class extends thread is the responsable for making the writers actions in this program
 * 
 * 
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

public class Writer extends Thread {

  private ImageView img; // Writer image
  private Label status; // writer displayed status
  private boolean programRunning = true; // is the program running?
  private double speed = 1000; // amount of miliseconds to wait whenever is called
  private String text; // text the writer will write in server
  private Label serverStatus; // the server status displayed
  private Slider slider; // speed slider
  private Semaphore changeSpeed = new Semaphore(1); // Semaphore for changing speed

  /**
   * Writer construct
   * 
   * @param img          : Writer image
   * @param status       : writer stats
   * @param text         : writer text
   * @param serverStatus : writer server status
   * @param slider       : writer speed slider
   */
  public Writer(ImageView img, Label status, String text, Label serverStatus, Slider slider) {
    this.img = img;
    this.status = status;
    this.text = text;
    this.serverStatus = serverStatus;
    this.slider = slider;
    setUpSlider();
  }

  /**
   * run method is called whenever Writer thread is started
   * 
   */
  @Override
  public void run() {
    while (programRunning) {
      toIdle();
      toWrite();
      toSleeep(200);
    }
  }

  /**
   * toIdle method is called when the Writer is doing nothing
   * 
   * 
   */

  public void toIdle() {
    toSleeep(1000);
  }

  /**
   * toWrite method will make Writer tries to write while acquiring a mutex and
   * wait until he can, when he finishes, he releases the semaphore
   * 
   */

  public void toWrite() {
    try {
      Platform.runLater(() -> {
        status.setText("Quero escrever!!!!!"); // writer wants to write
      });
      Variables.wrmutex.acquire(); // enter critical region, the server, so acquire wrmutex
      Platform.runLater(() -> {
        img.setImage(new Image("/img/escrevendo.gif")); // now he is writing
        serverStatus.setText(text); // change status text
        status.setText("Estou fazendo arte, me atrapalhe!"); // change status
      });

      toSleeep((int) getSpeed()); // sleep speed amount of seconds, this is used to create a visual ilusion of
                                  // doing something'
      Variables.wrmutex.release(); // we no longer writing on server, we release wrmutex

      Platform.runLater(() -> { // change visuals
        img.setImage(new Image("/img/EscritorAFK.png"));
        status.setText("Estou a pensar");

      });
    } catch (Exception e) {

    }

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
      System.out.println("Erro no escritor dormindo");
    }
  }

  /**
   * getSpeed returns value of speed, it acquires a semaphore and then set up
   * speed to return
   * 
   * {@return} this returns the speed variable
   */
  public double getSpeed() {
    double toReturn = 0;
    try {
      changeSpeed.acquire();
      toReturn = speed;
      changeSpeed.release();
    } catch (Exception e) {
    }
    return toReturn;
  }

  
  /**
   * setUpSlider method will add a listener to our slider passed as argument, the
   * slider will change speed
   * 
   */
  private void setUpSlider() {
    slider.valueProperty().addListener((observer, oldValue, newValue) -> {
      try {
        changeSpeed.acquire();
        speed = newValue.intValue();
        changeSpeed.release();
      } catch (Exception e) {
      }
    });

  }

}
