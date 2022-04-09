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
  private AnchorPane anchorPaneManagement;

  @FXML
  private ImageView imgShop;

  @FXML
  private ImageView imgProduction;

  @FXML
  private ImageView imgConsumer;

  @FXML
  private AnchorPane anchorPaneProducers;

  @FXML
  private ImageView imgRefinery1;

  @FXML
  private ImageView imgRefinery2;

  @FXML
  private ImageView imgRefinery3;

  @FXML
  private ImageView imgRefinery4;

  @FXML
  private ImageView imgProdToManagment;

  @FXML
  private ImageView imgRefineryTurnOn1;

  @FXML
  private ImageView imgRefineryTurnOn2;

  @FXML
  private ImageView imgRefineryTurnOn3;

  @FXML
  private ImageView imgRefineryTurnOn4;

  @FXML
  private ImageView imgLoadingBar1;

  @FXML
  private ImageView imgProgressBar11;

  @FXML
  private ImageView imgProgressBar12;

  @FXML
  private ImageView imgProgressBar13;

  @FXML
  private ImageView imgLoadingBar2;

  @FXML
  private ImageView imgProgressBar21;

  @FXML
  private ImageView imgProgressBar22;

  @FXML
  private ImageView imgProgressBar23;

  @FXML
  private ImageView imgLoadingBar3;

  @FXML
  private ImageView imgProgressBar31;

  @FXML
  private ImageView imgProgressBar32;

  @FXML
  private ImageView imgProgressBar33;

  @FXML
  private ImageView imgLoadingBar4;

  @FXML
  private ImageView imgProgressBar41;

  @FXML
  private ImageView imgProgressBar42;

  @FXML
  private ImageView imgProgressBar43;

  @FXML
  private Button buttonSpd11;

  @FXML
  private Button buttonSpd12;

  @FXML
  private Button buttonSpd13;

  @FXML
  private Button buttonSpd21;

  @FXML
  private Button buttonSpd22;

  @FXML
  private Button buttonSpd23;

  @FXML
  private Button buttonSpd31;

  @FXML
  private Button buttonSpd32;

  @FXML
  private Button buttonSpd33;

  @FXML
  private Button buttonSpd41;

  @FXML
  private Button buttonSpd42;

  @FXML
  private Button buttonSpd43;

  @FXML
  private AnchorPane anchorPaneConsumers;

  @FXML
  private ImageView imgCar1;

  @FXML
  private ImageView imgCar2;

  @FXML
  private ImageView imgCar3;

  @FXML
  private ImageView imgConsumerToManagment;

  @FXML
  private ImageView imgGasTurnOn1;

  @FXML
  private ImageView imgGasTurnOn2;

  @FXML
  private ImageView imgGasTurnOn3;

  @FXML
  private AnchorPane anchorPaneShop;

  @FXML
  private ImageView imgShopToManager;

  @FXML
  private ImageView imgGas;

  @FXML
  private ImageView imgOil;

  @FXML
  private ImageView imgWin;

  @FXML
  private ImageView imgRefinery;

  @FXML
  private ImageView imgWheel;

  @FXML
  private ImageView imgShopConfirm;

  @FXML
  private Label textLabelMoney;

  @FXML
  private Label textLabelOil;

  @FXML
  private Label labelShopText;

  private OilRefinery refinerys[] = new OilRefinery[4];
  private GasStation stations[] = new GasStation[3];

  private int money = 0;

  private ImageView progressBar[][] = new ImageView[4][3];
  
  private Button refinerySpeeds[][] = new Button[4][3];

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    createThreads();

    startThreads();

    setProgressBar();
    setButtons();

    /**
     * ShopController static class is used so MainController doesnt overload
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
      anchorPaneConsumers.setVisible(true);
    });

    imgProduction.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneProducers.setVisible(true);
    });

    imgProdToManagment.setOnMouseClicked(Event -> {
      anchorPaneProducers.setVisible(false);
      anchorPaneManagement.setVisible(true);
    });

    imgConsumerToManagment.setOnMouseClicked(Event -> {
      anchorPaneConsumers.setVisible(false);
      anchorPaneManagement.setVisible(true);
    });

    imgShopToManager.setOnMouseClicked(Event -> {
      anchorPaneShop.setVisible(false);
      anchorPaneManagement.setVisible(true);
    });

    imgShop.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneShop.setVisible(true);
    });

    /**
     * Next methods are used to turn refinerys on/off
     * 
     */

    imgRefineryTurnOn1.setOnMouseClicked(event -> {
      refineryTurnOnOff(0);
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
     * 
     */

    imgGas.setOnMouseClicked(Event -> {
      ShopController.changeSelected(0);
    });

    imgWheel.setOnMouseClicked(Event -> {
      ShopController.changeSelected(1);
    });

    imgRefinery.setOnMouseClicked(Event -> {
      ShopController.changeSelected(2);
    });

    imgOil.setOnMouseClicked(Event -> {
      ShopController.changeSelected(3);
    });

    imgWin.setOnMouseClicked(Event -> {
      ShopController.changeSelected(4);
    });

    imgShopConfirm.setOnMouseClicked(Event -> {
      ShopController.confirm();
    });

  }

  public void updateOil() {
    textLabelOil.setText(String.valueOf(Buffer.liters));
  }

  public void updateMoney() {
    textLabelMoney.setText(String.valueOf(getMoney()));
  }

  public void addMoney(int x) {
    this.money += x;
    updateMoney();
  }

  public int getMoney() {
    return this.money;
  }

  public void refineryTurnOnOff(int witch) {
    refinerys[witch].turnOnOff();
  }

  public void gasStationTurnOnOff(int witch) {
    stations[witch].turnOnOff();
  }

  public void setShopText(String text){
    labelShopText.setText(text);
  }

  public void unlockGasStation(int witch){
    stations[witch].makeAmericaGreat();
  }

  public void unlockGasSpeed( int speed){
    stations[0].unlockSpeed(speed);
    stations[1].unlockSpeed(speed);
    stations[2].unlockSpeed(speed);
    stations[3].unlockSpeed(speed);
  }

  public void unlockRefinery(int witch){
    refinerys[witch].makeAmericaGreat();
  }

  public void setButtons(){
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

  }

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

  public void createThreads() {
    refinerys[0] = new OilRefinery(this, imgRefinery1, imgRefineryTurnOn1, imgLoadingBar1, progressBar[0],refinerySpeeds[0]);
    refinerys[1] = new OilRefinery(this, imgRefinery2, imgRefineryTurnOn2, imgLoadingBar2, progressBar[1],refinerySpeeds[1]);
    refinerys[2] = new OilRefinery(this, imgRefinery3, imgRefineryTurnOn3, imgLoadingBar3, progressBar[2],refinerySpeeds[2]);
    refinerys[3] = new OilRefinery(this, imgRefinery4, imgRefineryTurnOn4, imgLoadingBar4, progressBar[3],refinerySpeeds[3]);

    stations[0] = new GasStation(this, imgCar1, imgGasTurnOn1);
    stations[1] = new GasStation(this, imgCar2, imgGasTurnOn2);
    stations[2] = new GasStation(this, imgCar3, imgGasTurnOn3);
  }

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
