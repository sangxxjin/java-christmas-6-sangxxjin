package christmas.controller;

import christmas.model.Benefits;
import christmas.model.Date;
import christmas.model.Orders;
import christmas.model.Prices;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

  public static Date dateRun() {
    OutputView.opening();
    while (true) {
      try {
        Date selectedDate = new Date(InputView.readDate());
        return selectedDate;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public static Orders ordersRun(Date date) {
    while (true) {
      try {
        Orders putOrders = new Orders(InputView.readMenu());
        OutputView.previewEventBenefits(date.getDate().getDayOfMonth());
        System.out.println();
        return putOrders;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

  }

  public static void Run() {
    Date date = dateRun();
    Orders orders = ordersRun(date);
    Prices prices = new Prices(orders.getOrders());
    Benefits benefits = new Benefits(prices, orders, date);
    OutputView.printOrderedMenu(orders.getOrders());
    OutputView.totalPrice(prices.getTotalPrice());
    OutputView.giftMenu(benefits.selectPromotion(prices.getTotalPrice()));
    OutputView.displayBenefitsDetails(benefits.getBenefitsList(),date);
    OutputView.displayTotalBenefitsAmount(benefits.getBenefits());
    OutputView.afterDiscountPrice(prices.afterDiscountPrice(benefits.getBenefits()));
    OutputView.badge(benefits.selectBadge(prices.getTotalPrice()));
  }

}
