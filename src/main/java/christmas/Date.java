package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {

  private static LocalDate date;


  public Date(String dateString) {
    int parsedDate=Integer.parseInt(dateString);
    this.date = LocalDate.of(2023,12,parsedDate);
  }

  public static LocalDate getDate() {
    return date;
  }
}

