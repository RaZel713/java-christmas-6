package christmas.custom.validator;

import static christmas.custom.common.validation.Validation.checkEmptyInput;
import static christmas.custom.common.validation.Validation.checkInvalidCharacters;
import static christmas.custom.common.validation.Validation.checkNullInput;
import static christmas.custom.common.validation.Validation.checkOutOfRange;
import static christmas.custom.common.validation.Validation.checkWhitespaceOnlyInput;

public class Validator {
    public static final String NUMBER_ONLY_PATTERN = "^[0-9]+$"; // 숫자만 있는지

    // 입력 관련 유효성 검사 (공통)
    public static void validateEmptyInput(String input) {
        checkNullInput(input);
        checkEmptyInput(input);
        checkWhitespaceOnlyInput(input);
    }

    public static void validateDate(String input) {
        checkInvalidCharacters(input, NUMBER_ONLY_PATTERN);
        checkOutOfRange(Integer.parseInt(input), 1, 31,
                CustomErrorMessages.INVALID_DATE.getMessage());
    }
}