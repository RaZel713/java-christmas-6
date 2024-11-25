package christmas.custom.common.validation;

public enum ErrorMessages {
    NULL_INPUT("입력이 null 입니다."),

    EMPTY_STRING_INPUT("입력이 빈 문자열입니다."),

    WHITESPACE_ONLY_INPUT("입력이 공백으로만 구성되어 있습니다.");

    private static final String ERROR_SIGN = "[ERROR] ";
    private static final String RETYPE_PROMPT = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_SIGN + message + RETYPE_PROMPT;
    }
}