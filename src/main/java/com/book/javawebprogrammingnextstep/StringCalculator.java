package com.book.javawebprogrammingnextstep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    /*
    문자 배열을 숫자로 변환하는 작업과 숫자 배열의 합을 구하는 두 가지 일을 하고 있다.
    메소드는 한 가지 책임만 가져야 한다는 원칙에 따라 이 두 가지 작업을 분리한다.
     */
//    private int sum(String[] values) {
//        int sum = 0;
//        for (String value : values) {
//            sum += Integer.parseInt(value);
//        }
//        return sum;
//    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }
    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
