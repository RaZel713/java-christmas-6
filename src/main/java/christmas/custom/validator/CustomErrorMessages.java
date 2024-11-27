package christmas.custom.validator;

public enum CustomErrorMessages {
    NULL_INPUT("입력이 null 입니다."),

    EMPTY_STRING_INPUT("입력이 빈 문자열입니다."),

    WHITESPACE_ONLY_INPUT("입력이 공백으로만 구성되어 있습니다."),

    INVALID_DATE("유효하지 않은 날짜입니다."),

    INVALID_ORDER("유효하지 않은 주문입니다.");

    private static final String ERROR_SIGN = "[ERROR] ";
    private static final String RETYPE_PROMPT = " 다시 입력해 주세요.";

    private final String message;

    CustomErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_SIGN + message + RETYPE_PROMPT;
    }
}
