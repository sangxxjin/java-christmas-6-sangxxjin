package christmas.view;

public class OutputView {

  private final static String OPENING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
  private final static String EVENT_PREVIEW = " 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

  public static void opening() {
    System.out.println(OPENING);
  }

  public static void previewEventBenefits(int date) {
    System.out.println("12월 "+date+"일에"+EVENT_PREVIEW);
  }

}
