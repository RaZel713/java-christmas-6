package christmas.custom.service.parser;

import christmas.custom.validator.Validator;

public class DateParser {
    public int run(String input) {
        Validator.validateEmptyInput(input);
        Validator.validateDate(input);
        return Integer.parseInt(input);
    }
}
