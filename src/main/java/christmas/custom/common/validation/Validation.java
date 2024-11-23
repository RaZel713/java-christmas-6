package christmas.custom.common.validation;

public class Validation {
    public static final String DIGIT_SPACE_DIGIT_REGEX = ".*\\d+\\s+\\d+.*";

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

    // 입력에 유효하지 않는 문자가 존재할 경우
    public static void checkInvalidCharacters(String input, String regexPattern) {
        if (!input.matches(regexPattern)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CHARACTERS_INPUT.getMessage());
        }
    }

    // 입력의 숫자 값이 int 타입의 범위를 넘어설 경우
    public void checkIntegerOverflow(String input) {
        long number = Long.parseLong(input.trim());

        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INT_OUT_OF_BOUNDS.getMessage());
        }
    }

    // 숫자와 숫자 사이에 공백이 존재하는 경우
    public void checkSpacesBetweenNumbers(String input) {
        if (input.matches(DIGIT_SPACE_DIGIT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessages.SPACES_BETWEEN_NUMBERS.getMessage());
        }
    }

    // 숫자가 주어진 범위를 넘어서는 경우
    public static void checkOutOfRange(int number, int rangeStart, int rangeEnd, String errorMessage) {
        if (number < rangeStart || number > rangeEnd) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validate(String value) {
        if (value.startsWith(",") || value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        if (value.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }
}