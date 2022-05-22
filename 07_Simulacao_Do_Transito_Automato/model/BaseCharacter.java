/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: BaseCharacter.java 
 *  
 * 
 *  
 * 
 * 
 *
 */

package model;

import java.util.concurrent.Semaphore;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 * 
 * BaseCharacter class extends thread and will implement every action used in
 * all classes
 * 
 * @see #moveX(int)
 * @see #moveY(int)
 * @see #changePause()
 */

public class BaseCharacter extends Thread {

  private String name; // class name
  private double x; // x position on FXML
  private double y; // y position on FXML
  private ImageView img; // class image
  private int speed = 5; // class amount of miliseconds waited for each movement of 1 pixel
  private Semaphore isActive = new Semaphore(1); // semaphore required in order to move the character
  private boolean isRunning = true; // is character moving?

  /**
   * BaseCharacter is the main and only constructor that exists in BaseCharacter
   * class, it defines all variables needed
   * 
   * @param name
   *             defines the class name
   * @param img
   *             defines the class image
   */

  public BaseCharacter(String name, ImageView img) {
    this.name = name;
    this.img = img;
    this.x = img.getX();
    this.y = img.getY();
  }

  /**
   * moveX method moves the x coordinate by 1 pixel then waits the miliseconds
   * defined in this.speed variable, it doesnt stop until destination is reached
   * 
   * @param amount
   *               amount of pixels it should move
   */
  public void moveX(int amount) {
    double toSum = (amount > 1 ? 1 : -1);
    double count = 0;

    while (count != amount) {
      acActive();
      setX(getX() + toSum);
      Platform.runLater(() -> {
        img.setX(getX());
      });
      count += toSum;
      toSleeep(getSpeed());
      relActive();
    }
  }

  /**
   * moveY method moves the x coordinate by 1 pixel then waits the miliseconds
   * defined in this.speed variable, it doesnt stop until destination is reached
   * 
   * @param amount
   *               amount of pixels it should move
   */
  public void moveY(int amount) {
    double toSum = (amount > 1 ? 1 : -1);
    double count = 0;

    while (count != amount) {
      acActive();
      setY(getY() + toSum);
      Platform.runLater(() -> {
        img.setY(getY());
      });
      count += toSum;
      toSleeep(getSpeed());
      relActive();
    }
  }

  /**
   * changePause method will whenever a class should be running or not, it
   * acquires the semaphore incase not, and release incase yes
   */
  public void changePause() {
    if (isRunning) {
      acActive();
      System.out.println(this.name + " Is now paused");
    } else {
      relActive();
      System.out.println(this.name + " Is now running");
    }
    changeRunning();
  }

  /**
   * acActive method acquires the isActive semaphore
   * 
   */
  public void acActive() {
    try {
      isActive.acquire();
    } catch (Exception e) {
    }
  }

  /**
   * relActive method releases the isActive semaphore
   * 
   */
  public void relActive() {
    try {
      isActive.release();
    } catch (Exception e) {
    }
  }

  /**
   * toSleeep method is an easier way to call Thread.sleep method
   * it sleeps an determined amount of miliseconds
   * 
   * @param miliseconds
   *                    amount of miliseconds the thread should sleep
   */
  public void toSleeep(int miliseconds) {
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
      System.out.println("Error sleeping in " + name);
    }
  }

  /**
   * run method is called whenever BaseCharacter thread is started
   * 
   */
  @Override
  public void run() {
    System.out.println("eae");
  }

  /**
   * getNeime method should return this.class this.name
   * it is written wrong so it dont cause conflict to thread.getName
   * 
   * @return this.class this.name
   */
  public String getNeime() {
    return this.name;
  }

  /**
   * getX method returns the x coordinate of this.class this.img
   * 
   * @return x coordinate of this.class this.img
   */
  public double getX() {
    return this.x;
  }

  /**
   * getX method returns the y coordinate of this.class this.img
   * 
   * @return y coordinate of this.class this.img
   */
  public double getY() {
    return this.y;
  }

  /**
   * setY method sets the Y coordinate its used for movement illusion
   * 
   * @param y
   *          y coordinate to set on
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * setY method sets the x coordinate its used for movement illusion
   * 
   * @param x
   *          x coordinate to set on
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * getSpeed method is called whenever its needed this.class this.speed
   * 
   * @return speed of this.class
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * setSpeed method is called whenever this.speed is needed
   * 
   * @param spd
   *            the new speed
   */
  public void setSpeed(int spd) {
    this.speed = spd;
  }

  /**
   * changeRunning method changes the current state of this.isRunning to its
   * reverse
   * 
   * 
   */
  public void changeRunning() {
    this.isRunning = !isRunning;
  }

}
