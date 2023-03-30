package org.interview.luxoftPrograms;

public class ReverseNumber {

    public static void main(String args[])
    {
        int numb = 2345678;
        int reverseNumb = findReverseNumber(numb);
        System.out.println(reverseNumb);
    }

    private static int findReverseNumber(int numb) {
        String str = Integer.toString(numb);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
       return Integer.parseInt(sb.toString());
    }
    public static int reverseNumber(int num) {
        int rev = 0;
        while (num != 0) {
            int digit = num % 10; // extract the last digit
            rev = rev * 10 + digit; // add the digit to the reversed number
            num /= 10; // remove the last digit from the original number
        }
        return rev;
    }

}
