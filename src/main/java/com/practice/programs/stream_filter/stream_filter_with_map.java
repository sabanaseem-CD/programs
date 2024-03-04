package com.practice.programs.stream_filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream_filter_with_map
{
    public static void main (String [] args)
    {
        //Program 1: Filter names starting with "A" and convert them to uppercase
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> uppercaseANames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("Capitalised Names starting with A: " + uppercaseANames);

        //Program 2: Filter strings longer than 5 characters and replace all vowels with "*"
        List<String> words = Arrays.asList("apple", "banana", "car", "elephant");
        List<String> censoredWords = words.stream()
                .filter(word -> word.length() > 5)
                .map(word -> word.replaceAll("[aeiouAEIOU]", "*"))
                .toList();
        System.out.println("Word having all vowels with '*' which has more than 5 characters: " + censoredWords);

        //Program 3: Filter even numbers and square them
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> squaredEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("Squared even numbers are: " + squaredEvenNumbers);

        //Program 4: Filter positive numbers, find the average, and format it to two decimal places
        List<Double> num = Arrays.asList(1.5, -2.0, 3.0, 4.5);
        double averagePositiveNumber = num.stream()
                .filter(n -> n > 0)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0); // In case no positive numbers
        System.out.printf("Average positive number is: %.2f%n", averagePositiveNumber);

        //Program 5: Remove whitespace from string
        String name = " Hello , world ! ";
        String consonants = name.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        System.out.println("String without whitespace is: " + consonants);
    }
}
