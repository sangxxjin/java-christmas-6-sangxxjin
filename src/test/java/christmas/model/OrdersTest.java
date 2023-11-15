package christmas.model;

import christmas.enums.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrdersTest {

  @Test
  public void testValidOrderCreation() {
    String validOrderString = "티본스테이크-2,초코케이크-1";
    Orders orders = new Orders(validOrderString);

    Map<MenuItem, Integer> expectedOrders = Map.of(
        MenuItem.T_BONE_STEAK, 2,
        MenuItem.CHOCOLATE_CAKE, 1
    );

    assertEquals(expectedOrders, orders.getOrders());
  }

  @Test
  public void testInvalidOrderCreation() {
    assertThrows(IllegalArgumentException.class, () -> new Orders("INVALID_ITEM-2"));
    assertThrows(IllegalArgumentException.class, () -> new Orders("T_BONE_STEAK-0"));
    assertThrows(IllegalArgumentException.class, () -> new Orders("CHOCOLATE_CAKE-invalid"));
    assertThrows(IllegalArgumentException.class, () -> new Orders("T_BONE_STEAK-1,T_BONE_STEAK-2"));
    assertThrows(IllegalArgumentException.class, () -> new Orders("T_BONE_STEAK"));
  }

  @Test
  public void testInvalidMenuItem() {
    assertThrows(IllegalArgumentException.class, () -> new Orders("NON_EXISTENT_ITEM-2"));
  }
}
