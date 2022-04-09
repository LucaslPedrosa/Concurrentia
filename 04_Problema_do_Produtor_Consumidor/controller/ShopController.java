package controller;

public class ShopController {

  private static int selected = 0;
  private static MainController controller;
  
  private static int gasStations = 0;
  private static int gasSpeed = 0;

  private static int refinerys = 0;
  private static int refinerysSpeed = 0;
  
  private static int win = 0;

  private static String text[][] = new String[6][6];

  public static void confirm(){

    switch(selected){
      case(1):

        break;
      default:
        break;
    }
    
    
    
  }

  public static void changeSelected(int select){
    selected = select;
    switch(select){
      case(1):
        controller.setShopText(text[1][gasStations]);
        break;
      default:
        break;

    }
  }

  public static void setController(MainController ctrl){
    controller = ctrl;
  }
  
}
