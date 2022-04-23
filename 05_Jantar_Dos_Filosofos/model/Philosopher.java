/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 13/04/2022
 *  last change at : 22/04/2022 01:24
 *  Name: Philosopher.java
 * 
 *  
 *  Philosopher class is the model class for any philosopher from the system would like to think / eat politely
 *  what it does is the looping of think/eat and resolves any concurency problems
 * 
 *
 * 
 */

package model;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Philosopher extends Thread {

  private String name; // Philosopher name
  private int index; // Philosopher position
  private ImageView rightFork; // the fork on his right
  private ImageView leftFork; // the fork on his left
  private int eatSpeed = 1000; // the amount of miliseconds it should take to eat
  private int thinkSpeed = 1000; // the amount of miliseconds it should take to think
  private Label message; // the message displayed on his label

  /**
   * Philosopher construct is the main Philosopher construct class
   * it should set all variables to its params
   * 
   * 
   * 
   * @param name      the philosopher name
   * @param index     the philosopher index
   * @param rightFork the philosopher fork on the right
   * @param leftFork  the philosopher fork on the left
   * @param message   the philosopher actual status message
   */
  public Philosopher(String name, int index, ImageView rightFork, ImageView leftFork, Label message) {
    this.name = name;
    this.rightFork = rightFork;
    this.leftFork = leftFork;
    this.index = index;
    this.message = message;
  }

  /**
   * run method overrides thread.run method
   * and its called whenever the philosopher is started
   * this method will think for an certain amount of time, then try to eat and
   * after that restart everything
   * 
   */
  @Override
  public void run() {
    while (Var.programRunning) {
      try {
        toThink(); // Philosopher thinking
        toEat(); // Philosopher eating
        toSleep(200); // wait to restart
      } catch (Exception e) {
        System.out.println("Uncatchable error");

      }
    }
  }

  /**
   * toThink method is the method called whenever the sages are meant to think
   * they set their status to sleeping and then begin to sleep
   * 
   * 
   */
  public void toThink() {
    try {
      System.out.println(name + ": como vou entender um meme sem eis que???? (pensando)");
      toSleep(thinkSpeed);
    } catch (Exception e) {
      System.out.println("Erro pensando");
    }
  }

  /**
   * toEat method is called whenever the sages are meant to eat
   * they set their status to hungry, then try to get their forks.
   * if they cant get the forks they will wait until its avaliable
   * when avaliable they will eat a lot of food
   * 
   * 
   */

  public void toEat() {

    try {
      System.out.println(name + ": EU MATARIA UM HOMEM DE TANTA FOME!");
      double colors[] = { 0.127, 0.255, 0 }; // the colors for hungry
      setMessage("Faminto", colors); // set on hungry message

      Var.mutex.acquire(); // critical region: only one philosopher can take the forks per time
      Var.philo[index].acquire(); // first fork be taken
      Var.philo[((index + 1) % 5)].acquire(); // second fork be taken
      Var.mutex.release();// exit critical region

      colors[0] = 0.220; // set un the colors for eating
      colors[1] = 0.20;
      colors[2] = 0.60;
      System.out.println(name + ": Estou me alimentando");
      setMessage("Comendo", colors); // set up eating msg
      Platform.runLater(() -> {
        rightFork.setVisible(false); // the forks are gone
        leftFork.setVisible(false);
      });

      toSleep(eatSpeed); // sleeps

      Platform.runLater(() -> {
        rightFork.setVisible(true); // he is finished eating
        leftFork.setVisible(true);
      });

      colors[0] = 0.139;
      colors[1] = 0.0;
      colors[2] = 0.139;
      setMessage("Pensando", colors); // set thinking status

      Var.philo[index].release(); // this fork is now avaliable
      Var.philo[((index + 1) % 5)].release(); // this fork is now avaliable

    } catch (Exception e) {
      System.out.println(e.getStackTrace());
      System.out.println("Erro comendo");
    }
  }

  /**
   * toSleep method is just a fast way to try-catch a Thread.sleep method, it
   * works just fine as Thread.sleep but it pullute less the screen
   * 
   * @param mili : the amount of miliseconds the thread will sleep
   */

  public void toSleep(int mili) {
    try {
      Thread.sleep(mili);
    } catch (Exception e) {
      System.out.println("Error in " + name);
    }

  }

  /**
   * setMessage method changes the screen
   * 
   * @param value  the message to set on status
   * @param colors the rgb colors from 0 to 1
   */

  public void setMessage(String value, double[] colors) {
    Platform.runLater(() -> {
      message.setText(value);
      message.setTextFill(Color.color(colors[0], colors[1], colors[2]));
    });
  }

  /**
   * setEatSpeed method will set the philosopher eat speed
   * 
   * @param speed amount of milseconds the sage will take eating
   */

  public void setEatSpeed(int speed) {
    try {
      this.eatSpeed = speed;
      System.out.println(name + " velocidade comente esta a : " + speed);
    } catch (Exception e) {
      System.out.println("Error in eat speed");
    }
  }

  /**
   * setThinkSpeed method will se the philosopher think speed
   * 
   * @param speed amount of miliseconds the sage will take eating
   */
  public void setThinkSpeed(int speed) {
    try {
      this.thinkSpeed = speed;
      System.out.println(name + " velocidade pensante esta a : " + speed);
    } catch (Exception e) {
      System.out.println("Error in sleep speed");
    }
  }

}
