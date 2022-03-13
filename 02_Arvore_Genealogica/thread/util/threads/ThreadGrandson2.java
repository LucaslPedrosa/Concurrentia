/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Creation : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: ThreadGrandson2.java
 *  Function: ThreadGrandson2 simulates the Grandson2 dying
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

public class ThreadGrandson2 extends Thread{

  /* *Grandson2 age starting value */
  private int age = 0;

  /* *This Controller should be the same as MainController used by FX */    
  private MainController controller;


  /*
   *
   * run() method is called whenever ThreadGrandson2 is started
   * It will age him and then die
   * 
   * 
   */
  @Override
  public void run(){
    controller.setGrandson2Visible();
    increaseAge(33);
    System.out.println("Morre o segundo neto aos " + age + " anos");
    controller.killGrandson2();

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
        controller.setGrandson2Age(age);
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
