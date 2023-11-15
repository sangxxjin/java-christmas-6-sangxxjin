package christmas.model;

import christmas.enums.MenuItem;
import java.util.Map;

public class Prices {

  private static int totalPrice;

  public Prices(Map<MenuItem, Integer> orders) {
    calculateTotalPrice(orders);
  }
  private void calculateTotalPrice(Map<MenuItem, Integer> orders) {
    for (Map.Entry<MenuItem, Integer> entry : orders.entrySet()) {
      MenuItem menuItem = entry.getKey();
      int itemCount = entry.getValue();
      totalPrice += menuItem.getPrice() * itemCount;
    }
  }

  public static int getTotalPrice() {
    return totalPrice;
  }
}