package model;

import java.util.concurrent.Semaphore;

public class Variables {

  private static final int TOTAL_SEMAPHORES = 50; // We create semaphores with one more than necessary because im not
                                                  // very into doing little subtractions while coding

  public static Semaphore semaphore[] = new Semaphore[TOTAL_SEMAPHORES];

  public static void setUpSemaphores() {
    for (int i = 0; i < TOTAL_SEMAPHORES; i++) {
      semaphore[i] = new Semaphore(1);
    }
    /**
     * some "cars" are unable to start at a non critical region
     * so in matter to make the program run, the semaphore of theirs critical regios
     * start at 0 mutex
     * 
     */
    semaphore[13] = new Semaphore(0);
    semaphore[38] = new Semaphore(0);
    semaphore[39] = new Semaphore(0);
    semaphore[41] = new Semaphore(0);
  }

}
