package christmas.custom.view;

public enum DisplayConstants {
    WELCOME_PROMPT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE_PROMPT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_PROMPT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    
    TITLE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER(" <주문 메뉴>"),
    TOTAL_PRICE("<할인 전 총주문 금액>"),
    FREEBIE("<증정 메뉴>"),
    EVENT("<혜택 내역>"),
    EVENT_PRICE("<총혜택 금액>"),
    FINAL_PRICE("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>");

    private final String format;

    DisplayConstants(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public String format(Object... args) {
        return String.format(format, args);
    }
}