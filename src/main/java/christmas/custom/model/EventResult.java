package christmas.custom.model;

import java.util.List;

public class EventResult {
    private final int totalPrice;
    private final String freebie;
    private final List<String> appliedEvents;
    private final int eventPrice;
    private final int finalPrice;
    private final String badge;

    public EventResult(int totalPrice, List<String> appliedEvents, List<Integer> eventPrice) {
        this.totalPrice = totalPrice;
        this.freebie = findFreebie(appliedEvents);
        this.appliedEvents = appliedEvents;
        this.eventPrice = calculateEventPrice(eventPrice);
        this.finalPrice = calculateFinalPrice(appliedEvents);
        this.badge = selectBadge();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getFreebie() {
        return freebie;
    }

    public List<String> getAppliedEvents() {
        return appliedEvents;
    }

    public int getEventPrice() {
        return eventPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public String getBadge() {
        return badge;
    }

    private int calculateFinalPrice(List<String> appliedEvents) {
        for (String appliedEvent : appliedEvents) {
            if (appliedEvent.equals("증정 이벤트: -25,000원")) {
                return totalPrice - eventPrice + 25000;
            }
        }
        return totalPrice - eventPrice;
    }

    private int calculateEventPrice(List<Integer> eventPrice) {
        if (eventPrice.isEmpty()) {
            return 0;
        }
        return eventPrice.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String findFreebie(List<String> appliedEvents) {
        for (String appliedEvent : appliedEvents) {
            if (appliedEvent.equals("증정 이벤트: -25,000원")) {
                return "샴페인 1개";

            }
        }
        return "없음";
    }

    private String selectBadge() {
        if (eventPrice > 20000) {
            return "산타";
        }
        if (eventPrice > 10000) {
            return "트리";
        }
        if (eventPrice > 5000) {
            return "별";
        }
        return "없음";
    }
}
