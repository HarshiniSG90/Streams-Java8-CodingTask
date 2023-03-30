package org.interview;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyAnalyzer
{
 //hello how are you , is this good with coffee to drink
 private static final List<String> STOP_WORDS = Arrays.asList(
         "a", "an", "and", "are", "as", "at", "be", "but", "by", "for",
         "if", "in", "into", "is", "it", "no", "not", "of", "on", "or",
         "such", "that", "the", "their", "then", "there", "these",
         "they", "this", "to", "was", "will", "with");

 public static List<String> findMostFrequentWords(Stream<String> lines)
 {
 // Implement here
List<String> input = lines.collect(Collectors.toList());
//input.forEach(System.out::println);

  Map<Object,Long> map = input.stream().flatMap(word -> getWords(word))
          .filter(ele->!isStopWord(ele.toString()))
          .collect(Collectors.groupingBy(str->str,Collectors.counting()));

  List<Map.Entry<Object, Long>> sortedEntries  = map.entrySet().stream()
                                                     .sorted(Map.Entry.<Object,Long>comparingByValue().reversed())
                                                     .collect(Collectors.toList());

  sortedEntries.forEach(x-> {
   System.out.println( x.getKey() + " == " + x.getValue());
  });
 return Arrays.asList(); // For happy compiler
 } // Helper methods, you can use or modify these as needed


 private static Stream<String> getWords(String line) {
 return Stream.of(line.split("\\s+"));
 }

 private static boolean isStopWord(String word) {
 return STOP_WORDS.contains(word);
 }

 public static void main(String args[])
 {
  String input = "hello how are you are you doing are is this good doing with coffee to drink doing";
  Stream<String> inputStream = Stream.of(input);
  findMostFrequentWords(inputStream);
 }

 @Override
 public String toString() {
  return "WordFrequencyAnalyzer{}";
 }
}

