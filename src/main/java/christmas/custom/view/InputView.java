package christmas.custom.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String WELCOME_PROMPT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public String askForDate() {
        System.out.println(WELCOME_PROMPT);
        System.out.println(DATE_PROMPT);
        return Console.readLine();
    }


}