package christmas.custom.view;

import static christmas.custom.view.DisplayConstants.DATE_PROMPT;
import static christmas.custom.view.DisplayConstants.ORDER_PROMPT;
import static christmas.custom.view.DisplayConstants.WELCOME_PROMPT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String askForDate() {
        System.out.println(WELCOME_PROMPT.getFormat());
        System.out.println(DATE_PROMPT.getFormat());
        return Console.readLine();
    }

    public String askForOrder() {
        System.out.println(ORDER_PROMPT.getFormat());
        return Console.readLine();
    }
}