package model;

import java.util.concurrent.Semaphore;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OilRefinery extends Thread {

  private int speed = 1000;
  private boolean online = true;
  private MainController controller;
  private ImageView img;

  public OilRefinery(MainController controller, ImageView img) {
    this.controller = controller;
    this.img = img;
  }

  @Override
  public void run() {
    try {
      while (online) {
        produce();
        wait(500);
      }
    } catch (Exception e) {
      System.out.println("Production error");
    }

  }

  public void produce() throws InterruptedException {
    Buffer.semaphoreEmpty.acquire(); // Make it so we cant add another one
    Buffer.mutex.acquire(); // Enter critical region
    Platform.runLater(() -> {

      controller.updateOil();
    });
    Buffer.mutex.release(); // exit critical region
    Buffer.semaphoreFull.release(); // Update Numbers
    wait(speed);
  }

  public void wait(int speed) {
    try {
      Thread.sleep(speed);
    } catch (Exception e) {
    }
  }

}
