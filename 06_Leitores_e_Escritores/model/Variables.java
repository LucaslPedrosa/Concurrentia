package model;

import java.util.concurrent.Semaphore;

public class Variables {
  static Semaphore mutex = new Semaphore(1);
  static Semaphore wrmutex = new Semaphore(1);


  
}
