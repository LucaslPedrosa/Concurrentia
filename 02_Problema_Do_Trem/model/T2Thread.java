package model;

import controller.MainController;
import javafx.scene.image.ImageView;

public class T2Thread extends TrainThread {

  public T2Thread(MainController controller, ImageView image) {
    super(controller, image);
  }

  @Override
  public void run() {
    while (looping) {
      moveX(+300d);
      controller.checkSignal();
      passTrack();
      moveY(2d);
      moveX(+400d);
      reset();
      controller.sleep(100);
    }
  }

  @Override
  public void passTrack() {
    controller.setSignal(2);
    controller.semaphoreChangeVisible();
    moveTriple(1.3, -0.5, -0.5);
    moveTriple(0.27, -0.26, 0d);
    moveTriple(0.93, -0.47, 0.5);
    moveTriple(1d, 0.3, 0.5);
    moveTriple(0.33, 0.3, 0);
    moveTriple(1d, 0.34, -0.5);
    controller.setSignal(0);
    controller.semaphoreChangeVisible();
  }

}
