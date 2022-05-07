package model;

import java.util.concurrent.Semaphore;

public class Variables {
  static Semaphore mutex = new Semaphore(1);
  static Semaphore wrmutex = new Semaphore(1);

  static private int readers = 0;


  public static int getReaders(){
    return readers;
  }

  public static void increaseReaders(){
    readers++;
  }

  public static void decreaseReaders(){
    readers--;
  }

  
}
