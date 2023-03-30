package org.interview.luxoftPrograms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArrays {

    public static void main(String args[])
    {
        int arr1[] ={1,2,3,5};
        int arr2[] = {4,6,7,8};

        int mergedArray[] = mergeTwoArray1(arr1,arr2);
        Arrays.stream(mergedArray).forEach(System.out::print);
    }

    private static int[] mergeTwoArray1(int[] arr1, int[] arr2) {

        int mergedArray[] = new int[arr1.length+arr2.length];

        int i=0,j=0,k=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j]) {
                mergedArray[k++] = arr1[i++];
            }else
            {
                mergedArray[k++] = arr2[j++];
            }
        }

        while(i<arr1.length)
        {
            mergedArray[k++] = arr1[i++];
        }

        while(j<arr2.length)
        {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;

    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int arr3[] = new int[arr1.length+arr2.length];

        int i=0,j=0,k=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                arr3[k++] = arr1[i++];
            }
            else
            {
                arr3[k++] = arr2[j++];
            }
        }
        while(i<arr1.length)
        {
            arr3[k++] = arr1[i++];
        }
        while(j<arr2.length)
        {
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }
}
