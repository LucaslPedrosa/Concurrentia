/*
 *  @author: Lucas Pedrosa Larangeira
 * 
 * 
 * 
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game implements Initializable {

  @FXML
  private AnchorPane anchorPaneGame;  // anchor pane used to store the game

  /*
   *  All these are matchSticks
   *  used in the game
   */

  @FXML
  private ImageView L1M1;
  @FXML
  private ImageView L2M3;
  @FXML
  private ImageView L2M2;
  @FXML
  private ImageView L2M1;
  @FXML
  private ImageView L3M5;
  @FXML
  private ImageView L3M4;
  @FXML
  private ImageView L3M3;
  @FXML
  private ImageView L3M2;
  @FXML
  private ImageView L3M1;
  @FXML
  private ImageView L4M7;
  @FXML
  private ImageView L4M6;
  @FXML
  private ImageView L4M5;
  @FXML
  private ImageView L4M4;
  @FXML
  private ImageView L4M3;
  @FXML
  private ImageView L4M2;
  @FXML
  private ImageView L4M1;

  @FXML
  private Button buttonRemove1; // Remove matchStick from line one

  @FXML
  private Button buttonRemove2; //Remove matchStick from line two

  @FXML
  private Button buttonRemove3; //Remove matchStick from line three

  @FXML
  private Button buttonRemove4; //Remove matchstick from line four

  @FXML
  private Button buttonFinalizeTurn;  //Finalize turn

  @FXML
  private Button backToHome;  //Go back to main menu

  @FXML
  private AnchorPane anchorPaneYouLose; // master oogway lose message

  @FXML
  private AnchorPane anchorPaneYouWin;  // master oogway win message

  @FXML
  private AnchorPane anchorPaneChooseVersus;  // Responsable to display the versus screen

  @FXML
  private Button buttonMachine; // Choose machine to play against

  @FXML
  private Button buttonLocal; // Choose local to play

  @FXML
  private AnchorPane anchorPaneEstaCerto; // Trolls the player

  @FXML
  private AnchorPane anchorPaneWhoPlaysFirst; // Anchor pane to display who will play first

  @FXML
  private Button buttonMachineFirst;  // Machine goes first

  @FXML
  private Button buttonHumanFirst;  // Human goes FIRST

  private Stage stage; // Used to change screens
  private Scene scene; // Used to change screens
  private Parent root; // Used to change screens

  // These will help us to know the number of sticks in each line
  private int[] lineSticks = { 1, 3, 5, 7 };

  // This will help us to lock the player to remove matchSticks from one side only
  private int actualLine = 0;

  // This int will be the index when we try to remove any matchStick
  private int remove = -1;

  //Self explanatory ones
  boolean againstBot = false;
  boolean botFirst = false;
  boolean playerTurn = false;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
    //  Put every matchStick image in a array by reference
    ImageView[] images = { L1M1, L2M1, L2M2, L2M3, L3M1, L3M2, L3M3, L3M4, L3M5, L4M1, L4M2, L4M3, L4M4, L4M5, L4M6,
        L4M7 };

    //  Trolls the player
    buttonMachine.setOnMouseEntered(event -> {
      anchorPaneEstaCerto.setVisible(true);
    });
    //  Trolls the player
    buttonMachine.setOnMouseExited(event -> {
      anchorPaneEstaCerto.setVisible(false);
    });

    //  Play against the machine and move to next anchor pane
    buttonMachine.setOnAction(event -> {
      againstBot = true;
      anchorPaneChooseVersus.setVisible(false);
      anchorPaneWhoPlaysFirst.setVisible(true);
    });

    //  Play local and move to next anchor pane
    buttonLocal.setOnAction(event -> {
      againstBot = false;
      anchorPaneChooseVersus.setVisible(false);
      anchorPaneGame.setVisible(true);
    });

    //  The human will go first, moves to game Screen
    buttonHumanFirst.setOnAction(event -> {
      botFirst = false;
      playerTurn = true;
      anchorPaneWhoPlaysFirst.setVisible(false);
      anchorPaneGame.setVisible(true);
    });

    //  Machine will go first, moves to game Screen and make
    //  a normal move;
    buttonMachineFirst.setOnAction(event -> {
      botFirst = true;
      for (int i = 0; i < 4; i++) {
        if (lineSticks[i] > 0) {
          remove = removeStick(i + 1);
          images[remove].setVisible(false);
          break;
        }
      }
      playerTurn = true;
      anchorPaneWhoPlaysFirst.setVisible(false);
      anchorPaneGame.setVisible(true);
    });

    //  Go back to main menu
    backToHome.setOnAction(event -> {
      try {
        switchToMenu(event);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    });

    //  Remove matchSticks from line 1
    buttonRemove1.setOnAction(event -> {
      remove = removeStick(1);
      if (remove != -1) {
        actualLine = 1;
        images[remove].setVisible(false);
        playerTurn = false;
      }
    });

    //  Remove matchSticks from line 2
    buttonRemove2.setOnAction(event -> {
      remove = removeStick(2);
      if (remove != -1) {
        actualLine = 2;
        images[remove].setVisible(false);
        playerTurn = false;
      }
    });

    //  Remove matchSticks from line 3
    buttonRemove3.setOnAction(event -> {
      remove = removeStick(3);
      if (remove != -1) {
        actualLine = 3;
        images[remove].setVisible(false);
        playerTurn = false;
      }
    });

    //  Remove matchSticks from line 4
    buttonRemove4.setOnAction(event -> {
      remove = removeStick(4);
      if (remove != -1) {
        actualLine = 4;
        images[remove].setVisible(false);
        playerTurn = false;
      }
    });

    /*
     *  buttonFinalizeTurn will end the turn and make the player
     *  Capable of making another move
     * 
     *  if the human is playing against the bot it will
     *  make a move against the player, the bot is smart and will try to win
     * 
     *  basically, if the NIM sum (search for NIM game tutorial on internet)
     *  is 0, it means the bot cant do much, so it will remove any match stick
     *  form any line and only one time, since it wants to extend the game
     *  the maximum possible to mislead the player
     * 
     *  if the NIM sum is diferent than 0, it means the game can be balanced,
     *  and the bot will do a sequence of searchs to see where he should remove
     *  the matchSticks
     * 
     *  the first bot search is the simply one, if the nim sum is w = "x,y,z" the bot will
     *  look if in any line has the "x,y,z" binary to four = x, two = y and one = z
     * 
     *  Example:
     * 
     *  we remove a two and a one
     *  x = 0, y = 1, z = 1
     *  we then look if any line has x >= 0 y >= 1 and z >= 1
     *  
     * 
     *  after that, has a possibility that the bot doesnt find anything, so it will look 
     *  if the NIM sum different from 0 was generate beyond a imbalance from removing one
     *  of the four rows from the game and transforming it into another power of two
     * 
     *  if the bot still finds nothing, it will then look if the imbalance was generated by 
     *  transforming a two into a one
     * 
     *  these three searchs should find the imbalance and then balance the game.
     *  If nothing was found (impossible case), the the bot will simply remove anything
     *  from the game to force him to make a move.
     *  
     * 
     * 
     */
    buttonFinalizeTurn.setOnAction(event -> {

      if (againstBot) {
        if (playerTurn) {
          return;
        }
        actualLine = 0;//makes possible to the bot to play
        int temporaryStickCount = 0;  // if the sum of every matchStick == 0, game ended
        for (int i = 0; i < 4; i++) {
          temporaryStickCount += lineSticks[i];
        }
        if (temporaryStickCount == 0) {
          anchorPaneYouWin.setVisible(true);
          return;
        }

        int binarySolve = botPlays(); //  Search for imbalance
        Boolean hasFour = false;  //  Imbalance resulted by removing a four
        Boolean removed = false;  //  See if the bot made a move

        if (binarySolve == 0) {
          for (int i = 0; i < 4; i++) {
            if (lineSticks[i] > 0) {
              remove = removeStick(i + 1); 
              images[remove].setVisible(false);
              break;
            }
          }
        } else {

          if (binarySolve > 4) {
            hasFour = true;
          }

          for (int i = 0; i < 4; i++) { // First search
            if (lineSticks[i] / 4 >= binarySolve / 4 && (lineSticks[i] % 4) / 2 >= (binarySolve % 4) / 2
                && lineSticks[i] % 2 >= binarySolve % 2) {
              for (int x = 0; x < binarySolve; x++) {
                remove = removeStick(i + 1);
                if (remove != -1)
                  images[remove].setVisible(false);
              }
              removed = true;
              break;
            }
          }

          if (!removed) {
            if (hasFour) {
              for (int i = 0; i < 4; i++) { //  Second search
                if (lineSticks[i] >= 4) {
                  while (lineSticks[i] != 0 && botPlays() != 0) {
                    remove = removeStick(i + 1);
                    if (remove != -1)
                      images[remove].setVisible(false);
                  }
                  removed = true;
                  break;
                }
              }
            }
          }

          if (!removed && binarySolve == 3) {
            for (int i = 0; i < 4; i++) { //  Third search
              if ((lineSticks[i] % 4) / 2 >= (binarySolve % 4) / 2) {
                remove = removeStick(i + 1);
                if (remove != -1)
                  images[remove].setVisible(false);
                removed = true;
                break;
              }
            }
          }

          if (!removed) {
            for (int i = 0; i < 4; i++) { //  Last search
              if (lineSticks[i] > 0) {
                remove = removeStick(i + 1);
                if (remove != -1)
                  images[remove].setVisible(false);
                break;
              }
            }
          }
          temporaryStickCount = 0;
          for (int i = 0; i < 4; i++) {
            temporaryStickCount += lineSticks[i];
          }
          if (temporaryStickCount == 0) {
            anchorPaneYouLose.setVisible(true);
          }
        }
      }
      actualLine = 0;
      playerTurn = true;

    });

  }

  /*
   *  switchToMenu function loads the /view/main_view.fxml
   *  and change the stage scene to main_view.fxml
  */
  public void switchToMenu(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  /*
   *  removeStick function will receive a line as param
   *  and see if theres at least one matchstick on that line
   *  and the player is not trying to remove from more than
   *  one line
   *  if the requirements are met, then it remove a matchStick
   *  from that line
   * 
   *  the return calculation are made this way:
   *  Example:
   *  in the line 2, since its a vector, should have range of:
   *  1-4, indexes if we request to remove one, it will go to:
   *  4 - 3 = 1 removing the images[1] that is the first from
   *  second row, if we try it again, it should go:
   *  4 - 2 = 2, removing the images[2] that is the second from second
   *  row. I hope that explains it
  */
  public int removeStick(int line) {

    int supossedSticks[] = { 1, 4, 9, 16 };
    int imageToRemove = 0;

    if (actualLine != line && actualLine != 0)
      return -1;

    if (lineSticks[line - 1] == 0)  //  Requirements not met
      return -1;

    imageToRemove -= lineSticks[line - 1];
    imageToRemove += supossedSticks[line - 1];

    lineSticks[line - 1]--;
    return imageToRemove;
  }

  public int botPlays() {

    int temporarySticks[] = { 0, 0, 0, 0 };
    int binarySolve = 0;

    for (int i = 0; i < 4; i++) {
      temporarySticks[i] = lineSticks[i];
      binarySolve ^= temporarySticks[i];
    }

    // first we need to calculate the binary solve of
    // the matchsticks rows, then we know how many match sticks
    // we need to remove to maintain the game "balanced"
    System.out.println(binarySolve);

    return binarySolve;

  }

}
