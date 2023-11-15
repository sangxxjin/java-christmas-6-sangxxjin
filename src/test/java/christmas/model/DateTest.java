package christmas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

  @Test
  public void testValidDateCreation() {
    Date validDate = new Date("10");
    assertEquals(LocalDate.of(2023, 12, 10), validDate.getDate());
  }

  @Test
  public void testInvalidDateCreation() {
    assertThrows(IllegalArgumentException.class, () -> new Date("35"));
    assertThrows(IllegalArgumentException.class, () -> new Date("0"));
    assertThrows(IllegalArgumentException.class, () -> new Date("-5"));
    assertThrows(IllegalArgumentException.class, () -> new Date("abc"));
  }

  @Test
  public void testIsFridayOrSaturday() {
    LocalDate friday = LocalDate.of(2023, 12, 15);
    assertTrue(Date.isFridayOrSaturday(friday));

    LocalDate saturday = LocalDate.of(2023, 12, 16);
    assertTrue(Date.isFridayOrSaturday(saturday));

    LocalDate sunday = LocalDate.of(2023, 12, 17);
    assertFalse(Date.isFridayOrSaturday(sunday));
  }

  @Test
  public void testIsSpecialDay() {
    LocalDate sunday = LocalDate.of(2023, 12, 17);
    assertTrue(Date.isSpecialDay(sunday));

    LocalDate christmas = LocalDate.of(2023, 12, 25);
    assertTrue(Date.isSpecialDay(christmas));

    LocalDate wednesday = LocalDate.of(2023, 12, 13);
    assertFalse(Date.isSpecialDay(wednesday));
  }
}
