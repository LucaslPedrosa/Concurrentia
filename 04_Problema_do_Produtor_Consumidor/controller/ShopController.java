/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 09/04/2022
 *  last change at : 10/04/2022 16:58
 *  Name: Principal.java
 * 
 *  ShopController class is used to: select an item from the shop, confirm an buy from the shop
 *  
 * 
 *
 * 
 */

package controller;

import javafx.application.Platform;
import model.Buffer;

public class ShopController {

  private static int selected = -1;  // index of witch item is selected from the shop
  private static MainController controller;  // The main controller class

  private static int gasStations = 0; // Unlocked gas stations index
  private static int gasSpeed = 0;  // Unlocked gas Speed index

  private static int refinerys = 0; // Unlocked Oil Refinery index
  private static int refinerysSpeed = 0;  //Unlocked Refinery speed index

  //Prices from every item
  private static int prices[][] = { { 40, 50 }, { 40, 40 }, { 40, 50, 60 }, { 40, 50 }, { 250 } };

  // Texted displayed on the shop from every item
  private static String text[][] = {
      {
          // VALUES USED BY GAS STATIONS //
          "NOVO POSTO: \n\nAtraves de dinheiro publico sujo, compra outro posto de gasolina\nPreco: 40 RS",
          "NOVO POSTO: \n\nSantos dummont inventou a roda e voce inventou um novo jeito de fazer dinheiro! compre mais um posto\nPreco: 50 RS",
          "Voce comprou todos os postos disponiveis"
      },
      {
          // VALUES USED BY GAS SPEED //
          "NOVA VELOCIDADE: \n\nAlguns dizem que adulterar gasolina eh ruim, bom....\n nao quando voce e o dono do posto!\nPreco: 40 RS",
          "NOVA VELOCIDADE: \n\nBolsonaro legaliza a cocaina fazendo com que os motoristas ou melhor CORREDORES dirijam mais rapido!\nPreco: 40 RS",
          "Voce comprou todas as velocidades disponiveis"
      },
      {
          // VALUES USED BY REFINERYS//
          "NOVA REFINARIA: \n\nVoce sabia que a idade da terra foi medida com base na quantidade de uranio em rochas?\nPreco: 40RS",
          "NOVA REFINARIA: \n\nO assassinato de ursos polares vale a pena pois voce esta ficando rico!\nPreco: 50 RS",
          "NOVA REFINARIA: \n\nEssa refinaria nem eh necessaria porque so pode ter 3 postos, mas quem se importa? voce subornou as autoridades!\n Preco: 60 RS",
          "Voce comprou todos as refinarias disponiveis"
      },
      {
          // VALUES USED BY REFINERY SPEED//
          "NOVA VELOCIDADE: \n\nSistemas inteligentes feito por cientistas da UESB fazem com que a coleta do pre-sal seja mais eficiente\nPreco: 40 RS",
          "NOVA VELOCIDADE: \n\nTodas as pessoas na terra sao utilizadas para realizar escavacoes fazendo assim que mais petrolio seja produzido\nPreco: 50 RS",
          "Voce comprou todas as velocidades disponiveis"
      },
      {
          "Nao ha nada que dinheiro nao compre nesse mundo, nem mesmo a vitoria\n(Isto encerra o jogo)\nPreco: 250 RS"
      }
  };


  /**
   * confirm method do a action defined by the selected index
   * 
   */
  public static void confirm() {

    try {
      switch (selected) {
        case (0): //Buy more gas station
          if (gasStations > 1)  // this means all gas stations were buyed
            return;
          if (controller.getMoney() < prices[0][gasStations]) // this means you are poor
            return;
          Buffer.mutex.acquire(); // Critical region (Gas threads are also using money variable)
          controller.addMoney(-prices[0][gasStations]); // modify money
          Buffer.mutex.release(); // Exit critical region
          gasStations++;  // another gas station to the book
          controller.unlockGasStation(gasStations); //unlock determined gas station
          break;  // end of index 1
        case (1): //Buy more gas speed
          if (gasSpeed > 1) //this means all gas speed were buyed
            return;
          if (controller.getMoney() < prices[1][gasSpeed])  //this means you are poor
            return;
          Buffer.mutex.acquire(); // Critical region (Gas threads are also using money variable)
          controller.addMoney(-prices[1][gasSpeed]);  //
          Buffer.mutex.release(); // Exit critical region
          gasSpeed++; // increase index
          controller.unlockGasSpeed(gasSpeed); //unlock defined index
          break;
        case (2): // Buy more refinerys
          if (refinerys > 2)  // this means all refinerys were buyed
            return;
          if (controller.getMoney() < prices[2][refinerys]) // this means you dont have enought money
            return;
          Buffer.mutex.acquire(); // Critical region (Gas threads are also using money variable)
          controller.addMoney(-prices[2][refinerys]);
          Buffer.mutex.release(); // Exit critical region
          refinerys++;  // Refinerys index increase 
          controller.unlockRefinery(refinerys); //Unlock determined index
          break;
        case (3): // Buy more refinery speed
          if (refinerysSpeed > 1)
            return;
          if (controller.getMoney() < prices[3][refinerysSpeed])
            return;
          Buffer.mutex.acquire(); // Critical region (Gas threads are also using money variable)
          controller.addMoney(-prices[3][refinerysSpeed]);
          Buffer.mutex.release(); // Exit critical region
          refinerysSpeed++;
          controller.unlockRefinerySpeed(refinerysSpeed);
          break;
        case (4): //end game
          if (controller.getMoney() < prices[4][0])
            return;
          controller.win(); // Just win it
          break;
        default:
          break;
      }
      controller.setShopText(""); //reset text
      selected = -1;
    } catch (Exception e) {
      System.out.println("Confirm error");
    }

  }


  /**
   * 
   *  changeSelected method defines selected index and sets his text
   * 
   * {@param select : defines selected index then switches it to display determined text}
   */
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
      case (4):
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
