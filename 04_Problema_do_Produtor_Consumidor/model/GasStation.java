package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GasStation extends Thread {

  private ImageView img;
  private MainController controller;
  private int speed = 100;  // Speed of moving car
  private boolean online = true;
  private int pricePerLitter = 10;
  private double ORIGINAL_X;
  private double ORIGINAL_Y;

  public GasStation(MainController controller, ImageView img) {
    this.img = img;
    this.controller = controller;
    this.ORIGINAL_X = img.getLayoutX();
    this.ORIGINAL_Y = img.getLayoutY();
  }

  @Override
  public void run() {

    while (online) {
      try {
        moveCar();
        consume();
        reset();
        wait(500);
      } catch (Exception e) {
        System.out.println("Consumption error");
      }

    }

  }

  public void moveCar() {
    int temp = 0;
    while(temp < 100){
      temp++;
      img.setLayoutX(img.getLayoutX()+2);
      img.setLayoutY(img.getLayoutY()-1);
      wait(speed/10);
    }

  }

  public void consume() {
    try {
      Buffer.semaphoreFull.acquire(); // Make it so we cant remove another one
      Buffer.mutex.acquire(); // Enter critical region

      Buffer.semaphoreEmpty.release(); // Update Numbers

      Platform.runLater(() -> {
        controller.updateOil();
        controller.addMoney(pricePerLitter);
      });
      Buffer.mutex.release(); // exit critical region
      wait(speed);
    } catch (Exception e) {
      System.out.println("Erro de consumo.");
    }
  }

  public void reset() {
    img.setLayoutX(ORIGINAL_X);
    img.setLayoutY(ORIGINAL_Y);
  }

  public void wait(int speed) {
    try {
      Thread.sleep(speed);
    } catch (Exception e) {
    }
  }

}
