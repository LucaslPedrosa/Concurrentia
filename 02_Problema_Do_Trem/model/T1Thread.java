package model;

import controller.MainController;
import javafx.scene.image.ImageView;

public class T1Thread extends TrainThread{

  public T1Thread(MainController controller, ImageView image) {
    super(controller,image);
  }

  @Override
  public void run(){
    moveX(-400d);
    passTrack();
    moveY(2d);
    moveX(-335d);
  }

  @Override
  public void passTrack(){

    moveTriple(-1d, 0.4, -0.5);
    moveTriple(-1d, 0.6, 0.5);
    moveTriple(-1.2d, -0.6, 0.5);
    moveTriple(-1d, -0.4, -0.5);

  }
  
}
