package model;

import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Writer extends Thread {

  private ImageView img;
  private Label status;
  private boolean programRunning = true;
  private double speed = 1000;
  private String text;
  private Label serverStatus;
  private Slider slider;
  private Semaphore changeSpeed = new Semaphore(1);

  public Writer(ImageView img, Label status, String text, Label serverStatus, Slider slider) {
    this.img = img;
    this.status = status;
    this.text = text;
    this.serverStatus = serverStatus;
    this.slider = slider;
    setUpSlider();
  }

  @Override
  public void run() {
    while (programRunning) {
      toIdle();
      toWrite();
      toSleeep(200);
    }
  }

  public void toIdle() {
    toSleeep(1000);
  }

  public void toWrite() {
    try {
      Platform.runLater(() -> {
        status.setText("Quero escrever!!!!!");
      });
      Variables.wrmutex.acquire();
      Platform.runLater(() -> {
        img.setImage(new Image("/img/escrevendo.gif"));
        serverStatus.setText(text);
        status.setText("Estou fazendo arte, me atrapalhe!");
      });

      toSleeep((int) getSpeed());
      Variables.wrmutex.release();
      Platform.runLater(() -> {
        img.setImage(new Image("/img/EscritorAFK.png"));
        status.setText("Estou a pensar");

      });
    } catch (Exception e) {

    }

  }

  public void toSleeep(int miliseconds) {
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
      System.out.println("Erro no escritor dormindo");
    }
  }

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
