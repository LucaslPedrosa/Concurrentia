/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Main controller should start the train1 thread and
 *  the train2 thread, also it should control whenever a train
 *  is able to pass throught the "tunnel"
 * 
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.T1Thread;
import model.T2Thread;

public class MainController implements Initializable {

  @FXML
  private ImageView t1; // Train one image
  @FXML
  private ImageView t2; // Train two image

  @FXML
  private ImageView semaphore; // Semaphore img to show the path is being used

  @FXML
  private Button t1V1; // Train 1 slow speed

  @FXML
  private Button t1V2; // Train 2 medium speed

  @FXML
  private Button t1V3; // Train 3 High speed

  @FXML
  private Button t2V1; // Train 2 slow speed

  @FXML
  private Button t2V2; // Train 2 medium speed

  @FXML
  private Button t2V3; // Train 3 high speed

  /**
   * Signal variable will be used
   * to determine whenever a train is allowed to pass
   * 0 = free path
   * 1 = train1 is using it
   * 2 = train2 is using it
   */
  int signal = 0;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    T1Thread train1 = new T1Thread(this, t1); // Create train 1 thread
    T2Thread train2 = new T2Thread(this, t2); // Creat train 2 thread
    train1.start(); // start train 1 thread
    train2.start(); // start train 2 thread

    t1V1.setOnAction(event -> { // train 1 set Slow speed
      /**
       * The number in every setSpeed method makes reference to the
       * amount of miliseconds the thread should sleep between every
       * small move making a ilusion of movement
       * 
       */
      train1.setSpeed(10);
    });

    t1V2.setOnAction(event -> { // train 1 med speed
      train1.setSpeed(5);
    });

    t1V3.setOnAction(event -> { // Train 1 high speed
      train1.setSpeed(2);
    });

    t2V1.setOnAction(event -> { // Train 2 slow speed
      train2.setSpeed(10);
    });

    t2V2.setOnAction(event -> { // train 2 medium speed
      train2.setSpeed(5);
    });

    t2V3.setOnAction(event -> { // train 2 high speed
      train2.setSpeed(2);
    });

  }

  /**
   * Method name: checkSignal
   * 
   * this method should see whenever is possible to any train tread
   * pass the double-use rail
   * 
   */

  public void checkSignal() {
    while (getSignal() != 0) {
      sleep(100);
    }
  }

  /**
   * Method name: sleep
   * this method should put ant thread to sleep the amount
   * of passed miliseconds 
   * 
   * 
   * @param mili
   */

  public void sleep(int mili) {
    try {
      Thread.sleep(mili);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }

  }

   /**
    * Name: semaphoreChangeVisible
    * 
    * this method should change the visibility of semaphore img to its ! value
    */

  public void semaphoreChangeVisible() {
    Platform.runLater(() -> {
      semaphore.setVisible(!semaphore.isVisible());
    });
  }

  /**
   * method name: setSignal
   * 
   * it should set the atribute signal by its param
   * 
   * @param signal
   */

  public void setSignal(int signal) {
    this.signal = signal;
  }

  /**
   * method name: setSignal
   * 
   * it should return this.signal atribute from mainController
   * 
   * @return this.signal
   */

  public int getSignal() {
    return this.signal;
  }
}
