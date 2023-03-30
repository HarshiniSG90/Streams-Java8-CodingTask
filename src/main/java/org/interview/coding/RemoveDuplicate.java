package org.interview.coding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicate {

    public static void main(String args[])
    {
        List<String> list = Arrays.asList("Harshini","kishore","Harshini");

        list.stream().distinct().forEach(System.out::println);

        Map<Object,Long> list1 = list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        list1.forEach((x,y)->System.out.println(x+"==="+y));

        list.stream().filter(x->x.contains("Ha")).map(y->y).forEach(System.out::println);


        //===================================================

        List<Integer> intList = Arrays.asList(1,3,0,-1,2,6,9,22,41,12);
        intList.stream().sorted().forEach(System.out::println);
        intList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        OptionalDouble val = intList.stream().mapToInt(Integer::intValue).average();
        System.out.println("======================= "+val.getAsDouble());

        int array1[] = {1,3,0,-1,2,6,9,22,41,12};
       OptionalDouble d = Arrays.stream(array1).average();

        System.out.println("======================= "+d.getAsDouble());

        String str = "hello harshini how are you";
       Map<Object,Long> map = Arrays.asList(str.split("")).stream().filter(x->!(x.contains(" "))).collect(Collectors.groupingBy(x->x,Collectors.counting()));
       map.forEach((x,y)->System.out.println(x+"====="+y));
        List<Object> l = map.entrySet().stream()
                .filter(x->x.getValue()>1).
                map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(l);
    }
}
