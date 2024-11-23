package christmas.custom.controller;

import christmas.custom.model.EventResult;
import christmas.custom.model.OrderSheet.OrderedMenu;
import christmas.custom.service.maker.EventResultMaker;
import christmas.custom.service.parser.DateParser;
import christmas.custom.service.parser.OrderParser;
import christmas.custom.view.InputView;
import christmas.custom.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final DateParser dateParser;
    private final OrderParser orderParser;
    private final EventResultMaker eventResultMaker;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dateParser = new DateParser();
        this.orderParser = new OrderParser();
        this.eventResultMaker = new EventResultMaker();
    }

    public void start() {
        int date = inputResponseForDate();
        List<OrderedMenu> orderSheet = inputResponseForOrder();
        EventResult result = eventResultMaker.start(date, orderSheet);
    }

    // 날짜 입력
    private int inputResponseForDate() {
        while (true) {
            try {
                String response = inputView.askForDate();
                return dateParser.run(response);
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    // 주문 입력
    private List<OrderedMenu> inputResponseForOrder() {
        while (true) {
            try {
                String response = inputView.askForOrder();
                return orderParser.run(response);
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}