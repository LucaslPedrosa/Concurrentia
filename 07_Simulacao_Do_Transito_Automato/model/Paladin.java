package model;

import javafx.scene.image.ImageView;

public class Paladin extends BaseCharacter {

  public Paladin(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {

        moveX(-95);
        Variables.semaphore[10].acquire();
        moveX(-40);
        moveY(-80);
        Variables.semaphore[34].acquire();
        moveY(-40);
        moveX(-40);
        Variables.semaphore[10].release();
        moveX(-95);
        Variables.semaphore[42].acquire();
        Variables.semaphore[16].acquire();
        moveX(-40);
        moveY(-80);
        Variables.semaphore[43].acquire();
        moveY(-40);
        moveX(40);
        Variables.semaphore[16].release();
        Variables.semaphore[34].release();
        moveX(135);
        moveY(-40);
        Variables.semaphore[43].release();
        Variables.semaphore[42].release();
        moveY(-40);
        Variables.semaphore[30].acquire();
        moveY(-40);
        moveX(135);
        Variables.semaphore[17].acquire();
        moveX(40);
        moveY(-40);
        Variables.semaphore[30].release();
        moveY(-40);
        Variables.semaphore[26].acquire();
        moveY(-40);
        moveX(40);
        moveX(95);
        Variables.semaphore[31].acquire();
        Variables.semaphore[18].acquire();
        Variables.semaphore[17].release();
        moveX(40);
        moveY(40);
        Variables.semaphore[26].release();
        moveY(80);
        moveX(40);
        Variables.semaphore[18].release();
        moveX(135);
        moveY(40);
        Variables.semaphore[31].release();
        moveY(40);
        Variables.semaphore[21].acquire();
        moveY(40);
        moveX(135);
        Variables.semaphore[15].acquire();
        moveX(40);
        moveY(40);
        Variables.semaphore[21].release();
        moveY(40);
        Variables.semaphore[35].acquire();
        moveY(40);
        moveX(-40);
        Variables.semaphore[15].release();
        moveX(-95);
        Variables.semaphore[4].acquire();
        moveX(-40);
        moveY(40);
        Variables.semaphore[35].release();
        moveY(80);
        moveX(-40);
        Variables.semaphore[4].release();
        moveX(-95);
        Variables.semaphore[23].acquire();
        moveX(-40);
        moveY(80);
        Variables.semaphore[40].acquire();
        moveY(40);
        moveX(-40);
        Variables.semaphore[23].release();
        moveX(-95);
        Variables.semaphore[24].acquire();
        moveX(-40);
        moveY(-40);
        Variables.semaphore[40].release();
        moveY(-80);
        moveX(-40);
        Variables.semaphore[24].release();

      } catch (Exception e) {

      }

    }
  }

}
