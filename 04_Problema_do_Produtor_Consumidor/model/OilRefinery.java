package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OilRefinery extends Thread {

  private int speed = 1000;
  private boolean online = false;
  private MainController controller;
  private ImageView img;
  private ImageView onlineButton;
  private ImageView progressBar[];
  private ImageView loadingBar;

  public OilRefinery(MainController controller, ImageView img, ImageView onlineButton, ImageView loadingBar,
      ImageView progressBar[]) {

    this.controller = controller;
    this.img = img;
    this.onlineButton = onlineButton;
    this.loadingBar = loadingBar;
    this.progressBar = progressBar;
  }

  @Override
  public void run() {
    while (true) {
      while (online) {
        try {
          collect();
          produce();
          reset();
          wait(1000);
        } catch (Exception e) {
          System.out.println("Production error");
        }
      }
      wait(3000);
    }

  }

  public void produce() throws InterruptedException {
    Buffer.semaphoreEmpty.acquire(); // Look if we can add one more
    Buffer.mutex.acquire(); // Enter critical region
    Buffer.addLiters(1);
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
      System.out.println("Error waiting");
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
    this.img.setVisible(true);
    loadingBar.setVisible(true);
    onlineButton.setVisible(true);
  }

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

  public void reset() {
    Platform.runLater(() -> {
      progressBar[0].setVisible(false);
      progressBar[1].setVisible(false);
      progressBar[2].setVisible(false);
    });
  }

}
