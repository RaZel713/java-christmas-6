package christmas.custom.validator;

import static christmas.custom.common.validation.Validation.checkEmptyInput;
import static christmas.custom.common.validation.Validation.checkInvalidCharacters;
import static christmas.custom.common.validation.Validation.checkNullInput;
import static christmas.custom.common.validation.Validation.checkOutOfRange;
import static christmas.custom.common.validation.Validation.checkWhitespaceOnlyInput;

import christmas.custom.model.Menu;
import christmas.custom.model.OrderSheet.OrderedMenu;
import java.util.List;

public class Validator {
    public static final String NUMBER_ONLY_PATTERN = "^[0-9]+$"; // 숫자만 있는지
    public static final String ORDER_FORM_PATTERN = "[가-힣]+-\\d+"; // 제로콜라-1 형식

    // 입력 관련 유효성 검사 (공통)
    public static void validateEmptyInput(String input) {
        checkNullInput(input);
        checkEmptyInput(input);
        checkWhitespaceOnlyInput(input);
    }

    public static void validateDate(String input) {
        checkInvalidCharacters(input, NUMBER_ONLY_PATTERN); // 에러 메시지 수정할 것
        checkOutOfRange(Integer.parseInt(input), 1, 31,
                CustomErrorMessages.INVALID_DATE.getMessage());
    }

    public static void validateOrderForm(List<String> input) {
        for (String orderForm : input) {
            if (!orderForm.matches(ORDER_FORM_PATTERN)) {
                throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
            }
        }
    }

    public static void validateOrderSheet(List<OrderedMenu> orderSheet) {
        checkDuplicate(orderSheet);
        checkTotalCount(orderSheet);
        checkDrinkOrder(orderSheet);
        for (OrderedMenu orderedMenu : orderSheet) {
            checkMenuName(orderedMenu);
            checkMenuCount(orderedMenu);
        }
    }

    private static void checkDuplicate(List<OrderedMenu> orderSheet) {
        for (int i = 0; i < orderSheet.size(); i++) {
            for (int j = i + 1; j < orderSheet.size(); j++) {
                if (orderSheet.get(i).getName().equals(orderSheet.get(j).getName())) {
                    throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
                }
            }
        }
    }

    private static void checkTotalCount(List<OrderedMenu> orderSheet) {
        int sum = 0;
        for (OrderedMenu orderedMenu : orderSheet) {
            sum += orderedMenu.getCount();
        }
        if (sum > 20) {
            throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
        }
    }

    private static void checkDrinkOrder(List<OrderedMenu> orderSheet) {
        int count = 0;
        for (OrderedMenu orderedMenu : orderSheet) {
            if (orderedMenu.getName().equals(Menu.COKE.getName()) ||
                    orderedMenu.getName().equals(Menu.WINE.getName()) ||
                    orderedMenu.getName().equals(Menu.CHAMPAGNE.getName())) {
                count += 1;
            }
        }
        if (count == orderSheet.size()) {
            throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
        }
    }

    private static void checkMenuName(OrderedMenu orderedMenu) {
        for (Menu menu : Menu.values()) {
            if (!orderedMenu.getName().equals(menu.getName())) { // 이름이 같지 않을 때
                throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
            }
        }
    }

    private static void checkMenuCount(OrderedMenu orderedMenu) {
        if (!(orderedMenu.getCount() >= 1)) { // 1 이상의 숫자가 아닐때
            throw new IllegalArgumentException(CustomErrorMessages.INVALID_ORDER.getMessage());
        }
    }
}