/*  Copyright (c), all rights of the music are reserved to Hans Zimmer and John Powell
 *
 *  @author Lucas Pedrosa Larangeira.
 *
*/
  

package controller;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Music {

  /*  This class will be used to display by a static method the music
   *  i choose for the game. it may there be a problem with some
   *  linux versions and not compile (20.0.1) for an example
   *  in this case the music will simply just not play
   * 
   * 
   * 
   * 
  */

  private static double volume = 100;
  private static MediaPlayer music; // the "music"

  public static void musicPlays(String filePath) {

    /* this method will get the media by its PATH and play by an indefinite amount of time
     * {@link #setVolume volume} will change the volume from 0 to 100
     * {@link #muteUnmute volume} will change the volume to 0 or 100
     * 
    */

    try {
      Media midia = new Media(Paths.get(filePath).toUri().toString());
      music = new MediaPlayer(midia);
      music.play();

    } catch (Exception e) {
      System.out.println("Error: " + e.getStackTrace());
    }

  }

  public static double getVolume() {
    return volume;
  }

  public static void setVolume(double vol) {
    try {
      volume = vol;
      music.setVolume(vol/100); //divided by 100 since its a 0-1 and its values should be 0.1 etc
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }
  }

  public static void muteUnmute() {
    try {
      if (volume == 0) {
        volume = 100;
      } else {
        volume = 0;
      }
      music.setVolume(volume/100);
    } catch (Exception e) {
      System.out.println(e.getStackTrace());
    }
  }

}
