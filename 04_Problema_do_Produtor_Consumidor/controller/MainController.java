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
    private Label textLabelMoney1;

    @FXML
    private AnchorPane anchorPaneConsumers;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

}
