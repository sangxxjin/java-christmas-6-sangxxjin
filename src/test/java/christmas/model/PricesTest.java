package christmas.model;

import christmas.enums.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricesTest {

  @Test
  public void testCalculateTotalPrice() {
    Map<MenuItem, Integer> orders = new HashMap<>();
    orders.put(MenuItem.T_BONE_STEAK, 2);
    orders.put(MenuItem.CHOCOLATE_CAKE, 1);

    Prices prices = new Prices(orders);

    assertEquals(125000, prices.getTotalPrice());
  }

  @Test
  public void testAfterDiscountPrice() {
    Map<MenuItem, Integer> orders = new HashMap<>();
    orders.put(MenuItem.T_BONE_STEAK, 1);
    orders.put(MenuItem.CHOCOLATE_CAKE, 1);

    Prices prices = new Prices(orders);

    int benefits = 2500;
    int afterDiscountPrice = prices.afterDiscountPrice(benefits);

    assertEquals(67500, afterDiscountPrice);
  }

  @Test
  public void testAfterDiscountPriceWithChampagne() {
    Map<MenuItem, Integer> orders = new HashMap<>();
    orders.put(MenuItem.T_BONE_STEAK, 2);
    orders.put(MenuItem.CHOCOLATE_CAKE, 1);

    Prices prices = new Prices(orders);

    int benefits = 2500;
    int afterDiscountPrice = prices.afterDiscountPrice(benefits);

    assertEquals(147500, afterDiscountPrice);
  }
}
