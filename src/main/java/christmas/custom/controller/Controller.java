package christmas.custom.controller;

import christmas.custom.service.parser.DateParser;
import christmas.custom.view.InputView;
import christmas.custom.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final DateParser dateParser;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dateParser = new DateParser();
    }

    public void start() {
        int date = inputResponseForDate();
    }

    // 제대로 된 입력이 있을 때까지 반복
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
}