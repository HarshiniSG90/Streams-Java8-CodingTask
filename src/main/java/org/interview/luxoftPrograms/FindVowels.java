package org.interview.luxoftPrograms;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindVowels {

    public static void main(String arg[])
    {
        String str1 = "This is the sample text to demonstrate vowel counting";
        findVowelsGroupByWords(str1);
    }

    private static void findVowelsGroupByWords(String str1) {

       Map<String ,Integer> map = Arrays.stream(str1.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(FindVowels::findVowel)));

       map.entrySet().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
    }

    public static int findVowel(String str)
    {
        return (int) str.chars().filter(ch->"aeiou".indexOf(ch)!=-1).count();
    }
}
