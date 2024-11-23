package christmas.custom.model.OrderSheet;

public class OrderedMenu {
    private final String name;
    private final int count;

    public OrderedMenu(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}