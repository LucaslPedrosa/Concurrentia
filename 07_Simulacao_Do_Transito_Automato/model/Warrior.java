package model;

import javafx.scene.image.ImageView;

public class Warrior extends BaseCharacter{

  public Warrior(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){

      moveX(175);
      moveY(-240);
      moveX(175);
      moveY(-120);
      moveX(175);  
      moveY(120);
      moveX(175);
      moveY(240);
      moveX(175);
      moveY(-600);
      moveX(-350);
      moveY(120);
      moveX(-175);
      moveY(-120);
      moveX(-350);
      moveY(600);
      
    }
  }
  

  
}
