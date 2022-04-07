package model;

import controller.MainController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GasStation extends Thread{

  private ImageView img;
  private MainController controller;
  private int speed = 1000;
  private boolean online = true;  

  public GasStation(ImageView img, MainController controller){
    this.img = img;
    this.controller = controller;
  }

  @Override
  public void run(){
    try {
      while (online) {
        moveCar();
        consume();
        reset();
        wait(500);
      }
    
    } catch (Exception e) {
      System.out.println("Consumption error");
    }

  }

  public void moveCar(){

  }

  public void consume(){

  }

  public void reset(){

  }
  
}
