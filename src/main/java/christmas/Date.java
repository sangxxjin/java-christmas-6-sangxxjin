package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {

  private static LocalDate date;
  private static final String INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

  public Date(String dateString) {
    try {
      int parsedDate = Integer.parseInt(dateString);
      if (isValidDate(parsedDate)) {
        this.date = LocalDate.of(2023,12,parsedDate);
      } else {
        throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
    }
  }

  private boolean isValidDate(int date) {
    return date >= 1 && date <= 31;
  }

  public static LocalDate getDate() {
    return date;
  }
}

