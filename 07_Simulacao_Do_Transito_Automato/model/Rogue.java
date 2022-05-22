/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: Rogue.java 
 *  
 * 
 *  
 *  Rogue thread is the thread used for simulating Rogue 'car' actions
 * 
 *
 */

package model;

import javafx.scene.image.ImageView;

public class Rogue extends BaseCharacter {

  public Rogue(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {

        moveX(-40);
        moveY(80);
        Variables.semaphore[33].acquire();
        moveY(120);
        Variables.semaphore[39].acquire();
        Variables.semaphore[43].acquire();
        moveY(40);
        moveX(40);
        Variables.semaphore[33].release();
        Variables.semaphore[13].release();
        Variables.semaphore[41].release();
        moveX(175);
        Variables.semaphore[43].release();
        moveX(95);
        Variables.semaphore[44].acquire();
        moveX(40);
        moveX(135);
        Variables.semaphore[41].acquire();
        Variables.semaphore[20].acquire();
        moveX(40);
        moveX(40);
        Variables.semaphore[39].release();
        Variables.semaphore[44].release();
        moveX(95);
        Variables.semaphore[21].acquire();
        moveX(40);
        moveX(135);
        Variables.semaphore[1].acquire();
        Variables.semaphore[36].acquire();
        Variables.semaphore[27].acquire();
        moveX(40);
        moveY(-40);
        Variables.semaphore[20].release();
        Variables.semaphore[21].release();
        moveY(-120);
        Variables.semaphore[27].release();
        moveY(-80);
        moveX(-40);
        Variables.semaphore[36].release();
        moveX(-175);
        moveX(-95);
        Variables.semaphore[26].acquire();
        moveX(-80);
        Variables.semaphore[1].release();
        moveX(-95);
        Variables.semaphore[13].acquire();
        moveX(-40);
        moveX(-40);
        Variables.semaphore[26].release();
        moveX(-135);
        moveX(-135);

      } catch (Exception e) {

      }

    }
  }

}
