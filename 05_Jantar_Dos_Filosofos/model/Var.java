package model;

import java.util.concurrent.Semaphore;

public class Var {

  public static boolean programRunning = true;
  public static Semaphore mutex = new Semaphore(1); 
  public static Semaphore philo[] = new Semaphore[5];

  public static int philosophersStates[] = {0,0,0,0,0};


  
}
