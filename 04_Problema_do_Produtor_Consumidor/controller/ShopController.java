package controller;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class ShopController {

  private static int selected = 0;
  private static MainController controller;

  private static int gasStations = 0;
  private static int gasSpeed = 0;

  private static int refinerys = 0;
  private static int refinerysSpeed = 0;

  private static int win = 0;

  private static String text[][] = {
      {
          // VALUES USED BY GAS STATIONS //
          "NOVO POSTO: \n\nAtraves de dinheiro publico sujo, compra outro posto de gasolina",
          "NOVO POSTO: \n\nSantos dummont inventou a roda e voce inventou um novo jeito de fazer dinheiro! compre mais um posto",
          "Voce comprou todos os postos disponiveis"
      },
      {
          // VALUES USED BY GAS SPEED //
          "NOVA VELOCIDADE: \n\nAlguns dizem que adulterar gasolina eh ruim, bom....\n nao quando voce e o dono do posto!",
          "NOVA VELOCIDADE: \n\nBolsonaro legaliza a cocaina fazendo com que os motoristas ou melhor CORREDORES dirijam mais rapido!",
          "Voce comprou todas as velocidades disponiveis"
      },
      {
          // VALUES USED BY REFINERYS//
          "NOVA REFINARIA: \n\nVoce sabia que a idade da terra foi medida com base na quantidade de uranio em rochas?",
          "NOVA REFINARIA: \n\nO assassinato de ursos polares vale a pena pois voce esta ficando rico!",
          "NOVA REFINARIA: \n\nEssa refinaria nem eh necessaria porque so pode ter 3 postos, mas quem se importa? voce subornou as autoridades!",
          "Voce comprou todos as refinarias disponiveis"
      },
      {
          // VALUES USED BY REFINERY SPEED//
          "NOVA VELOCIDADE: \n\nSistemas inteligentes feito por cientistas da UESB fazem com que a coleta do pre-sal seja mais eficiente",
          "NOVA VELOCIDADE: \n\nTodas as pessoas na terra sao utilizadas para realizar escavacoes fazendo assim que mais petrolio seja produzido",
          "Voce comprou todas as velocidades disponiveis"
      },
      {
          "Nao ha nada que dinheiro nao compre nesse mundo, nem mesmo a vitoria"
      }
  };

  public static void confirm() {

    switch (selected) {
      case (0):
        if (gasStations > 2)
          return;
        gasStations++;
        controller.unlockGasStation(gasStations);
        break;
      case (1):
        if(gasSpeed > 2)
          return;
        gasSpeed++;
        controller.unlockGasSpeed(gasSpeed);
        break;
      default:
        break;
    }
    controller.setShopText("");
    selected = -1;

  }

  public static void changeSelected(int select) {
    selected = select;
    switch (select) {
      case (0):
        Platform.runLater(() -> {
          controller.setShopText(text[0][gasStations]);
        });
        break;
      case (1):
        Platform.runLater(() -> {
          controller.setShopText(text[1][gasSpeed]);
        });
        break;
      case (2):
        Platform.runLater(() -> {
          controller.setShopText(text[2][refinerys]);
        });
        break;
      case (3):
        Platform.runLater(() -> {
          controller.setShopText(text[3][refinerysSpeed]);
        });
        break;
      case (5):
        Platform.runLater(() -> {
          controller.setShopText(text[4][0]);
        });
      break;
      default:
        break;

    }
  }

  public static void setController(MainController ctrl) {
    controller = ctrl;
  }

}
