package model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Philosopher extends Thread {

  private String name;
  private int index;
  private ImageView rightFork;
  private ImageView leftFork;
  private int eatSpeed = 1000;
  private int thinkSpeed = 1000;
  private Label message;

  public Philosopher(String name, int index, ImageView rightFork, ImageView leftFork, Label message) {
    this.name = name;
    this.rightFork = rightFork;
    this.leftFork = leftFork;
    this.index = index;
    this.message = message;
  }

  public void run() {
    while (Var.programRunning) {
      toThink();
      toEat();
      toSleep(200);
    }
  }

  public void toThink() {
    try {
      setMessage("Pensando");
      System.out.println(name + ": como vou entender um meme sem eis que???? (pensando)");
      toSleep(thinkSpeed);
    } catch (Exception e) {
      System.out.println("Erro pensando");
    }
  }

  public void toEat() {
    System.out.println(name + ": EU MATARIA UM HOMEM DE TANTA FOME!");
    setMessage("Faminto");
    try {
      Var.mutex.acquire();
      System.out.println(name + ": Estou me alimentando");
      Var.philo[index].acquire();
      Var.philo[((index + 1) % 5)].acquire();
      Var.mutex.release();
      setMessage("Comendo");

      rightFork.setVisible(false);
      leftFork.setVisible(false);

      toSleep(eatSpeed);

      rightFork.setVisible(true);
      leftFork.setVisible(true);

      Var.philo[index].release();
      Var.philo[((index + 1) % 5)].release();

    } catch (Exception e) {
      System.out.println(e.getStackTrace());
      System.out.println("Erro comendo");
    }
  }

  public void toSleep(int mili) {
    try {
      Thread.sleep(mili);
    } catch (Exception e) {
      System.out.println("Error in " + name);
    }

  }

  public void setMessage(String value) {
    Platform.runLater(() -> {
      message.setText(value);
    });
  }

  public void setEatSpeed(int speed){
    this.eatSpeed = speed;
    System.out.println(name + " velocidade comente esta a : " + speed);

  }

  public void setThinkSpeed(int speed){
    this.thinkSpeed = speed;
    System.out.println(name + " velocidade pensante esta a : " + speed);
  }

  /**
   * Next methods are getters and setters
   * 
   */

}
