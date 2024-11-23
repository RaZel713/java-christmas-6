package christmas.custom.service.parser;

import static christmas.custom.common.utils.StringUtils.cleanConsecutiveDelimiters;
import static christmas.custom.common.utils.StringUtils.removeEmptyAndTrimStrings;
import static christmas.custom.common.utils.StringUtils.splitStringByDelimiter;

import christmas.custom.model.OrderSheet.OrderedMenu;
import christmas.custom.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class OrderParser {
    public List<OrderedMenu> run(String input) {
        Validator.validateEmptyInput(input);
        List<String> orderForms = parseOrder(input);
        Validator.validateOrderForm(orderForms);

        List<OrderedMenu> OrderSheet = createOrderSheet(orderForms);
        Validator.validateOrderSheet(OrderSheet);

        return OrderSheet;
    }

    private List<String> parseOrder(String input) {
        String cleanedComma = cleanConsecutiveDelimiters(input, ",");
        List<String> splitStringByComma = splitStringByDelimiter(cleanedComma, ",");
        return removeEmptyAndTrimStrings(splitStringByComma);
    }

    private List<OrderedMenu> createOrderSheet(List<String> orderForms) {
        List<OrderedMenu> orderSheet = new ArrayList<>();
        for (String orderForm : orderForms) {
            OrderedMenu orderedMenu = createOrderedMenu(parseOrderForm(orderForm));
            orderSheet.add(orderedMenu);
        }
        return orderSheet;
    }

    private List<String> parseOrderForm(String orderForm) {
        return splitStringByDelimiter(orderForm, "-");
    }

    private OrderedMenu createOrderedMenu(List<String> orderForm) {
        String menuName = orderForm.get(0).trim();
        int menuCount = Integer.parseInt(orderForm.get(1).trim());
        return new OrderedMenu(menuName, menuCount);
    }
}