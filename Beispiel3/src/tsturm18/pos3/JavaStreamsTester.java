/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsturm18.pos3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author timst
 */
public class JavaStreamsTester {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("A");
        strings.add("AA");
        strings.add("");
        strings.add("AAA");
        strings.add(" ");
        strings.add(" ");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println(getCountEmptyString(strings));
        System.out.println(getCountLength3(strings));
        for (String string : deleteEmptyStrings(strings)) {
            System.out.println(string);
        }
        System.out.println(getMergedString(strings, ";"));
        for (Integer integer : getSquares(numbers)) {
            System.out.println(integer);
        }
        System.out.println(getMax(numbers));
        System.out.println(getMin(numbers));
        System.out.println(getSum(numbers));
        System.out.println(getAverage(numbers));
    }

    private static int getCountEmptyString(List<String> strings) {
        return strings.stream().filter(s -> s.equals(""))
                .collect(Collectors.toList())
                .size();
    }

    private static int getCountLength3(List<String> strings) {
        return strings.stream().filter(s -> s.length() == 3).
                collect(Collectors.toList()).
                size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return strings.stream().filter(s -> (s.equals("") == false))
                .collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator) {
        return strings.stream().reduce("", ((b1, b2) -> b1 + separator + b2));
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n)
                .collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .max((number1, number2) -> number1 - number2)
                .orElse(0);
    }

    private static int getMin(List<Integer> numbers) {
        return numbers.stream()
                .min((number1, number2) -> number1 - number2)
                .orElse(0);
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().reduce(0, (b1, b2) -> b1 + b2);
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(number -> number)
                .average()
                .orElse(0);
    }
}
