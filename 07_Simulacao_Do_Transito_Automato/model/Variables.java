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
     * so in matter to make the program run, the semaphore of theirs critical
     * regions start at 0
     * 
     */

    // Mage start here:
    semaphore[38] = new Semaphore(0);

    // Rogue start here:
    semaphore[41] = new Semaphore(0);
    semaphore[13] = new Semaphore(0);

    // Ninja start here:
    semaphore[39] = new Semaphore(0);
    semaphore[42] = new Semaphore(0);

    /**
     * Some regions can be acessed by two 'cars' but it may occur a deadlock if
     * more cars enter it
     * 
     */

     semaphore[45] = new Semaphore(2);
  }

}
