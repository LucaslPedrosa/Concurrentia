package model;

import java.util.concurrent.Semaphore;

public class Buffer {

  private static final int BUFFER_SIZE = 20;
  public static Semaphore semaphoreEmpty = new Semaphore(BUFFER_SIZE);
  public static Semaphore semaphoreFull = new Semaphore(0);
  public static Semaphore mutex = new Semaphore(1);
  
}
