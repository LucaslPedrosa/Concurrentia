package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadFather extends Thread {

  private int age = 0;
  private MainController controller;

  @Override
  public void run(){
    controller.setFatherVisible();

    increaseAge(22); // Father now is 22 years old

    ThreadSon1 son1 = new ThreadSon1(); // Son thread created
    son1.setController(controller); // Son controller set
    son1.start(); // start of son thread
    System.out.println("O pai tem o primeiro filho aos " + age + " anos");
    
    increaseAge(3); // Father now is 25 years old
    
    ThreadSon2 son2 = new ThreadSon2(); //Son 2 thread created
    son2.setController(controller); // son controller set
    son2.start(); // Son 2 start
    System.out.println("O pai tem o segundo filho aos " + age + " anos");
    
    increaseAge(7); // Father now is 32 years old

    ThreadSon3 son3 = new ThreadSon3(); // Third and last son
    son3.setController(controller); // Controller set
    son3.start(); // start of thread
    System.out.println("O pai tem o terceiro filho aos " + age + " anos");

    increaseAge(58);  // last years
    System.out.println("Pai morre aos " + age + " anos");
    controller.killFather(); // this should change the father img

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
