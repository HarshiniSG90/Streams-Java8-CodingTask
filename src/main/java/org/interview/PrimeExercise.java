package org.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class PrimeExercise {

    public static void main(String args[])
    {
       boolean isPrime = isPrime(7);
        List<Double> list = Stream.iterate(1,i->i+1).filter(k->isPrime(k)).map(Math::sqrt).limit(10).collect(Collectors.toList());

        System.out.println(list);


    }

    public static boolean isPrime(int numb)
    {
        return IntStream.range(2,numb).noneMatch(n->numb%n == 0);
    }
}
