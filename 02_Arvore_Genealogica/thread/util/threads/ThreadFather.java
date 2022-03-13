/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Creation : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: ThreadFather.java
 *  Function: ThreadFather simulates the Father having his three 
 *  childs and then proceed to death
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/


package util.threads;

import controller.MainController;
import javafx.application.Platform;

public class ThreadFather extends Thread {

  /* *Father age starting value */
  private int age = 0;

  /* *This Controller should be the same as MainController used by FX */
  private MainController controller;


  /*
   *
   * run() method is called whenever ThreadFather is started
   * It will age the father and create his child Threads
   * 
   * 
   */

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
        controller.setFatherAge(age);
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
