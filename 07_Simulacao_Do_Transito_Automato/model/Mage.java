package model;

import javafx.scene.image.ImageView;

public class Mage extends BaseCharacter{

  public Mage(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveY(-600);
      moveX(350);
      moveY(600);
      moveX(-350);
    }
  }
  
}
