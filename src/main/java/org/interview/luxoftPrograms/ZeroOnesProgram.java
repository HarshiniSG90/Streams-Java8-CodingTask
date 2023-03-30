package org.interview.luxoftPrograms;

import java.util.Arrays;

public class ZeroOnesProgram {

    public static void main(String args[])
    {
        int[] arr = {0,1,0,1,1,0,1,0};

        int sortedArray1[] = sortZeroFollowedByOnes(arr);
        Arrays.stream(sortedArray1).forEach(System.out::print);
    }

    private static int[] sortZeroFollowedByOnes(int[] arr) {
        int left = 0;int right = arr.length-1;

        while(left<right)
        {
            while(arr[left]==0 && left<right)
            {
                left++;
            }
            while(arr[right]==1 && left<right)
            {
                right--;
            }

            while(left<right)
            {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return arr;
    }

}
