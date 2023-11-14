package christmas;

import christmas.enums.MenuItem;
import java.util.Map;

public class Benefits {

  private static int totalPrice;

  public Benefits() {
    calculateTotalPrice(Orders.getOrders());
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
