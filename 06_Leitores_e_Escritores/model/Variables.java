/**
 * @Author: Lucas Pedrosa Larangeira
 * 
 * 
 *
 *  Variables class is responsable for holding Semaphores
 *  used from all threads in a static way, also it counts the amount of readers
 * 
 * 
 * 
 * 
 */

package model;

import java.util.concurrent.Semaphore;

public class Variables {
  static Semaphore mutex = new Semaphore(1);  //mutex for acessing readers
  static Semaphore wrmutex = new Semaphore(1);  // mutex for acessing server

  static private int readers = 0; //amount of readers reading


  /**
   * method getReaders just returns {@value readers} int
   * 
   * {@return} this return the readers variable
   */
  public static int getReaders() {
    return readers;
  }

  /**
   * increase readers method will add one to readers variable
   * 
   */
  public static void increaseReaders() {
    readers++;
  }

  /**
   * decrease readers methdo will remove one from readers variable
   * 
   */

  public static void decreaseReaders() {
    readers--;
  }

}
