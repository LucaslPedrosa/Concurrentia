/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: Ninja.java 
 *  
 * 
 *  
 *  Ninja thread is the thread used for simulating Ninja 'car' actions
 * 
 *
 */


package model;


import javafx.scene.image.ImageView;

public class Ninja extends BaseCharacter{

  public Ninja(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      try {
        moveX(175);
        Variables.semaphore[42].release();
        moveX(95);
        Variables.semaphore[7].acquire();
        Variables.semaphore[44].acquire();
        moveX(40);
        moveX(135);
        Variables.semaphore[38].acquire();
        Variables.semaphore[6].acquire();
        moveX(40);
        moveY(40);
        Variables.semaphore[44].release();
        Variables.semaphore[39].release();
        moveY(120);
        Variables.semaphore[6].release();
        Variables.semaphore[7].release();
        moveY(40);
        Variables.semaphore[23].acquire();
        moveY(120);
        Variables.semaphore[40].acquire();
        moveY(40);
        moveX(-40);
        Variables.semaphore[23].release();
        Variables.semaphore[38].release();
        moveX(-95);
        Variables.semaphore[25].acquire();
        moveX(-40);
        moveX(-40);
        Variables.semaphore[40].release();
        moveX(-95);
        Variables.semaphore[12].acquire();
        moveX(-40);
        moveX(-175);
        moveY(-120);
        moveY(-80);
        Variables.semaphore[42].acquire();
        Variables.semaphore[16].acquire();
        moveY(-120);
        Variables.semaphore[39].acquire();
        moveY(-40);
        moveX(40);
        Variables.semaphore[16].release();
        Variables.semaphore[25].release();
        Variables.semaphore[12].release();
        
      } catch (Exception e) {

      }

    }
  }
  
}
