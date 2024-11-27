package christmas.custom.service.maker;

import christmas.custom.model.EventResult;
import christmas.custom.model.Menu;
import christmas.custom.model.OrderSheet.OrderedMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventResultMaker {
    public EventResult start(int date, List<OrderedMenu> orderSheet) {
        int totalPrice = calculateTotalPrice(orderSheet);
        List<Integer> eventPrice = new ArrayList<>();
        List<String> appliedEvents = applyEvents(date, totalPrice, orderSheet, eventPrice);
        if (eventPrice.isEmpty()) {
            appliedEvents.add("없음"); // 위치 변경 필요
        }
        return new EventResult(totalPrice, appliedEvents, eventPrice);
    }

    private int calculateTotalPrice(List<OrderedMenu> orderSheet) {
        int sum = 0;
        for (OrderedMenu orderedMenu : orderSheet) {
            sum += Menu.getPriceByName(orderedMenu.getName()) * orderedMenu.getCount();
        }
        return sum;
    }

    private List<String> applyEvents(int date, int totalPrice, List<OrderedMenu> orderSheet, List<Integer> eventPrice) {
        List<String> appliedEvents = new ArrayList<>();
        if (totalPrice >= 10000) { // 이벤트 있음
            applyChristmasEvent(date, appliedEvents, eventPrice);
            applyDailyEvent(date, orderSheet, appliedEvents, eventPrice);
            applySpecialEvent(date, appliedEvents, eventPrice);
            applyFreebieEvent(date, appliedEvents, eventPrice);
        }
        return appliedEvents;
    }

    private void applyChristmasEvent(int date, List<String> appliedEvents, List<Integer> eventPrice) {
        if (date <= 25) { // 크리스 마스 할인 적용 가능
            int christmasDiscount = 1000 + (date - 1) * 100;
            appliedEvents.add(String.format("크리스마스 디데이 할인: -%,d원", christmasDiscount));
            eventPrice.add(christmasDiscount);
        }
    }

    private void applyDailyEvent(int date, List<OrderedMenu> orderSheet,
                                 List<String> appliedEvents, List<Integer> eventPrice) {
        List<Integer> weekendDate = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        int count = 0;
        if (weekendDate.contains(date)) { // 주말 할인
            count = applyWeekendEvent(orderSheet, appliedEvents);
        }
        if (!weekendDate.contains(date)) { // 평일 할인
            count = applyWeekdaysEvent(orderSheet, appliedEvents);
        }
        eventPrice.add(2023 * count);
    }

    private int applyWeekendEvent(List<OrderedMenu> orderSheet, List<String> appliedEvents) {
        int count = 0;
        for (OrderedMenu orderedMenu : orderSheet) {
            if (Menu.isSortMain(orderedMenu.getName())) { // 메인 메뉴 1개당 2023원 할인
                count += orderedMenu.getCount();
            }
        }
        appliedEvents.add(String.format("주말 할인: -%,d원", 2023 * count));
        return count;
    }

    private int applyWeekdaysEvent(List<OrderedMenu> orderSheet, List<String> appliedEvents) {
        int count = 0;
        for (OrderedMenu orderedMenu : orderSheet) {
            if (Menu.isSortDesert(orderedMenu.getName())) { // 디저트 메뉴 1개당 2023원 할인
                count += orderedMenu.getCount();
            }
        }
        appliedEvents.add(String.format("평일 할인: -%,d원", 2023 * count));
        return count;
    }

    private void applySpecialEvent(int date, List<String> appliedEvents, List<Integer> eventPrice) {
        List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
        if (starDate.contains(date)) { // 특별 할인 (별)
            appliedEvents.add("특별 할인: -1,000원");
            eventPrice.add(1000);
        }
    }

    private void applyFreebieEvent(int totalPrice, List<String> appliedEvents, List<Integer> eventPrice) {
        if (totalPrice >= 120000) { // 증정 이벤트
            appliedEvents.add("증정 이벤트: -25,000원");
            eventPrice.add(25000);
        }
    }
}