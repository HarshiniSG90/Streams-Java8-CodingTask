package org.interview.luxoftPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestPositiveNumber {

    public static void main(String args[])
    {
        int arr[] = {3,2,-7,9,0,8,1,-2};
        int smallestNumber = findSmallestPositiveNumber(arr);
      //  System.out.println(smallestNumber);

        int arr1[]={1,2,4,5};
        int missingNumber = findMissingPositiveNumber(arr1);
        System.out.println(missingNumber);

        int arr3[]= {100,300,200,700,33,66,1000,77,302};
        findSecondLargestNumber(arr3);
    }

    private static void findSecondLargestNumber(int[] arr3) {
        Arrays.stream(arr3).boxed().sorted(Collections.reverseOrder())
                .limit(2)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static int findMissingPositiveNumber(int[] arr1) {

        Set<Integer> set = Arrays.stream(arr1).boxed().filter(x->x>0).collect(Collectors.toSet());
        System.out.println(set);
        int max = Arrays.stream(arr1).max().orElse(0);

        for(int i=1;i<=max+1;i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return -1;
    }

    private static int findSmallestPositiveNumber(int[] arr) {

        int num = Arrays.stream(arr).filter(x->x>0).sorted().findFirst().orElse(0);
        return num;
    }
}
