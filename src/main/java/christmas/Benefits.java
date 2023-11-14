package christmas;

import christmas.enums.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefits {

  private static int totalPrice;
  private static boolean promotion;
  private static List<Integer> benefitsList = new ArrayList<>();
  private static int benefits;

  public Benefits() {
    calculateTotalPrice(Orders.getOrders());
    selectGift();
    christmasDiscount();
    selectDayDiscount(Orders.getOrders());
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
    if (Date.getDate().getDayOfMonth()>=1&&Date.getDate().getDayOfMonth()<=25){
      benefitsList.add(900 + (Date.getDate().getDayOfMonth() * 100));
    }
    else benefitsList.add(0);
    benefits += benefitsList.get(0);
  }

  private void selectDayDiscount(Map<MenuItem, Integer> orders) {
    int dayDiscount = 0;
    if (Date.isFridayOrSaturday(Date.getDate())) {
      for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
        if ("메인".equals(entry.getKey().getCategory())) dayDiscount += 2303;
      }
    }
    if (!Date.isFridayOrSaturday(Date.getDate())) {
      for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
        if ("디저트".equals(entry.getKey().getCategory())) dayDiscount += 2303;
      }
    }
    benefitsList.add(dayDiscount);
    benefits += benefitsList.get(1);
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
}
