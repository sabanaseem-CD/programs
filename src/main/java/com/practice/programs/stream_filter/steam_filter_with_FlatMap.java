package com.practice.programs.stream_filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class steam_filter_with_FlatMap
{
    public static void main (String [] args)
    {
        //Program 1: Find all unique words from a list of sentences
        List<String> sentences = Arrays.asList("Hello world!", "This is a sentence.", "Another sentence here.");
        Set<String> uniqueWords = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toSet());
        System.out.println("Unique words are: " + uniqueWords);

        //Program 2: Find the average length of all words in a list of sentences, ignoring empty words
        double averageWordLength = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> !word.isEmpty())
                .mapToInt(String::length)
                .average()
                .orElse(0.0); // In case of empty sentences
        System.out.println("Average word length is: " + averageWordLength);

        // Program 3: Find all unique words longer than 5 characters from a list of paragraphs, ignoring case:
        Set<String> uniqueLongWords = sentences.stream()
                .flatMap(paragraph -> Arrays.stream(paragraph.split(" ")))
                .filter(word -> word.length() > 5)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println("Unique long words are: " + uniqueLongWords);

        // Program 4:
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> oddNum = listOfLists.stream()
                .flatMap(List::stream)
                .filter(n-> n%2 !=0)
                .toList();
        System.out.println("Odd numbers are: " + oddNum);

        //Program 5: Square each number in the nested list
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        List<Integer> squaredNum = nestedList.stream()
                .flatMap(Collection::stream)
                .map(n-> n*n)
                .toList();
        System.out.println("Squared values are: " + squaredNum);

    }
}
