package christmas.custom.model;

public enum Menu {
    SOUP("에피타이저", "양송이수프", 6000),
    TAPAS("에피타이저", "타파스", 5500),
    SALAD("에피타이저", "시저샐러드", 8000),

    STEAK("메인", "티본스테이크", 55000),
    RIBS("메인", "바비큐립", 54000),
    SEA_FOOD_PASTA("메인", "해산물파스타", 35000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),

    CAKE("디저트", "초코케이크", 15000),
    ICE_CREAM("디저트", "아이스크림", 5000),

    COKE("음료", "제로콜라", 3000),
    WINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000);

    private final String sort;
    private final String name;
    private final int price;

    Menu(String sort, String name, int price) {
        this.sort = sort;
        this.name = name;
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static boolean isSortMain(String input) {
        for (Menu menu : Menu.values()) {
            if (menu.getSort().equals("메인") && input.equals(menu.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSortDesert(String input) {
        for (Menu menu : Menu.values()) {
            if (menu.getSort().equals("디저트") && input.equals(menu.getName())) {
                return true;
            }
        }
        return false;
    }

    public static int getPriceByName(String input) {
        for (Menu menu : Menu.values()) {
            if (input.equals(menu.getName())) {
                return menu.getPrice();
            }
        }
        return 0;
    }
}