package christmas.custom.view;

import static christmas.custom.view.DisplayConstants.EVENT;
import static christmas.custom.view.DisplayConstants.EVENT_BADGE;
import static christmas.custom.view.DisplayConstants.EVENT_PRICE;
import static christmas.custom.view.DisplayConstants.FINAL_PRICE;
import static christmas.custom.view.DisplayConstants.FREEBIE;
import static christmas.custom.view.DisplayConstants.ORDER;
import static christmas.custom.view.DisplayConstants.TITLE;
import static christmas.custom.view.DisplayConstants.TOTAL_PRICE;

import christmas.custom.model.EventResult;
import christmas.custom.model.OrderSheet.OrderedMenu;
import java.util.List;

public class OutputView {
    public void displayEventResult(int date, List<OrderedMenu> orderSheet, EventResult result) {
        printTitle(date);
        printOrder(date, orderSheet);
        printTotalPrice(result);
        printFreebie(result);
        printEvents(result);
        printResultPrice(result);
        printBadge(result);
    }

    private void printTitle(int date) {
        System.out.println(TITLE.format(date));
        System.out.println();
    }

    private void printOrder(int date, List<OrderedMenu> orderSheet) {
        System.out.println(ORDER.getFormat());
        for (OrderedMenu orderedMenu : orderSheet) {
            System.out.println(orderedMenu.getName() + " " + orderedMenu.getCount() + "개");
        }
        System.out.println();
    }

    private void printTotalPrice(EventResult result) {
        System.out.println(TOTAL_PRICE.getFormat());
        System.out.println(String.format("%,d", result.getTotalPrice()) + "원");
        System.out.println();
    }

    private void printFreebie(EventResult result) {
        System.out.println(FREEBIE.getFormat());
        System.out.println(result.getFreebie());
        System.out.println();
    }

    private void printEvents(EventResult result) {
        System.out.println(EVENT.getFormat());
        for (String event : result.getAppliedEvents()) {
            System.out.println(event);
        }
        System.out.println();
    }

    private void printResultPrice(EventResult result) {
        System.out.println(EVENT_PRICE.getFormat());
        System.out.println(String.format("-%,d", result.getEventPrice()) + "원");
        System.out.println();

        System.out.println(FINAL_PRICE.getFormat());
        System.out.println(String.format("%,d", result.getFinalPrice()) + "원");
        System.out.println();
    }

    private void printBadge(EventResult result) {
        System.out.println(EVENT_BADGE.getFormat());
        System.out.println(result.getBadge());
    }

    // 에러 메시지 출력
    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}