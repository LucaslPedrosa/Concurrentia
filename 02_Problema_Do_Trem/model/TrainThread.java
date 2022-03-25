package model;

import java.util.concurrent.Semaphore;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class TrainThread extends Thread {

  protected MainController controller;
  private ImageView image;
  private int speed = 10;
  private double posX;
  private double posY;
  private double angle;
  private final double ORIGINAL_POSX;
  private final double ORIGINAL_POSY;
  private final double ORIGINAL_ANGLE;
  protected boolean looping = true;

  public TrainThread(MainController controller, ImageView image) {
    this.controller = controller;
    this.image = image;
    posX = image.getX();
    posY = image.getY();
    angle = image.getRotate();
    ORIGINAL_POSX = posX;
    ORIGINAL_POSY = posY;
    ORIGINAL_ANGLE = angle;
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
      try { Thread.sleep((speed)); } catch (Exception e) {}

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
        Thread.sleep(speed);
      } catch (Exception e) {
        System.out.println("Erro no moveX: " + e.getStackTrace());
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
        Thread.sleep((speed));
      } catch (Exception e) {
        System.out.println("Erro no moveY: " + e.getStackTrace());
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
        Thread.sleep(speed);
      }catch(Exception e){}
      Platform.runLater(() -> {
        image.setRotate((image.getRotate() + sun)%360);

      });
    }
    angle = image.getRotate();
  }

  public void reset(){
    Platform.runLater(() -> {
      image.setRotate(ORIGINAL_ANGLE);
      image.setX(ORIGINAL_POSX);
      image.setY(ORIGINAL_POSY);
    });
    angle = ORIGINAL_ANGLE;
    posY = ORIGINAL_POSY;
    posX = ORIGINAL_POSX;
  }

  public void setSpeed(int speed){
    this.speed = speed;
  }


}
