package model;

import javafx.scene.image.ImageView;

public class Archer extends BaseCharacter{

  public Archer(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveY(240);
      moveX(-350);
      moveY(120);
      moveX(175);
      moveY(120);
      moveX(175);
      moveY(120);
      moveX(-350);
      moveY(-120);
      moveX(-175);
      moveY(120);
      moveX(-350);
      moveY(-600);
      moveX(875);
    }
  }
  
}
