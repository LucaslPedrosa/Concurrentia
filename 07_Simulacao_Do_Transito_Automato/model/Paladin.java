package model;

import javafx.scene.image.ImageView;

public class Paladin extends BaseCharacter{

  public Paladin(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      moveY(-120);
      moveX(-175);
      moveY(-120);
      moveX(-175);
      moveY(-120);
      moveX(175);
      moveY(-120);
      moveX(175);
      moveY(-120);
      moveX(175);
      moveY(120);
      moveX(175);
      moveY(120);
      moveX(175);
      moveY(120);
      moveX(-175);
      moveY(120);
      moveX(-175);
      moveY(120);
      moveX(-175);

    }
  }
  
}
