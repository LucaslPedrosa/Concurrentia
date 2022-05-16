package model;

import javafx.scene.image.ImageView;

public class Ninja extends BaseCharacter{

  public Ninja(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveX(525);
      moveY(360);
      moveX(-525);
      moveY(-360);
    }
  }
  
}
