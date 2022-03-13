/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Creation : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: ThreadGrandson1.java
 *  Function: ThreadSon3 simulates the Son3 ageing then dying
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

public class ThreadSon3 extends Thread{
  
  /* *ThreadSon3 age starting value */
  private int age = 0;
  /* *This Controller should be the same as MainController used by FX */    
  private MainController controller;


  /*
   *
   * run() method is called whenever ThreadSon3 is started
   * It will age him and create his child
   * 
   * 
   */
  @Override
  public void run(){
    controller.setSon3Visible();
    increaseAge(55);
    System.out.println("Morre o filho 3 aos " + age + " anos");
    controller.killSon3();

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
        controller.setSon3Age(age);
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
