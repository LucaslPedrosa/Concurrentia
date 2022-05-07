package model;

import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Reader extends Thread {

  private double speed = 1000;
  private ImageView img;
  private Label stats;
  private Slider slider;
  private boolean programRunning = true;
  private Semaphore changeSpeed = new Semaphore(1);

  public Reader(ImageView img, Label stats, Slider slider) {
    this.img = img;
    this.stats = stats;
    this.slider = slider;
    setUpSlider();
  }

  @Override
  public void run() {
    while (programRunning) {
      toIdle();
      toRead();
      toSleeep(200);
    }
  }

  public void toRead() {

    try {
      Platform.runLater(() -> {
        stats.setText("Quero ler!!!!!");
      });

      Variables.mutex.acquire();
      if (Variables.getReaders() == 0) {
        Variables.wrmutex.acquire();
      }
      Variables.increaseReaders();
      Variables.mutex.release();

      Platform.runLater(() -> {
        img.setImage(new Image("/img/lendo.gif"));
        stats.setText("Estou lendo nao atrapalhe");
      });

      toSleeep((int) getSpeed());

      Variables.mutex.acquire();
      Variables.decreaseReaders();

      if (Variables.getReaders() == 0) {
        Variables.wrmutex.release();
      }
      Variables.mutex.release();
      Platform.runLater(() -> {
        img.setImage(new Image("/img/LeitorAFK.png"));
        stats.setText("fzndo nada");
      });
    } catch (Exception e) {

    }

  }

  public void toIdle() {
    toSleeep((int) getSpeed());
  }

  public void toSleeep(int miliseconds) {
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
    }
  }

  public void setUpSlider() {
    slider.valueProperty().addListener((observable, oldValue, newValue) -> {
      try {
        changeSpeed.acquire();
        speed = newValue.intValue();
        changeSpeed.release();

      } catch (Exception e) {

      }
    });
  }

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
