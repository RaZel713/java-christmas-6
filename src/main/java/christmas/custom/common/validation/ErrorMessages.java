package christmas.custom.common.validation;

public enum ErrorMessages {
    NULL_INPUT("입력이 null 입니다."),

    EMPTY_STRING_INPUT("입력이 빈 문자열입니다."),

    WHITESPACE_ONLY_INPUT("입력이 공백으로만 구성되어 있습니다."),

    INVALID_CHARACTERS_INPUT("입력에 유효하지 않은 문자가 포함되어 있습니다."),

    INT_OUT_OF_BOUNDS("입력된 숫자가 int 타입의 범위를 초과합니다."),

    SPACES_BETWEEN_NUMBERS("숫자와 숫자 사이에 공백이 존재합니다."),

    INVALID_INPUT("잘못된 입력입니다.");

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