package org.interview.coding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeCoding {

    public static void main(String args[])
    {
        String str = "Hai Harshini how is life how";
        int[] numbers = {5,9,11,2,8,21,29,1};
      //  removeDuplicate(str);
        findFirstNonRepeatableCharacterFromString(str);
      /*  findTheSecondHigestNumber(numbers);
        findTheLongestString();
        findElementsStartingWith1(numbers);
        stringJoinExample();
        skipAndLimitExample();*/
      //  reverseMapBasedOnWordOccurance();
    }

    private static void reverseMapBasedOnWordOccurance() {
        String str = "hello harshini how are you hello kishore hello are";

        Map<String,Long> map = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
       map.entrySet().stream().sorted((x,y)->(int)(y.getValue()-x.getValue())).forEach(x->System.out.println(x.getKey()+"=="+x.getValue()));

    }

    private static void skipAndLimitExample() {

        IntStream.range(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);

    }

    private static void stringJoinExample() {
        List<String> list = Arrays.asList("1","2","3","6");
       String join =  String.join("-",list);
        System.out.println(join);
    }

    private static void findElementsStartingWith1(int[] numbers) {
        Arrays.stream(numbers).boxed()
                .map(x->x+"").filter(x->x.startsWith("2")).forEach(System.out::println);
    }

    private static void findTheLongestString() {

        String str[] = {"java","hyderabad","krakow","hello okay na"};
        String str1 = Arrays.stream(str).
                reduce((word1,word2)->word1.length()>word2.length()?word1:word2)
                .get();

        System.out.println(str1);

       }

    private static void findTheSecondHigestNumber(int[] numbers) {
       Integer secondHigestNumb =  Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst().get();
        System.out.println(secondHigestNumb);

        Integer secondLowestNumb =  Arrays.stream(numbers).boxed()
                .sorted()
                .skip(1).findFirst().orElse(0);
        System.out.println(secondLowestNumb);
    }

    private static void findFirstNonRepeatableCharacterFromString(String str) {
        String firstNonEle = Arrays.stream(str.split("")).filter(x->!(x.contains(" "))).peek(System.out::print).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().orElse(null).getKey();
      //if you need to change to non repeatable word just include space in split method
        System.out.println("\n"+firstNonEle);

        String firstRepeatableEle = Arrays.stream(str.split("")).filter(x->!(x.contains(" "))).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1).findFirst().get().getKey();
    }

    private static void removeDuplicate(String str) {

       List<String> duplicateElements =  Arrays.asList(str.split("")).stream().filter(x->!(x.contains(" "))).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(duplicateElements);

        List<String> uniqueEle =  Arrays.asList(str.split("")).stream().filter(x->!(x.contains(" "))).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(uniqueEle);
    }
}
