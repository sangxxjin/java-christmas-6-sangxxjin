package christmas.model;

import christmas.enums.EventBadge;
import christmas.enums.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BenefitsTest {

  private Benefits benefits;

  @BeforeEach
  public void setUp() {
    Prices mockPrices = Mockito.mock(Prices.class);
    Orders mockOrders = Mockito.mock(Orders.class);
    Date mockDate = Mockito.mock(Date.class);

    when(mockPrices.getTotalPrice()).thenReturn(130000);

    Map<MenuItem, Integer> orders = new HashMap<>();
    orders.put(MenuItem.T_BONE_STEAK, 2);
    orders.put(MenuItem.CHOCOLATE_CAKE, 1);
    when(mockOrders.getOrders()).thenReturn(orders);

    when(mockDate.getDate()).thenReturn(LocalDate.of(2023, 12, 25));

    benefits = new Benefits(mockPrices, mockOrders, mockDate);
  }

  @Test
  public void testBenefitsCalculation() {
    assertEquals(3400, benefits.getBenefitsList().get(0));

    assertEquals(2023, benefits.getBenefitsList().get(1));

    assertEquals(1000, benefits.getBenefitsList().get(2));

    assertEquals(25000, benefits.getBenefitsList().get(3));

    assertEquals(31423, benefits.getBenefits());

    assertEquals(EventBadge.SANTA, benefits.selectBadge(150000));
  }
}
