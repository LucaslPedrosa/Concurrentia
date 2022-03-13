/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Creation : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: ThreadGrandson1.java
 *  Function: ThreadSon1 simulates the Son1
 *  ageing, having his child and then dying
 * 
 * 
 * 

 * 
*/


package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadSon1 extends Thread{

  /* *Son1 age starting value */
  private int age = 0;
  /* *This Controller should be the same as MainController used by FX */    
  private MainController controller;

  /*
   *
   * run() method is called whenever ThreadSon1 is started
   * It will age him, has his child then die
   * 
   * 
   */
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

  /*
   *  Method name: increaseAge
   *  it should increase int Age by "much"
   *  and sleep the same number of times
   * 
   */
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

  /*
   *  The next lines are just get and set methods
   *  these types are self explanatory
   * 
   * 
   */
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
