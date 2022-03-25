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
  private ImageView t1;
  @FXML
  private ImageView t2;

  @FXML
  private ImageView semaphore;

  @FXML
  private Button t1V1;

  @FXML
  private Button t1V2;

  @FXML
  private Button t1V3;

  @FXML
  private Button t2V1;

  @FXML
  private Button t2V2;

  @FXML
  private Button t2V3;

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
    T1Thread train1 = new T1Thread(this, t1);
    T2Thread train2 = new T2Thread(this, t2);
    train1.start();
    train2.start();

    t1V1.setOnAction(event -> {
      train1.setSpeed(10);
    });

    t1V2.setOnAction(event -> {
      train1.setSpeed(5);
    });

    t1V3.setOnAction(event -> {
      train1.setSpeed(2);
    });

    t2V1.setOnAction(event -> {
      train2.setSpeed(10);
    });

    t2V2.setOnAction(event -> {
      train2.setSpeed(5);
    });

    t2V3.setOnAction(event -> {
      train2.setSpeed(2);
    });

  }

  public void checkSignal() {
    while (getSignal() != 0) {
      try {
        Thread.sleep(100);
      } catch (Exception e) {

      }
    }
  }

  public void setSignal(int signal) {
    this.signal = signal;
  }

  public int getSignal() {
    return this.signal;
  }

  public void sleep(int mili) {
    try {
      Thread.sleep(mili);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }

  }

  public void semaphoreChangeVisible(){
    Platform.runLater(() -> {
      semaphore.setVisible(!semaphore.isVisible());
    });
  }

}
