package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private final static String VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

  public static String readDate() {
    System.out.println(VISIT_DATE);
    return Console.readLine();
  }

}
