package christmas;

import christmas.custom.controller.Controller;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Controller controller = new Controller(
                appConfig.inputView(), appConfig.outputView());
        controller.start();
    }
}
