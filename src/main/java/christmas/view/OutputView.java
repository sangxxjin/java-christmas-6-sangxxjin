package christmas.view;

import christmas.Date;
import christmas.enums.MenuItem;
import java.util.List;
import java.util.Map;

public class OutputView {

  private final static String MINUS_SIGN = "-";
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
    System.out.println(String.format("12월 %d일에%s", date, EVENT_PREVIEW));
  }

  public static void printOrderedMenu(Map<MenuItem, Integer> orders) {
    System.out.println(ORDER_MENU_HEADER);
    for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
      System.out.println(String.format("%s %d개", entry.getKey().getName(), entry.getValue()));
    }
    System.out.println();
  }

  public static void totalPrice(int totalPrice) {
    System.out.println(TOTAL_ORDER_PRICE_BEFORE_DISCOUNT);
    System.out.println(String.format("%,d원", totalPrice) + "\n");
  }

  public static void giftMenu(boolean giftMenu) {
    System.out.println(GIFT_MENU);
    if (giftMenu) {
      System.out.println("샴페인 1개" + "\n");
    }
    if (!giftMenu) {
      System.out.println("없음" + "\n");
    }
  }

  public static void displayBenefitsDetails(List<Integer> benefitsList) {
    System.out.println(BENEFITS_DETAILS);
    boolean areAllValuesZero = true;
    for (Integer value : benefitsList) {
      if (value != 0) {
        areAllValuesZero = false;
      }
    }
    if (!areAllValuesZero) {
      System.out.println(
          String.format("%s: %s%,d원", CHRISTMAS_DDAY_DISCOUNT, MINUS_SIGN, benefitsList.get(0)));
      if (Date.isFridayOrSaturday(Date.getDate())) {
        System.out.println(String.format("주말 할인: %s%,d원", MINUS_SIGN, benefitsList.get(1)));
      }
      if (!Date.isFridayOrSaturday(Date.getDate())) {
        System.out.println(String.format("평일 할인: %s%,d원", MINUS_SIGN, benefitsList.get(1)));
      }
      System.out.println(String.format("특별 할인: %s%,d원", MINUS_SIGN, benefitsList.get(2)));
      System.out.println(String.format("증정 이벤트: %s%,d원" + "\n", MINUS_SIGN, benefitsList.get(3)));
    }
    if (areAllValuesZero) {
      System.out.println("없음" + "\n");
    }
  }

  public static void displayTotalBenefitsAmount(int benefits) {
    System.out.println(TOTAL_BENEFIT_AMOUNT);
    if (0 == benefits) {
      System.out.println("없음" + "\n");
    }
    if (0 != benefits) {
      System.out.println(String.format("%s%,d원" + "\n", MINUS_SIGN, benefits));
    }
  }

  public static void afterDiscountPrice(int afterDiscountPrice) {
    System.out.println(EXPECTED_PAYMENT_AMOUNT_AFTER_DISCOUNT);
    System.out.println(String.format("%,d원" + "\n", afterDiscountPrice));
  }

  public static void badge(String badge) {
    System.out.println(DECEMBER_EVENT_BADGE_MESSAGE);
    System.out.println(badge);
  }
}