package christmas.model;

import christmas.enums.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class Orders {

  private static Map<MenuItem, Integer> orders = new HashMap<>();
  private static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";


  public Orders(String orderString) {
    this.orders = processOrderString(orderString);
  }

  private Map<MenuItem, Integer> processOrderString(String orderString) {
    Map<MenuItem, Integer> processedOrders = new HashMap<>();
    String[] orderItems = orderString.split(",");

    for (String item : orderItems) {
      processOrderItem(item, processedOrders);
    }

    return processedOrders;
  }

  private void processOrderItem(String item, Map<MenuItem, Integer> processedOrders) {
    String[] itemDetails = item.split("-");

    if (itemDetails.length != 2) {
      handleInvalidOrder(INVALID_ORDER_MESSAGE);
    }

    String itemName = itemDetails[0];
    int itemCount = 0;

    try {
      itemCount = Integer.parseInt(itemDetails[1]);
    } catch (NumberFormatException e) {
      handleInvalidOrder(INVALID_ORDER_MESSAGE);
    }

    if (itemCount < 1) {
      handleInvalidOrder(INVALID_ORDER_MESSAGE);
    }

    MenuItem menuItem = findMenuItem(itemName);

    if (menuItem == null) {
      handleInvalidOrder(INVALID_ORDER_MESSAGE);
    }

    if (processedOrders.containsKey(menuItem)) {
      handleInvalidOrder(INVALID_ORDER_MESSAGE);
    } else {
      processedOrders.put(menuItem, itemCount);
    }
  }

  private void handleInvalidOrder(String errorMessage) {
    throw new IllegalArgumentException(errorMessage);
  }

  private MenuItem findMenuItem(String itemName) {
    for (MenuItem itemEnum : MenuItem.values()) {
      if (itemEnum.getName().equals(itemName)) {
        return itemEnum;
      }
    }
    return null;
  }

  public static Map<MenuItem, Integer> getOrders() {
    return orders;
  }


}