package christmas.custom.view;

import christmas.custom.model.EventResult;
import christmas.custom.model.OrderSheet.OrderedMenu;
import java.util.List;

public class OutputView {
    public void displayEventResult(int date, List<OrderedMenu> orderSheet, EventResult result) {
        System.out.println(DisplayConstants.TITLE.format(date));
        System.out.println();

        System.out.println(DisplayConstants.ORDER.getFormat());
        for (OrderedMenu orderedMenu : orderSheet) {
            System.out.println(orderedMenu.getName() + " " + orderedMenu.getCount() + "개");
        }
        System.out.println();

        System.out.println(DisplayConstants.TOTAL_PRICE.getFormat());
        System.out.println(String.format("%,d", result.getTotalPrice()) + "원");
        System.out.println();

        System.out.println(DisplayConstants.FREEBIE.getFormat());
        System.out.println(result.getFreebie());
        System.out.println();

        System.out.println(DisplayConstants.EVENT.getFormat());
        for (String event : result.getAppliedEvents()) {
            System.out.println(event);
        }
        System.out.println();

        System.out.println(DisplayConstants.EVENT_PRICE.getFormat());
        System.out.println(String.format("-%,d", result.getEventPrice()) + "원");
        System.out.println();

        System.out.println(DisplayConstants.FINAL_PRICE.getFormat());
        System.out.println(String.format("%,d", result.getFinalPrice()) + "원");
        System.out.println();

        System.out.println(DisplayConstants.EVENT_BADGE.getFormat());
        System.out.println(result.getBadge());
    }

    // 에러 메시지 출력
    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}