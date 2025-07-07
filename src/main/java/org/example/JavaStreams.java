package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaStreams {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> nameList = Arrays.asList("Ajovi", "Ivan", "Francis", "AJanna", "Chris");
        List<Integer> squareList = Arrays.asList(1,2,3,4,5);
        List<Person> people = Arrays.asList(
                new Person("Jovi", 13),
                new Person("Janna", 27),
                new Person("Ivan", 35),
                new Person("Christian", 4),
                new Person("Francis", 106)
        );

        Predicate<Integer> isOdd = n -> n % 2 != 0;

        Predicate<String> startsWithA = s -> s.startsWith("A");

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        Predicate<Integer> combined = isEven.and(greaterThanFive);

        List<Integer> oddNumbers = numberList.stream()
                .filter(isOdd)
                .collect(Collectors.toList());

        List<String> startLetter = nameList.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());

        List<Integer> squareNumbers = squareList.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        List<Integer> combinePredicates = numberList.stream()
                .filter(combined)
                .collect(Collectors.toList());

        List<Person> ageAscending = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        List<Person> nameAlphabetical = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        List<Person> ageDescending = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());

        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Names starting with A: " + startLetter);
        System.out.println("Squared numbers: " + squareNumbers);
        System.out.println("Even and > 5: " + combinePredicates);
        System.out.println("Sorted by age (ascending): " + ageAscending);
        System.out.println("Sorted by name: " + nameAlphabetical);
        System.out.println("Sorted by age (descending): " + ageDescending);
    }
}
