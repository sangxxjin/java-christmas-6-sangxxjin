package christmas.model;

import christmas.enums.EventBadge;
import christmas.enums.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Benefits {
  private List<Integer> benefitsList = new ArrayList<>();
  private int benefits;
  private static final int CHRISTMAS_EVENT_START_DATE = 1;
  private static final int CHRISTMAS_EVENT_END_DATE = 25;
  private static final int WEEK_DISCOUNT_PRICE = 2023;
  private static final int SPECIAL_DISCOUNT_PRICE = 1000;

  public Benefits(Prices prices, Orders orders, Date date) {
    benefitsList.add(christmasDiscount(date));
    benefitsList.add(selectDayDiscount(orders.getOrders(),date));
    benefitsList.add(specialDiscount(date));
    benefitsList.add(promotion(prices.getTotalPrice()));
    addBenefits(benefitsList);
  }

  public boolean selectPromotion(int totalPrice) {
    if (totalPrice > 120000) {
      return true;
    }
    return false;
  }

  private int christmasDiscount(Date date) {
    int christmasDiscount=0;
    if (date.getDate().getDayOfMonth() >= CHRISTMAS_EVENT_START_DATE
        && date.getDate().getDayOfMonth() <= CHRISTMAS_EVENT_END_DATE) {
      christmasDiscount = 900 + (date.getDate().getDayOfMonth() * 100);
    }
    return christmasDiscount;
  }

  private int selectDayDiscount(Map<MenuItem, Integer> orders,Date date) {
    int dayDiscount = orders.entrySet()
        .stream()
        .filter(entry ->
            (date.isFridayOrSaturday(date.getDate()) && "메인".equals(entry.getKey().getCategory()))
                || (!date.isFridayOrSaturday(date.getDate()) && "디저트".equals(
                entry.getKey().getCategory())))
        .mapToInt(entry -> WEEK_DISCOUNT_PRICE * entry.getValue())
        .sum();
    return dayDiscount;
  }

  private int specialDiscount(Date date) {
    if (Date.isSpecialDay(date.getDate())) {
      return SPECIAL_DISCOUNT_PRICE;
    }
    return 0;
  }

  private int promotion(int totalPrices) {
    if (totalPrices>120000) {
      return 25000;
    }
    return 0;
  }

  private void addBenefits(List<Integer> benefitsList){
    for (int i = 0; i < benefitsList.size(); i++) {
      benefits+=benefitsList.get(i);
    }
  }

  public EventBadge selectBadge(int totalPrice) {
    return EventBadge.calculateEventBadge(totalPrice);
  }


  public List<Integer> getBenefitsList() {
    return benefitsList;
  }

  public int getBenefits() {
    return benefits;
  }
}