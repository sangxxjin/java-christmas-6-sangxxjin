package christmas;

import christmas.enums.EventBadge;
import christmas.enums.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefits {

  private static int totalPrice;
  private static boolean promotion;
  private static List<Integer> benefitsList = new ArrayList<>();
  private static int benefits;
  private static int afterDiscountPrice;
  private static EventBadge Badge;
  private static final int CHRISTMAS_EVENT_START_DATE = 1;
  private static final int CHRISTMAS_EVENT_END_DATE = 25;
  private static final int WEEK_DISCOUNT_PRICE = 2023;
  private static final int SPECIAL_DISCOUNT_PRICE = 1000;

  public Benefits() {
    calculateTotalPrice(Orders.getOrders());
    selectGift();
    christmasDiscount();
    selectDayDiscount(Orders.getOrders());
    specialDiscount();
    promotion();
    afterDiscountPrice();
    selectBadge(totalPrice);
  }

  private void calculateTotalPrice(Map<MenuItem, Integer> orders) {
    for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
      MenuItem menuItem = entry.getKey();
      int itemCount = entry.getValue();
      totalPrice += menuItem.getPrice() * itemCount;
    }
  }

  private void selectGift() {
    if (totalPrice > 120000) {
      promotion = true;
    } else {
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
    int dayDiscount = 0;
    if (Date.isFridayOrSaturday(Date.getDate())) {
      for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
        if ("메인".equals(entry.getKey().getCategory())) {
          dayDiscount += WEEK_DISCOUNT_PRICE * entry.getValue();
        }
      }
    }
    if (!Date.isFridayOrSaturday(Date.getDate())) {
      for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
        if ("디저트".equals(entry.getKey().getCategory())) {
          dayDiscount += WEEK_DISCOUNT_PRICE * entry.getValue();
        }
      }
    }
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
    if (promotion)afterDiscountPrice+=25000;
  }

  public void selectBadge(int totalPrice) {
    Badge = EventBadge.calculateEventBadge(totalPrice);
  }

  public static int getTotalPrice() {
    return totalPrice;
  }

  public static boolean getPromotion() {
    return promotion;
  }

  public static List<Integer> getBenefitsList() {
    return benefitsList;
  }

  public static int getBenefits() {
    return benefits;
  }

  public static int getAfterDiscountPrice() {
    return afterDiscountPrice;
  }

  public static EventBadge getBadge() {
    return Badge;
  }
}