package org.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {

    public static List<String> filterLongStrings(List<String> inputList)
    {
        inputList.stream().filter(x->x.length()>5).map(y->y).forEach(System.out::println);
        return Arrays.asList();
    }

    public static void main(String args[])
    {
        List<String> input = Arrays.asList("hello", "world", "foo", "bar", "hello world");
        filterLongStrings(input);
    }
}
