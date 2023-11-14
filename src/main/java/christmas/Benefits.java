package christmas;

import christmas.enums.MenuItem;
import java.util.Map;

public class Benefits {

  private static int totalPrice;
  private static boolean promotion;

  public Benefits() {
    calculateTotalPrice(Orders.getOrders());
    selectGift();
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

  public static int getTotalPrice() {
    return totalPrice;
  }

  public static boolean getPromotion() {
    return promotion;
  }
}
