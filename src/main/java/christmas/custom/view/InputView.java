package christmas.custom.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String WELCOME_PROMPT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ORDER_PROMPT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String askForDate() {
        System.out.println(WELCOME_PROMPT);
        System.out.println(DATE_PROMPT);
        return Console.readLine();
    }

    public String askForOrder() {
        System.out.println(ORDER_PROMPT);
        return Console.readLine();
    }
}