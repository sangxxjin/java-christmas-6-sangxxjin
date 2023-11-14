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

}
