package model;

import javafx.scene.image.ImageView;

public class Rogue extends BaseCharacter{

  public Rogue(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveY(240);
      moveX(875);
      moveY(-240);
      moveX(-875);
    }
  }
  
}
