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
    private ImageView imgConsumerToManagment;

    @FXML
    private Label textLabelMoney;

    @FXML
    private Label textLabelOil;

    @FXML
    private AnchorPane anchorPaneConsumers;

    OilRefinery refinerys[] = new OilRefinery[4];
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

      refinerys[0] = new OilRefinery(this, imgRefinery1);
      refinerys[1] = new OilRefinery(this, imgRefinery2);
      refinerys[2] = new OilRefinery(this, imgRefinery3);
      refinerys[3] = new OilRefinery(this, imgRefinery4);

      refinerys[0].start();

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

    }

    public void updateOil(){
      textLabelOil.setText(String.valueOf(Buffer.semaphoreFull.availablePermits()));
    }

}
