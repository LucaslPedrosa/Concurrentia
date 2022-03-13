package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadGreatGrandson extends Thread{
  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setGreatGrandsonVisible();
    increaseAge(12);
    System.out.println("Morre aos " + age + " anos o bisneneto");
    controller.killGreatGrandson();
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
        controller.setGreatGrandsonAge(age);
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
