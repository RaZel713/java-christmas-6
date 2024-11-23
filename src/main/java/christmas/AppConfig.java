package christmas;

import christmas.custom.view.InputView;
import christmas.custom.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}