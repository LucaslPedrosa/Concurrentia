package model;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Writer extends Thread {

  private ImageView img;
  private Label status;
  private boolean programRunning = true;
  private int speed = 1000;
  private String text;
  private Label serverStatus;

  public Writer(ImageView img, Label status, String text, Label serverStatus) {
    this.img = img;
    this.status = status;
    this.text = text;
    this.serverStatus = serverStatus;
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
      Variables.wrmutex.acquire();

      Platform.runLater(() -> {
        img.setImage(new Image("/img/escrevendo.gif"));
        serverStatus.setText(text);
      });

      toSleeep(speed);
      Variables.wrmutex.release();
      Platform.runLater(() -> {
        img.setImage(new Image("/img/EscritorAFK.png"));

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

}
