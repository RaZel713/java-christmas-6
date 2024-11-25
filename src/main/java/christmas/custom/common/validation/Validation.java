package christmas.custom.common.validation;

public class Validation {
    // 입력이 null 인지
    public static void checkNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_INPUT.getMessage());
        }
    }

    // 입력이 빈 문자열 인지
    public static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_STRING_INPUT.getMessage());
        }
    }

    // 입력이 공백만 입력 되었는지
    public static void checkWhitespaceOnlyInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.WHITESPACE_ONLY_INPUT.getMessage());
        }
    }

    // 숫자가 주어진 범위를 넘어서는 경우
    public static void checkOutOfRange(int number, int rangeStart, int rangeEnd, String errorMessage) {
        if (number < rangeStart || number > rangeEnd) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}