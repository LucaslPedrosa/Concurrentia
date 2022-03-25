package model;

import java.util.concurrent.Semaphore;

import controller.MainController;
import javafx.scene.image.ImageView;

public class T1Thread extends TrainThread {

  public T1Thread(MainController controller, ImageView image) {
    super(controller, image);
  }

  @Override
  public void run() {
    while (looping) {
      moveX(-400d);
      controller.checkSignal();
      passTrack();
      moveY(2d);
      moveX(-335d);
      reset();
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
      controller.sleep(5);
    }
  }

  @Override
  public void passTrack() {
    controller.setSignal(1);
    controller.semaphoreChangeVisible();
    moveTriple(-1d, 0.4, -0.5);
    moveTriple(-1d, 0.6, 0.5);
    moveTriple(-1.2d, -0.6, 0.5);
    moveTriple(-1d, -0.4, -0.5);
    controller.setSignal(0);
    controller.semaphoreChangeVisible();
  }

}
