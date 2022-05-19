package model;

import javafx.scene.image.ImageView;

public class Archer extends BaseCharacter {

  public Archer(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Variables.semaphore[24].acquire();
        moveX(-40);
        moveY(120);
        Variables.semaphore[25].acquire();
        moveX(-40);
        Variables.semaphore[24].release();
        moveX(-95);
        Variables.semaphore[11].acquire();
        moveX(-40);
        moveX(-175);
        moveY(-120);
        moveY(-80);
        Variables.semaphore[14].acquire();
        Variables.semaphore[16].acquire();
        moveY(-120);
        Variables.semaphore[13].acquire();
        moveY(-40);
        Variables.semaphore[16].release();
        Variables.semaphore[25].release();
        moveY(-160);
        Variables.semaphore[14].release();
        moveY(-80);
        moveX(50);
        Variables.semaphore[13].release();
        moveX(125);
        moveX(125);
        Variables.semaphore[26].acquire();
        moveX(50);
        Variables.semaphore[11].release();
        moveX(125);
        Variables.semaphore[1].acquire();
        moveX(50);
        moveX(50);
        Variables.semaphore[26].release();
        moveX(125);
        moveX(175);
        moveY(60);
        Variables.semaphore[27].acquire();
        moveY(140);
        Variables.semaphore[20].acquire();
        Variables.semaphore[21].acquire();
        moveY(40);
        moveX(-50);
        Variables.semaphore[1].release();
        Variables.semaphore[27].release();
        moveX(-125);
        moveX(-50);
        Variables.semaphore[21].release();
        moveX(-75);
        Variables.semaphore[5].acquire();
        Variables.semaphore[6].acquire();
        moveX(-50);
        moveY(40);
        Variables.semaphore[20].release();
        moveY(40);
        Variables.semaphore[8].acquire();
        moveY(40);
        moveX(50);
        Variables.semaphore[6].release();
        moveX(75);
        Variables.semaphore[4].acquire();
        moveX(50);
        moveY(40);
        Variables.semaphore[8].release();
        moveY(80);
        moveX(50);
        Variables.semaphore[4].release();
        Variables.semaphore[5].release();
        moveX(75);
        Variables.semaphore[22].acquire();
        Variables.semaphore[3].acquire();
        moveX(50);
        moveY(120);
        moveX(-175);
        moveX(-50);
        Variables.semaphore[3].release();
        moveX(-75);  
        Variables.semaphore[23].acquire();
        moveX(-50);
        moveY(-120);
        moveX(-50);
        Variables.semaphore[23].release();
        Variables.semaphore[22].release();
        moveX(-85);

        


        








      } catch (Exception e) {

      }
    }
  }

}
