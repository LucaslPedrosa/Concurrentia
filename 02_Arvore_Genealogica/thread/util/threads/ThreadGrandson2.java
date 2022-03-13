package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadGrandson2 extends Thread{
  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setGrandson2Visible();
    increaseAge(33);
    System.out.println("Morre o segundo neto aos " + age + " anos");
    controller.killGrandson2();

  }

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
        controller.setGrandson2Age(age);
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
