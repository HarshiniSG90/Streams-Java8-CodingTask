package org.interview.luxoftPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EpamCodingTask {

    public static void main(String arg[])
    {
        Integer arr[] = {17,70,8,3,60,4};
        findLargestComparingToRight(arr);
    }

    private static void findLargestComparingToRight(Integer[] arr) {

        List<Integer> list = Arrays.asList(arr);
        List<Integer> maxList = new ArrayList<>();
        int maxEle = list.get(list.size()-1);
        System.out.println(maxEle);
        for(int i=list.size()-2;i>=0;i--)
        {
            if(list.get(i)>maxEle)
            {
                maxEle = list.get(i);
                maxList.add(maxEle);

            }
        }
        maxList.stream().forEach(System.out::println);
    }
}
