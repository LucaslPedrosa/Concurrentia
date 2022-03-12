package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadFather extends Thread {

  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setFatherVisible();

    increaseAge(23); // Father now is 23 years old

    ThreadSon1 son1 = new ThreadSon1();
    son1.setController(controller);
    son1.start();
    System.out.println("O pai tem o primeiro filho aos 23 anos");
    increaseAge(2); // Father now is 25 years old
    ThreadSon2 son2 = new ThreadSon2();
    son2.setController(controller);
    son2.start();
    System.out.println("O pai tem o segundo filho aos 25 anos");
    increaseAge(7); // Father now is 32 years old

    ThreadSon3 son3 = new ThreadSon3();
    son3.setController(controller);
    son3.start();
    System.out.println("O pai tem o terceiro filho aos 32 anos");

    increaseAge(58);
    System.out.println("Pai morre");

  }

  //Methods
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
        controller.setFatherAge(age);
      });
    }

  }

  // gets and sets
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
