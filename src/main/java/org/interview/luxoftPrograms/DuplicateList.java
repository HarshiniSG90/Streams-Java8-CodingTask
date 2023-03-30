package org.interview.luxoftPrograms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateList {

    public static void main(String args[])
    {
        Integer array[] = {2,4,5,8,9,9,2};
       List<Integer> dupList = findDuplicate(array);
        System.out.println(dupList);
    }

    private static List<Integer> findDuplicate(Integer[] array) {

        //approach 1
        Set<Integer> set = new HashSet<>();
        List<Integer> list = Arrays.asList(array).stream().filter(x->!(set.add(x))).map(Function.identity()).collect(Collectors.toList());
      //  return list;

        //approach 2
        Map<Integer,Long> map = Arrays.asList(array).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> list2 = map.entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());

        return list2;
    }
}
