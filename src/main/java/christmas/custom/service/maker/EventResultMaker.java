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
            for (Menu menu : Menu.values()) {
                if (orderedMenu.getName().equals(menu.getName())) { // 이름 같으면
                    sum += menu.getPrice() * orderedMenu.getCount();
                    break;
                }
            }
        }
        return sum;
    }

    private List<String> applyEvents(int date, int totalPrice, List<OrderedMenu> orderSheet, List<Integer> eventPrice) {
        List<String> appliedEvents = new ArrayList<>();

        List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
        List<Integer> weekendDate = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

        if (totalPrice >= 10000) { // 이벤트 있음
            if (date <= 25) { // 크리스 마스 할인 적용 가능
                int christmasDiscount = 1000 + (date - 1) * 100;
                appliedEvents.add(String.format("크리스마스 디데이 할인: -%,d원", christmasDiscount));
                eventPrice.add(christmasDiscount);
            }
            if (weekendDate.contains(date)) { // 주말 할인
                // 메인 메뉴 1개당 2023원 할인
                int count = 0;
                for (OrderedMenu orderedMenu : orderSheet) {
                    for (Menu menu : Menu.values()) {
                        if (menu.getSort().equals("메인") && orderedMenu.getName().equals(menu.getName())) {
                            count += orderedMenu.getCount();
                        }
                    }
                }
                appliedEvents.add(String.format("주말 할인: -%,d원", 2023 * count));
                eventPrice.add(2023 * count);
            }
            if (!weekendDate.contains(date)) { // 평일 할인
                // 디저트 메뉴 1개당 2023원 할인
                int count = 0;
                for (OrderedMenu orderedMenu : orderSheet) {
                    for (Menu menu : Menu.values()) {
                        if (menu.getSort().equals("디저트") && orderedMenu.getName().equals(menu.getName())) {
                            count += orderedMenu.getCount();
                        }
                    }
                }
                appliedEvents.add(String.format("평일 할인: -%,d원", count));
                eventPrice.add(2023 * count);
            }
            if (starDate.contains(date)) { // 특별 할인 (별)
                appliedEvents.add("특별 할인: -1,000원");
                eventPrice.add(1000);
            }
            if (totalPrice >= 120000) { // 증정 이벤트
                appliedEvents.add("증정 이벤트: -25,000원");
                eventPrice.add(25000);
            }
        }
        return appliedEvents;
    }
}