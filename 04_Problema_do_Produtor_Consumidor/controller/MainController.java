/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 31/03/2022
 *  last change at : 10/04/2022 15:24
 *  Name: Principal.java
 * 
 *  MainController class controls everything that happens in FXML that
 *  includes images, buttons, anchor pane etc...
 *  it put the threads on a array and start then 
 *  
 * 
 *
 * 
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Buffer;
import model.GasStation;
import model.OilRefinery;

public class MainController implements Initializable {
  @FXML
  private AnchorPane anchorPaneManagement; // Anchor pane used by management screen

  @FXML
  private ImageView imgShop; // used to go to shop anchor pane

  @FXML
  private ImageView imgProduction; // used to go to production anchor pane

  @FXML
  private ImageView imgConsumer; // used to go to consumer anchor pane

  @FXML
  private AnchorPane anchorPaneProducers; // Anchor pane used by producers

  @FXML
  private ImageView imgRefinery1; // Refinery 1 img

  @FXML
  private ImageView imgRefinery2; // Refinery 2 img

  @FXML
  private ImageView imgRefinery3; // Refinery 3 img

  @FXML
  private ImageView imgRefinery4; // Refinery 4 img

  @FXML
  private ImageView imgProdToManagment; // Image used to go from production screen to manager

  @FXML
  private ImageView imgRefineryTurnOn1; // Img used to turn on/off refinery 1

  @FXML
  private ImageView imgRefineryTurnOn2; // Img used to turn on/off refinery 2

  @FXML
  private ImageView imgRefineryTurnOn3; // Img used to turn on/off refinery 3

  @FXML
  private ImageView imgRefineryTurnOn4; // Img used to turn on/off refinery 4

  @FXML
  private ImageView imgLoadingBar1; // Loading bar image from refinery 1

  @FXML
  private ImageView imgProgressBar11; // Progress bar time 1 from refinery 1

  @FXML
  private ImageView imgProgressBar12; // Progress bar time 2 from refinery 1

  @FXML
  private ImageView imgProgressBar13; // Progress bar time 3 from refinery 1

  @FXML
  private ImageView imgLoadingBar2; // Loading bar image from refinery 2

  @FXML
  private ImageView imgProgressBar21; // Progress bar time 1 from refinery 2

  @FXML
  private ImageView imgProgressBar22; // Progress bar time 2 from refinery 2

  @FXML
  private ImageView imgProgressBar23; // Progress bar time 3 from refinery 2

  @FXML
  private ImageView imgLoadingBar3;// Loading bar image from refinery 3

  @FXML
  private ImageView imgProgressBar31; // Progress bar time 1 from refinery 3

  @FXML
  private ImageView imgProgressBar32; // Progress bar time 2 from refinery 3

  @FXML
  private ImageView imgProgressBar33; // Progress bar time 3 from refinery 3

  @FXML
  private ImageView imgLoadingBar4; // Loading bar image from refinery 4

  @FXML
  private ImageView imgProgressBar41; // Progress bar time 1 from refinery 4

  @FXML
  private ImageView imgProgressBar42; // Progress bar time 2 from refinery 4

  @FXML
  private ImageView imgProgressBar43; // Progress bar time 3 from refinery 4

  @FXML
  private Button buttonSpd11; // Button used to toggle Speed 1 from refinery 1

  @FXML
  private Button buttonSpd12; // Button used to toggle Speed 2 from refinery 1

  @FXML
  private Button buttonSpd13; // Button used to toggle Speed 3 from refinery 1

  @FXML
  private Button buttonSpd21; // Button used to toggle Speed 1 from refinery 2

  @FXML
  private Button buttonSpd22; // Button used to toggle Speed 2 from refinery 2

  @FXML
  private Button buttonSpd23; // Button used to toggle Speed 3 from refinery 2

  @FXML
  private Button buttonSpd31; // Button used to toggle Speed 1 from refinery 3

  @FXML
  private Button buttonSpd32; // Button used to toggle Speed 2 from refinery 3

  @FXML
  private Button buttonSpd33; // Button used to toggle Speed 3 from refinery 3

  @FXML
  private Button buttonSpd41; // Button used to toggle Speed 1 from refinery 4

  @FXML
  private Button buttonSpd42; // Button used to toggle Speed 2 from refinery 4

  @FXML
  private Button buttonSpd43; // Button used to toggle Speed 3 from refinery 4

  @FXML
  private AnchorPane anchorPaneConsumers; // Anchor pane used to display consumers

  @FXML
  private ImageView imgCar1; // Car image from gas station 1

  @FXML
  private ImageView imgCar2; // Car image from gas station 2

  @FXML
  private ImageView imgCar3; // Car image from gas station 3

  @FXML
  private ImageView imgConsumerToManagment; // Image used to go from consumer Anchor pane to Managment Anchor pane

  @FXML
  private ImageView imgGasTurnOn1; // Image used to turn gas station 1 on/off

  @FXML
  private ImageView imgGasTurnOn2; // Image used to turn gas station 2 on/off

  @FXML
  private ImageView imgGasTurnOn3; // Image used to turn gas station 3 on/off

  @FXML
  private Button buttonGasSpeed11; // Image used to turn Gas station 1 speed 1

  @FXML
  private Button buttonGasSpeed12; // Image used to turn Gas station 1 speed 2

  @FXML
  private Button buttonGasSpeed13; // Image used to turn Gas station 1 speed 3

  @FXML
  private Button buttonGasSpeed21; // Image used to turn Gas station 2 speed 1

  @FXML
  private Button buttonGasSpeed22; // Image used to turn Gas station 2 speed 2

  @FXML
  private Button buttonGasSpeed23; // Image used to turn Gas station 2 speed 3

  @FXML
  private Button buttonGasSpeed31; // Image used to turn Gas station 3 speed 1

  @FXML
  private Button buttonGasSpeed32; // Image used to turn Gas station 3 speed 2

  @FXML
  private Button buttonGasSpeed33; // Image used to turn Gas station 3 speed 3

  @FXML
  private AnchorPane anchorPaneShop; // AnchorPane used to display shop

  @FXML
  private ImageView imgShopToManager; // Image used to go from shop to Manager Anchorpane

  @FXML
  private Label labelShopText; // Label used to display shop itens text

  @FXML
  private ImageView imgGas; // image used to buy another refinery

  @FXML
  private ImageView imgOil; // Image used to buy Refinery speed

  @FXML
  private ImageView imgWin; // Image used to win the game

  @FXML
  private ImageView imgRefinery; // Image used to buy another refinery

  @FXML
  private ImageView imgWheel; // Image used to buy gas speed

  @FXML
  private ImageView imgShopConfirm; // Image used to confirm shop selection

  @FXML
  private Label textLabelMoney; // Label used to display actual money

  @FXML
  private Label textLabelOil; // Label used to display actual Oil

  @FXML
  private AnchorPane anchorPaneWin; // Anchor pane used to display Victory!

  private OilRefinery refinerys[] = new OilRefinery[4]; // Array of Refinerys used to turn they on easily
  private GasStation stations[] = new GasStation[3]; // Array of Gas Stations used to turn they on easily

  private int money = 0; // Actual money

  private ImageView progressBar[][] = new ImageView[4][3]; // Array of progressBar from refinerys to make they work
                                                           // easily

  private Button refinerySpeeds[][] = new Button[4][3]; // Array of Refinery Speeds used to turn they on and click on
                                                        // them easily
  private Button stationSpeeds[][] = new Button[3][3]; // Array of Station Speeds used to turn they on and click on them
                                                       // easily

  /**
   * Method name: initialize
   * 
   * This method comes from extends initializable and it should Override previous
   * initialize,
   * this method is executed whenever MainController is started and is used to
   * make everything work
   * fine in a 'single line'
   * 
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    createThreads(); // Create all the Threads

    startThreads(); // Start all the Threads

    setProgressBar(); // set Progress Bar from refinerys
    setButtons(); // set speed buttons

    /**
     * ShopController static class is used so MainController doesn't overload
     * in methods
     * its the same as making header files in c++ as example
     */
    ShopController.setController(this); // set ShopController MainController

    /**
     * Next methods are used to change screens
     * 
     */
    imgConsumer.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneConsumers.setVisible(true); // Go to Consumer screen
    });

    imgProduction.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneProducers.setVisible(true); // Go to Producer Screen
    });

    imgProdToManagment.setOnMouseClicked(Event -> {
      anchorPaneProducers.setVisible(false);
      anchorPaneManagement.setVisible(true); // Go to Management Screen
    });

    imgConsumerToManagment.setOnMouseClicked(Event -> {
      anchorPaneConsumers.setVisible(false);
      anchorPaneManagement.setVisible(true); // Go to management Screen
    });

    imgShopToManager.setOnMouseClicked(Event -> {
      anchorPaneShop.setVisible(false);
      anchorPaneManagement.setVisible(true); // Go to Management Screen
    });

    imgShop.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneShop.setVisible(true); // Go to shop Screen
    });

    /**
     * Next methods are used to turn refinerys on/off
     * 
     */

    imgRefineryTurnOn1.setOnMouseClicked(event -> {
      refineryTurnOnOff(0); // Self explanatory
    });

    imgRefineryTurnOn2.setOnMouseClicked(event -> {
      refineryTurnOnOff(1);
    });

    imgRefineryTurnOn3.setOnMouseClicked(event -> {
      refineryTurnOnOff(2);
    });

    imgRefineryTurnOn4.setOnMouseClicked(event -> {
      refineryTurnOnOff(3);
    });

    /**
     * Next methods are used to turn GasStations on / off
     * 
     */

    imgGasTurnOn1.setOnMouseClicked(event -> {
      gasStationTurnOnOff(0);
    });

    imgGasTurnOn2.setOnMouseClicked(event -> {
      gasStationTurnOnOff(1);
    });

    imgGasTurnOn3.setOnMouseClicked(event -> {
      gasStationTurnOnOff(2);
    });

    /**
     * Next methods are used to buy on shop
     * 
     * 
     */

    imgGas.setOnMouseClicked(Event -> {
      ShopController.changeSelected(0); // Select the First item from the shop
    });

    imgWheel.setOnMouseClicked(Event -> {
      ShopController.changeSelected(1); // Select the Second item from the shop
    });

    imgRefinery.setOnMouseClicked(Event -> {
      ShopController.changeSelected(2); // Select the Third item from the shop
    });

    imgOil.setOnMouseClicked(Event -> {
      ShopController.changeSelected(3); // Select the Fourty item from the shop
    });

    imgWin.setOnMouseClicked(Event -> {
      ShopController.changeSelected(4); // Select the Fifth item from the shop
    });

    // This function will be called whenever Shop Confirm is clicked
    imgShopConfirm.setOnMouseClicked(Event -> {
      ShopController.confirm(); // confirm the selected item
    });

    /**
     * Next methods are used to change gas stations cars speed
     * 
     */

    buttonGasSpeed11.setOnMouseClicked(Event -> {
      stations[0].setSpeed(1000);
    });

    buttonGasSpeed21.setOnMouseClicked(Event -> {
      stations[1].setSpeed(1000);
    });

    buttonGasSpeed21.setOnMouseClicked(Event -> {
      stations[2].setSpeed(1000);
    });

    buttonGasSpeed12.setOnMouseClicked(Event -> {
      stations[0].setSpeed(550);
    });

    buttonGasSpeed22.setOnMouseClicked(Event -> {
      stations[1].setSpeed(550);
    });

    buttonGasSpeed32.setOnMouseClicked(Event -> {
      stations[2].setSpeed(550);
    });

    buttonGasSpeed13.setOnMouseClicked(Event -> {
      stations[0].setSpeed(225);
    });

    buttonGasSpeed23.setOnMouseClicked(Event -> {
      stations[1].setSpeed(225);
    });

    buttonGasSpeed33.setOnMouseClicked(Event -> {
      stations[2].setSpeed(225);
    });

    buttonSpd11.setOnMouseClicked(Event -> {
      refinerys[0].setSpeed(1000);
    });

    buttonSpd21.setOnMouseClicked(Event -> {
      refinerys[1].setSpeed(1000);
    });

    buttonSpd31.setOnMouseClicked(Event -> {
      refinerys[2].setSpeed(1000);
    });

    buttonSpd41.setOnMouseClicked(Event -> {
      refinerys[3].setSpeed(1000);
    });

    buttonSpd12.setOnMouseClicked(Event -> {
      refinerys[0].setSpeed(550);
    });

    buttonSpd22.setOnMouseClicked(Event -> {
      refinerys[1].setSpeed(550);
    });

    buttonSpd32.setOnMouseClicked(Event -> {
      refinerys[2].setSpeed(550);
    });

    buttonSpd42.setOnMouseClicked(Event -> {
      refinerys[3].setSpeed(550);
    });

    buttonSpd13.setOnMouseClicked(Event -> {
      refinerys[0].setSpeed(225);
    });

    buttonSpd23.setOnMouseClicked(Event -> {
      refinerys[1].setSpeed(225);
    });

    buttonSpd33.setOnMouseClicked(Event -> {
      refinerys[2].setSpeed(225);
    });

    buttonSpd43.setOnMouseClicked(Event -> {
      refinerys[3].setSpeed(225);
    });

  }

  /**
   * Method name: updateOil
   * 
   * this function updates oil text whenever is called
   */
  public void updateOil() {
    textLabelOil.setText(String.valueOf(Buffer.liters));
  }

  /**
   * Method name: updateMoney
   * 
   * this function updates money text whenever is called
   * 
   */

  public void updateMoney() {
    textLabelMoney.setText(String.valueOf(getMoney()));
  }

  /**
   * Method name: addMoney
   * 
   * this method will add an amount of money and then
   * update the money
   * 
   * {
   * 
   * @param x : money to be added}
   */

  public void addMoney(int x) {
    try {
      Buffer.mutex.acquire(); // Critical region enter
      this.money += x;
      updateMoney();
      Buffer.mutex.release(); // Critical region exit
    } catch (Exception e) {
      System.out.println("Add money error");
    }

  }

  // Get money returns value of money
  public int getMoney() {
    return this.money;
  }

  /**
   * refineryTurnOnOff is used to turn ON or OFF any refinery
   * 
   * {
   * 
   * @param witch : this is the index of witch refinery from refinerys array
   *              declarated in line 248 will be turned ON/OFF}
   */
  public void refineryTurnOnOff(int witch) {
    refinerys[witch].turnOnOff();
  }

  /**
   * gasStationTurnOnOff is used to turn ON or OFF any gas Station
   * 
   * {
   * 
   * @param witch : this is the index of witch gas station from stations array
   *              declarated on
   *              line 248 will be turned ON/OFF}
   * 
   */

  public void gasStationTurnOnOff(int witch) {
    stations[witch].turnOnOff();
  }

  // Method used to set shop text
  public void setShopText(String text) {
    labelShopText.setText(text);
  }

  // Method used to unlock determined gas station
  public void unlockGasStation(int witch) {
    stations[witch].makeAmericaGreat();
  }

  /**
   * unlockRefinerySpeed will make ALL refinerys determined speed avaliable
   * 
   * {
   * 
   * @param speed : index used to unlock the speed}
   */
  public void unlockRefinerySpeed(int speed) {
    refinerys[0].unlockSpeed(speed);
    refinerys[1].unlockSpeed(speed);
    refinerys[2].unlockSpeed(speed);
    refinerys[3].unlockSpeed(speed);
  }

  // Win method called to finish the game
  public void win() {
    anchorPaneWin.setVisible(true);
  }

  /**
   * unlockGasSpeed method unlocks an determined speed for ALL gas stations
   * 
   * {
   * 
   * @param speed : index of witch speed will be unlocked}
   */
  public void unlockGasSpeed(int speed) {
    stations[0].unlockSpeed(speed);
    stations[1].unlockSpeed(speed);
    stations[2].unlockSpeed(speed);
  }

  /**
   * unlockRefinery method receives an index of a determined refinery and then
   * unlocks it
   * 
   * {
   * 
   * @param witch : index of witch refinery should be unlocked}
   */
  public void unlockRefinery(int witch) {
    refinerys[witch].makeAmericaGreat();
  }

  /**
   * setButtons method is used to put every speed button in a determined array,
   * used to pass
   * as param in consumer and producer constructors
   * 
   */
  public void setButtons() {
    refinerySpeeds[0][0] = buttonSpd11;
    refinerySpeeds[0][1] = buttonSpd12;
    refinerySpeeds[0][2] = buttonSpd13;

    refinerySpeeds[1][0] = buttonSpd21;
    refinerySpeeds[1][1] = buttonSpd22;
    refinerySpeeds[1][2] = buttonSpd23;

    refinerySpeeds[2][0] = buttonSpd31;
    refinerySpeeds[2][1] = buttonSpd32;
    refinerySpeeds[2][2] = buttonSpd33;

    refinerySpeeds[3][0] = buttonSpd41;
    refinerySpeeds[3][1] = buttonSpd42;
    refinerySpeeds[3][2] = buttonSpd43;

    stationSpeeds[0][0] = buttonGasSpeed11;
    stationSpeeds[0][1] = buttonGasSpeed12;
    stationSpeeds[0][2] = buttonGasSpeed13;

    stationSpeeds[1][0] = buttonGasSpeed21;
    stationSpeeds[1][1] = buttonGasSpeed22;
    stationSpeeds[1][2] = buttonGasSpeed23;

    stationSpeeds[2][0] = buttonGasSpeed31;
    stationSpeeds[2][1] = buttonGasSpeed32;
    stationSpeeds[2][2] = buttonGasSpeed33;

  }

  /**
   * SetProgressBar method is used to put images from progress bar in a determined
   * array used to pass
   * as params to constructors
   * 
   */

  public void setProgressBar() {
    progressBar[0][0] = imgProgressBar11;
    progressBar[0][1] = imgProgressBar12;
    progressBar[0][2] = imgProgressBar13;

    progressBar[1][0] = imgProgressBar21;
    progressBar[1][1] = imgProgressBar22;
    progressBar[1][2] = imgProgressBar23;

    progressBar[2][0] = imgProgressBar31;
    progressBar[2][1] = imgProgressBar32;
    progressBar[2][2] = imgProgressBar33;

    progressBar[3][0] = imgProgressBar41;
    progressBar[3][1] = imgProgressBar42;
    progressBar[3][2] = imgProgressBar43;
  }

  /**
   * createThreads method create every thread used in barcelona and then puts then
   * in a array.
   * 
   * the params passed for the refinerys are: Maincontroller , refinery Image,
   * refinery image button to turn on, loading bar empty,
   * array of progressBar
   * 
   */

  public void createThreads() {
    refinerys[0] = new OilRefinery(this, imgRefinery1, imgRefineryTurnOn1, imgLoadingBar1, progressBar[0],
        refinerySpeeds[0]);
    refinerys[1] = new OilRefinery(this, imgRefinery2, imgRefineryTurnOn2, imgLoadingBar2, progressBar[1],
        refinerySpeeds[1]);
    refinerys[2] = new OilRefinery(this, imgRefinery3, imgRefineryTurnOn3, imgLoadingBar3, progressBar[2],
        refinerySpeeds[2]);
    refinerys[3] = new OilRefinery(this, imgRefinery4, imgRefineryTurnOn4, imgLoadingBar4, progressBar[3],
        refinerySpeeds[3]);

    stations[0] = new GasStation(this, imgCar1, imgGasTurnOn1, stationSpeeds[0]);
    stations[1] = new GasStation(this, imgCar2, imgGasTurnOn2, stationSpeeds[1]);
    stations[2] = new GasStation(this, imgCar3, imgGasTurnOn3, stationSpeeds[2]);
  }


  /**
   * startThreads is used just to make the code more "good looking"
   * it starts every thread once created previosly
   * 
   */
  public void startThreads() {
    refinerys[0].start();
    refinerys[1].start();
    refinerys[2].start();
    refinerys[3].start();

    stations[0].start();
    stations[1].start();
    stations[2].start();
  }

}
