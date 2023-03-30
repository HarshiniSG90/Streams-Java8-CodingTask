package org.interview;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringMapExercise {

    public static Map<String, List<String>> findSentencesWithWords(List<String> sentences, List<String> words)
    {
        Map<Object,Object> map = words.stream()
                .collect(Collectors.toMap(word->word,
                                          word->sentences.stream()
                                                  .filter(st->st.contains(word))
                                                  .collect(Collectors.toList()))
                         );
        map.entrySet().stream().forEach(x->{System.out.println(x.getKey()+" == "+x.getValue());});

        return new HashMap<String,List<String>>();
    }

    public static void main(String args[])
    {
        List<String> input1 = Arrays.asList("The quick brown fox jumps over the lazy dog", "She sells seashells by the seashore", "Peter Piper picked a peck of pickled peppers");
        List<String> input2 = Arrays.asList("quick", "seashells", "peppers");
       // findSentencesWithWords(input1,input2);
        String str="hello hai harshini hai hello kishore";
        List<String> list = Arrays.asList(str.split(" "));
        Map<Object,Long> map = list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        map.entrySet().stream().forEach(x->{System.out.println(x.getKey()+" == "+ x.getValue());});
        //findDuplicateWord(str);
        //Map<City, Set<String>> namesByCity
        //   = people.stream().collect(
        //     groupingBy(Person::getCity,
        //                mapping(Person::getLastName,
        //                        toSet())));
        //

        int num = 2;
        List<Integer> list1 = Stream.iterate(100,i->i+1).filter(n->n%num==0).limit(300).collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void findDuplicateWord(String str) {
       List<String> list =  Arrays.asList(str.split(" "));
       HashSet<String> set = new HashSet<>();
        Map<Object, java.lang.Long> map = list.stream()
               .collect(Collectors.groupingBy(x->x,Collectors.counting()));
      // map.entrySet().forEach(x->System.out.println(x.getKey()+"="+x.getValue()));

      // HashSet<String> set = new HashSet<String >();
       List<String> str1 = list.stream().filter(x->!set.add(x)).collect(Collectors.toList());
       // System.out.println(str1);
    }
}
