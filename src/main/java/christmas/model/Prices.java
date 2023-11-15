package christmas.model;

import christmas.enums.MenuItem;
import java.util.Map;

public class Prices {

  private static int totalPrice;

  public Prices(Map<MenuItem, Integer> orders) {

  }

  public static int getTotalPrice() {
    return totalPrice;
  }
}