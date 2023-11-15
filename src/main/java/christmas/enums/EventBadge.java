package christmas.enums;

public enum EventBadge {
  SANTA("산타", 20000),
  TREE("트리", 10000),
  STAR("별", 5000),
  NONE("없음", 0);

  private final String name;
  private final int price;

  EventBadge(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public static EventBadge calculateEventBadge(int totalDiscount) {
    int absoluteDiscount = Math.abs(totalDiscount);
    for (EventBadge badge : EventBadge.values()) {
      if (absoluteDiscount >= badge.price) {
        return badge;
      }
    }
    return EventBadge.NONE;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
