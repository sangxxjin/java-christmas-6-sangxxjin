package christmas.view;

import christmas.Date;
import christmas.enums.MenuItem;
import java.util.List;
import java.util.Map;

public class OutputView {

  private final static String MINUS = "-";

  private final static String OPENING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
  private final static String EVENT_PREVIEW = " 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
  private final static String ORDER_MENU_HEADER = "<주문 메뉴>";
  private final static String TOTAL_ORDER_PRICE_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
  private final static String GIFT_MENU = "<증정 메뉴>";
  private final static String BENEFITS_DETAILS = "<혜택 내역>";
  private final static String CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인";
  private static final String TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>";
  private static final String EXPECTED_PAYMENT_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
  private static final String DECEMBER_EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";

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

  public static void giftMenu(boolean giftMenu) {
    System.out.println(GIFT_MENU);
    if (giftMenu) {
      System.out.println("샴페인 1개"+"\n");
    }
    if (!giftMenu) {
      System.out.println("없음"+"\n");
    }
  }
  public static void benefitsDetails(List<Integer> benefitsList){
    System.out.println(BENEFITS_DETAILS);
    boolean checkAllZero = true;
    for (Integer value : benefitsList) {
      if (value != 0) {
        checkAllZero = false;
      }
    }
    if (!checkAllZero) {
      System.out.println(CHRISTMAS_DDAY_DISCOUNT + ": " + MINUS + benefitsList.get(0) + "원");
      if (Date.isFridayOrSaturday(Date.getDate())) {
        System.out.println("주말 할인: " + MINUS + benefitsList.get(1) + "원");
      }
      if (!Date.isFridayOrSaturday(Date.getDate())) {
        System.out.println("평일 할인: " + MINUS + benefitsList.get(1) + "원");
      }
      System.out.println("특별 할인: " + MINUS + benefitsList.get(2) + "원");
      System.out.println("증정 이벤트: " + MINUS + benefitsList.get(3) + "원"+"\n");
    } else {
      System.out.println("없음"+"\n");
    }
  }
  public static void totalBenfitsAmount(int benefits){
    System.out.println(TOTAL_BENEFIT_AMOUNT);
    if (0 == benefits) {
      System.out.println("없음"+"\n");
    }
    else System.out.println(MINUS+ benefits+"원"+"\n");
  }
  public static void afterDiscountPrice(int afterDiscountPrice){
    System.out.println(EXPECTED_PAYMENT_AMOUNT_AFTER_DISCOUNT);
    System.out.println(afterDiscountPrice+"원"+"\n");
  }
  public static void badge(String badge){
    System.out.println(DECEMBER_EVENT_BADGE_MESSAGE);
    System.out.println(badge);
  }
}