/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: Warrior.java 
 *  
 * 
 *  
 *  Warrior thread is the thread used for simulating Warrior 'car' actions
 * 
 *
 */

package model;

import javafx.scene.image.ImageView;

public class Warrior extends BaseCharacter {

  public Warrior(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {
        moveY(-40);
        // Critical Region: Semaphore 10
        Variables.semaphore[10].acquire();
        moveY(-40);
        moveY(-80);
        // Critical Region: Semaphore 9
        Variables.semaphore[9].acquire();
        moveY(-40);
        moveX(40);
        // We no longer need to wait on road 10, this means semaphore 10 is no more
        Variables.semaphore[10].release();
        moveX(135);
        moveY(-40);
        // Semaphore 9 is no more
        Variables.semaphore[9].release();
        moveY(-40);
        // its needed semaphore 7 and 44
        Variables.semaphore[7].acquire();
        Variables.semaphore[44].acquire();
        moveY(-40);
        moveX(135);
        Variables.semaphore[5].acquire();
        // We need to get the bigger semaphore first, so deadlocks dont ocurr
        Variables.semaphore[6].acquire();
        moveX(40);
        moveY(40);
        Variables.semaphore[44].release();
        moveY(40);
        Variables.semaphore[8].acquire();
        // We can now enter road 8
        moveY(40);
        moveX(40);
        Variables.semaphore[6].release();
        Variables.semaphore[7].release();
        // Road 6 is no more
        moveX(95);
        Variables.semaphore[4].acquire();
        // We can now enter road 4
        moveX(40);
        moveY(40);
        Variables.semaphore[8].release();
        moveY(80);
        moveY(40);
        Variables.semaphore[4].release();
        // Road 4 is no more
        Variables.semaphore[5].release();
        // Big road 5 is no more
        moveY(40);
        Variables.semaphore[37].acquire();
        Variables.semaphore[3].acquire();
        moveY(40);
        // We can now use road 3
        moveX(175);
        moveY(-120);
        moveY(-40);
        Variables.semaphore[3].release();
        // Semaphore 3 is no more
        moveY(-40);
        Variables.semaphore[45].acquire();
        Variables.semaphore[2].acquire();
        Variables.semaphore[15].acquire();
        moveY(-40);
        moveY(-40);
        Variables.semaphore[1].acquire();
        Variables.semaphore[27].acquire();
        moveY(-40);
        moveY(-40);
        Variables.semaphore[15].release();
        moveY(-120);
        Variables.semaphore[27].release();
        Variables.semaphore[2].release();
        moveY(-40);
        moveY(-80);
        moveX(-310);
        Variables.semaphore[18].acquire();
        moveX(-40);
        moveY(20);
        Variables.semaphore[37].release();
        Variables.semaphore[1].release();
        Variables.semaphore[45].release();
        moveY(60);
        Variables.semaphore[29].acquire();
        moveY(40);
        moveX(-40);
        Variables.semaphore[18].release();
        moveX(-95);
        Variables.semaphore[17].acquire();
        moveX(-40);
        moveY(-40);
        Variables.semaphore[29].release();
        moveY(-40);
        Variables.semaphore[11].acquire();
        Variables.semaphore[13].acquire();
        moveY(-40);
        moveX(-40);
        Variables.semaphore[17].release();
        moveX(-310);
        moveY(80);
        Variables.semaphore[14].acquire();
        Variables.semaphore[33].acquire();
        moveY(80);
        moveY(40);
        Variables.semaphore[12].acquire();
        Variables.semaphore[16].acquire();
        moveY(40);
        moveY(40);
        Variables.semaphore[33].release();
        Variables.semaphore[13].release();
        moveY(80);
        moveY(40);
        Variables.semaphore[14].release();
        Variables.semaphore[16].release();
        moveY(200);
        moveX(40);
        moveX(135);
        moveY(-40);
        Variables.semaphore[12].release();
        Variables.semaphore[11].release();

      } catch (Exception e) {

      }

    }
  }

}
