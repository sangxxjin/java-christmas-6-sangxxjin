package christmas.controller;

import christmas.model.Benefits;
import christmas.model.Date;
import christmas.model.Orders;
import christmas.model.Prices;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

  public static void dateRun() {
    OutputView.opening();
    while (true) {
      try {
        Date selectedDate = new Date(InputView.readDate());
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static void ordersRun() {
    while (true) {
      try {
        Orders putOrders = new Orders(InputView.readMenu());
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    OutputView.previewEventBenefits(Date.getDate().getDayOfMonth());
    System.out.println();
  }

  public static void benefitsRun() {
    Prices prices = new Prices(Orders.getOrders());
    Benefits benefits = new Benefits();
    OutputView.printOrderedMenu(Orders.getOrders());
    OutputView.totalPrice(prices.getTotalPrice());
    OutputView.giftMenu(benefits.selectPromotion(prices.getTotalPrice()));
    OutputView.displayBenefitsDetails(benefits.getBenefitsList());
    OutputView.displayTotalBenefitsAmount(benefits.getBenefits());
    OutputView.afterDiscountPrice(prices.afterDiscountPrice(benefits.getBenefits()));
    OutputView.badge(benefits.selectBadge(prices.getTotalPrice()));
  }

}
