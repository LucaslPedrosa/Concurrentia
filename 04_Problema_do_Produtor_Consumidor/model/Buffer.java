/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 31/03/2022
 *  last change at : 10/04/2022 17:24
 *  Name: Principal.java
 * 
 *  
 *  Buffer class is used to handle concurent problems and make the life safer
 *
 * 
 */

package model;

import java.util.concurrent.Semaphore;

public class Buffer {

  private static final int BUFFER_SIZE = 5; // Oil tank size
  public static Semaphore semaphoreEmpty = new Semaphore(BUFFER_SIZE);  // semaphore used to producers dont produce more than they can
  public static Semaphore semaphoreFull = new Semaphore(0); // semaphore used so consumers dont consume more than they can
  public static Semaphore mutex = new Semaphore(1);  // semaphore used to enter critical region
  public static int liters = 0;

  /**
   * 
   * {@param add : amount of liters it should be added}
   */
  public static void addLiters(int add) {
    liters += add;
  }

}
