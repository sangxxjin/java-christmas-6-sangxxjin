package christmas.model;

import christmas.enums.EventBadge;
import christmas.enums.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefits {
  private static List<Integer> benefitsList = new ArrayList<>();
  private static int benefits;
  private static final int CHRISTMAS_EVENT_START_DATE = 1;
  private static final int CHRISTMAS_EVENT_END_DATE = 25;
  private static final int WEEK_DISCOUNT_PRICE = 2023;
  private static final int SPECIAL_DISCOUNT_PRICE = 1000;

  public Benefits() {
    christmasDiscount();
    selectDayDiscount(Orders.getOrders());
    specialDiscount();
    promotion(Prices.getTotalPrice());
  }

  public boolean selectPromotion(int totalPrice) {
    if (totalPrice > 120000) {
      promotion = true;
    }
    if (totalPrice <= 120000) {
      promotion = false;
    }
  }

  private void christmasDiscount() {
    if (Date.getDate().getDayOfMonth() >= CHRISTMAS_EVENT_START_DATE
        && Date.getDate().getDayOfMonth() <= CHRISTMAS_EVENT_END_DATE) {
      benefitsList.add(900 + (Date.getDate().getDayOfMonth() * 100));
    } else {
      benefitsList.add(0);
    }
    benefits += benefitsList.get(0);
  }

  private void selectDayDiscount(Map<MenuItem, Integer> orders) {
    int dayDiscount = orders.entrySet()
        .stream()
        .filter(entry ->
            (Date.isFridayOrSaturday(Date.getDate()) && "메인".equals(entry.getKey().getCategory()))
                || (!Date.isFridayOrSaturday(Date.getDate()) && "디저트".equals(
                entry.getKey().getCategory())))
        .mapToInt(entry -> WEEK_DISCOUNT_PRICE * entry.getValue())
        .sum();

    benefitsList.add(dayDiscount);
    benefits += benefitsList.get(1);
  }

  public void specialDiscount() {
    if (Date.isSpecialDay(Date.getDate())) {
      benefitsList.add(SPECIAL_DISCOUNT_PRICE);
    } else {
      benefitsList.add(0);
    }
    benefits += benefitsList.get(2);
  }

  public void promotion() {
    if (promotion) {
      benefitsList.add(25000);
      benefits += benefitsList.get(3);
    } else {
      benefitsList.add(0);
    }
  }

  public void afterDiscountPrice() {
    afterDiscountPrice = totalPrice - benefits;
    if (promotion) {
      afterDiscountPrice += MenuItem.CHAMPAGNE.getPrice();
    }
  }

  public void selectBadge(int totalPrice) {
    Badge = EventBadge.calculateEventBadge(totalPrice);
  }


  public static List<Integer> getBenefitsList() {
    return benefitsList;
  }

  public static int getBenefits() {
    return benefits;
  }
}