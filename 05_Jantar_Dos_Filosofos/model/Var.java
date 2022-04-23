/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 13/04/2022
 *  last change at : 22/04/2022 01:24
 *  Name: Philosopher.java
 * 
 *  
 *  Var class is responsable to dealing with any concurent problems since it contains every semaphore
 * 
 *
 * 
 */


package model;

import java.util.concurrent.Semaphore;

public class Var {

  public static boolean programRunning = true;  // Loop forever
  public static Semaphore mutex = new Semaphore(1); // ask waiter if picking up a fork is possible
  public static Semaphore philo[] = new Semaphore[6]; // philosophers forks

}
