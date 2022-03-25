package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class TrainThread extends Thread {

  private MainController controller;
  private ImageView image;
  private int speed = 90;
  private double posX;
  private double posY;
  private double angle;

  public TrainThread(MainController controller, ImageView image) {
    this.controller = controller;
    this.image = image;
    posX = image.getX();
    posY = image.getY();
    angle = image.getRotate();
  }

  /*
   * Method name: run
   *
   * it should be called whenever TrainThread is started
   * 
   * 
   */
  @Override
  public void run() {

  }

  public void passTrack(){
    
  }

  public void moveTriple(double x, double y, double r){
    int i = 0;

    while (i < 100) {
      i++;
      try { Thread.sleep((10)); } catch (Exception e) {}

      Platform.runLater(() -> {
        image.setX(image.getX()+x);
        image.setY(image.getY()+y);
        image.setRotate((image.getRotate()+r)%360);
      });
    }
    posX = image.getX();
    posY = image.getY();
    angle = image.getRotate();
  }

  public void moveX(Double x) {
    double sun = (x < 0 ? -1 : 1);

    while (((sun < 0 && image.getX() > posX+x) || (sun > 0 && image.getX() < posX + x))) {
      try {
        Thread.sleep((10));
      } catch (Exception e) {
      }
      Platform.runLater(() -> {
        image.setX(image.getX() + sun);
      });
    }

    posX = image.getX();
  }

  public void moveY(Double y) {
    double sun = (y < 0 ? -1 : 1);

    while (((sun < 0 && image.getY() > posY+y) || (sun > 0 && image.getY() < posY + y))) {
      try {
        Thread.sleep((10));
      } catch (Exception e) {
      }
      Platform.runLater(() -> {
        image.setY(image.getY() + sun);
      });
    }
    posY = image.getY();
  }

  public void rotate(double direction){
    double sun = (direction < 0 ? -1 : 1);
    while(((sun < 0 && image.getRotate() > angle+direction) || (sun > 0 && image.getRotate() < angle + direction))){
      try{
        Thread.sleep(10);
      }catch(Exception e){}
      Platform.runLater(() -> {
        image.setRotate((image.getRotate() + sun)%360);

      });
    }
    angle = image.getRotate();
  }

}
