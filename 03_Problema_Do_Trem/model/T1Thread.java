/**
 * 
 * @Author Lucas Pedrosa Larangeira
 * 
 * 
 * 
 * T1Thread is responsible for moving and making decisions 
 * made by the number one train
 * 
 */

package model;

import controller.MainController;
import javafx.scene.image.ImageView;

public class T1Thread extends TrainThread {

  public T1Thread(MainController controller, ImageView image) { // Start T1Thread
    super(controller, image);
  }
  

  /**
   * method name: run
   * 
   * this is a method is a list everything the train 1 thread
   * should do whenever is started
   * 
   */
  @Override
  public void run() {
    while (looping) {
      moveX(-400d); // move image X by -400 double
      controller.checkSignal(); // check if the mid track is being used
      passTrack();  // pass the track
      moveY(2d);  // adjust just a little bit to the track
      moveX(-335d); // move image x by -335 double
      reset();  // reset
      controller.sleep(200);  // wait a little bit so dont ocurrs erros
    }
  }


  /**
   * method name: passTrack
   * 
   * 
   * this method should put the train to pass the track
   * and set it as ocupied or used
   * 
   */

  @Override
  public void passTrack() {
    controller.setSignal(1);  // train 1 is using the track
    controller.semaphoreChangeVisible();  // change visible to true
    moveTriple(-1d, 0.4, -0.5); // move triple x y r
    moveTriple(-1d, 0.6, 0.5);
    moveTriple(-1.2d, -0.6, 0.5);
    moveTriple(-1d, -0.4, -0.5);
    controller.setSignal(0);  // no one is using the track
    controller.semaphoreChangeVisible();  // change visible to false
  }

}
