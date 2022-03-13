package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadSon1 extends Thread{

  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setSon1Visible();
    increaseAge(16);

    ThreadGrandson1 grandSon1 = new ThreadGrandson1();
    grandSon1.setController(controller);
    grandSon1.start();
    System.out.println("Nasce o neto 1");

    increaseAge(45);
    System.out.println("Primeiro filho morre aos " + age + " anos");
    controller.killSon1();
  }

  // Methods

  public void increaseAge(int much){
    much += age;
    while(age < much){
      try{
      Thread.sleep(1000);
      }catch(Exception e){
        System.out.println("Error ageing");
      }
      setAge((getAge()+1));
      Platform.runLater( () -> {
        controller.setSon1Age(age);
      });
    }
  }

  //gets and sets
  public void setController(MainController controller){
    this.controller = controller;
  }

  public int getAge(){
    return this.age;
  }

  public void setAge(int age){
    this.age = age;
  }
  
}
