package com.practice.programs.stream_filter;

import com.practice.programs.ProgramsApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class streamFilterPrograms {

    public void main(String[] args)
    {
        SpringApplication.run(streamFilterPrograms.class, args);

        //Program 1: Filtering strings having 3 words
        List<String> words = Arrays.asList("apple", "banana", "car", "dog", "elephant");
        List<String> lengthThreeWords = words.stream()
                .filter(s -> s.length() == 3)
                .toList();
        System.out.println("Three letter words are: " + lengthThreeWords);

        //Program 2: Filtering strings having 3 or 4 words
        List<String> wordsList = Arrays.asList("apple", "banana", "car", "dog", "elephant");
        List<String> lengthWords = wordsList.stream()
                .filter(s -> s.length() == 3 || s.length() == 4)
                .toList();
        System.out.println("3 or 4 letter words are: " + lengthWords);

        //Program 3: Filtering to get Odd Number
        List<Integer> lNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> oddNumber = lNum.stream()
                .filter(n-> n % 2 !=0)
                .toList();
        System.out.println("Odd numbers are: " + oddNumber);

        //Program 4: Filtering numbers between 5 and 9
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n > 5 && n < 9)
                .toList();
        System.out.println("Numbers between 5 and 9: " + filteredNumbers);

        //Program 5: Filtering numbers divisible by 3
        List<Integer> listNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> divisibleNumber = listNum.stream()
                .filter(n-> n % 3 ==0)
                .toList();
        System.out.println("Odd numbers are: " + divisibleNumber);

        //Program 6: Filtering using age greater than 18
        List<Person> people = Arrays.asList(
                new Person("John", 17),
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Jane", 35)
        );
        List<Person> adults = people.stream()
                .filter(p -> p.getAge() >= 18)
                .toList();
        System.out.println("Adults: " + adults);

        //Program 7: Filtering people having alphabet 'A' or 'a' in them
        List<Person> record = people.stream()
                .filter(p -> p.getAge() >= 18)
                .toList();
        System.out.println("Peoples having alphabet 'A' in their name: " + record);

        //Program 8: Filtering words Starting with vowels
        List<String> wordLis = Arrays.asList("apple", "banana", "car", "dog", "elephant");
        List<String> filteredWords = wordLis.stream()
                .filter(this::startsWithVowel)
                .toList();
        System.out.println("Words Starting with vowels are: " + filteredWords);

        //Program 9: Filtering words having 'a' or 'A' in them
        List<String> wordLi = Arrays.asList("Apple", "banana", "car", "dog", "elephant");
        List<String> filterWords = wordLi.stream()
                .filter(this::havingAa)
                .toList();
        System.out.println("Words Starting with vowels are: " + filterWords);

        //Program 10: Filtering Distinct numbers
        List<Integer> number = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 1);
        List<Integer> distinctNumbers = number.stream()
                .distinct()
                .toList();
        System.out.println("Distinct Numbers are:"+ distinctNumbers);
    }

    private boolean startsWithVowel(String word)
    {
        return word.matches("[aeiouAEIOU].*");
    }

    private boolean havingAa(String word)
    {
        return word.matches(".*[aA].*");
    }
}
