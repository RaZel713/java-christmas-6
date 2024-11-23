package christmas.custom.view;

public enum DisplayConstants {
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