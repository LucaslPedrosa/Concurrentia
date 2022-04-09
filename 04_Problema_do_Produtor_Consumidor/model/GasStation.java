package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GasStation extends Thread {

  private ImageView img;
  private ImageView onlineButton;
  private MainController controller;
  private int speed = 100; // Speed of moving car
  private boolean online = false;
  private int pricePerLitter = 10;
  private double ORIGINAL_X;
  private double ORIGINAL_Y;
  private Button speeds[];
  private boolean isSpeed[] = new boolean[3];

  public GasStation(MainController controller, ImageView img, ImageView onlineButton, Button speeds[]) {
    this.img = img;
    this.controller = controller;
    this.onlineButton = onlineButton;
    this.ORIGINAL_X = img.getLayoutX();
    this.ORIGINAL_Y = img.getLayoutY();
    this.speeds = speeds;
  }

  @Override
  public void run() {
    while (true) {
      while (online) {
        try {
          img.setVisible(true);
          moveCar();
          consume();
          wait(500);
          reset();
          wait(500);
        } catch (Exception e) {
          System.out.println("Consumption error");
        }
      }
      wait(3000);
    }

  }

  public void moveCar() {
    int temp = 0;
    while (temp < 100) {
      temp++;
      Platform.runLater(() -> {
        img.setLayoutX(img.getLayoutX() + 2);
        img.setLayoutY(img.getLayoutY() - 1);
      });
      wait(speed / 10);
    }
  }

  public void consume() {
    try {
      Buffer.semaphoreFull.acquire(); // look if we can remove another one
      Buffer.mutex.acquire(); // Enter critical region
      Buffer.addLiters(-1);
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

  public void reset() {
    img.setVisible(false);
    img.setLayoutX(ORIGINAL_X);
    img.setLayoutY(ORIGINAL_Y);
  }

  public void wait(int speed) {
    try {
      Thread.sleep(speed);
    } catch (Exception e) {
    }
  }

  public void turnOnOff() {
    this.online = !(this.online);

    Platform.runLater(() -> {
      if (online)
        this.onlineButton.setImage(new Image("/img/powerOn.png"));
      else
        this.onlineButton.setImage(new Image("/img/powerOff.png"));
    });
  }

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

  public void unlockSpeed(int speed) {
    isSpeed[speed] = true;
    if (onlineButton.isVisible())
      Platform.runLater(() -> {
        speeds[speed].setVisible(true);
      });
  }

}
