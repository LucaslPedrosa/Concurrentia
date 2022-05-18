package model;


import java.util.concurrent.Semaphore;

import javafx.scene.image.ImageView;

public class Warrior extends BaseCharacter{

  public Warrior(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run(){
    while(true){
      try {
        moveY(-120);
        // Critical Region: Semaphore 10
        Variables.semaphore[10].acquire();
        moveY(-120);
        //Critical Region: Semaphore 9
        Variables.semaphore[9].acquire();
        moveX(25);
        //We no longer need to wait on road 10, this means semaphore 10 is no more
        Variables.semaphore[10].release();
        moveX(150);
        moveY(-20);
        //Semaphore 9 is no more
        Variables.semaphore[9].release();
        moveY(-80);

        Variables.semaphore[7].acquire();
        moveY(-20);
        moveX(150);
        Variables.semaphore[5].acquire();
        // We need to get the bigger semaphore first, so deadlocks dont ocurr
        Variables.semaphore[6].acquire();
        moveX(25);
        moveY(100);
        Variables.semaphore[8].acquire();
        // We can now enter road 8
        moveY(20);
        moveX(25);
        Variables.semaphore[6].release();
        Variables.semaphore[7].release();
        // Road 6 is no more
        moveX(125);
        Variables.semaphore[4].acquire();
        // We can now enter road 4
        moveX(25);
        moveY(20);
        Variables.semaphore[8].release();
        moveY(100);
        Variables.semaphore[4].release();
        // Road 4 is no more
        Variables.semaphore[5].release();
        // Big road 5 is no more
        moveY(100);
        Variables.semaphore[3].acquire();
        // We can now use road 3
        moveX(175);
        moveY(-120);
        moveY(-20);
        Variables.semaphore[3].release();
        //Semaphore 3 is no more
        moveY(-80);
        Variables.semaphore[2].acquire();
        Variables.semaphore[15].acquire();
        moveY(-120);
        Variables.semaphore[1].acquire();
        moveY(-20);
        Variables.semaphore[15].release();
        moveY(-140);
        Variables.semaphore[2].release();
        moveY(-100);
        moveX(-350);
        Variables.semaphore[1].release();
        moveY(120);
        moveX(-175);
        moveY(-100);
        Variables.semaphore[11].acquire();
        moveY(-20);
        moveX(-320);
        Variables.semaphore[13].acquire();
        moveX(-30);
        moveY(100);
        Variables.semaphore[14].acquire();
        moveY(120);
        Variables.semaphore[12].acquire();
        Variables.semaphore[16].acquire();
        moveY(20);
        Variables.semaphore[13].release();
        moveY(120);
        Variables.semaphore[14].release();
        Variables.semaphore[16].release();
        moveY(240);
        moveX(25);
        Variables.semaphore[12].release();
        moveX(150);
        Variables.semaphore[11].release();

      } catch (Exception e) {

      }




      
    }
  }
  

  
}
