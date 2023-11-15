package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {

  private LocalDate date;
  private static final int YEAR = 2023;
  private static final int MONTH = 12;
  private static final int EVENT_START_DATE = 1;
  private static final int EVENT_END_DATE = 31;
  private static final int CHRISTMAS_DDAY = 25;

  private static final String INVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

  public Date(String dateString) {
    try {
      int parsedDate = Integer.parseInt(dateString);
      if (isValidDate(parsedDate)) {
        this.date = LocalDate.of(YEAR, MONTH, parsedDate);
      }
      if (!isValidDate(parsedDate)) {
        throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
    }
  }

  private boolean isValidDate(int date) {
    return date >= EVENT_START_DATE && date <= EVENT_END_DATE;
  }

  public static boolean isFridayOrSaturday(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
  }

  public static boolean isSpecialDay(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    return dayOfWeek == DayOfWeek.SUNDAY || date.getDayOfMonth() == CHRISTMAS_DDAY;
  }

  public LocalDate getDate() {
    return date;
  }
}

