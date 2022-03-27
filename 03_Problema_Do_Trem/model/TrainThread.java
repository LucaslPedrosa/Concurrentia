/**
 * @Author : Lucas Pedrosa Larangeira
 * 
 * 
 *  TrainThread should contain every method 
 *  Train 1 thread and Train 2 threads needs 
 *  to work
 * 
 * 
 * 
 */

package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class TrainThread extends Thread {

  protected MainController controller; // the MainController class (should be the same for all threads)
  private ImageView image; // the train image
  private int speed = 10; // the train speed
  private double posX; // the train image X coordinate
  private double posY; // the train image Y coordinate
  private double angle; // the train rotation
  private final double ORIGINAL_POSX; // the original image X coordinate used to restart the train
  private final double ORIGINAL_POSY; // the original image Y coordinate used to restart the train
  private final double ORIGINAL_ANGLE; // the original imge rotate used to restart the train
  protected boolean looping = true; // make the train loop forever

  public TrainThread(MainController controller, ImageView image) {
    this.controller = controller; // set Controller
    this.image = image; // set image
    posX = image.getX(); // set posX
    posY = image.getY(); // set posY
    angle = image.getRotate(); // set angle
    ORIGINAL_POSX = posX; // set original posX
    ORIGINAL_POSY = posY; // set original posY
    ORIGINAL_ANGLE = angle; // set original angle
  }

  /*
   * Method name: run
   * 
   * it should be called whenever TrainThread is started
   * the threads should @Override this method
   * 
   */
  @Override
  public void run() {

  }

  /*
   * Method name: passTrack
   * 
   * it should be called to the trains pass their tracks
   * the threads should @Override this method
   * 
   */
  public void passTrack() {

  }

  /**
   * method name: moveTriple
   * 
   * this method should move equally the three passed arguments
   * this method loops the movement 100 times
   * the loop wait time is defined by the TrainThread.speed atribute
   * 
   * @param x // amount of X-axis movement per loop
   * @param y // amount of Y-axis movement per loop
   * @param r // amount of image rotation per loop
   */

  public void moveTriple(double x, double y, double r) {
    int i = 0;

    while (i < 100) {
      i++;
      trainSleep(speed);
      Platform.runLater(() -> {
        image.setX(image.getX() + x);
        image.setY(image.getY() + y);
        image.setRotate((image.getRotate() + r) % 360);
      });
    }
    posX = image.getX();
    posY = image.getY();
    angle = image.getRotate();
  }

  /**
   * method name: moveX
   * 
   * this method should move the image X coordinate by
   * the amount passed as argument
   * it increases (or decreases) by 1 the image X and loops itself
   * until the image reach final destination
   * 
   * 
   * @param x // amount of X-axis movement
   */

  public void moveX(Double x) {
    double sun = (x < 0 ? -1 : 1);

    while (((sun < 0 && image.getX() > posX + x) || (sun > 0 && image.getX() < posX + x))) {
      trainSleep(speed);
      Platform.runLater(() -> {
        image.setX(image.getX() + sun);
      });
    }

    posX = image.getX();
  }

  /**
   * method name: moveY
   * 
   * this method should move the image Y coordinate by
   * the amount passed as argument
   * it increases (or decreases) by 1 the image Y and loops itself
   * until the image reach final destination
   * 
   * 
   * 
   * @param y // amount of Y-axis movement
   */

  public void moveY(Double y) {
    double sun = (y < 0 ? -1 : 1);

    while (((sun < 0 && image.getY() > posY + y) || (sun > 0 && image.getY() < posY + y))) {
      trainSleep(speed);
      Platform.runLater(() -> {
        image.setY(image.getY() + sun);
      });
    }
    posY = image.getY();
  }

  /**
   * method name: rotate
   * 
   * this method should spin the image rotation coordinate by
   * the amount passed as argument
   * it increases (or decreases) by 1 the image rotation and loops itself
   * until the image reach final destination
   * 
   * 
   * @param direction // the 360 degrees image direction
   */

  public void rotate(double direction) {
    double sun = (direction < 0 ? -1 : 1);
    while (((sun < 0 && image.getRotate() > angle + direction) || (sun > 0 && image.getRotate() < angle + direction))) {
      trainSleep(speed);
      Platform.runLater(() -> {
        image.setRotate((image.getRotate() + sun) % 360);

      });
    }
    angle = image.getRotate();
  }

  /**
   * method name: reset
   * 
   * this method should set the image X, Y , Rotation and all
   * variables to their start values
   * 
   * 
   */

  public void reset() {
    Platform.runLater(() -> {
      image.setRotate(ORIGINAL_ANGLE);
      image.setX(ORIGINAL_POSX);
      image.setY(ORIGINAL_POSY);
    });
    angle = ORIGINAL_ANGLE;
    posY = ORIGINAL_POSY;
    posX = ORIGINAL_POSX;
  }

  /**
   * method name: setSpeed
   * 
   * @param speed
   */

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * method name: trainSleep
   * 
   * Mythologically it is a well known fact that trains do not have the ability to
   * sleep, this method changes everything you know.
   * 
   * @param miliseconds // Amount of time it should sleep
   */

  public void trainSleep(int miliseconds) {
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
      System.out.println("Error in trainSleep " + e.getStackTrace());
    }
  }

}
