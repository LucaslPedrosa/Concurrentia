package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadSon2 extends Thread{
  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setSon2Visible();

    increaseAge(20);

    ThreadGrandson2 grandson2 = new ThreadGrandson2();
    grandson2.setController(controller);
    grandson2.start();

    System.out.println("Nasce o segundo neto");

    increaseAge(35);

    System.out.println("Segundo filho morre aos 55 anos");

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
        controller.setSon2Age(age);
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
