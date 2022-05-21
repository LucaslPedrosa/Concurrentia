package model;

import javafx.scene.image.ImageView;

public class Knight extends BaseCharacter {

  public Knight(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {
        moveX(95);
        Variables.semaphore[30].acquire();
        moveX(40);
        moveX(135);
        Variables.semaphore[29].acquire();
        moveX(40);
        Variables.semaphore[30].release();
        moveX(135);
        Variables.semaphore[31].acquire();
        moveX(40);
        moveX(40);
        Variables.semaphore[29].release();
        moveX(40);
        Variables.semaphore[31].release();
        moveX(95);
        moveX(135);
        Variables.semaphore[2].acquire();
        Variables.semaphore[27].acquire();
        moveX(40);
        moveY(80);
        moveY(40);
        Variables.semaphore[15].acquire();
        moveY(40);
        Variables.semaphore[27].release();
        moveY(40);
        Variables.semaphore[35].acquire();
        moveY(40);
        moveX(-40);
        Variables.semaphore[15].release();
        Variables.semaphore[2].release();
        moveX(-95);
        Variables.semaphore[8].acquire();
        moveX(-80);
        Variables.semaphore[35].release();
        moveX(-135);
        moveX(-40);
        Variables.semaphore[8].release();
        moveX(-95);
        Variables.semaphore[9].acquire();
        moveX(-40);
        moveX(-135);
        Variables.semaphore[34].acquire();
        moveX(-40);
        moveX(-40);
        Variables.semaphore[9].release();
        moveX(-95);
        Variables.semaphore[14].acquire();
        Variables.semaphore[16].acquire();
        moveX(-40);
        moveY(-80);
        Variables.semaphore[33].acquire();
        moveY(-80);
        Variables.semaphore[16].release();
        Variables.semaphore[34].release();
        moveY(-80);
        moveX(40);
        Variables.semaphore[33].release();
        Variables.semaphore[14].release();
      } catch (Exception e) {

      }
    }
  }

}
