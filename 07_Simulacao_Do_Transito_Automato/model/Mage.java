package model;

import javafx.scene.image.ImageView;

public class Mage extends BaseCharacter{

  public Mage(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      try {
        Variables.semaphore[22].acquire();
        Variables.semaphore[23].acquire();
        moveY(40);
        moveY(120);
        moveX(40);
        Variables.semaphore[23].release();
        
        moveX(95);
        
      } catch (Exception e) {
      }
    }
  }
  
}
