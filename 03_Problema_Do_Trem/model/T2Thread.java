/**
 * 
 * @Author : Lucas Pedrosa Larangeira
 * 
 * 
 * 
 * 
 * T2Thread is responsible for moving and making decisions 
 * made by the number two train
 * 
 */

package model;

import controller.MainController;
import javafx.scene.image.ImageView;

public class T2Thread extends TrainThread {

  public T2Thread(MainController controller, ImageView image) {
    super(controller, image);
  }

  /**
   * method name: run
   * 
   * this is a method is a list everything the train 2 thread
   * should do whenever is started
   * 
   */

  @Override
  public void run() {
    while (looping) {
      moveX(+300d); // move Train 2 image by 300 double
      controller.checkSignal(); // check if track is being used
      passTrack();  // pass the track
      moveY(2d);  // adjust the train a little bit
      moveX(+400d); // move Train 2 image by 400 double
      reset();  // reset
      controller.sleep(200);  // wait a little so erros dont occur
    }
  }

  @Override
  public void passTrack() {
    controller.setSignal(2);  // train 2 is using the track
    controller.semaphoreChangeVisible();  // set semaphore visible to true
    moveTriple(1.3, -0.5, -0.5);  // move triple x y r
    moveTriple(0.27, -0.26, 0d);
    moveTriple(0.93, -0.47, 0.5);
    moveTriple(1d, 0.3, 0.5);
    moveTriple(0.33, 0.3, 0);
    moveTriple(1d, 0.34, -0.5);
    controller.setSignal(0);  // no one is using the track
    controller.semaphoreChangeVisible();  // change semaphore visible to false
  }

}
