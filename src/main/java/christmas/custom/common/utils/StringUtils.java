package christmas.custom.common.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {
    public static final String MULTIPLE_TEMPLATE = "%s{2,}"; // 연속된 구분자
    public static final String EDGE_TEMPLATE = "^%s|%s$"; // 앞뒤 구분자
    public static final String EMPTY_STRING = ""; // 빈문자열

    // 한 종류의 구분자만 사용되는 경우, 해당 구분자를 정리
    public static String cleanConsecutiveDelimiters(String input, String delimiter) {
        String escapedDelimiter = Pattern.quote(delimiter); // 특수 문자 처리를 위해 escape
        String consecutiveDelimitersRegex = String.format(MULTIPLE_TEMPLATE, escapedDelimiter); // 연속된 구분자 표현식
        String leadingTrailingDelimiterRegex =
                String.format(EDGE_TEMPLATE, escapedDelimiter, escapedDelimiter); // 앞뒤 구분자 표현식

        return input.replaceAll(consecutiveDelimitersRegex, delimiter) // 연속된 구분자를 하나로 변경
                .replaceAll(leadingTrailingDelimiterRegex, EMPTY_STRING); // 앞뒤 구분자 제거
    }

    // 구분자로 해당 문자열 분리 후 문자열 리스트로 반환
    public static List<String> splitStringByDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    // 문자열 리스트의 각 문자열에 trim 적용, 빈문자열 제거, 다시 문자열 리스트로 수집
    public static List<String> removeEmptyAndTrimStrings(List<String> input) {
        return input.stream() // 리스트를 스트림으로 변환
                .map(String::trim) // 각 문자열에 trim() 적용
                .filter(s -> !s.isEmpty()) // 빈 문자열 제외
                .collect(Collectors.toList()); // 리스트로 수집
    }
}