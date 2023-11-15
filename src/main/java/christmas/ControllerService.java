package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ControllerService {

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
    Benefits benefits = new Benefits();
    OutputView.printOrderedMenu(Orders.getOrders());
    OutputView.totalPrice(benefits.getTotalPrice());
    OutputView.giftMenu(benefits.getPromotion());
    OutputView.displayBenefitsDetails(benefits.getBenefitsList());
    OutputView.displayTotalBenefitsAmount(benefits.getBenefits());
    OutputView.afterDiscountPrice(benefits.getAfterDiscountPrice());
    OutputView.badge(benefits.getBadge());
  }

}
