package christmas.custom.view;

public enum DisplayConstants {
    TITLE("일반 출력 메시지"),
    ITEM_NAME("%s\t\t\t%d\t\t\t%,d");
    // "%10s" -  최소 10자리 공간을 할당하며, 부족한 자리는 공백으로 채웁니다. (앞에 공백 출력 뒤에 문자열 출력)
    // "%05d" -  5자리로 고정하고, 자리가 부족하면 0으로 채웁니다. (앞에 0출력)
    // %f는 소수점을 포함한 실수를 출력합니다. 기본적으로 소수점 이하 6자리까지 출력
    // %.2f는 소수점 이하 2자리까지 출력합니다.
    // %,.2f는 실수를 천 단위 구분 기호와 소수점 이하 2자리까지 출력
    // %tF	날짜 (yyyy-mm-dd) new java.util.Date() 사용
    // %tT	시간 (HH:mm:ss)

    private final String format;

    DisplayConstants(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public String format(Object... args) {
        return String.format(format, args);
    }
}