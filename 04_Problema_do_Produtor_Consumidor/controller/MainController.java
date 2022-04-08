package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
  private Label textLabelMoney;

  @FXML
  private Label textLabelOil;

  OilRefinery refinerys[] = new OilRefinery[4];
  GasStation stations[] = new GasStation[3];

  private int money = 0;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    refinerys[0] = new OilRefinery(this, imgRefinery1, imgRefineryTurnOn1);
    refinerys[1] = new OilRefinery(this, imgRefinery2, imgRefineryTurnOn2);
    refinerys[2] = new OilRefinery(this, imgRefinery3, imgRefineryTurnOn3);
    refinerys[3] = new OilRefinery(this, imgRefinery4, imgRefineryTurnOn4);

    stations[0] = new GasStation(this, imgCar1, imgGasTurnOn1);
    stations[1] = new GasStation(this, imgCar2, imgGasTurnOn2);
    stations[2] = new GasStation(this, imgCar3, imgGasTurnOn3);

    refinerys[0].start();
    refinerys[1].start();
    refinerys[2].start();
    refinerys[3].start();

    stations[0].start();
    stations[1].start();
    stations[2].start();

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

    /**
     * Next methods are used to turn refinerys on/off
     * 
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

}
