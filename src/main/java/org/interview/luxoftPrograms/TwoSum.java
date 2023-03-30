package org.interview.luxoftPrograms;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String args[])
    {
        int arr[] = {1,2,3,4,6,7,9};
        int target = 9;
        findTwoSumArray(arr,target);
    }

    private static void findTwoSumArray(int[] arr, int target) {
       Set<Integer> seen = new HashSet<>();
       Set<String> pairs = new HashSet<>();

       for(int i=0;i<arr.length;i++)
       {
           int complementary = target - arr[i];
           if(seen.contains(complementary))
           {
               int a = Math.min(arr[i],complementary);
               int b = Math.max(arr[i],complementary);
               pairs.add(a+","+b);
           }
           seen.add(arr[i]);
       }

       if(pairs.isEmpty())
       {
           System.out.println("No unique pairs found");
       }
       else
       {
           for (String str :pairs)
           System.out.println(str);
       }
    }
}
