package model;

import javafx.scene.image.ImageView;

public class Knight extends BaseCharacter{

  public Knight(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveX(875);
      moveY(240);
      moveX(-875);
      moveY(-240);
    }
  }
  
}
