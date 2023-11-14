package christmas.view;

import christmas.enums.MenuItem;
import java.util.Map;

public class OutputView {

  private final static String OPENING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
  private final static String EVENT_PREVIEW = " 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
  private final static String ORDER_MENU_HEADER = "<주문 메뉴>";
  private final static String TOTAL_ORDER_PRICE_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";

  public static void opening() {
    System.out.println(OPENING);
  }

  public static void previewEventBenefits(int date) {
    System.out.println("12월 " + date + "일에" + EVENT_PREVIEW);
  }
  public static void printOrderedMenu(Map<MenuItem,Integer> orders) {
    System.out.println(ORDER_MENU_HEADER);
    for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
      System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
    }
    System.out.println();
  }
  public static void totalPrice(int totalPrice){
    System.out.println(TOTAL_ORDER_PRICE_BEFORE_DISCOUNT);
    System.out.println(totalPrice+"원"+"\n");
  }
}