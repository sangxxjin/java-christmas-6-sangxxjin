package christmas.view;

public class OutputView {

  private final static String OPENING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
  private final static String EVENT_PREVIEW = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

  public static void opening() {
    System.out.println(OPENING);
  }

  public static void previewEventBenefits() {
    System.out.println(EVENT_PREVIEW);
  }

}
