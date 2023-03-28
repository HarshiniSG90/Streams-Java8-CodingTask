package org.interview;

import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class IntegerStreamExcercise {

    public static void main(String args[])
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        findMinAndMax(list);
       // findPairs(list);
    }
    public static List<List<Integer>> findPairs(List<Integer> inputList)
    {
        List<List<Integer>> list = inputList.stream().flatMap(i->inputList.stream().filter(j->i<j).map(j->Arrays.asList(i,j)))
                .filter(pair->(pair.get(0)+pair.get(1)) % 3 ==0).distinct().sorted(Comparator.comparingInt(pair ->pair.get(0)))
                .collect(Collectors.toList());
     /*  List<List<Integer>> list =  inputList.stream().flatMap(i->inputList.stream().filter(j->i<j).map(j->Arrays.asList(i,j)))
                .filter(pair->(pair.get(0)+pair.get(1))%3 ==0).distinct().sorted(Comparator.comparingInt(pair->pair.get(0)))
                .collect(Collectors.toList());

    */
        System.out.println(list);

        return list;
    }

    public static void findMinAndMax(List<Integer> list)
    {
     /*   int min = list.stream().mapToInt(x->x).max().orElse(0);
       int max = list.stream().mapToInt(x->x).min().orElse(1);
        double average = list.stream().mapToInt(x->x).average().orElse(0);*/
        IntSummaryStatistics statistics = list.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(statistics.getMin()+" = "+statistics.getMax()+" = "+statistics.getAverage());
    }
}
